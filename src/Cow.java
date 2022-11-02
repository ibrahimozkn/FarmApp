import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 * This class represents cow the animal which includes its basic informations and treatments
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
 *
 */
public class Cow {
    private int tagNo;
    private String gender;
    private LocalDate dateOfBirth;
    private boolean purchased;
    private ArrayList<Treatment> treatments;


    /**
     * Instantiates a new Cow.
     *
     * @param tagNo       the tag no
     * @param gender      the gender
     * @param dateOfBirth the date of birth
     * @param purchased   the purchased
     */
    public Cow(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased){
        this.tagNo = tagNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.purchased = purchased;
        this.treatments = new ArrayList<Treatment>();
    }

    /**
     * Instantiates a new Cow.
     *
     * @param tagNo  the tag no
     * @param gender the gender
     */
    public Cow(int tagNo, String gender){
        this.tagNo = tagNo;
        this.gender = gender;
        this.purchased = false;
        this.dateOfBirth = LocalDate.now();
        this.treatments = new ArrayList<Treatment>();
    }


    /**
     * Calculates the age of the cow and returns the resulting number.
     *
     * @return age of the cow
     */
    public int getAge(){
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    /**
     * Get tag number of the cow
     *
     * @return tag number of the cow
     */
    public int getTagNo(){
        return this.tagNo;
    }

    /**
     * Get gender of the cow male or female.
     *
     * @return gender of the cow
     */
    public String getGender(){
        return this.gender;
    }

    /**
     * Get date of birth of the cow
     *
     * @return date of birth of the cow
     */
    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }

    /**
     * Get whether if cow is purchased or farm-rising
     *
     * @return farm -rising (false) or purchased (true)
     */
    public boolean getPurchased(){
        return this.purchased;
    }

    /**
     * Set tag number of the cow
     *
     * @param tagNo tag number of the cow
     */
    public void setTagNo(int tagNo){
       this.tagNo = tagNo;
    }

    /**
     * Sets gender of the cow.
     *
     * @param gender gender of the cow
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets purchased status of the cow. True for purchased, false for farm-rising
     *
     * @param purchased purchased (true) or farm-rising (false)
     */
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    /**
     * Sets date of birth of the cow
     *
     * @param dateOfBirth date of birth of the cow
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Adds treatment to a cow
     *
     * @param treatment treatment object
     */
    public void hasTreatment(Treatment treatment){
        treatments.add(treatment);
    }

    /**
     * Gets treatments of the cow
     *
     * @return list of treatment objects
     */
    public ArrayList<Treatment> getTreatments() {
        return treatments;
    }
}
