import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DataStorage extends Thread{

    private String url = "jdbc:mysql://localhost:3306/farmappdb";
    private String username = "root";
    private String password = "";
    private Connection connection;
    private Statement statement;




    DataStorage() throws SQLException, ClassNotFoundException {
        super("Data thread");

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection( url, username,password);
        statement = connection.createStatement();

    }

    public void run(){
        try {
            boolean result = checkMD5();

            if(!result) new JInfoDialog("WARNING: Data has been updated").showScreen();

        } catch (Exception e){
            new JInfoDialog(e.toString()).showScreen();
        }
    }


    public String createMD5(ObjectInputStream in) throws IOException, NoSuchAlgorithmException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int ch;
        while ((ch = in.read()) != -1) {
            baos.write (ch);
        }

        byte buffer[] = baos.toByteArray();


        MessageDigest md = MessageDigest.getInstance("MD5");

        md.reset();

        md.update(buffer);


        byte digest[] = md.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<digest.length;i++) {
            hexString.append (
                    Integer.toHexString(0xFF & digest[i]));
            hexString.append (" ");
        }
        baos.close();


        return hexString.toString();

    }

    public boolean checkMD5() throws IOException, NoSuchAlgorithmException {
        File file = new File("animal.txt");

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

        String md5 = createMD5(in);
        in.close();

        File md5File = new File("md5.txt");

        DataInputStream md5In = new DataInputStream(new FileInputStream(md5File));

        String orgMd5 = md5In.readUTF();

        md5In.close();

        return md5.equalsIgnoreCase(orgMd5);
    }


    public void writeData(FarmMe farmMe) throws SQLException, IOException, NoSuchAlgorithmException {
        File file = new File("animal.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(farmMe.animals);


        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));


        String md5String = createMD5(in);
        in.close();

        File md5File = new File("md5.txt");


        DataOutputStream md5Writer = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(md5File)));

        md5Writer.writeUTF(md5String);

        md5Writer.close();


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

                statement.execute(insertSQL);

            }else if(employee instanceof FarmWorker){
                String insertSQL = "INSERT INTO employee (`empID`, `gender`, `dateOfBirth`, `type`, `BScDegree`, `dateOfGraduation`, `expertiseLevel`, `previousFarmName`, `workExperience`) VALUES (" + employee.getEmpID()
                        + ",'" + employee.getGender() + "'," + "STR_TO_DATE('" + employee.getDateOfBirth().toString() + "'" + ", '%Y-%m-%d')" + "," + "'f'," + "false" + ","
                        + "STR_TO_DATE('" + "1998-02-01" + "'" + ", '%Y-%m-%d')" + "," + "0" + ",'" + ((FarmWorker) employee).getPreviousFarmName() + "',"+ ((FarmWorker) employee).getWorkExperience() + ");";

                statement.execute(insertSQL);
            }
        }



    }

    public void readData(FarmMe farmMe) throws SQLException{
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
