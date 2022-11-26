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
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Cow(1, "male", LocalDate.now(), true, 100));
        animals.add(new Cow(2, "female", LocalDate.of(2001, 1, 5), false, 70));


        animals.add(new Sheep(3, "male", LocalDate.of(2018, 11, 14), true));
        animals.add(new Sheep(4, "male", LocalDate.of(2013, 9, 21), false));

        ArrayList<Employee> employees = new ArrayList<Employee>();

        employees.add(new Veterinary(1, "female", LocalDate.of(1997, 5, 7), true, LocalDate.of(2012, 5, 7), 5));
        employees.add(new Veterinary(2, "male", LocalDate.of(2000, 12, 15), true, LocalDate.of(2019, 1, 1), 2));

        employees.add(new FarmWorker(3, "male", LocalDate.of(1988, 11, 1), "Farm 1", 1));
        employees.add(new FarmWorker(4, "female", LocalDate.of(1974, 8, 13), "Farm 2", 5));

         animals.get(0).hasTreatment(new CleaningTreatment(LocalDate.of(2021, 11, 14), "Brush", (FarmWorker) employees.get(2)));
         animals.get(1).hasTreatment(new CleaningTreatment(LocalDate.now(), "Brush 2", (FarmWorker) employees.get(3)));

         animals.get(2).hasTreatment(new CleaningTreatment(LocalDate.of(2021, 11, 14), "Brush 3", (FarmWorker) employees.get(3)));
         animals.get(3).hasTreatment(new CleaningTreatment(LocalDate.of(2022, 11, 5), "Brush 4", (FarmWorker) employees.get(2)));

         HealthTreatment healthTreatment1 = new HealthTreatment(LocalDate.now(), true, (Veterinary) employees.get(0));
         HealthTreatment healthTreatment2 = new HealthTreatment(LocalDate.of(2020, 1, 27), true, (Veterinary) employees.get(1));
         HealthTreatment healthTreatment3 = new HealthTreatment(LocalDate.of(2014, 4, 14), true, (Veterinary) employees.get(0));
         HealthTreatment healthTreatment4 = new HealthTreatment(LocalDate.now(), true, (Veterinary) employees.get(1));

         healthTreatment1.addMedication(new Medication("detail 1", 100, LocalDate.now(), 5, "Note 1"));
         healthTreatment2.addMedication(new Medication("detail 2", 20, LocalDate.of(2020, 3, 4), 15, "Note 2"));
         healthTreatment3.addMedication(new Medication("detail 3", 7, LocalDate.of(2004, 7, 20), 13, "Note 3"));
         healthTreatment4.addMedication(new Medication("detail 4", 500, LocalDate.of(2013, 2, 9), 1000, "Note 4"));

         animals.get(0).hasTreatment(healthTreatment1);
         animals.get(1).hasTreatment(healthTreatment2);
         animals.get(2).hasTreatment(healthTreatment3);
         animals.get(3).hasTreatment(healthTreatment4);

        return new FarmMe(animals, employees);
    }
}
