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
     * Get b sc degree boolean.
     *
     * @return the boolean
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
     * Sets b sc degree.
     *
     * @param BScDegree the b sc degree
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

    public double getSalary() {
        return Payment.grossSalary * (Payment.grossSalary * 0.1 * (LocalDate.now().getYear() - this.dateOfGraduation.getYear()));
    }
}
