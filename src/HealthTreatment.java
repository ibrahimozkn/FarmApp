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
     * @param emergency the emergency
     * @param vet       the vet
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
     * @param date      the date
     * @param emergency the emergency
     * @param vet       the vet
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
     * @param date      the date
     * @param emergency the emergency
     */
    public HealthTreatment(LocalDate date, boolean emergency){
        this.setDateOfTreatment(date);
        this.emergency = emergency;
        this.medications = new ArrayList<Medication>();
    }

    /**
     * Is emergency boolean.
     *
     * @return the boolean
     */
    public boolean isEmergency() {
        return emergency;
    }

    /**
     * Sets emergency.
     *
     * @param emergency the emergency
     */
    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    /**
     * Gets vet.
     *
     * @return the vet
     */
    public Veterinary getVet() {
        return vet;
    }

    /**
     * Sets vet.
     *
     * @param vet the vet
     */
    public void setVet(Veterinary vet) {
        this.vet = vet;
    }

    /**
     * Gets medications.
     *
     * @return the medications
     */
    public ArrayList<Medication> getMedications() {
        return medications;
    }

    /**
     * H given by.
     *
     * @param vet the vet
     */
    public void hGivenBy(Veterinary vet){
        this.vet = vet;
    }

    /**
     * Has medications.
     *
     * @param medications the medications
     */
    public void hasMedications(ArrayList<Medication> medications){
        this.medications = medications;
    }

    /**
     * Add medication.
     *
     * @param medication the medication
     */
    public void addMedication(Medication medication){
        this.medications.add(medication);
    }

}
