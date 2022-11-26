import java.time.LocalDate;

/**
 * The type Farm worker.
 */
public class FarmWorker extends Employee{

    private String previousFarmName;
    private int workExperience;

    /**
     * Instantiates a new Farm worker.
     *
     * @param empId       the emp id
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
     * @param empId            the emp id
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
     * Gets previous farm name.
     *
     * @return the previous farm name
     */
    public String getPreviousFarmName() {
        return previousFarmName;
    }

    /**
     * Gets work experience.
     *
     * @return the work experience
     */
    public int getWorkExperience() {
        return workExperience;
    }

    /**
     * Sets previous farm name.
     *
     * @param previousFarmName the previous farm name
     */
    public void setPreviousFarmName(String previousFarmName) {
        this.previousFarmName = previousFarmName;
    }

    /**
     * Sets work experience.
     *
     * @param workExperience the work experience
     */
    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    //TODO: Do Compare Functions
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

    @Override
    public double getSalary() {
        return Payment.grossSalary + (Payment.grossSalary * 0.02 * workExperience);
    }
}
