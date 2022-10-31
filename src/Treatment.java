import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The type Treatment.
 */
public class Treatment {
    private LocalDate dateOfTreatment;
    private String details;
    private Veterinary vet;
    private ArrayList<Medication> medications;


    /**
     * Instantiates a new Treatment.
     *
     * @param dateOfTreatment the date of treatment
     * @param details         the details
     * @param vet             the vet
     */
    public Treatment(LocalDate dateOfTreatment, String details, Veterinary vet){
        this.dateOfTreatment = dateOfTreatment;
        this.details = details;
        this.vet = vet;
        this.medications = new ArrayList<Medication>();
    }

    /**
     * Instantiates a new Treatment.
     *
     * @param dateOfTreatment the date of treatment
     * @param details         the details
     * @param vet             the vet
     * @param medications     the medications
     */
    public Treatment(LocalDate dateOfTreatment, String details, Veterinary vet, ArrayList<Medication> medications){
        this.dateOfTreatment = dateOfTreatment;
        this.details = details;
        this.vet = vet;
        this.medications = new ArrayList<Medication>(medications);
    }

    /**
     * Gets date of treatment.
     *
     * @return the date of treatment
     */
    public LocalDate getDateOfTreatment() {
        return dateOfTreatment;
    }

    /**
     * Gets details.
     *
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets date of treatment.
     *
     * @param dateOfTreatment the date of treatment
     */
    public void setDateOfTreatment(LocalDate dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
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
     * Gets vet.
     *
     * @return the vet
     */
    public Veterinary getVet() {
        return vet;
    }

    /**
     * Sets details.
     *
     * @param details the details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Given by.
     *
     * @param vet the vet
     */
    public void givenBy(Veterinary vet){
        this.vet = vet;
    }

    /**
     * Has medication.
     *
     * @param medication the medication
     */
    public void hasMedication(Medication medication){
        medications.add(medication);
    }


}
