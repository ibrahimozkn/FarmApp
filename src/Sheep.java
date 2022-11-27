import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class which represents a real-world animal sheep.
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
 * @see Animal
 *
 */
public class Sheep extends Animal{


    /**
     * Instantiates a new Sheep.
     *
     * @param tagNo       the tag no
     * @param gender      the gender
     * @param dateOfBirth the date of birth
     * @param purchased   if purchased or farm raising
     */
    public Sheep(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased){
        this.setTagNo(tagNo);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
        this.setPurchased(purchased);
        this.setTreatments(new ArrayList<Treatment>());
        this.setMilking(new HashMap<LocalDate, Double>());
    }

    /**
     * Instantiates a new Sheep.
     *
     * @param tagNo     the tag no
     * @param gender    the gender
     * @param purchased if purchased or farm raising
     */
    public Sheep(int tagNo, String gender, boolean purchased){
        this.setTagNo(tagNo);
        this.setGender(gender);
        this.setDateOfBirth(LocalDate.now());
        this.setPurchased(purchased);
        this.setTreatments(new ArrayList<Treatment>());
        this.setMilking(new HashMap<LocalDate, Double>());
    }

    /**
     * Provides feeding information about sheep according to its age
     *
     * */
    public void feeding() {
        if(this.getGender() == "male" && this.getAge() < 5){
            System.out.println("Only grass");
            /*only grass*/
        }else if(this.getGender() == "female" && this.getAge() < 8){
            System.out.println("Only grass");
            /*only grass*/
        }else if(this.getGender() == "male" && this.getAge() > 5){
            System.out.println("Total mixed ration (TMR) where includes hay, fermented grass (silage), maize silage and high energy grains like brewers grains, soy bean, cotton seed and citrus pulp.");

            /*Total mixed
            ration (TMR) diet is needed. */
        }else if(this.getGender() == "female" && this.getAge() > 8){
            System.out.println("Total mixed ration (TMR) where includes hay, fermented grass (silage), maize silage and high energy grains like brewers grains, soy bean, cotton seed and citrus pulp.");


            /* Total
mixed ration (TMR) diet is needed.*/
        }

    }
}
