import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DataStorage {

    private String url = "jdbc:mysql://localhost:3306/farmappdb";
    private String username = "root";
    private String password = "";
    private Connection connection;
    private Statement statement;


    DataStorage() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection( url, username,password);
        statement = connection.createStatement();
    }


    public void writeData(FarmMe farmMe) throws SQLException, IOException {
        File file = new File("animal.txt");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(farmMe.animals.get(0));
        } catch (IOException e) {
            System.out.println(e);
        }

        statement.execute("DELETE FROM animal");
        statement.execute("DELETE FROM employee");

        for (Animal animal:
             farmMe.animals) {
            if(animal instanceof Cow){
                String insertSQL = "INSERT INTO animal (`tagNo`, `gender`, `dateOfBirth`, `purchased`, `type`, `Weight`) VALUES (" + animal.getTagNo() + "," +
                         "'" + animal.getGender() + "'," + "STR_TO_DATE('" + animal.getDateOfBirth().toString() + "'" + ", '%Y-%m-%d')" +
                        "," + animal.getPurchased() + ", 'c'," + ((Cow) animal).getWeight() + ")" + ";";
                statement.execute(insertSQL);
            }else if(animal instanceof Sheep){
                String insertSQL = "INSERT INTO animal (`tagNo`, `gender`, `dateOfBirth`, `purchased`, `type`, `Weight`) VALUES (" + animal.getTagNo() + "," +
                        "'" + animal.getGender() + "'," + "STR_TO_DATE('" + animal.getDateOfBirth().toString() + "'" + ", '%Y-%m-%d')" +
                        "," + animal.getPurchased() + ", 's'," + "0" + ")" + ";";

                statement.execute(insertSQL);
            }
            
        }

        for(Employee employee: farmMe.employees){
            if(employee instanceof Veterinary){
                String insertSQL = "INSERT INTO employee (`empID`, `gender`, `dateOfBirth`, `type`, `BScDegree`, `dateOfGraduation`, `expertiseLevel`, `previousFarmName`, `workExperience`) VALUES (" + employee.getEmpID()
                        + ",'" + employee.getGender() + "'," + "STR_TO_DATE('" + employee.getDateOfBirth().toString() + "'" + ", '%Y-%m-%d')" + "," + "'v'," + ((Veterinary) employee).getBScDegree() + ","
                        + "STR_TO_DATE('" + ((Veterinary) employee).getDateOfGraduation().toString() + "'" + ", '%Y-%m-%d')" + "," + ((Veterinary) employee).getExpertiseLevel() + ", '', 0);";

                System.out.println(insertSQL);

                statement.execute(insertSQL);

            }else if(employee instanceof FarmWorker){
                String insertSQL = "INSERT INTO employee (`empID`, `gender`, `dateOfBirth`, `type`, `BScDegree`, `dateOfGraduation`, `expertiseLevel`, `previousFarmName`, `workExperience`) VALUES (" + employee.getEmpID()
                        + ",'" + employee.getGender() + "'," + "STR_TO_DATE('" + employee.getDateOfBirth().toString() + "'" + ", '%Y-%m-%d')" + "," + "'f'," + "false" + ","
                        + "STR_TO_DATE('" + "1998-02-01" + "'" + ", '%Y-%m-%d')" + "," + "0" + ",'" + ((FarmWorker) employee).getPreviousFarmName() + "',"+ ((FarmWorker) employee).getWorkExperience() + ");";
                System.out.println(insertSQL);

                statement.execute(insertSQL);
            }
        }



    }

    public void readData(FarmMe farmMe) throws SQLException {
        ResultSet animalRs = statement.executeQuery("SELECT * From animal");


        farmMe.animals = new ArrayList<>();
        farmMe.employees = new ArrayList<>();

        while (animalRs.next()){
            String type = animalRs.getString("type");
            if(type.equalsIgnoreCase("c")){
                farmMe.animals.add(new Cow(
                        animalRs.getInt("tagNo"),
                        animalRs.getString("gender"),
                        animalRs.getDate("dateOfBirth").toLocalDate(),
                        animalRs.getBoolean("purchased"),
                        animalRs.getDouble("weight")
                        )
                );
            }else if(type.equalsIgnoreCase("s")){
                farmMe.animals.add(new Sheep(
                                animalRs.getInt("tagNo"),
                                animalRs.getString("gender"),
                                animalRs.getDate("dateOfBirth").toLocalDate(),
                                animalRs.getBoolean("purchased")
                        )
                );
            }
        }
        animalRs.close();
        ResultSet employeeRs = statement.executeQuery("SELECT * From employee");

        while (employeeRs.next()){
            String type = employeeRs.getString("type");
            if(type.equalsIgnoreCase("v")){
                farmMe.employees.add(new Veterinary(
                        employeeRs.getInt("empId"),
                        employeeRs.getString("gender"),
                        employeeRs.getDate("dateOfBirth").toLocalDate(),
                        employeeRs.getBoolean("BScDegree"),
                        employeeRs.getDate("dateOfGraduation").toLocalDate(),
                        employeeRs.getInt("expertiseLevel")
                        ));

            }else if(type.equalsIgnoreCase("f")){
                farmMe.employees.add(new FarmWorker(
                        employeeRs.getInt("empId"),
                        employeeRs.getString("gender"),
                        employeeRs.getDate("dateOfBirth").toLocalDate(),
                        employeeRs.getString("previousFarmName"),
                        employeeRs.getInt("workExperience")
                ));
            }
        }

        File file = new File("animal.txt");

        Animal animal = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            animal = (Animal)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(animal.getDateOfBirth());
    }

}
