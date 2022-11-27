import java.time.LocalDate;

/**
 * This class represents vet.
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
 */
public class Veterinary extends Employee{

    private boolean BScDegree;
    private LocalDate dateOfGraduation;
    private int expertiseLevel;


    /**
     * Instantiates a new Veterinary.
     *
     * @param vetID       the vet id
     * @param gender      the gender
     * @param dateOfBirth the date of birth
     */
    public Veterinary(int vetID, String gender, LocalDate dateOfBirth){
        this.setEmpID(vetID);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
    }

    /**
     * Instantiates a new Veterinary.
     *
     * @param vetID            the vet id
     * @param gender           the gender
     * @param dateOfBirth      the date of birth
     * @param degree           the degree
     * @param dateOfGraduation the date of graduation
     * @param expertiseLevel   the expertise level
     */
    public Veterinary(int vetID, String gender, LocalDate dateOfBirth, boolean degree, LocalDate dateOfGraduation, int expertiseLevel){
        this.setEmpID(vetID);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
        this.setBScDegree(degree);
        this.dateOfGraduation = dateOfGraduation;
        this.expertiseLevel = expertiseLevel;
    }

    /**
     * Gets the BScDegree status of the vet
     *
     * @return boolean where true means has and false means has not
     */
    public boolean getBScDegree(){
        return this.BScDegree;
    }

    /**
     * Gets date of graduation.
     *
     * @return the date of graduation
     */
    public LocalDate getDateOfGraduation() {
        return dateOfGraduation;
    }

    /**
     * Gets expertise level.
     *
     * @return the expertise level
     */
    public int getExpertiseLevel() {
        return expertiseLevel;
    }

    /**
     * Sets the BScDegree status of the vet
     *
     * @param BScDegree boolean where true means has and false means has not
     */
    public void setBScDegree(boolean BScDegree) {
        this.BScDegree = BScDegree;
    }

    /**
     * Sets date of graduation.
     *
     * @param dateOfGraduation the date of graduation
     */
    public void setDateOfGraduation(LocalDate dateOfGraduation) {
        this.dateOfGraduation = dateOfGraduation;
    }

    /**
     * Sets expertise level.
     *
     * @param expertiseLevel the expertise level
     */
    public void setExpertiseLevel(int expertiseLevel) {
        this.expertiseLevel = expertiseLevel;
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
     * Calculates salary of the vet
     *
     * @return calculated salary of the vet
     *
     * */
    public double getSalary() {
        return Payment.grossSalary * (Payment.grossSalary * 0.1 * (LocalDate.now().getYear() - this.dateOfGraduation.getYear()));
    }
}
