import java.time.LocalDate;

/**
 * The type Veterinary.
 */
public class Veterinary {
    private int vetID;
    private String gender;
    private LocalDate dateOfBirth;
    private double salary;


    /**
     * Instantiates a new Veterinary.
     *
     * @param vetID       the vet id
     * @param gender      the gender
     * @param dateOfBirth the date of birth
     */
    public Veterinary(int vetID, String gender, LocalDate dateOfBirth){
        this.vetID = vetID;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        salary = 0;
    }

    /**
     * Instantiates a new Veterinary.
     *
     * @param vetID       the vet id
     * @param gender      the gender
     * @param dateOfBirth the date of birth
     * @param salary      the salary
     */
    public Veterinary(int vetID, String gender, LocalDate dateOfBirth, double salary){
        this.vetID = vetID;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }

    /**
     * Gets vet id.
     *
     * @return the vet id
     */
    public int getVetID() {
        return vetID;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Gets salary.
     *
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets vet id.
     *
     * @param vetID the vet id
     */
    public void setVetID(int vetID) {
        this.vetID = vetID;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Sets salary.
     *
     * @param salary the salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
