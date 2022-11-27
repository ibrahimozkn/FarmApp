import java.time.LocalDate;

/**
 * Employee type that is working for the farm. Class represents a farm worker.
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
 * @see Employee
 *
 */
public class FarmWorker extends Employee{

    private String previousFarmName;
    private int workExperience;

    /**
     * Instantiates a new Farm worker.
     *
     * @param empId       the employee id
     * @param gender      the gender
     * @param dateOfBirth the date of birth
     */
    public FarmWorker(int empId, String gender, LocalDate dateOfBirth){
        this.setEmpID(empId);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
    }

    /**
     * Instantiates a new Farm worker.
     *
     * @param empId            the employee id
     * @param gender           the gender
     * @param dateOfBirth      the date of birth
     * @param previousFarmName the previous farm name
     * @param workExperience   the work experience
     */
    public FarmWorker(int empId, String gender, LocalDate dateOfBirth, String previousFarmName, int workExperience){
        this.setEmpID(empId);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
        this.previousFarmName = previousFarmName;
        this.workExperience = workExperience;
    }

    /**
     * Gets previous farm name where worker worked.
     *
     * @return the previous farm name
     */
    public String getPreviousFarmName() {
        return previousFarmName;
    }

    /**
     * Gets work experience of the employee.
     *
     * @return the work experience of the employee
     */
    public int getWorkExperience() {
        return workExperience;
    }

    /**
     * Sets previous farm name where worker worked.
     *
     * @param previousFarmName the previous farm name
     */
    public void setPreviousFarmName(String previousFarmName) {
        this.previousFarmName = previousFarmName;
    }

    /**
     * Sets work experience of the worker.
     *
     * @param workExperience the work experience of the worker
     */
    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }


    /**
     * Compares salaries of current employee object with the given employee.
     *
     * @return 0 if salaries are equal, 1 if given employee has greater salary, -1 if current object has greater salary.
     *
     * */
    @Override
    public int compareTo(Employee employee) {
        if(employee.getSalary() == this.getSalary()){
            return 0;
        }else if(employee.getSalary() > this.getSalary()){
            return 1;
        }else {
            return -1;
        }
    }

    /**
     * Calculates salary of the farm worker
     *
     * @return calculated salary of the farm worker
     *
     * */
    @Override
    public double getSalary() {
        return Payment.grossSalary + (Payment.grossSalary * 0.02 * workExperience);
    }
}
