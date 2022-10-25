import java.time.LocalDate;

public class Treatment {
    private LocalDate dateOfTreatment;
    private String details;

    public LocalDate getDateOfTreatment() {
        return dateOfTreatment;
    }

    public String getDetails() {
        return details;
    }

    public void setDateOfTreatment(LocalDate dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
