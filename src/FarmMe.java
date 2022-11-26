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
 * @version 1.0
 * @since 1.0
 */
public class FarmMe {

    /**
     * List of cows
     *
     * @see Cow
     */
    public ArrayList<Animal> animals;

    /**
     * List of vets
     *
     * @see Veterinary
     */
    public ArrayList<Employee> employees;

    /**
     * Main method that is executed when program runs.
     *
     * @param args the arguments in command line
     */
    public static void main(String[] args){
        //FarmMe farm = PopulateData.populate();
        FarmMe farm = new FarmMe();
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
                    try {
                        System.out.println("Please enter tagNo: ");
                        tagNo = userInput.nextInt();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid tag no");
                        break;
                    }


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


        for (Animal animal:
                animals) {
            if(animal.getTagNo() == tagNo){
                System.out.println("Animal with this tagNo already exists");
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



        double weight;

        System.out.println("Please enter the weight of the cow: ");
        weight = userInput.nextDouble();
        userInput.nextLine();


        this.animals.add(new Cow(tagNo, gender, date, purchasedInt == 1, weight));

        System.out.println("\nCow with tagNo " + tagNo + " added successfully");


    }


    public void addSheep(){
        Scanner userInput = new Scanner(System.in);

        int tagNo;

        try {
            System.out.println("Enter sheep tagNo: ");
            tagNo = userInput.nextInt();

            userInput.nextLine();
        }catch (Exception e){
            System.out.println("Invalid tag number");
            return;
        }


        for (Animal animal:
                animals) {
            if(animal.getTagNo() == tagNo){
                System.out.println("Animal with this tagNo already exists");
                return;
            }

        }


        String gender;
        System.out.println("Enter gender of the sheep (Male/Female): ");
        gender = userInput.nextLine();


        if(!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))){
            System.out.println("Invalid gender (male/female)");
            return;
        }


        LocalDate date;

        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();


        try{
            System.out.println("Enter sheep's date of birth (dd/mm/yyyy): ");
            String dateRaw = userInput.nextLine();

            date = LocalDate.parse(dateRaw, dateFormat);
            System.out.println(date.toString());

        }catch (Exception e){
            System.out.println("Invalid date, correct format (dd/mm/yyyy)");
            return;
        }

        int purchasedInt;

        do {
            System.out.println("Enter if sheep is purchased or farm-rising (1 for purchased, 0 for farm-rising): ");
            purchasedInt = userInput.nextInt();
            userInput.nextLine();
        }while (purchasedInt != 1 && purchasedInt != 0);



        this.animals.add(new Sheep(tagNo, gender, date, purchasedInt == 1));

        System.out.println("\nSheep with tagNo " + tagNo + " added successfully");


    }

    /**
     * Deletes cow object from the list of cows with the matching tagNo if exists. If cow with tag no doesn't exist
     * prints user an error message.
     *
     * @param tagNo tag number of the cow
     */
    public void deleteCow(int tagNo){
        for (Animal animal:
             this.animals) {
            if(animal.getTagNo() == tagNo && animal instanceof Cow){
                animals.remove(animal);
                System.out.println("Cow with tagNo " + tagNo + " deleted successfully");
                return;
            }

        }

        System.out.println("Cow with tagNo " + tagNo + " doesn't exist");

    }

    public void deleteSheep(int tagNo){
        for (Animal animal:
                this.animals) {
            if(animal.getTagNo() == tagNo && animal instanceof Sheep){
                animals.remove(animal);
                System.out.println("Sheep with tagNo " + tagNo + " deleted successfully");
                return;
            }

        }

        System.out.println("Sheep with tagNo " + tagNo + " doesn't exist");

    }

    /**
     * Shows details of the cow with matching tagNo. If cow doesn't exist, method prints user an error message.
     *
     * @param tagNo the tag no
     */
    public void getCowDetails(int tagNo){


        for (Animal animal:
             this.animals) {
            if(animal.getTagNo() == tagNo && animal instanceof Cow){
                DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();


                System.out.println("Cow #" + tagNo);
                System.out.println("    Gender: " + animal.getGender());
                System.out.println("    Date of birth: " + animal.getDateOfBirth().format(dateFormat));
                System.out.println("    Age: " + animal.getAge());
                System.out.println("    Purchase Status: " + (animal.getPurchased() ? "Purchased" : "Farm-rising"));
                System.out.println("    Weight: " + ((Cow) animal).getWeight());
                return;
            }
        }

        System.out.println("Cow with tagNo " + tagNo + " doesn't exist");

    }


    public void getSheepDetails(int tagNo){


        for (Animal animal:
                this.animals) {
            if(animal.getTagNo() == tagNo && animal instanceof Sheep){
                DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();


                System.out.println("Sheep #" + tagNo);
                System.out.println("    Gender: " + animal.getGender());
                System.out.println("    Date of birth: " + animal.getDateOfBirth().format(dateFormat));
                System.out.println("    Age: " + animal.getAge());
                System.out.println("    Purchase Status: " + (animal.getPurchased() ? "Purchased" : "Farm-rising"));
                return;
            }
        }

        System.out.println("Sheep with tagNo " + tagNo + " doesn't exist");

    }

    /**
     * First collects required data to create Veterinary object from the user, then adds new Veterinary object to the list of vets
     *
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


        for (Employee vetTemp:
             this.employees) {
            if(vetTemp.getEmpID() == vetId){
                System.out.println("Employee with this vetId already exists");
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

        LocalDate dateofGrad;

        try{
            System.out.println("Enter vet's date of graduation (dd/mm/yyyy): ");
            String dateRaw = userInput.nextLine();

            dateofGrad = LocalDate.parse(dateRaw, dateFormat);
            //System.out.println(date.toString());

        }catch (Exception e){
            System.out.println("Invalid date, correct format (dd/mm/yyyy)");
            return;
        }

        int hasDegree = -1;

        do {
            try{
                System.out.println("Enter if vet has BSc Degree (1 yes, 0 for no): ");
                hasDegree = userInput.nextInt();
                userInput.nextLine();
            }catch (Exception ex){
                System.out.println("Please enter valid degree option");
            }

        }while (hasDegree != 1 && hasDegree != 0);

        int expertiseLevel;

        try{
            System.out.println("Enter expertise level of the vet: ");
            expertiseLevel = userInput.nextInt();
        }catch (Exception ex){
            System.out.println("Please enter proper level (integer values)");
            return;
        }


        userInput.nextLine();


        this.employees.add(new Veterinary(vetId, gender, date, hasDegree == 1, dateofGrad, expertiseLevel));
        System.out.println("Vet added successfully!\n");

    }

    /**
     * Finds matching veterinary object with vetID and deletes from the vets list. If veterinary with the provided
     * doesn't exist, it prints error message
     *
     * @param vetID vets identity number
     */
    public void deleteVet(int vetID){
        for (Employee vetTemp:
                this.employees) {
            if(vetTemp.getEmpID() == vetID && vetTemp instanceof Veterinary){
                employees.remove(vetTemp);
                System.out.println("Vet with tagNo " + vetID + " deleted successfully");
                return;
            }
        }

        System.out.println("Vet with empID " + vetID + " doesn't exist");

    }

    /**
     * Prints the details of the matching veterinary object with the provided vetid. If vet with given vetid
     * doesn't exist error message is printed.
     *
     * @param vetId vet Id
     */
    public void getVetDetails(int vetId){

        for (Employee vet:
                employees) {
            if(vet.getEmpID() == vetId && vet instanceof Veterinary){
                DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();


                System.out.println("Vet #" + vetId);
                System.out.println("    Gender: " + vet.getGender());
                System.out.println("    Date of birth: " + vet.getDateOfBirth().format(dateFormat));
                System.out.println("    Has BSc Degree: $" + ((Veterinary) vet).getBScDegree());
                System.out.println("    Date of graduation: $" + ((Veterinary) vet).getDateOfGraduation().format(dateFormat));
                System.out.println("    Expertise level: $" + ((Veterinary) vet).getExpertiseLevel());
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
     * @param empID id number of the vet
     * @param tagNo tag number of the cow
     */
    public void addTreatment(int empID, int tagNo){
        Employee employee = null;

        for (Employee empTemp:
                this.employees) {
            if(empTemp.getEmpID() == empID){
                employee = empTemp;
                break;
            }
        }

        if(employee == null){
            System.out.println("Employee with id " + empID + " doesn't exist");
            return;
        }

        Animal animal = null;

        for (Animal animalTemp:
                this.animals) {
            if(animalTemp.getTagNo() == tagNo ){
                animal = animalTemp;
                break;
            }

        }

        if(animal == null){
            System.out.println("Animal with tagNo " + tagNo + " doesn't exist");
            return;
        }

        Scanner userInput = new Scanner(System.in);


        System.out.println("Please enter (1) for Cleaning (2) for Health related treatment: ");
        int treatmentType;

        try{
            treatmentType = userInput.nextInt();
            userInput.nextLine();
        }catch (Exception e){
            System.out.println("Invalid treatment option");
            return;
        }

        if(treatmentType == 1 && !(employee instanceof FarmWorker)){
            System.out.println("Employee for Cleaning Treatment needs to be a farm worker.");
            return;
        }else if(treatmentType == 1 && !(employee instanceof Veterinary)){
            System.out.println("Employee for Health Treatment needs to be a vet.");
            return;
        }

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
            }
        }
/*
        Treatment treatment;

        if(treatmentType == 1){
            treatment = new CleaningTreatment();
        }else if(treatmentType == 2){
            treatment = new HealthTreatment();
        }else{
            System.out.println("Invalid treatment option");
            return;
        }*/



        if(treatmentType == 1){
            String materialsUsed;

            System.out.println("Please enter materials used for the treatment: ");
            materialsUsed = userInput.nextLine();

            CleaningTreatment cleaningTreatment = new CleaningTreatment(date, materialsUsed);

            cleaningTreatment.cGivenBy((FarmWorker) employee);

            animal.hasTreatment(cleaningTreatment);

        }else if(treatmentType == 2){
            int emergency;



            System.out.println("Please enter (1) for Emergency (0) for Not Emergency: ");

            try{
                emergency = userInput.nextInt();
                userInput.nextLine();
            }catch (Exception e){
                System.out.println("Invalid treatment option");
                return;
            }


            HealthTreatment healthTreatment = new HealthTreatment(date, emergency == 1);


            healthTreatment.hGivenBy((Veterinary) employee);//hi

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
                    }
                }

                System.out.println("Please enter the dosage of medication");
                double dosage = userInput.nextDouble();
                userInput.nextLine();

                System.out.println("Please enter the notes of medication");
                String notes = userInput.nextLine();


                healthTreatment.addMedication(new Medication(medDetails, duration, startDate, dosage, notes));
                System.out.println("Medication added successfully");


                System.out.println("\nDo you want to stop adding medication and confirm treatment? Type (1) for yes");
                int addMed = userInput.nextInt();
                userInput.nextLine();

                if(addMed == 1) break;
                counter++;

            }
            animal.hasTreatment(healthTreatment);


        }else{
            System.out.println("Invalid treatment type");
            return;
        }

        System.out.println("Treatment is added to animal with tagNo " + tagNo + " successfully");


    }

    /**
     * Prints treatment details of the cow with its medication details. If cow doesn't exist, it prints error message
     *
     * @param tagNo the tag no
     */
    public void getCowTreatment(int tagNo){

        Cow cow = null;

        for (Animal cowTemp:
                this.animals) {
            if(cowTemp.getTagNo() == tagNo && cowTemp instanceof Cow){
                cow = (Cow) cowTemp;
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
            if(treatment instanceof HealthTreatment hTreatment){
                System.out.println("Health Treatment #" + counter);
                System.out.println("    Date of treatment: " + treatment.getDateOfTreatment().format(dateFormat));
                System.out.println("    Emergency: " + hTreatment.isEmergency());
                System.out.println("    Treatment given by: Vet#" + hTreatment.getVet().getEmpID());

                System.out.println("    Medications:");

                int medCount = 1;
                for (Medication medication:
                        hTreatment.getMedications()) {
                    System.out.println("\n      Medication #" + medCount);
                    System.out.println("            Details: " + medication.getDetails());
                    System.out.println("            Duration: " + medication.getDuration());
                    System.out.println("            Start Date: " + medication.getStartDate().format(dateFormat));
                    System.out.println("            Dosage: " + medication.getDosage());
                    System.out.println("            Notes: " + medication.getNotes());

                    medCount++;

                }

                System.out.println("\n");

            }else if(treatment instanceof CleaningTreatment cTreatment){
                System.out.println("Cleaning Treatment #" + counter);
                System.out.println("    Date of treatment: " + treatment.getDateOfTreatment().format(dateFormat));
                System.out.println("    Materials used: " + cTreatment.getMaterialsUsed());
                System.out.println("    Treatment given by: Farm Worker#" + cTreatment.getWorker().getEmpID());
            }

            counter++;
        }
    }

    public void getSheepTreatment(int tagNo){

        Sheep sheep = null;

        for (Animal sheepTemp:
                this.animals) {
            if(sheepTemp.getTagNo() == tagNo && sheepTemp instanceof Sheep){
                sheep = (Sheep) sheepTemp;
                break;
            }

        }
        if(sheep == null){
            System.out.println("Sheep with tagNo " + tagNo + " doesn't exist");
            return;
        }

        if(sheep.getTreatments().isEmpty()){
            System.out.println("Sheep has no treatments");
            return;
        }

        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

        int counter = 1;
        for (Treatment treatment: sheep.getTreatments()) {
            if(treatment instanceof HealthTreatment hTreatment){
                System.out.println("Health Treatment #" + counter);
                System.out.println("    Date of treatment: " + treatment.getDateOfTreatment().format(dateFormat));
                System.out.println("    Emergency: " + hTreatment.isEmergency());
                System.out.println("    Treatment given by: Vet#" + hTreatment.getVet().getEmpID());

                System.out.println("    Medications:");

                int medCount = 1;
                for (Medication medication:
                        hTreatment.getMedications()) {
                    System.out.println("\n      Medication #" + medCount);
                    System.out.println("            Details: " + medication.getDetails());
                    System.out.println("            Duration: " + medication.getDuration());
                    System.out.println("            Start Date: " + medication.getStartDate().format(dateFormat));
                    System.out.println("            Dosage: " + medication.getDosage());
                    System.out.println("            Notes: " + medication.getNotes());

                    medCount++;

                }

                System.out.println("\n");

            }else if(treatment instanceof CleaningTreatment cTreatment){
                System.out.println("Cleaning Treatment #" + counter);
                System.out.println("    Date of treatment: " + treatment.getDateOfTreatment().format(dateFormat));
                System.out.println("    Materials used: " + cTreatment.getMaterialsUsed());
                System.out.println("    Treatment given by: Farm Worker#" + cTreatment.getWorker().getEmpID());
            }

            counter++;
        }
    }

    /**
     * Retrieves all treatments of a cow at an exact date that is given from the user. If cow or treatment doesn't exist, method prints an error message.
     *
     * @param tagNo           the tag no
     * @param dateOfTreatment the date of treatment
     */
    public void getCowTreatment(int tagNo, LocalDate dateOfTreatment){


        Cow cow = null;

        for (Animal cowTemp:
                this.animals) {
            if(cowTemp.getTagNo() == tagNo && cowTemp instanceof Cow){
                cow = (Cow) cowTemp;
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
            if(treatment instanceof HealthTreatment hTreatment){
                System.out.println("Health Treatment #" + counter);
                System.out.println("    Date of treatment: " + treatment.getDateOfTreatment().format(dateFormat));
                System.out.println("    Emergency: " + hTreatment.isEmergency());
                System.out.println("    Treatment given by: Vet#" + hTreatment.getVet().getEmpID());

                System.out.println("    Medications:");

                int medCount = 1;
                for (Medication medication:
                        hTreatment.getMedications()) {
                    System.out.println("\n      Medication #" + medCount);
                    System.out.println("            Details: " + medication.getDetails());
                    System.out.println("            Duration: " + medication.getDuration());
                    System.out.println("            Start Date: " + medication.getStartDate().format(dateFormat));
                    System.out.println("            Dosage: " + medication.getDosage());
                    System.out.println("            Notes: " + medication.getNotes());

                    medCount++;

                }

                System.out.println("\n");

            }else if(treatment instanceof CleaningTreatment cTreatment){
                System.out.println("Cleaning Treatment #" + counter);
                System.out.println("    Date of treatment: " + treatment.getDateOfTreatment().format(dateFormat));
                System.out.println("    Materials used: " + cTreatment.getMaterialsUsed());
                System.out.println("    Treatment given by: Farm Worker#" + cTreatment.getWorker().getEmpID());
            }

            counter++;
        }
    }

    public void getSheepTreatment(int tagNo, LocalDate dateOfTreatment){


        Sheep sheep = null;

        for (Animal sheepTemp:
                this.animals) {
            if(sheepTemp.getTagNo() == tagNo && sheepTemp instanceof Sheep){
                sheep = (Sheep) sheepTemp;
                break;
            }

        }
        if(sheep == null){
            System.out.println("Sheep with tagNo " + tagNo + " doesn't exist");
            return;
        }

        if(sheep.getTreatments().isEmpty()){
            System.out.println("Sheep has no treatments");
            return;
        }

        ArrayList<Treatment> treatments = new ArrayList<Treatment>();

        for (Treatment treatmentTemp:
                sheep.getTreatments()) {
            if(treatmentTemp.getDateOfTreatment().equals(dateOfTreatment)){
                treatments.add(treatmentTemp);
            }
        }

        if(treatments.isEmpty()){
            System.out.println("Sheep has no treatments at that date");
            return;
        }

        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

        int counter = 1;
        for (Treatment treatment: treatments) {
            if(treatment instanceof HealthTreatment hTreatment){
                System.out.println("Health Treatment #" + counter);
                System.out.println("    Date of treatment: " + treatment.getDateOfTreatment().format(dateFormat));
                System.out.println("    Emergency: " + hTreatment.isEmergency());
                System.out.println("    Treatment given by: Vet#" + hTreatment.getVet().getEmpID());

                System.out.println("    Medications:");

                int medCount = 1;
                for (Medication medication:
                        hTreatment.getMedications()) {
                    System.out.println("\n      Medication #" + medCount);
                    System.out.println("            Details: " + medication.getDetails());
                    System.out.println("            Duration: " + medication.getDuration());
                    System.out.println("            Start Date: " + medication.getStartDate().format(dateFormat));
                    System.out.println("            Dosage: " + medication.getDosage());
                    System.out.println("            Notes: " + medication.getNotes());

                    medCount++;

                }

                System.out.println("\n");

            }else if(treatment instanceof CleaningTreatment cTreatment){
                System.out.println("Cleaning Treatment #" + counter);
                System.out.println("    Date of treatment: " + treatment.getDateOfTreatment().format(dateFormat));
                System.out.println("    Materials used: " + cTreatment.getMaterialsUsed());
                System.out.println("    Treatment given by: Farm Worker#" + cTreatment.getWorker().getEmpID());
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

        for (Animal cow:
             this.animals) {
            if(cow instanceof Cow){
                System.out.println("Cow with tag number: " + cow.getTagNo());
                System.out.println("    Gender: " + cow.getGender());
                System.out.println("    Date of birth: " + cow.getDateOfBirth().format(dateFormat));
                System.out.println("    Age: " + cow.getAge());
                System.out.println("    Type: " + (cow.getPurchased() ? "Purchased" : "Farm-rising"));
                System.out.println("    Weight: " + ((Cow) cow).getWeight());
            }



        }
    }

    public void listSheep(){
        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

        System.out.println("All sheep that are in the system: ");

        for (Animal sheep:
                this.animals) {
            if(sheep instanceof Sheep){
                System.out.println("Sheep with tag number: " + sheep.getTagNo());
                System.out.println("    Gender: " + sheep.getGender());
                System.out.println("    Date of birth: " + sheep.getDateOfBirth().format(dateFormat));
                System.out.println("    Age: " + sheep.getAge());
                System.out.println("    Type: " + (sheep.getPurchased() ? "Purchased" : "Farm-rising"));
            }



        }
    }

    /**
     * Lists all the vets that are found in the app with their details
     */
    public void listVet(){
        System.out.println("All vets that are in the system: ");
        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

        for (Employee vet:
                this.employees) {
            if(vet instanceof Veterinary){
                System.out.println("Vet #" + vet.getEmpID());
                System.out.println("    Gender: " + vet.getGender());
                System.out.println("    Date of birth: " + vet.getDateOfBirth().format(dateFormat));
                System.out.println("    Has BSc Degree: $" + ((Veterinary) vet).getBScDegree());
                System.out.println("    Date of graduation: $" + ((Veterinary) vet).getDateOfGraduation().format(dateFormat));
                System.out.println("    Expertise level: $" + ((Veterinary) vet).getExpertiseLevel());
            }

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
        this.animals = new ArrayList<Animal>();
        this.employees = new ArrayList<Employee>();
    }

    /**
     * Instantiates a new Farm me with cow list and empty vet list
     *
     * @param animals list of the animals
     */
    public FarmMe(ArrayList<Animal> animals){
        this.animals = new ArrayList<Animal>(animals);
        this.employees = new ArrayList<Employee>();
    }

    /**
     * Instantiates a new Farm me with cow and vet list
     *
     * @param animals list of the animals
     * @param employees list of the employees
     */
    public FarmMe(ArrayList<Animal> animals, ArrayList<Employee> employees){
        this.animals = new ArrayList<Animal>(animals);
        this.employees = new ArrayList<Employee>(employees);
    }



    public FarmMe(ArrayList<Cow> cows, ArrayList<Animal> sheeps, ArrayList<Veterinary> vets, ArrayList<FarmWorker> farmWorkers){
        this.animals = new ArrayList<Animal>();

        this.animals.addAll(cows);
        this.animals.addAll(sheeps);

        this.employees = new ArrayList<Employee>();
        this.employees.addAll(vets);
        this.employees.addAll(farmWorkers);
    }


}
