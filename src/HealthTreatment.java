import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The type Health treatment.
 */
public class HealthTreatment extends Treatment {
    private boolean emergency;
    private Veterinary vet;
    private ArrayList<Medication> medications;


    /**
     * Instantiates a new Health treatment.
     *
     * @param emergency if its emergent
     * @param vet       the vet who gave the treatment
     */
    public HealthTreatment(boolean emergency, Veterinary vet){
        this.setDateOfTreatment(LocalDate.now());
        this.emergency = emergency;
        this.vet = vet;
        this.medications = new ArrayList<Medication>();
    }

    /**
     * Instantiates a new Health treatment.
     *
     * @param date      the date of treatment
     * @param emergency if treatment is emergent
     * @param vet       the vet who gave the treatment
     */
    public HealthTreatment(LocalDate date, boolean emergency, Veterinary vet){
        this.setDateOfTreatment(date);
        this.emergency = emergency;
        this.vet = vet;
        this.medications = new ArrayList<Medication>();
    }


    /**
     * Instantiates a new Health treatment.
     *
     * @param date      the date of treatment
     * @param emergency if treatment is emergent
     */
    public HealthTreatment(LocalDate date, boolean emergency){
        this.setDateOfTreatment(date);
        this.emergency = emergency;
        this.medications = new ArrayList<Medication>();
    }

    /**
     * Returns if treatment is emergent
     *
     * @return the boolean
     */
    public boolean isEmergency() {
        return emergency;
    }

    /**
     * Sets emergency of the treatment.
     *
     * @param emergency treatment is emergent or not
     */
    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    /**
     * Returns the vet who gave the treatment
     *
     * @return the vet gave the treatment
     */
    public Veterinary getVet() {
        return vet;
    }

    /**
     * Gets list of medications used in the treatment.
     *
     * @return the medications
     */
    public ArrayList<Medication> getMedications() {
        return medications;
    }

    /**
     * Assigns the vet who gave the treatment.
     *
     * @param vet the vet
     */
    public void hGivenBy(Veterinary vet){
        this.vet = vet;
    }

    /**
     * Assigns list of medications which used in the treatment
     *
     * @param medications list of medications
     */
    public void hasMedications(ArrayList<Medication> medications){
        this.medications = medications;
    }

    /**
     * Adds a single medication to list of medications that used in the treatment
     *
     * @param medication the medication object
     */
    public void addMedication(Medication medication){
        this.medications.add(medication);
    }

}
