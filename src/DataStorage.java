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


    public void writeData(FarmMe farmMe) throws SQLException {
        statement.execute("DELETE FROM animal");

        statement.execute("DELETE FROM employee");
        for (Animal animal:
             farmMe.animals) {
            if(animal instanceof Cow){
                String insertSQL = "INSERT INTO animal (`tagNo`, `gender`, `dateOfBirth`, `purchased`, `type`, `Weight`) VALUES (" + animal.getTagNo() + "," +
                         "'" + animal.getGender() + "'," + "STR_TO_DATE('" + animal.getDateOfBirth().toString() + "'" + ", '%Y-%m-%d')" +
                        "," + animal.getPurchased() + ", 'c'," + ((Cow) animal).getWeight() + ")" + ";";

                System.out.println(insertSQL);
                System.out.println(animal.getDateOfBirth().toString());
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
    }

}
