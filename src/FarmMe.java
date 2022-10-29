import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Scanner;

public class FarmMe {

    public ArrayList<Cow> cows;
    public ArrayList<Veterinary> vets;

    public static void main(String[] args){
        FarmMe farm = PopulateData.populate();


        farm.menu();
    }

    public void menu(){

        System.out.println("Welcome to FarmApp!");

        int option;

        do{
            Scanner userInput = new Scanner(System.in);

            System.out.println("(1) Add a new cow");
            System.out.println("(2) Delete a cow");
            System.out.println("(3) Get cow details");
            System.out.println("(4) Add a new vet");
            System.out.println("(5) Delete a vet");
            System.out.println("(6) Get vet details");
            System.out.println("(7) Add treatment");
            System.out.println("(8) Get cow treatment");
            System.out.println("(9) List cows");
            System.out.println("(10) List vets");
            System.out.println("(11) Exit");

            System.out.println("\nEnter your option: ");


            option = userInput.nextInt();

            int tagNo;
            int vetId;
            switch (option){
                case 1:
                    addCow();
                    break;
                case 2:
                    System.out.println("Please enter tagNo of the cow you want to delete: ");
                    tagNo = userInput.nextInt();
                    userInput.nextLine();

                    deleteCow(tagNo);

                    break;
                case 3:
                    System.out.println("Please enter tagNo of the cow you want to see details: ");
                    tagNo = userInput.nextInt();
                    userInput.nextLine();

                    getCowDetails(tagNo);
                    break;
                case 4:
                    addVet();
                    break;
                case 5:
                    System.out.println("Please enter vetID of the vet you want to delete: ");
                    vetId = userInput.nextInt();
                    userInput.nextLine();

                    deleteVet(vetId);
                    break;
                case 6:
                    System.out.println("Please enter vetID of the vet you want to see details: ");
                    vetId = userInput.nextInt();
                    userInput.nextLine();

                    getVetDetails(vetId);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

            System.out.println("\n");

        }while (option != 11);
    }

    public void addCow(){
        Scanner userInput = new Scanner(System.in);

        int tagNo;

        try {
            System.out.println("Enter cow tagNo: ");
            tagNo = userInput.nextInt();

            userInput.nextLine();
        }catch (Exception e){
            System.out.println("Invalid tag number");
            return;
        }


        if(this.cows.stream().anyMatch(x -> x.getTagNo() == tagNo)){
            System.out.println("Cow with this tagNo already exists");
            return;
        }


        String gender;
        System.out.println("Enter gender of the cow (Male/Female): ");
        gender = userInput.nextLine();


        if(!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))){
            System.out.println("Invalid gender (male/female)");
            return;
        }


        LocalDate date;

        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();


        try{
            System.out.println("Enter cow's date of birth (dd/mm/yyyy): ");
            String dateRaw = userInput.nextLine();

            date = LocalDate.parse(dateRaw, dateFormat);
            System.out.println(date.toString());

        }catch (Exception e){
            System.out.println("Invalid date, correct format (dd/mm/yyyy)");
            return;
        }

        int purchasedInt;

        do {
            System.out.println("Enter if cow is purchased or farm-rising (1 for purchased, 0 for farm-rising): ");
            purchasedInt = userInput.nextInt();
            userInput.nextLine();
        }while (purchasedInt != 1 && purchasedInt != 0);


        this.cows.add(new Cow(tagNo, gender, date, purchasedInt == 1));

        System.out.println("\nCow with tagNo " + tagNo + " added successfully");


    }

    public void deleteCow(int tagNo){
        if(this.cows.removeIf(c -> c.getTagNo() == tagNo)){
            System.out.println("Cow with tagNo " + tagNo + " deleted successfully");
        }else{
            System.out.println("Cow with tagNo " + tagNo + " doesn't exist");
        }
    }

    public void getCowDetails(int tagNo){
        if(cows.stream().anyMatch(c -> c.getTagNo() == tagNo)){
            Cow cow = cows.stream().filter(c -> c.getTagNo() == tagNo).findFirst().orElse(null);

            System.out.println("Cow #" + tagNo);
            System.out.println("Gender: " + cow.getGender());
            System.out.println("Date of birth: " + cow.getDateOfBirth().toString());
            System.out.println("Purchase Status: " + (cow.getPurchased() ? "Purchased" : "Farm-rising"));

        }else{
            System.out.println("Cow with tagNo " + tagNo + " doesn't exist");
        }
    }


    public void addVet(){
        Scanner userInput = new Scanner(System.in);

        int vetId;

        try {
            System.out.println("Enter vetId: ");
            vetId = userInput.nextInt();

            userInput.nextLine();
        }catch (Exception e){
            System.out.println("Invalid tag number");
            return;
        }


        if(this.vets.stream().anyMatch(x -> x.getVetID() == vetId)){
            System.out.println("Vet with this vetId already exists");
            return;
        }


        String gender;
        System.out.println("Enter gender of the vet (Male/Female): ");
        gender = userInput.nextLine();


        if(!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))){
            System.out.println("Invalid gender (male/female)");
            return;
        }


        LocalDate date;

        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();


        try{
            System.out.println("Enter vet's date of birth (dd/mm/yyyy): ");
            String dateRaw = userInput.nextLine();

            date = LocalDate.parse(dateRaw, dateFormat);
            System.out.println(date.toString());

        }catch (Exception e){
            System.out.println("Invalid date, correct format (dd/mm/yyyy)");
            return;
        }

        System.out.println("Enter salary of the vet: ");
        double salary = userInput.nextDouble();
        userInput.nextLine();

        this.vets.add(new Veterinary(vetId, gender, date, salary));
        System.out.println("Vet added successfully!\n");

    }

    public void deleteVet(int vetID){
        if(this.vets.removeIf(c -> c.getVetID() == vetID)){
            System.out.println("Vet with tagNo " + vetID + " deleted successfully");
        }else{
            System.out.println("Vet with tagNo " + vetID + " doesn't exist");
        }
    }

    public void getVetDetails(int vetId){
        if(vets.stream().anyMatch(c -> c.getVetID() == vetId)){
            Veterinary vet = vets.stream().filter(c -> c.getVetID() == vetId).findFirst().orElse(null);

            System.out.println("Vet #" + vetId);
            System.out.println("Gender: " + vet.getGender());
            System.out.println("Date of birth: " + vet.getDateOfBirth().toString());
            System.out.println("Salary: $" + vet.getSalary());

        }else{
            System.out.println("Vet with vetID " + vetId + " doesn't exist");
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
