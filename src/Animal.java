import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Animal {
    private int tagNo;
    private String gender;
    private LocalDate dateOfBirth;
    private boolean purchased;
    private HashMap<LocalDate, Double> milking;
    private ArrayList<Treatment> treatments;

    public abstract void feeding();

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


    public HashMap<LocalDate, Double> getMilking() {
        return milking;
    }

    public ArrayList<Treatment> getTreatments() {
        return treatments;
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

    public void setMilking(HashMap<LocalDate, Double> milking) {
        this.milking = milking;
    }


    public void setTreatments(ArrayList<Treatment> treatments) {
        this.treatments = treatments;
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
}
