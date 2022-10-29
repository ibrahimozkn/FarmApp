import java.time.LocalDate;

public class Veterinary {
    private int vetID;
    private String gender;
    private LocalDate dateOfBirth;
    private double salary;



    public int getVetID() {
        return vetID;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setVetID(int vetID) {
        this.vetID = vetID;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
