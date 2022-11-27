import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This method represents treatment with medications used for a cow given by a vet.
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
 */
public class Treatment {
    private LocalDate dateOfTreatment;


    /**
     * Instantiates a new Treatment.
     *
     * @param dateOfTreatment the date of treatment
     */
    public Treatment(LocalDate dateOfTreatment){
        this.dateOfTreatment = dateOfTreatment;
    }

    /**
     * Instantiates a new Treatment with date of treatment as today.
     */
    public Treatment(){
        this.dateOfTreatment = LocalDate.now();
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
     * Sets date of treatment.
     *
     * @param dateOfTreatment the date of treatment
     */
    public void setDateOfTreatment(LocalDate dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }



}
