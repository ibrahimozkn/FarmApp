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

    public Veterinary(int vetID, String gender, LocalDate dateOfBirth, boolean degree, LocalDate dateOfGraduation, int expertiseLevel){
        this.setEmpID(vetID);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
        this.setBScDegree(degree);
        this.dateOfGraduation = dateOfGraduation;
        this.expertiseLevel = expertiseLevel;
    }

    public boolean getBScDegree(){
        return this.BScDegree;
    }

    public LocalDate getDateOfGraduation() {
        return dateOfGraduation;
    }

    public int getExpertiseLevel() {
        return expertiseLevel;
    }

    public void setBScDegree(boolean BScDegree) {
        this.BScDegree = BScDegree;
    }

    public void setDateOfGraduation(LocalDate dateOfGraduation) {
        this.dateOfGraduation = dateOfGraduation;
    }

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
