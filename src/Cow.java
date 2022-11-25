import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents cow the animal which includes its basic informations and treatments
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
 *
 */
public class Cow extends Animal{
    private double weight;

    public void feeding(){
        if(this.getAge() < 3){
            System.out.println("Cow with younger than 3 year old needs to be fed with grass");
        }else if(this.getAge() > 5 && this.weight < 500){
                    /*
           needs Total mixed ration (TMR) is a diet that
        includes hay, fermented grass (silage), maize silage and
        high energy grains like brewers grains, soy bean, cotton
        seed and citrus pulp.*/
        }else if(this.getAge() > 10){
            /*If a cow is older than 10 years old, it needs grains and oilseed
            meals.*/
        }else{
            /*In all other cases, the cow needs be fed with grass and grains.*/
        }

    }

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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
