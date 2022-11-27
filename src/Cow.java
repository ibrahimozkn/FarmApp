import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents cow the animal which includes its weight and other variables and methods included in animal class
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
 */
public class Cow extends Animal{
    private double weight;


    /**
     * Instantiates a new Cow.
     *
     * @param tagNo       the tag no
     * @param gender      the gender
     * @param dateOfBirth the date of birth
     * @param purchased   the purchased
     */
    public Cow(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased){
        this.setTagNo(tagNo);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
        this.setPurchased(purchased);
        this.setTreatments(new ArrayList<Treatment>());
        this.setMilking(new HashMap<LocalDate, Double>());
    }

    /**
     * Instantiates a new Cow.
     *
     * @param tagNo       the tag no
     * @param gender      the gender
     * @param dateOfBirth the date of birth
     * @param purchased   whether the cow is purchased or farm raising
     * @param weight      the weight of the cow
     */
    public Cow(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased, double weight){
        this.setTagNo(tagNo);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
        this.setPurchased(purchased);
        this.setTreatments(new ArrayList<Treatment>());
        this.setMilking(new HashMap<LocalDate, Double>());
        this.weight = weight;
    }

    /**
     * Instantiates a new Cow.
     *
     * @param tagNo  the tag no
     * @param gender the gender
     */
    public Cow(int tagNo, String gender){
        this.setTagNo(tagNo);
        this.setGender(gender);
        this.setDateOfBirth(LocalDate.now());
        this.setPurchased(false);
        this.setTreatments(new ArrayList<Treatment>());
        this.setMilking(new HashMap<LocalDate, Double>());
    }

    /**
     * Gets weight.
     *
     * @return weight of the cow
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight weight of the cow
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
    * Provides feeding information about cow according to its age or weight
    *
    * */
    public void feeding(){
        if(this.getAge() < 3){
            System.out.println("Only grass");
        }else if(this.getAge() > 5 && this.weight < 500){
            System.out.println("Total mixed ration (TMR) where includes hay, fermented grass (silage), maize silage and high energy grains like brewers grains, soy bean, cotton seed and citrus pulp.");
                    /*
           needs Total mixed ration (TMR) is a diet that
        includes hay, fermented grass (silage), maize silage and
        high energy grains like brewers grains, soy bean, cotton
        seed and citrus pulp.*/
        }else if(this.getAge() > 10){
            System.out.println("Grains and oilseed meals");

            /*If a cow is older than 10 years old, it needs grains and oilseed
            meals.*/
        }else{
            System.out.println("Grass and grains");

            /*In all other cases, the cow needs be fed with grass and grains.*/
        }

    }
}
