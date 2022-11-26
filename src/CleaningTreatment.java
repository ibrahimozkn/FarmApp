import java.time.LocalDate;

/**
 * The type Cleaning treatment.
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
     * @param materialsUsed   the materials used
     */
    public CleaningTreatment(LocalDate dateOfTreatment, String materialsUsed){
        this.materialsUsed = materialsUsed;
        this.setDateOfTreatment(dateOfTreatment);

    }

    /**
     * Instantiates a new Cleaning treatment.
     *
     * @param dateOfTreatment the date of treatment
     * @param materialsUsed   the materials used
     * @param worker          the worker
     */
    public CleaningTreatment(LocalDate dateOfTreatment, String materialsUsed, FarmWorker worker){
        this.materialsUsed = materialsUsed;
        this.setDateOfTreatment(dateOfTreatment);
        this.worker = worker;
    }

    /**
     * Gets materials used.
     *
     * @return the materials used
     */
    public String getMaterialsUsed() {
        return materialsUsed;
    }

    /**
     * Sets materials used.
     *
     * @param materialsUsed the materials used
     */
    public void setMaterialsUsed(String materialsUsed) {
        this.materialsUsed = materialsUsed;
    }

    /**
     * Gets worker.
     *
     * @return the worker
     */
    public FarmWorker getWorker() {
        return worker;
    }

    /**
     * C given by.
     *
     * @param worker the worker
     */
    public void cGivenBy(FarmWorker worker){
        this.worker = worker;
    }
}
