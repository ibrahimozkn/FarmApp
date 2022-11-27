import java.time.LocalDate;

/**
 * Interface which represents a real-world employee.
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
 */
public abstract class Employee implements Comparable<Employee>, Payment{
    private int empID;
    private String gender;
    private LocalDate dateOfBirth;

    /**
     * Gets employee id
     *
     * @return the employee id
     */
    public int getEmpID() {
        return empID;
    }

    /**
     * Gets gender of the employee
     *
     * @return gender of the employee
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets date of birth of the employee
     *
     * @return date of birth of the employee
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets employee id
     *
     * @param empID the employee id
     */
    public void setEmpID(int empID) {
        this.empID = empID;
    }

    /**
     * Sets gender of the employee
     *
     * @param gender gender of the vet
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets date of birth of the employee
     *
     * @param dateOfBirth date of birth of the employee
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
