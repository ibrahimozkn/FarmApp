public class Sheep extends Animal{

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
