import java.time.LocalDate;

public abstract class Employee implements Comparable, Payment{
    private int empID;
    private String gender;
    private LocalDate dateOfBirth;

    public int getEmpID() {
        return empID;
    }

    /**
     * Gets gender of the vet
     *
     * @return gender of the vet
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets date of birth of the vet
     *
     * @return date of birth of the vet
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    /**
     * Sets gender of the vet
     *
     * @param gender gender of the vet
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets date of birth of the vet
     *
     * @param dateOfBirth date of birth of the vet
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
