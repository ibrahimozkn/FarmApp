import java.time.LocalDate;

/**
 * The type Medication.
 */
public class Medication {
    private String details;
    private int duration;
    private LocalDate startDate;
    private double dosage;
    private String notes;


    /**
     * Instantiates a new Medication.
     *
     * @param details   the details
     * @param duration  the duration
     * @param startDate the start date
     * @param dosage    the dosage
     * @param notes     the notes
     */
    public Medication(String details, int duration, LocalDate startDate, double dosage, String notes){
        this.details = details;
        this.duration = duration;
        this.startDate = startDate;
        this.dosage = dosage;
        this.notes = notes;
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
     * Gets duration.
     *
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets start date.
     *
     * @return the start date
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Gets dosage.
     *
     * @return the dosage
     */
    public double getDosage() {
        return dosage;
    }

    /**
     * Gets notes.
     *
     * @return the notes
     */
    public String getNotes() {
        return notes;
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
     * Sets duration.
     *
     * @param duration the duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Sets start date.
     *
     * @param startDate the start date
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Sets dosage.
     *
     * @param dosage the dosage
     */
    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    /**
     * Sets notes.
     *
     * @param notes the notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
