import java.time.LocalDate;
import java.util.ArrayList;

public class HealthTreatment extends Treatment {
    private boolean emergency;
    private Veterinary vet;
    private ArrayList<Medication> medications;


    public HealthTreatment(boolean emergency, Veterinary vet){
        this.setDateOfTreatment(LocalDate.now());
        this.emergency = emergency;
        this.vet = vet;
        this.medications = new ArrayList<Medication>();
    }

    public HealthTreatment(LocalDate date, boolean emergency, Veterinary vet){
        this.setDateOfTreatment(date);
        this.emergency = emergency;
        this.vet = vet;
        this.medications = new ArrayList<Medication>();
    }



    public HealthTreatment(LocalDate date, boolean emergency){
        this.setDateOfTreatment(date);
        this.emergency = emergency;
        this.medications = new ArrayList<Medication>();
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public Veterinary getVet() {
        return vet;
    }

    public void setVet(Veterinary vet) {
        this.vet = vet;
    }

    public ArrayList<Medication> getMedications() {
        return medications;
    }

    public void hGivenBy(Veterinary vet){
        this.vet = vet;
    }

    public void hasMedications(ArrayList<Medication> medications){
        this.medications = medications;
    }

    public void addMedication(Medication medication){
        this.medications.add(medication);
    }

}
