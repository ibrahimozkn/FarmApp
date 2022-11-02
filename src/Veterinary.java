import java.time.LocalDate;

/**
 * This class represents vet.
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
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
     * Gets vet's id
     *
     * @return identity number of the vet
     */
    public int getVetID() {
        return vetID;
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

    /**
     * Gets salary of the vet
     *
     * @return salary of the vet
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

    /**
     * Sets salary of the vet
     *
     * @param salary salary of the vet
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
