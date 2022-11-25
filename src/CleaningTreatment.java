import java.time.LocalDate;

public class CleaningTreatment extends Treatment{
    private String materialsUsed;
    private FarmWorker worker;

    public CleaningTreatment(){
        this.setDateOfTreatment(LocalDate.now());
        materialsUsed = "";
    }

    public CleaningTreatment(LocalDate dateOfTreatment, String materialsUsed){
        this.materialsUsed = materialsUsed;
        this.setDateOfTreatment(dateOfTreatment);

    }

    public CleaningTreatment(LocalDate dateOfTreatment, String materialsUsed, FarmWorker worker){
        this.materialsUsed = materialsUsed;
        this.setDateOfTreatment(dateOfTreatment);
        this.worker = worker;
    }

    public String getMaterialsUsed() {
        return materialsUsed;
    }

    public void setMaterialsUsed(String materialsUsed) {
        this.materialsUsed = materialsUsed;
    }

    public FarmWorker getWorker() {
        return worker;
    }

    public void cGivenBy(FarmWorker worker){
        this.worker = worker;
    }
}
