import java.time.LocalDate;
//TODO: Write desc

/**
 * This class represents medication which is going to be used in a treatment.
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
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
     * Instantiates a new Medication.
     *
     * @param details   the details
     * @param duration  the duration
     * @param startDate the start date
     * @param dosage    the dosage
     */
    public Medication(String details, int duration, LocalDate startDate, double dosage){
        this.details = details;
        this.duration = duration;
        this.startDate = startDate;
        this.dosage = dosage;
        this.notes = "";
    }

    /**
     * Gets details of the medication.
     *
     * @return details of the medication
     */
    public String getDetails() {
        return details;
    }

    /**
     * Gets duration of the medication
     *
     * @return duration of the medication
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets start date of the medication
     *
     * @return start date of the medication
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Gets dosage of the medication
     *
     * @return dosage of the medication
     */
    public double getDosage() {
        return dosage;
    }

    /**
     * Gets notes of the medication
     *
     * @return notes of the medication
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets details of the medication
     *
     * @param details details of the medication
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Sets duration.
     *
     * @param duration duration of the medication
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Sets start date of the medication
     *
     * @param startDate the start date
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Sets dosage of the medication
     *
     * @param dosage dosage of the medication
     */
    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    /**
     * Sets notes of the medication
     *
     * @param notes notes of the medication
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
