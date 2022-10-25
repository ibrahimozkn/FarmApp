import java.util.ArrayList;

public class FarmMe {

    public ArrayList<Cow> cows;
    public ArrayList<Veterinary> vets;

    public static void main(String[] args){

    }

    public void menu(){

    }

    public void addCow(Cow cow){
        this.cows.add(cow);
    }

    public void deleteCow(int tagNo){
        if(this.cows.removeIf(c -> c.getTagNo() == tagNo)){

        }else{

        }
    }

    public FarmMe(){
        this.cows = new ArrayList<Cow>();
        this.vets = new ArrayList<Veterinary>();
    }

    public FarmMe(ArrayList<Cow> cows){
        this.cows = new ArrayList<Cow>(cows);
        this.vets = new ArrayList<Veterinary>();
    }

    public FarmMe(ArrayList<Cow> cows, ArrayList<Veterinary> vets){
        this.cows = new ArrayList<Cow>(cows);
        this.vets = new ArrayList<Veterinary>(vets);
    }


}
