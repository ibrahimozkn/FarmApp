import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This method represents treatment with medications used for a cow given by a vet.
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
 *
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
     * Gets medications used in the treatment
     *
     * @return list of medications
     */
    public ArrayList<Medication> getMedications() {
        return medications;
    }

    /**
     * Gets the vet who gave the treatment
     *
     * @return vet
     */
    public Veterinary getVet() {
        return vet;
    }

    /**
     * Sets details of the treatment
     *
     * @param details details of the treatment
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Sets the vet who gave the treatment.
     *
     * @see Veterinary
     * @param vet vet
     */
    public void givenBy(Veterinary vet){
        this.vet = vet;
    }

    /**
     * Adds used medication to the list of medications that are used in the treatment
     *
     * @see Medication
     * @param medication the medication
     */
    public void hasMedication(Medication medication){
        medications.add(medication);
    }


}
