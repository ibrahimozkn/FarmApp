import java.time.LocalDate;

/**
 * Type of Treatment which involves cleaning an animal by a worker
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
 * @see Treatment
 *
 */
public class CleaningTreatment extends Treatment{
    private String materialsUsed;
    private FarmWorker worker;

    /**
     * Instantiates a new Cleaning treatment.
     */
    public CleaningTreatment(){
        this.setDateOfTreatment(LocalDate.now());
        materialsUsed = "";
    }

    /**
     * Instantiates a new Cleaning treatment.
     *
     * @param dateOfTreatment the date of treatment
     * @param materialsUsed   the materials used in the treatment
     */
    public CleaningTreatment(LocalDate dateOfTreatment, String materialsUsed){
        this.materialsUsed = materialsUsed;
        this.setDateOfTreatment(dateOfTreatment);

    }

    /**
     * Instantiates a new Cleaning treatment.
     *
     * @param dateOfTreatment the date of treatment
     * @param materialsUsed   the materials used in the treatment
     * @param worker          the farm worker
     */
    public CleaningTreatment(LocalDate dateOfTreatment, String materialsUsed, FarmWorker worker){
        this.materialsUsed = materialsUsed;
        this.setDateOfTreatment(dateOfTreatment);
        this.worker = worker;
    }

    /**
     * Gets materials used.
     *
     * @return materials used in the treatment
     */
    public String getMaterialsUsed() {
        return materialsUsed;
    }

    /**
     * Sets materials used.
     *
     * @param materialsUsed materials used in the treatment
     */
    public void setMaterialsUsed(String materialsUsed) {
        this.materialsUsed = materialsUsed;
    }

    /**
     * Gets worker who gave the treatment.
     *
     * @return FarmWorker object
     */
    public FarmWorker getWorker() {
        return worker;
    }

    /**
     * Sets the farm worker who gave the cleaning treatment
     *
     * @param worker FarmWorker object
     */
    public void cGivenBy(FarmWorker worker){
        this.worker = worker;
    }
}
