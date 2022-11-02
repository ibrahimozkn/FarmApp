import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * FarmMe is the main class that whole FarmApp is operated. It stores some information about the farm such as
 * <ul>
 *     <li>List of cows</li>
 *     <li>List of vets</li>
 * </ul>
 *
 * @author Ibrahim Ozkan
 * @version %I% %G%
 * @since 1.0
 */
public class FarmMe {

    /**
     * List of cows
     *
     * @see Cow
     */
    public ArrayList<Cow> cows;
    /**
     * List of vets
     *
     * @see Veterinary
     */
    public ArrayList<Veterinary> vets;

    /**
     * Main method that is executed when program runs.
     *
     * @param args the arguments in command line
     * @since 1.0
     */
    public static void main(String[] args){
        FarmMe farm = PopulateData.populate();
        farm.menu();
    }

    /**
     * Command Line interface that will be shown to the users in order to
     * interact with the program. Users can select various options such as:
     * <ul>
     *     <li>Add a new cow</li>
     *     <li>Delete a cow</li>
     *     <li>Get cow details</li>
     *     <li>Add a new vet</li>
     *     <li>Get vet details</li>
     *     <li>Add treatment</li>
     *     <li>List cows</li>
     *     <li>List vets</li>
     *     <li>Exit</li>
     * </ul>
     *
     * @since 1.0
     */
    public void menu(){

        System.out.println("Welcome to FarmApp!");

        int option;

        while(true){
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
                case 7:
                    System.out.println("Please enter vetID: ");
                    vetId = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("Please enter tagNo: ");
                    tagNo = userInput.nextInt();
                    userInput.nextLine();

                    addTreatment(vetId, tagNo);

                    break;
                case 8:
                    System.out.println("Please enter tagNo: ");
                    tagNo = userInput.nextInt();
                    userInput.nextLine();

                    try{
                        System.out.println("Please enter date of treatment (leave empty if no date): ");
                        String dateRaw = userInput.nextLine();

                        if(dateRaw.isEmpty() || dateRaw.isBlank()){
                            getCowTreatment(tagNo);
                            break;
                        }

                        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();
                        LocalDate date = LocalDate.parse(dateRaw, dateFormat);

                        getCowTreatment(tagNo, date);

                    }catch (Exception e){
                        System.out.println("Invalid date");
                        break;
                    }

                    break;
                case 9:
                    listCow();
                    break;
                case 10:
                    listVet();
                    break;
                case 11:
                    exit();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

            System.out.println("\n");

        }
    }

    /**
     * First, collects data from the user about cow object. Then adds a new cow object to FarmMe's cow list.
     *
     * @since 1.0
     */
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


        for (Cow cow:
             cows) {
            if(cow.getTagNo() == tagNo){
                System.out.println("Cow with this tagNo already exists");
                return;
            }

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

    /**
     * Deletes cow object from the list of cows with the matching tagNo if exists. If cow with tag no doesnt exist
     * prints user an error message.
     *
     * @param tagNo tag number of the cow
     * @since 1.0
     */
    public void deleteCow(int tagNo){
        for (Cow cow:
             this.cows) {
            if(cow.getTagNo() == tagNo){
                cows.remove(cow);
                System.out.println("Cow with tagNo " + tagNo + " deleted successfully");
                return;
            }

        }

        System.out.println("Cow with tagNo " + tagNo + " doesn't exist");

    }

    /**
     * Shows details of the cow with matching tagNo. If cow doesnt exist, method prints user an error message.
     *
     * @param tagNo the tag no
     * @since 1.0
     */
    public void getCowDetails(int tagNo){


        for (Cow cow:
             this.cows) {
            if(cow.getTagNo() == tagNo){
                DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();


                System.out.println("Cow #" + tagNo);
                System.out.println("    Gender: " + cow.getGender());
                System.out.println("    Date of birth: " + cow.getDateOfBirth().format(dateFormat));
                System.out.println("    Age: " + cow.getAge());
                System.out.println("    Purchase Status: " + (cow.getPurchased() ? "Purchased" : "Farm-rising"));
                return;
            }
        }

        System.out.println("Cow with tagNo " + tagNo + " doesn't exist");

    }


    /**
     * First collects required data to create Veterinary object from the user, then adds new Veterinary object to the list of vets
     *
     * @since 1.0
     */
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


        for (Veterinary vetTemp:
             this.vets) {
            if(vetTemp.getVetID() == vetId){
                System.out.println("Vet with this vetId already exists");
                return;
            }
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

    /**
     * Finds matching veterinary object with vetID and deletes from the vets list. If veterinary with the provided
     * doesn't exist, it prints error message
     *
     * @param vetID vets identity number
     */
    public void deleteVet(int vetID){
        for (Veterinary vetTemp:
                this.vets) {
            if(vetTemp.getVetID() == vetID){
                vets.remove(vetTemp);
                System.out.println("Vet with tagNo " + vetID + " deleted successfully");
                return;
            }
        }

        System.out.println("Vet with tagNo " + vetID + " doesn't exist");

    }

    /**
     * Prints the details of the matching veterinary object with the provided vetid. If vet with given vetid
     * doesn't exist error message is printed.
     *
     * @param vetId vet Id
     */
    public void getVetDetails(int vetId){

        for (Veterinary vet:
             vets) {
            if(vet.getVetID() == vetId){
                DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();


                System.out.println("Vet #" + vetId);
                System.out.println("    Gender: " + vet.getGender());
                System.out.println("    Date of birth: " + vet.getDateOfBirth().format(dateFormat));
                System.out.println("    Salary: $" + vet.getSalary());
                return;
            }
        }


        System.out.println("Vet with vetID " + vetId + " doesn't exist");



    }

    /**
     * Add treatment to a cow with given vet id and tag number. Also gets user input about medications that are involved in the treatment.
     * If any of the provided veterinary object or cow object doesn't exist
     * method prints an error message.
     *
     * @param vetID id number of the vet
     * @param tagNo tag number of the cow
     */
    public void addTreatment(int vetID, int tagNo){
        Veterinary vet = null;

        for (Veterinary vetTemp:
                this.vets) {
            if(vetTemp.getVetID() == vetID){
                vet = vetTemp;
                break;
            }
        }

        if(vet == null){
            System.out.println("Vet with vetID " + vetID + " doesn't exist");
            return;
        }

        Cow cow = null;

        for (Cow cowTemp:
                this.cows) {
            if(cowTemp.getTagNo() == tagNo){
                cow = cowTemp;
                break;
            }

        }

        if(cow == null){
            System.out.println("Cow with tagNo " + tagNo + " doesn't exist");
            return;
        }

        Scanner userInput = new Scanner(System.in);


        LocalDate date;

        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();


        while (true){
            try{
                System.out.println("Enter date of treatment (dd/mm/yyyy): ");
                String dateRaw = userInput.nextLine();

                date = LocalDate.parse(dateRaw, dateFormat);
                System.out.println(date.toString());
                break;

            }catch (Exception e){
                System.out.println("Invalid date, correct format (dd/mm/yyyy)");
                continue;
            }
        }

        System.out.println("Please enter details of treatment");
        String details = userInput.nextLine();



        System.out.println("Please enter medication details of the treatment");


        Treatment treatment = new Treatment(date, details, vet);

        int counter = 1;
        while (true){
            System.out.println("Medication #" + counter);
            System.out.println("Please enter details of the medication");
            String medDetails = userInput.nextLine();

            System.out.println("Please enter the duration of medication");
            int duration = userInput.nextInt();
            userInput.nextLine();

            LocalDate startDate;

            while (true){
                try{
                    System.out.println("Enter start date of medication (dd/mm/yyyy): ");
                    String dateRaw = userInput.nextLine();

                    startDate = LocalDate.parse(dateRaw, dateFormat);
                    System.out.println(startDate.toString());
                    break;

                }catch (Exception e){
                    System.out.println("Invalid date, correct format (dd/mm/yyyy)");
                    continue;
                }
            }

            System.out.println("Please enter the dosage of medication");
            double dosage = userInput.nextDouble();
            userInput.nextLine();

            System.out.println("Please enter the notes of medication");
            String notes = userInput.nextLine();


            treatment.hasMedication(new Medication(medDetails, duration, startDate, dosage, notes));
            System.out.println("Medication added successfully");


            System.out.println("\nDo you want to stop adding medication and confirm treatment? Type (1) for yes");
            int addMed = userInput.nextInt();
            userInput.nextLine();

            if(addMed == 1) break;
            counter++;

        }

        cow.hasTreatment(treatment);
        System.out.println("Treatment is added to cow with tagNo " + tagNo + " successfully");


    }

    /**
     * Prints treatment details of the cow with it's medication details. If cow doesn't exist, it prints error message
     *
     * @param tagNo the tag no
     */
    public void getCowTreatment(int tagNo){

        Cow cow = null;

        for (Cow cowTemp:
                this.cows) {
            if(cowTemp.getTagNo() == tagNo){
                cow = cowTemp;
                break;
            }

        }
        if(cow == null){
            System.out.println("Cow with tagNo " + tagNo + " doesn't exist");
            return;
        }

        if(cow.getTreatments().isEmpty()){
            System.out.println("Cow has no treatments");
            return;
        }

        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

        int counter = 1;
        for (Treatment treatment: cow.getTreatments()) {
            System.out.println("Treatment #" + counter);
            System.out.println("    Date of treatment: " + treatment.getDateOfTreatment().format(dateFormat));
            System.out.println("    Details: " + treatment.getDetails());
            System.out.println("    Treatment given by: Vet#" + treatment.getVet().getVetID());

            System.out.println("    Medications:");

            int medCount = 1;
            for (Medication medication:
                 treatment.getMedications()) {
                System.out.println("\n      Medication #" + medCount);
                System.out.println("            Details: " + medication.getDetails());
                System.out.println("            Duration: " + medication.getDuration());
                System.out.println("            Start Date: " + medication.getStartDate().format(dateFormat));
                System.out.println("            Dosage: " + medication.getDosage());
                System.out.println("            Notes: " + medication.getNotes());

                medCount++;

            }

            System.out.println("\n");
            counter++;
        }
    }

    /**
     * Retrieves all treatments of a cow at a exact date that is given from the user. If cow or treatment doesn't exist, method prints an error message.
     *
     * @param tagNo           the tag no
     * @param dateOfTreatment the date of treatment
     */
    public void getCowTreatment(int tagNo, LocalDate dateOfTreatment){


        Cow cow = null;

        for (Cow cowTemp:
                this.cows) {
            if(cowTemp.getTagNo() == tagNo){
                cow = cowTemp;
                break;
            }

        }
        if(cow == null){
            System.out.println("Cow with tagNo " + tagNo + " doesn't exist");
            return;
        }

        if(cow.getTreatments().isEmpty()){
            System.out.println("Cow has no treatments");
            return;
        }

        ArrayList<Treatment> treatments = new ArrayList<Treatment>();

        for (Treatment treatmentTemp:
             cow.getTreatments()) {
            if(treatmentTemp.getDateOfTreatment().equals(dateOfTreatment)){
                treatments.add(treatmentTemp);
            }
        }

        if(treatments.isEmpty()){
            System.out.println("Cow has no treatments at that date");
            return;
        }

        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

        int counter = 1;
        for (Treatment treatment: treatments) {
            System.out.println("Treatment #" + counter);
            System.out.println("    Date of treatment: " + treatment.getDateOfTreatment().format(dateFormat));
            System.out.println("    Details: " + treatment.getDetails());
            System.out.println("    Treatment given by: Vet#" + treatment.getVet().getVetID());

            System.out.println("    Medications:");

            int medCount = 1;
            for (Medication medication:
                    treatment.getMedications()) {
                System.out.println("\n      Medication #" + medCount);
                System.out.println("            Details: " + medication.getDetails());
                System.out.println("            Duration: " + medication.getDuration());
                System.out.println("            Start Date: " + medication.getStartDate().format(dateFormat));
                System.out.println("            Dosage: " + medication.getDosage());
                System.out.println("            Notes: " + medication.getNotes());

                medCount++;

            }


            counter++;
        }
    }

    /**
     * Lists all the cows that are found in the app with their details
     */
    public void listCow(){
        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

        System.out.println("All cows that are in the system: ");

        for (Cow cow:
             this.cows) {
            System.out.println("Cow with tag number: " + cow.getTagNo());
            System.out.println("    Gender: " + cow.getGender());
            System.out.println("    Date of birth: " + cow.getDateOfBirth().format(dateFormat));
            System.out.println("    Age: " + cow.getAge());
            System.out.println("    Type: " + (cow.getPurchased() ? "Purchased" : "Farm-rising"));


        }
    }

    /**
     * Lists all the vets that are found in the app with their details
     */
    public void listVet(){
        System.out.println("All vets that are in the system: ");
        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

        for (Veterinary vet:
                this.vets) {
            System.out.println("Vet with vet id: " + vet.getVetID());
            System.out.println("    Gender: " + vet.getGender());
            System.out.println("    Date of birth: " + vet.getDateOfBirth().format(dateFormat));
            System.out.println("    Salary: $" + vet.getSalary());
        }
    }

    /**
     * Terminates the program
     */
    public void exit(){
        System.out.println("Goodbye!");
        System.exit(0);
    }

    /**
     * Instantiates a new Farm me with empty cow and vet list
     */
    public FarmMe(){
        this.cows = new ArrayList<Cow>();
        this.vets = new ArrayList<Veterinary>();
    }

    /**
     * Instantiates a new Farm me with cow list and empty vet list
     *
     * @param cows list of the cows
     */
    public FarmMe(ArrayList<Cow> cows){
        this.cows = new ArrayList<Cow>(cows);
        this.vets = new ArrayList<Veterinary>();
    }

    /**
     * Instantiates a new Farm me with cow and vet list
     *
     * @param cows list of the cows
     * @param vets list of the vets
     */
    public FarmMe(ArrayList<Cow> cows, ArrayList<Veterinary> vets){
        this.cows = new ArrayList<Cow>(cows);
        this.vets = new ArrayList<Veterinary>(vets);
    }


}
