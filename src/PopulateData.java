import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class is used to populate FarmMe class
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
 *
 */
public class PopulateData {
    /**
     * Populates farm me object with 3 cows and 3 vets where each cow has 1 treatment and each treatment has 1 medication.
     *
     * @see FarmMe
     * @return populated farmMe object
     */
    public static FarmMe populate(){
        ArrayList<Cow> cows = new ArrayList<Cow>();
        cows.add(new Cow(1, "male", LocalDate.now(), true));
        cows.add(new Cow(2, "female", LocalDate.of(2001, 1, 5), false));
        cows.add(new Cow(3, "male", LocalDate.of(2013, 9, 21), true));

        ArrayList<Veterinary> vets = new ArrayList<Veterinary>();

        vets.add(new Veterinary(1, "female", LocalDate.of(1997, 5, 7), 2500.0));
        vets.add(new Veterinary(2, "male", LocalDate.of(1998, 12, 27), 2700.0));
        vets.add(new Veterinary(3, "female", LocalDate.of(1999, 8, 20), 1500.0));

        Treatment treatment1 = new Treatment(LocalDate.of(2022, 7, 5), "Treatment detail 1", vets.get(2));
        treatment1.hasMedication(new Medication("Medication detail 1", 100, LocalDate.of(2021, 5, 18), 1.2, "Medication notes 1"));

        Treatment treatment2 = new Treatment(LocalDate.of(2018, 1, 10), "Treatment detail 2", vets.get(0));
        treatment2.hasMedication(new Medication("Medication detail 2", 500, LocalDate.of(2019, 12, 1), 2.5, "Medication notes 2"));


        Treatment treatment3 = new Treatment(LocalDate.of(2018, 1, 10), "Treatment detail 3", vets.get(0));
        treatment3.hasMedication(new Medication("Medication detail 3", 900, LocalDate.of(2007, 7, 18), 9.1, "Medication notes 3"));

        cows.get(0).hasTreatment(treatment1);
        cows.get(1).hasTreatment(treatment2);
        cows.get(2).hasTreatment(treatment3);


        return new FarmMe(cows, vets);
    }
}
