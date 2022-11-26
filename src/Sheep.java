import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Sheep extends Animal{


    public Sheep(int tagNo, String gender, LocalDate dateOfBirth, boolean purchased){
        this.setTagNo(tagNo);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
        this.setPurchased(purchased);
        this.setTreatments(new ArrayList<Treatment>());
        this.setMilking(new HashMap<LocalDate, Double>());
    }

    public Sheep(int tagNo, String gender, boolean purchased){
        this.setTagNo(tagNo);
        this.setGender(gender);
        this.setDateOfBirth(LocalDate.now());
        this.setPurchased(purchased);
        this.setTreatments(new ArrayList<Treatment>());
        this.setMilking(new HashMap<LocalDate, Double>());
    }

    //TODO: Constructor
    public void feeding() {
        if(this.getGender() == "male" && this.getAge() < 5){
            /*only grass*/
        }else if(this.getGender() == "female" && this.getAge() < 8){
            /*only grass*/
        }else if(this.getGender() == "male" && this.getAge() > 5){
            /*Total mixed
ration (TMR) diet is needed. */
        }else if(this.getGender() == "female" && this.getAge() > 8){
            /* Total
mixed ration (TMR) diet is needed.*/
        }

    }
}
