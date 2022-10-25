import java.time.LocalDate;

public class Medication {
    private String details;
    private int duration;
    private LocalDate startDate;
    private double dosage;
    private String notes;

    public String getDetails() {
        return details;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public double getDosage() {
        return dosage;
    }

    public String getNotes() {
        return notes;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
