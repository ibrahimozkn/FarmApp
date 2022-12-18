import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * FarmMe is the main class that whole FarmApp is operated. It stores some information about the farm such as
 * <ul>
 *     <li>List of animals</li>
 *     <li>List of employees</li>
 * </ul>
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
 */
public class FarmMe {

    /**
     * List of animals
     *
     * @see Animal
     */
    public ArrayList<Animal> animals;

    /**
     * List of employees
     *
     * @see Employee
     */
    public ArrayList<Employee> employees;

    /**
     * Main method that is executed when program runs.
     *
     * @param args the arguments in command line
     */
    public static void main(String[] args){


        FarmMe farm = PopulateData.populate();
        Gui gui = new Gui(farm);
        gui.showGUI();
        farm.menu();
    }

    /**
     * Command Line interface that will be shown to the users in order to
     * interact with the program.
     */
    public void menu(){

        System.out.println("Welcome to FarmApp!");

        int option;

        while(true){
            Scanner userInput = new Scanner(System.in);

            System.out.println("(1) Add a new cow");
            System.out.println("(2) Add a new sheep");
            System.out.println("(3) Delete a cow");
            System.out.println("(4) Delete a sheep");
            System.out.println("(5) Get cow details");
            System.out.println("(6) Get sheep details");
            System.out.println("(7) Add a new vet");
            System.out.println("(8) Add a new farm worker");
            System.out.println("(9) Delete a vet");
            System.out.println("(10) Delete a farm worker");
            System.out.println("(11) Get vet details");
            System.out.println("(12) Get farm worker details");
            System.out.println("(13) Add treatment");
            System.out.println("(14) Get cow treatment");
            System.out.println("(15) Get sheep treatment");
            System.out.println("(16) List cows");
            System.out.println("(17) List sheep");
            System.out.println("(18) List vets");
            System.out.println("(19) List farm workers");
            System.out.println("(20) Get feeding animal info");
            System.out.println("(21) Get employee salary");
            System.out.println("(22) Add milking measurement");
            System.out.println("(23) Exit");

            System.out.println("\nEnter your option: ");


            try{
                option = userInput.nextInt();
                userInput.nextLine();
            }catch (Exception e){
                System.out.println("Invalid option");
                continue;
            }

            int tagNo;
            int vetId;
            switch (option){
                case 1:
                    addCow();
                    break;
                case 2:
                    addSheep();
                    break;
                case 3:
                    try {
                        System.out.println("Please enter tagNo of the cow you want to delete: ");
                        tagNo = userInput.nextInt();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid tag number");
                        break;
                    }


                    deleteCow(tagNo);

                    break;
                case 4:
                    try {
                        System.out.println("Please enter tagNo of the sheep you want to delete: ");
                        tagNo = userInput.nextInt();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid tag number");
                        break;
                    }


                    deleteSheep(tagNo);

                    break;
                case 5:
                    try {
                        System.out.println("Please enter tagNo of the cow you want to see details: ");
                        tagNo = userInput.nextInt();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid tag number");
                        break;
                    }


                    getCowDetails(tagNo);
                    break;
                case 6:
                    try {
                        System.out.println("Please enter tagNo of the sheep you want to see details: ");
                        tagNo = userInput.nextInt();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid tag number");
                        break;
                    }


                    getSheepDetails(tagNo);
                    break;
                case 7:
                    addVet();
                    break;
                case 8:
                    addFarmWorker();
                    break;
                case 9:

                    try {
                        System.out.println("Please enter empId of the vet you want to delete: ");
                        vetId = userInput.nextInt();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid employee id");
                        break;
                    }



                    deleteVet(vetId);
                    break;
                case 10:

                    try {
                        System.out.println("Please enter empId of the farm worker you want to delete: ");
                        vetId = userInput.nextInt();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid employee id");
                        break;
                    }



                    deleteFarmWorker(vetId);
                    break;
                case 11:

                    try {
                        System.out.println("Please enter vetID of the vet you want to see details: ");
                        vetId = userInput.nextInt();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid employee id");
                        break;
                    }



                    getVetDetails(vetId);
                    break;
                case 12:

                    try {
                        System.out.println("Please enter empId of the farm worker you want to see details: ");
                        vetId = userInput.nextInt();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid employee id");
                        break;
                    }



                    getFarmWorkerDetails(vetId);
                    break;
                case 13:
                    try {
                        System.out.println("Please enter vetID: ");
                        vetId = userInput.nextInt();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid employee id");
                        break;
                    }

                    try {
                        System.out.println("Please enter tagNo: ");
                        tagNo = userInput.nextInt();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid tag number");
                        break;
                    }



                    addTreatment(vetId, tagNo);

                    break;
                case 14:
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
                case 15:
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
                            getSheepTreatment(tagNo);
                            break;
                        }

                        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();
                        LocalDate date = LocalDate.parse(dateRaw, dateFormat);

                        getSheepTreatment(tagNo, date);

                    }catch (Exception e){
                        System.out.println("Invalid date");
                        break;
                    }

                    break;
                case 16:
                    listCow();
                    break;
                case 17:
                    listSheep();
                    break;
                case 18:
                    listVet();
                    break;
                case 19:
                    listFarmWorker();
                    break;
                case 20:
                    try {
                        System.out.println("Please enter tagNo: ");
                        tagNo = userInput.nextInt();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid tag no");
                        break;
                    }

                    feedingAnimal(tagNo);
                    break;
                case 21:
                    try {
                        System.out.println("Please enter empId: ");
                        vetId = userInput.nextInt();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid employee id");
                        break;
                    }

                    double result = getEmpSalary(vetId);

                    if(result != -1){
                        System.out.println("Salary of employee is " + result + "$");
                    }

                    break;
                case 22:
                    try {
                        System.out.println("Please enter tagNo: ");
                        tagNo = userInput.nextInt();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid tag no");
                        break;
                    }

                    double amount;
                    try {
                        System.out.println("Please enter amount: ");
                        amount = userInput.nextDouble();
                        userInput.nextLine();
                    }catch (Exception e){
                        System.out.println("Invalid amount");
                        break;
                    }

                    addMilkingMeasurement(tagNo, amount);
                    break;
                case 23:
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
     * First, collects data from the user about cow object. Then adds a new cow object to FarmMe's animal list.
     */
    @Deprecated
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

        int purchasedInt = -1;

        do {
            try{
                System.out.println("Enter if cow is purchased or farm-rising (1 for purchased, 0 for farm-rising): ");
                purchasedInt = userInput.nextInt();
                userInput.nextLine();
            }catch (Exception e){
                System.out.println("Invalid input");
                continue;
            }

        }while (purchasedInt != 1 && purchasedInt != 0);



        double weight;

        try {
            System.out.println("Please enter the weight of the cow: ");
            weight = userInput.nextDouble();
            userInput.nextLine();
        }catch (Exception e){
            System.out.println("Invalid weight");
            return;

        }



        this.animals.add(new Cow(tagNo, gender, date, purchasedInt == 1, weight));

        System.out.println("\nCow with tagNo " + tagNo + " added successfully");


    }


    public boolean addCow(int tagNo, String gender, LocalDate date, boolean purchased, double weight){
        for (Animal animal:
                animals) {
            if(animal.getTagNo() == tagNo){
                return false;
            }

        }
        return this.animals.add(new Cow(tagNo, gender, date, purchased, weight));
    }


    /**
     * Initially gets details of the sheep from used, then adds the sheep to animal list.
     */
    @Deprecated
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

        int purchasedInt = -1;

        do {
            try{
                System.out.println("Enter if cow is purchased or farm-rising (1 for purchased, 0 for farm-rising): ");
                purchasedInt = userInput.nextInt();
                userInput.nextLine();
            }catch (Exception e){
                System.out.println("Invalid input");
                continue;
            }

        }while (purchasedInt != 1 && purchasedInt != 0);



        this.animals.add(new Sheep(tagNo, gender, date, purchasedInt == 1));

        System.out.println("\nSheep with tagNo " + tagNo + " added successfully");


    }

    public boolean addSheep(int tagNo, String gender, LocalDate date, boolean purchased){
        for (Animal animal:
                animals) {
            if(animal.getTagNo() == tagNo){
                return false;
            }

        }
        return this.animals.add(new Sheep(tagNo, gender, date, purchased));
    }

    /**
     * Deletes cow object from the list of animals with the matching tagNo if exists. If cow with tag no doesn't exist
     * prints user an error message.
     *
     * @param tagNo tag number of the cow
     */
    public boolean deleteCow(int tagNo){
        for (Animal animal:
             this.animals) {
            if(animal.getTagNo() == tagNo && animal instanceof Cow){
                animals.remove(animal);
                return true;
            }

        }

        return false;

    }


    /**
     * Deletes sheep object from the list of animals with the matching tagNo if exists. If sheep with tag no doesn't exist
     * prints user an error message.
     *
     * @param tagNo tag number of the sheep
     */
    public boolean deleteSheep(int tagNo){
        for (Animal animal:
                this.animals) {
            if(animal.getTagNo() == tagNo && animal instanceof Sheep){
                animals.remove(animal);
                return true;
            }

        }

        return false;

    }

    /**
     * Shows details of the cow with matching tagNo. If cow doesn't exist, method prints user an error message.
     *
     * @param tagNo the tag no
     */
    public String getCowDetails(int tagNo){
        String cowDetails = "Cow with tagNo " + tagNo + " doesn't exist";

        for (Animal animal:
             this.animals) {
            if(animal.getTagNo() == tagNo && animal instanceof Cow){
                DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

                cowDetails = "";

                cowDetails += ("Cow #" + tagNo + "\n");
                cowDetails += ("    Gender: " + animal.getGender() + "\n");
                cowDetails += ("    Date of birth: " + animal.getDateOfBirth().format(dateFormat) + "\n");
                cowDetails += ("    Age: " + animal.getAge() + "\n");
                cowDetails += ("    Purchase Status: " + (animal.getPurchased() ? "Purchased" : "Farm-rising") + "\n");
                cowDetails += ("    Weight: " + ((Cow) animal).getWeight() + "\n");
                cowDetails += ("    Milking Records: " + "\n");
                for(LocalDate dateKey : animal.getMilking().keySet()){
                    cowDetails += ("        " + dateKey.format(dateFormat) + ": " + animal.getMilking().get(dateKey) + "\n");

                }
                return cowDetails;
            }
        }

        return cowDetails;

    }


    /**
     * Shows details of the sheep with matching tagNo. If sheep doesn't exist, method prints user an error message.
     *
     * @param tagNo the tag no
     */
    public String getSheepDetails(int tagNo){
        String sheepDetails = "Sheep with tagNo " + tagNo + " doesn't exist";

        for (Animal animal:
                this.animals) {
            if(animal.getTagNo() == tagNo && animal instanceof Sheep){
                DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

                sheepDetails = "";

                sheepDetails +=("Sheep #" + tagNo + "\n");
                sheepDetails +=("    Gender: " + animal.getGender() + "\n");
                sheepDetails +=("    Date of birth: " + animal.getDateOfBirth().format(dateFormat) + "\n");
                sheepDetails +=("    Age: " + animal.getAge() + "\n");
                sheepDetails +=("    Purchase Status: " + (animal.getPurchased() ? "Purchased" : "Farm-rising") + "\n");
                sheepDetails +=("    Milking Records:" + "\n");
                for(LocalDate dateKey : animal.getMilking().keySet()){
                    sheepDetails +=("        " + dateKey.format(dateFormat) + ": " + animal.getMilking().get(dateKey) + "\n");

                }
                return sheepDetails;
            }
        }

        return sheepDetails;

    }

    /**
     * First collects required data to create Veterinary object from the user, then adds new Veterinary object to the list of employees
     * @
     */
    @Deprecated
    public void addVet(){
        Scanner userInput = new Scanner(System.in);

        int vetId;

        try {
            System.out.println("Enter vetId: ");
            vetId = userInput.nextInt();

            userInput.nextLine();
        }catch (Exception e){
            System.out.println("Invalid employee id");
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

    public boolean addVet(int vetId, String gender, LocalDate dob, LocalDate dOfGrad, boolean hasDegree, int expertiseLevel){
        this.employees.add(new Veterinary(vetId, gender, dob, hasDegree, dOfGrad, expertiseLevel));
        return true;

    }

    /**
     * First collects required data to create FarmWorker object from the user, then adds new Veterinary object to the list of employees
     */
    @Deprecated
    public void addFarmWorker(){
        Scanner userInput = new Scanner(System.in);

        int vetId;

        try {
            System.out.println("Enter empId: ");
            vetId = userInput.nextInt();

            userInput.nextLine();
        }catch (Exception e){
            System.out.println("Invalid employee id");
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
        System.out.println("Enter gender of the farm worker (Male/Female): ");
        gender = userInput.nextLine();


        if(!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))){
            System.out.println("Invalid gender (male/female)");
            return;
        }


        LocalDate date;

        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();


        try{
            System.out.println("Enter worker's date of birth (dd/mm/yyyy): ");
            String dateRaw = userInput.nextLine();

            date = LocalDate.parse(dateRaw, dateFormat);
            System.out.println(date.toString());

        }catch (Exception e){
            System.out.println("Invalid date, correct format (dd/mm/yyyy)");
            return;
        }

        String previousFarmName;

        System.out.println("Enter previous farm name: ");
        previousFarmName = userInput.nextLine();


        int workExperience;

        try{
            System.out.println("Enter work experience: ");
            workExperience = userInput.nextInt();
        }catch (Exception ex){
            System.out.println("Please enter proper experience (integer values)");
            return;
        }


        userInput.nextLine();


        this.employees.add(new FarmWorker(vetId, gender, date, previousFarmName, workExperience));
        System.out.println("Farm Worker added successfully!\n");

    }

    public boolean addFarmWorker(int empId, String gender, LocalDate dob, String prevFarm, int workExperience){
        return this.employees.add(new FarmWorker(empId, gender, dob, prevFarm, workExperience));

    }

    /**
     * Finds matching veterinary object with empID deletes from the employees list. If veterinary with the provided
     * doesn't exist, it prints error message
     *
     * @param empID vets identity number
     */
    public boolean deleteVet(int empID){
        for (Employee vetTemp:
                this.employees) {
            if(vetTemp.getEmpID() == empID && vetTemp instanceof Veterinary){
                return employees.remove(vetTemp);
            }
        }

        return false;

    }

    /**
     * Finds matching farm worker object with empID and deletes from the employees list. If farm worker with the provided
     * doesn't exist, it prints error message
     *
     * @param empId employee id
     */
    public boolean deleteFarmWorker(int empId){
        for (Employee workerTemp:
                this.employees) {
            if(workerTemp.getEmpID() == empId && workerTemp instanceof FarmWorker){
                return employees.remove(workerTemp);
            }
        }

        return false;

    }

    /**
     * Prints the details of the matching veterinary object with the provided empID. If vet with given employee id
     * doesn't exist error message is printed.
     *
     * @param empID vet's employee id
     */
    public String getVetDetails(int empID){

        String vetDetails = "Vet with vetID " + empID + " doesn't exist";
        for (Employee vet:
                employees) {
            if(vet.getEmpID() == empID && vet instanceof Veterinary){
                DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

                vetDetails = "";

                vetDetails += ("Vet #" + empID + "\n");
                vetDetails +=("    Gender: " + vet.getGender() + "\n");
                vetDetails +=("    Date of birth: " + vet.getDateOfBirth().format(dateFormat) + "\n");
                vetDetails += ("    Has BSc Degree: " + ((Veterinary) vet).getBScDegree() + "\n");
                vetDetails += ("    Date of graduation: " + ((Veterinary) vet).getDateOfGraduation().format(dateFormat) + "\n");
                vetDetails += ("    Expertise level: " + ((Veterinary) vet).getExpertiseLevel() + "\n");
                return vetDetails;
            }
        }

        return vetDetails;

    }

    /**
     * Prints the details of the matching farm worker object with the provided empID. If farm worker with given employee id
     * doesn't exist error message is printed.
     *
     * @param empId farm worker's employee id
     */
    public String getFarmWorkerDetails(int empId){

        String workerDetails = "Farm Worker with empId " + empId + " doesn't exist";
        for (Employee worker:
                employees) {
            if(worker.getEmpID() == empId && worker instanceof FarmWorker){
                DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

                workerDetails = "";
                workerDetails +=("Farm Worker #" + empId + "\n");
                workerDetails +=("    Gender: " + worker.getGender() + "\n");
                workerDetails +=("    Date of birth: " + worker.getDateOfBirth().format(dateFormat) + "\n");
                workerDetails +=("    Previous farm: " + ((FarmWorker) worker).getPreviousFarmName() + "\n");
                workerDetails +=("    Work experience: " + ((FarmWorker) worker).getWorkExperience() + "\n");
                return workerDetails;
            }
        }

        return workerDetails;



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
        }else if(treatmentType == 2 && !(employee instanceof Veterinary)){
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
     * Prints treatment details of the cow with its medication details and type. If cow doesn't exist, it prints error message
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

    /**
     * Prints treatment details of the sheep with its medication details and type. If sheep doesn't exist, it prints error message
     *
     * @param tagNo the tag no
     */
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

    /**
     * Retrieves all treatments of a sheep at an exact date that is given from the user. If sheep or treatment doesn't exist, method prints an error message.
     *
     * @param tagNo           the tag no
     * @param dateOfTreatment the date of treatment
     */
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

    /**
     * Lists all the sheep that are found in the app with their details
     */
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
     * Lists all the farm workers that are found in the app with their details
     */
    public void listFarmWorker(){
        System.out.println("All farm workers that are in the system: ");
        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

        for (Employee worker:
                this.employees) {
            if(worker instanceof FarmWorker){
                System.out.println("Farm Worker #" + worker.getEmpID());
                System.out.println("    Gender: " + worker.getGender());
                System.out.println("    Date of birth: " + worker.getDateOfBirth().format(dateFormat));
                System.out.println("    Previous farm: " + ((FarmWorker) worker).getPreviousFarmName());
                System.out.println("    Work experience: " + ((FarmWorker) worker).getWorkExperience());
            }

        }
    }


    /**
     * Provides feeding information based on a specific animal that has provided tag number. If animal doesn't exist method prints an error message.
     *
     * @param tagNo the tag no
     */
    public void feedingAnimal(int tagNo){
        Animal animal = null;

        for (Animal animalTemp:
                this.animals) {
            if(animalTemp.getTagNo() == tagNo){
                animal = animalTemp;
                break;
            }

        }
        if(animal == null){
            System.out.println("Animal with tagNo " + tagNo + " doesn't exist");
            return;
        }

        System.out.println("Feeding information about " + (animal instanceof Sheep ? "Sheep" : "Cow") + "is provided below: ");
        animal.feeding();
    }

    /**
     * Returns employee's salary by calling method of the given employee. It checks the employees list and gets the employee object that is matching
     * with the given employee id. If employee doesn't exist, method prints an error.
     *
     * @param empId the emp id
     * @return salary of the employee
     */
    public double getEmpSalary(int empId){
        Employee employee = null;

        for (Employee empTemp:
                this.employees) {
            if(empTemp.getEmpID() == empId){
                employee = empTemp;
                break;
            }
        }

        if(employee == null){
            System.out.println("Employee with id " + empId + " doesn't exist");
            return -1;
        }



        return employee.getSalary();
    }

    /**
     * Adds milking measurement record to animal that belongs to given tag number. Milking measurement can only be done once to an animal daily.
     *
     * @param tagNo  the tag no
     * @param amount amount that is milked
     */
    public void addMilkingMeasurement(int tagNo, double amount){
        Animal animal = null;

        for (Animal animalTemp:
                this.animals) {
            if(animalTemp.getTagNo() == tagNo){
                animal = animalTemp;
                break;
            }

        }
        if(animal == null){
            System.out.println("Animal with tagNo " + tagNo + " doesn't exist");
            return;
        }


        if(animal.getMilking().containsKey(LocalDate.now())){
            System.out.println("Milking already recorded for this animal today");
            return;
        }

        animal.getMilking().put(LocalDate.now(), amount);
        DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();

        System.out.println("Milking dated "+ LocalDate.now().format(dateFormat) + " for animal with tagNo" + tagNo + " is recorded.");

    }


    /**
     * Terminates the program
     */
    public void exit(){
        System.out.println("Goodbye!");
        System.exit(0);
    }

    /**
     * Instantiates a new Farm me with empty animal and employee list
     */
    public FarmMe(){
        this.animals = new ArrayList<Animal>();
        this.employees = new ArrayList<Employee>();
    }

    /**
     * Instantiates a new Farm me with animal list and empty employee list
     *
     * @param animals list of the animals
     */
    public FarmMe(ArrayList<Animal> animals){
        this.animals = new ArrayList<Animal>(animals);
        this.employees = new ArrayList<Employee>();
    }

    /**
     * Instantiates a new Farm me with animal and employee list
     *
     * @param animals   list of the animals
     * @param employees list of the employees
     */
    public FarmMe(ArrayList<Animal> animals, ArrayList<Employee> employees){
        this.animals = new ArrayList<Animal>(animals);
        this.employees = new ArrayList<Employee>(employees);
    }


}
