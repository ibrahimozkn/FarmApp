import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 * The type Cow.
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
     * Get age int.
     *
     * @return the int
     */
    public int getAge(){
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    /**
     * Get tag no int.
     *
     * @return the int
     */
    public int getTagNo(){
        return this.tagNo;
    }

    /**
     * Get gender string.
     *
     * @return the string
     */
    public String getGender(){
        return this.gender;
    }

    /**
     * Get date of birth local date.
     *
     * @return the local date
     */
    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }

    /**
     * Get purchased boolean.
     *
     * @return the boolean
     */
    public boolean getPurchased(){
        return this.purchased;
    }

    /**
     * Set tag no.
     *
     * @param tagNo the tag no
     */
    public void setTagNo(int tagNo){
       this.tagNo = tagNo;
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
     * Sets purchased.
     *
     * @param purchased the purchased
     */
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void hasTreatment(Treatment treatment){
        treatments.add(treatment);
    }

    public ArrayList<Treatment> getTreatments() {
        return treatments;
    }
}
