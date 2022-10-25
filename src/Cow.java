import java.time.LocalDate;
import java.time.Period;

public class Cow {
    private int tagNo;
    private String gender;
    private LocalDate dateOfBirth;
    private boolean purchased;



    public int getAge(){
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }


    public int getTagNo(){
        return this.tagNo;
    }

    public String getGender(){
        return this.gender;
    }

    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }

    public boolean getPurchased(){
        return this.purchased;
    }

    public void setTagNo(int tagNo){
       this.tagNo = tagNo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}