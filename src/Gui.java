import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Gui extends JFrame implements ActionListener {
    JFrame mainMenu = new JFrame("Main Menu");
    JLabel mainTitle = new JLabel("Welcome to FarmAPP");

    JMenuBar bar = new JMenuBar();
    JMenu menu = new JMenu("Actions");
    JMenuItem opt1, opt2, opt3, opt4, opt5, opt6, opt7, opt8, opt9, opt10, opt11,
    opt12, opt13, opt14, opt15, opt16, opt17, opt18, opt19, opt20, opt21, opt22;

    FarmMe farmInstance;

    public Gui(FarmMe farm){
        farmInstance = farm;
    }

    public void showGUI()
    {

        mainMenu.setLayout(new GridLayout(30, 1));
        mainMenu.setLocationByPlatform(true);

        opt1 = new JMenuItem("Add cow");
        opt2 = new JMenuItem("Add sheep");
        opt3 = new JMenuItem("Delete a cow");
        opt4 = new JMenuItem("Delete a sheep");
        opt5 = new JMenuItem("Get cow details");
        opt6 = new JMenuItem("Get sheep details");
        opt7 = new JMenuItem("Add a new vet");
        opt8 = new JMenuItem("Add a new farm worker");
        opt9 = new JMenuItem("Delete a vet");
        opt10 = new JMenuItem("Delete a farm worker");
        opt11 = new JMenuItem("Get vet details");
        opt12 = new JMenuItem("Get farm worker details");
        opt13 = new JMenuItem("Add treatment");
        opt14 = new JMenuItem("Get cow treatment");
        opt15 = new JMenuItem("Get sheep treatment");
        opt16 = new JMenuItem("List cows");
        opt17 = new JMenuItem("List sheep");
        opt18 = new JMenuItem("List vets");
        opt19 = new JMenuItem("List farm workers");
        opt20 = new JMenuItem("Get feeding animal info");
        opt21 = new JMenuItem("Get employee salary");
        opt22 = new JMenuItem("Add milking measurement");

        opt1.setActionCommand("addCowScreen");
        opt2.setActionCommand("addSheepScreen");
        opt3.setActionCommand("deleteCowScreen");
        opt4.setActionCommand("deleteSheepScreen");
        opt5.setActionCommand("cowDetailsScreen");
        opt6.setActionCommand("sheepDetailsScreen");
        opt7.setActionCommand("addVetScreen");
        opt8.setActionCommand("addFarmWorkerScreen");
        opt9.setActionCommand("deleteVetScreen");
        opt10.setActionCommand("deleteFarmWorker");
        opt11.setActionCommand("vetDetailsScreen");
        opt12.setActionCommand("workerDetailsScreen");


        opt1.addActionListener(this);
        opt2.addActionListener(this);
        opt3.addActionListener(this);
        opt4.addActionListener(this);
        opt5.addActionListener(this);
        opt6.addActionListener(this);
        opt7.addActionListener(this);
        opt8.addActionListener(this);
        opt9.addActionListener(this);
        opt10.addActionListener(this);
        opt11.addActionListener(this);
        opt12.addActionListener(this);



        menu.add(opt1);
        menu.add(opt2);
        menu.add(opt3);
        menu.add(opt4);
        menu.add(opt5);
        menu.add(opt6);
        menu.add(opt7);
        menu.add(opt8);
        menu.add(opt9);
        menu.add(opt10);
        menu.add(opt11);
        menu.add(opt12);

        bar.add(menu);
        mainMenu.add(bar);

        mainMenu.add(mainTitle);


        mainMenu.setPreferredSize(new Dimension(600, 800));
        mainMenu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainMenu.setTitle("Main Menu");
        mainMenu.pack();
        mainMenu.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        System.out.println(event);
        if(event.equalsIgnoreCase("addCowScreen")){
            new JAddCow(farmInstance).showScreen();
        }else if(event.equalsIgnoreCase("addSheepScreen")){
            new JAddSheep(farmInstance).showScreen();
        }else if(event.equalsIgnoreCase("deleteCowScreen")){
            new JDeleteCow(farmInstance).showScreen();
        }else if(event.equalsIgnoreCase("deleteSheepScreen")){
            new JDeleteSheep(farmInstance).showScreen();
        }else if(event.equalsIgnoreCase("cowDetailsScreen")){
            new JCowDetails(farmInstance).showScreen();
        }else if(event.equalsIgnoreCase("sheepDetailsScreen")){
            new JSheepDetails(farmInstance).showScreen();
        }else if(event.equalsIgnoreCase("addVetScreen")){
            new JAddVet(farmInstance).showScreen();
        }else if(event.equalsIgnoreCase("addFarmWorkerScreen")){
            new JAddFarmWorker(farmInstance).showScreen();
        }else if(event.equalsIgnoreCase("deleteVetScreen")){
            new JDeleteVet(farmInstance).showScreen();
        }else if(event.equalsIgnoreCase("deleteFarmWorkerScreen")){
            new JDeleteFarmWorker(farmInstance).showScreen();
        }else if(event.equalsIgnoreCase("vetDetailsScreen")){
            new JVetDetails(farmInstance).showScreen();
        }else if(event.equalsIgnoreCase("workerDetailsScreen")){
            new JFarmWorkerDetails(farmInstance).showScreen();
        }

    }

}

class JAddCow extends Gui implements ActionListener{
    JTextField tagId = new JTextField();
    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    ButtonGroup group = new ButtonGroup();
    JTextField dob = new JTextField();
    JLabel dobLbl = new JLabel();
    JFrame addCowScreen = new JFrame("Add Cow");
    JRadioButton purchased = new JRadioButton("purchased");
    JRadioButton farmRising = new JRadioButton("farm-rising");
    JTextField weight = new JTextField();
    JLabel weightLbl = new JLabel();
    ButtonGroup purchasedGroup = new ButtonGroup();
    JButton submit = new JButton();

    public JAddCow(FarmMe farm){
        super(farm);
    }

    public void showScreen(){
        addCowScreen.setLayout(new GridLayout(10, 2));
        addCowScreen.setLocationByPlatform(true);


        tagId.setActionCommand("tagIdInput");

        JLabel tagIdLbl = new JLabel();
        tagIdLbl.setText("TagId");

        addCowScreen.add(tagIdLbl);
        addCowScreen.add(tagId);


        addCowScreen.add(male);
        addCowScreen.add(female);



        group.add(male);
        group.add(female);


        dobLbl.setText("Date Of Birth");

        addCowScreen.add(dobLbl);
        addCowScreen.add(dob);



        addCowScreen.add(purchased);
        addCowScreen.add(farmRising);



        group.add(purchased);
        group.add(farmRising);




        weightLbl.setText("Weight of the cow");

        addCowScreen.add(weightLbl);
        addCowScreen.add(weight);


        submit.setActionCommand("AddCow");
        submit.setText("Add Cow");

        submit.addActionListener(this);

        addCowScreen.add(submit);


        addCowScreen.setPreferredSize(new Dimension(600, 800));
        addCowScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addCowScreen.setTitle("Add cow");
        addCowScreen.pack();
        addCowScreen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDate date;
        try{
            DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();
            date = LocalDate.parse(dob.getText(), dateFormat);
        }catch (Exception ex){
            System.out.println("Error parse dialog");
            return;
        }


        //TODO: Test Radio Button
        boolean result = farmInstance.addCow(Integer.parseInt(tagId.getText()), female.isSelected() ? "female" : "male", date, farmRising.isSelected() ? true : false, Double.parseDouble(weight.getText()));
        farmInstance.listCow();
        if(result == false){
            System.out.println("Error dialog");
        }else{
            addCowScreen.setVisible(false);
        }
    }

}

class JAddSheep extends Gui implements ActionListener{
    JTextField tagId = new JTextField();
    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    ButtonGroup group = new ButtonGroup();
    JTextField dob = new JTextField();
    JLabel dobLbl = new JLabel();
    JFrame addSheepScreen = new JFrame("Add Sheep");
    JRadioButton purchased = new JRadioButton("purchased");
    JRadioButton farmRising = new JRadioButton("farm-rising");
    ButtonGroup purchasedGroup = new ButtonGroup();
    JButton submit = new JButton();

    public JAddSheep(FarmMe farm){
        super(farm);
    }

    public void showScreen(){
        addSheepScreen.setLayout(new GridLayout(10, 2));
        addSheepScreen.setLocationByPlatform(true);


        tagId.setActionCommand("tagIdInput");

        JLabel tagIdLbl = new JLabel();
        tagIdLbl.setText("TagId");

        addSheepScreen.add(tagIdLbl);
        addSheepScreen.add(tagId);


        addSheepScreen.add(male);
        addSheepScreen.add(female);



        group.add(male);
        group.add(female);


        dobLbl.setText("Date Of Birth");

        addSheepScreen.add(dobLbl);
        addSheepScreen.add(dob);



        addSheepScreen.add(purchased);
        addSheepScreen.add(farmRising);



        group.add(purchased);
        group.add(farmRising);




        submit.setActionCommand("AddSheep");
        submit.setText("Add Sheep");

        submit.addActionListener(this);

        addSheepScreen.add(submit);


        addSheepScreen.setPreferredSize(new Dimension(600, 800));
        addSheepScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addSheepScreen.setTitle("Add Sheep");
        addSheepScreen.pack();
        addSheepScreen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDate date;
        try{
            DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();
            date = LocalDate.parse(dob.getText(), dateFormat);
        }catch (Exception ex){
            System.out.println("Error parse dialog");
            return;
        }


        //TODO: Test Radio Button
        boolean result = farmInstance.addSheep(Integer.parseInt(tagId.getText()), female.isSelected() ? "female" : "male", date, farmRising.isSelected() ? true : false);
        farmInstance.listSheep();

        if(result == false){
            System.out.println("Error dialog");
        }else{
            addSheepScreen.setVisible(false);
        }
    }

}

class JDeleteCow extends Gui implements ActionListener{
    JTextField tagId = new JTextField();
    JFrame deleteCowScreen = new JFrame("Delete Cow");
    JButton submit = new JButton();

    public JDeleteCow(FarmMe farm){
        super(farm);
    }

    public void showScreen(){
        deleteCowScreen.setLayout(new GridLayout(10, 2));
        deleteCowScreen.setLocationByPlatform(true);


        tagId.setActionCommand("tagIdInput");

        JLabel tagIdLbl = new JLabel();
        tagIdLbl.setText("TagId");

        deleteCowScreen.add(tagIdLbl);
        deleteCowScreen.add(tagId);


        submit.setActionCommand("DeleteCow");
        submit.setText("Delete Cow");

        submit.addActionListener(this);

        deleteCowScreen.add(submit);


        deleteCowScreen.setPreferredSize(new Dimension(600, 800));
        deleteCowScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteCowScreen.setTitle("Delete Cow");
        deleteCowScreen.pack();
        deleteCowScreen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //TODO: Test Radio Button
        boolean result = farmInstance.deleteCow(Integer.parseInt(tagId.getText()));
        farmInstance.listCow();
        if(result == false){
            System.out.println("Error dialog");
        }else{
            deleteCowScreen.setVisible(false);
        }
    }

}

class JDeleteSheep extends Gui implements ActionListener{
    JTextField tagId = new JTextField();
    JFrame deleteCowScreen = new JFrame("Delete Sheep");
    JButton submit = new JButton();

    public JDeleteSheep(FarmMe farm){
        super(farm);
    }

    public void showScreen(){
        deleteCowScreen.setLayout(new GridLayout(10, 2));
        deleteCowScreen.setLocationByPlatform(true);


        tagId.setActionCommand("tagIdInput");

        JLabel tagIdLbl = new JLabel();
        tagIdLbl.setText("TagId");

        deleteCowScreen.add(tagIdLbl);
        deleteCowScreen.add(tagId);


        submit.setActionCommand("DeleteSheep");
        submit.setText("Delete Sheep");

        submit.addActionListener(this);

        deleteCowScreen.add(submit);


        deleteCowScreen.setPreferredSize(new Dimension(600, 800));
        deleteCowScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteCowScreen.setTitle("Delete Sheep");
        deleteCowScreen.pack();
        deleteCowScreen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //TODO: Test Radio Button
        boolean result = farmInstance.deleteSheep(Integer.parseInt(tagId.getText()));
        farmInstance.listSheep();
        if(result == false){
            System.out.println("Error dialog");
        }else{
            deleteCowScreen.setVisible(false);
        }
    }

}

class JCowDetails extends Gui implements ActionListener{
    JTextField tagId = new JTextField();
    JFrame deleteCowScreen = new JFrame("Cow Details");
    JButton submit = new JButton();
    JTextArea infoArea = new JTextArea("");

    public JCowDetails(FarmMe farm){
        super(farm);
    }

    public void showScreen(){
        deleteCowScreen.setLayout(new GridLayout(10, 2));
        deleteCowScreen.setLocationByPlatform(true);


        tagId.setActionCommand("tagIdInput");

        JLabel tagIdLbl = new JLabel();
        tagIdLbl.setText("TagId");

        deleteCowScreen.add(tagIdLbl);
        deleteCowScreen.add(tagId);





        submit.setActionCommand("GetCowDetails");
        submit.setText("Get Cow Details");

        submit.addActionListener(this);

        infoArea.setEditable(false);
        infoArea.setBackground(null);


        JScrollPane zScrollPane = new JScrollPane(infoArea);

        deleteCowScreen.add(submit);
        deleteCowScreen.add(zScrollPane);


        deleteCowScreen.setPreferredSize(new Dimension(600, 800));
        deleteCowScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteCowScreen.setTitle("Get Cow Details");
        deleteCowScreen.pack();
        deleteCowScreen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //TODO: Test Radio Button
        String detail = farmInstance.getCowDetails(Integer.parseInt(tagId.getText()));
        System.out.println(detail);
        infoArea.setText(detail);
    }

}

class JSheepDetails extends Gui implements ActionListener{
    JTextField tagId = new JTextField();
    JFrame screen = new JFrame("Sheep Details");
    JButton submit = new JButton();
    JTextArea infoArea = new JTextArea("");

    public JSheepDetails(FarmMe farm){
        super(farm);
    }

    public void showScreen(){
        screen.setLayout(new GridLayout(10, 2));
        screen.setLocationByPlatform(true);


        tagId.setActionCommand("tagIdInput");

        JLabel tagIdLbl = new JLabel();
        tagIdLbl.setText("TagId");

        screen.add(tagIdLbl);
        screen.add(tagId);





        submit.setActionCommand("GetSheepDetails");
        submit.setText("Get Sheep Details");

        submit.addActionListener(this);

        infoArea.setEditable(false);
        infoArea.setBackground(null);


        JScrollPane zScrollPane = new JScrollPane(infoArea);

        screen.add(submit);
        screen.add(zScrollPane);


        screen.setPreferredSize(new Dimension(600, 800));
        screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        screen.setTitle("Get Sheep Details");
        screen.pack();
        screen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //TODO: Test Radio Button
        String detail = farmInstance.getSheepDetails(Integer.parseInt(tagId.getText()));
        System.out.println(detail);
        infoArea.setText(detail);
    }

}

class JAddVet extends Gui implements ActionListener{
    JFrame screen = new JFrame("Add vet");

    JTextField vetId = new JTextField();
    JLabel vetIdLbl = new JLabel("Vet Id");

    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    ButtonGroup group = new ButtonGroup();
    ButtonGroup group2 = new ButtonGroup();

    JTextField dob = new JTextField();
    JLabel dobLbl = new JLabel("Date Of Birth");

    JTextField dOfGrad = new JTextField();
    JLabel dOfGradLbl = new JLabel("Date of Graduation");

    JRadioButton hasDegree = new JRadioButton("Has degree");
    JRadioButton hasNotDegree = new JRadioButton("No degree");

    JTextField expertiseLevel = new JTextField();
    JLabel expertiseLevelLbl = new JLabel("Expertise Level");
    JButton submit = new JButton("Add vet");

    public JAddVet(FarmMe farm){
        super(farm);
    }

    public void showScreen(){
        screen.setLayout(new GridLayout(10, 2));
        screen.setLocationByPlatform(true);

        screen.add(vetIdLbl);
        screen.add(vetId);

        screen.add(male);
        screen.add(female);

        group.add(male);
        group.add(female);

        screen.add(dobLbl);
        screen.add(dob);



        screen.add(dOfGradLbl);
        screen.add(dOfGrad);


        screen.add(hasDegree);
        screen.add(hasNotDegree);

        group2.add(hasDegree);
        group2.add(hasNotDegree);

        screen.add(expertiseLevelLbl);
        screen.add(expertiseLevel);

        submit.addActionListener(this);

        screen.add(submit);


        screen.setPreferredSize(new Dimension(600, 800));
        screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        screen.pack();
        screen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDate date;
        LocalDate dateofGrad;
        try{
            DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();
            date = LocalDate.parse(dob.getText(), dateFormat);
            dateofGrad = LocalDate.parse(dOfGrad.getText(), dateFormat);
        }catch (Exception ex){
            System.out.println("Error parse dialog");
            return;
        }


        //TODO: Test Radio Button
        boolean result = farmInstance.addVet(Integer.parseInt(vetId.getText()), female.isSelected() ? "female" : "male", date, dateofGrad, hasDegree.isSelected() ? true : false, Integer.parseInt(expertiseLevel.getText()));
        farmInstance.listVet();
        if(result == false){
            System.out.println("Error dialog");
        }else{
            screen.setVisible(false);
        }
    }

}

class JAddFarmWorker extends Gui implements ActionListener{
    JFrame screen = new JFrame("Add Farm Worker");

    JTextField empId = new JTextField();
    JLabel empIdLbl = new JLabel("Emp Id");

    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    ButtonGroup group = new ButtonGroup();
    ButtonGroup group2 = new ButtonGroup();

    JTextField dob = new JTextField();
    JLabel dobLbl = new JLabel("Date Of Birth");

    JTextField prevFarm = new JTextField();
    JLabel prevFarmLbl = new JLabel("Previous Farm Name");

    JTextField workExperience = new JTextField();
    JLabel workExperienceLbl = new JLabel("Previous Farm Name");

    JButton submit = new JButton("Add Farm Worker");

    public JAddFarmWorker(FarmMe farm){
        super(farm);
    }

    public void showScreen(){
        screen.setLayout(new GridLayout(10, 2));
        screen.setLocationByPlatform(true);

        screen.add(empIdLbl);
        screen.add(empId);

        screen.add(male);
        screen.add(female);

        group.add(male);
        group.add(female);

        screen.add(dobLbl);
        screen.add(dob);

        screen.add(prevFarmLbl);
        screen.add(prevFarm);

        screen.add(workExperienceLbl);
        screen.add(workExperienceLbl);

        submit.addActionListener(this);

        screen.add(submit);


        screen.setPreferredSize(new Dimension(600, 800));
        screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        screen.pack();
        screen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDate date;
        try{
            DateTimeFormatter dateFormat = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy").toFormatter();
            date = LocalDate.parse(dob.getText(), dateFormat);
        }catch (Exception ex){
            System.out.println("Error parse dialog");
            return;
        }


        //TODO: Test Radio Button
        boolean result = farmInstance.addFarmWorker(Integer.parseInt(empId.getText()), female.isSelected() ? "female" : "male", date, prevFarm.getText(), Integer.parseInt(workExperience.getText()));
        farmInstance.listFarmWorker();
        if(result == false){
            System.out.println("Error dialog");
        }else{
            screen.setVisible(false);
        }
    }

}

class JDeleteVet extends Gui implements ActionListener{
    JFrame screen = new JFrame("Delete Vet");

    JTextField empId = new JTextField();
    JLabel empIdLbl = new JLabel("Vet Id");

    JButton submit = new JButton("Delete Vet");

    public JDeleteVet(FarmMe farm){
        super(farm);
    }

    public void showScreen(){
        screen.setLayout(new GridLayout(10, 2));
        screen.setLocationByPlatform(true);

        screen.add(empIdLbl);
        screen.add(empId);

        submit.addActionListener(this);

        screen.add(submit);

        screen.setPreferredSize(new Dimension(600, 800));
        screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        screen.pack();
        screen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean result = farmInstance.deleteVet(Integer.parseInt(empId.getText()));
        farmInstance.listFarmWorker();
        if(result == false){
            System.out.println("Error dialog");
        }else{
            screen.setVisible(false);
        }
    }

}

class JDeleteFarmWorker extends Gui implements ActionListener{
    JFrame screen = new JFrame("Delete Farm Worker");

    JTextField empId = new JTextField();
    JLabel empIdLbl = new JLabel("Emp Id");

    JButton submit = new JButton("Delete Farm Worker");

    public JDeleteFarmWorker(FarmMe farm){
        super(farm);
    }

    public void showScreen(){
        screen.setLayout(new GridLayout(10, 2));
        screen.setLocationByPlatform(true);

        screen.add(empIdLbl);
        screen.add(empId);

        submit.addActionListener(this);

        screen.add(submit);

        screen.setPreferredSize(new Dimension(600, 800));
        screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        screen.pack();
        screen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean result = farmInstance.deleteFarmWorker(Integer.parseInt(empId.getText()));
        farmInstance.listFarmWorker();
        if(result == false){
            System.out.println("Error dialog");
        }else{
            screen.setVisible(false);
        }
    }

}

class JVetDetails extends Gui implements ActionListener{
    JTextField empId = new JTextField();
    JLabel empIdLbl = new JLabel("Emp Id");
    JFrame screen = new JFrame("Vet Details");
    JButton submit = new JButton();
    JTextArea infoArea = new JTextArea("");

    public JVetDetails(FarmMe farm){
        super(farm);
    }

    public void showScreen(){
        screen.setLayout(new GridLayout(10, 2));
        screen.setLocationByPlatform(true);

        screen.add(empIdLbl);
        screen.add(empId);

        submit.setActionCommand("GetVetDetails");
        submit.setText("Get Vet Details");

        submit.addActionListener(this);

        infoArea.setEditable(false);
        infoArea.setBackground(null);


        JScrollPane scrollPane = new JScrollPane(infoArea);

        screen.add(submit);
        screen.add(scrollPane);


        screen.setPreferredSize(new Dimension(600, 800));
        screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        screen.setTitle("Get Vet Details");
        screen.pack();
        screen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //TODO: Test Radio Button
        String detail = farmInstance.getVetDetails(Integer.parseInt(empId.getText()));
        infoArea.setText(detail);
    }

}

class JFarmWorkerDetails extends Gui implements ActionListener{
    JTextField empId = new JTextField();
    JLabel empIdLbl = new JLabel("Emp Id");
    JFrame screen = new JFrame("Farm Worker Details");
    JButton submit = new JButton();
    JTextArea infoArea = new JTextArea("");

    public JFarmWorkerDetails(FarmMe farm){
        super(farm);
    }

    public void showScreen(){
        screen.setLayout(new GridLayout(10, 2));
        screen.setLocationByPlatform(true);

        screen.add(empIdLbl);
        screen.add(empId);

        submit.setText("Get Farm Worker Details");

        submit.addActionListener(this);

        infoArea.setEditable(false);
        infoArea.setBackground(null);


        JScrollPane scrollPane = new JScrollPane(infoArea);

        screen.add(submit);
        screen.add(scrollPane);


        screen.setPreferredSize(new Dimension(600, 800));
        screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        screen.setTitle("Get Farm Worker Details");
        screen.pack();
        screen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //TODO: Test Radio Button
        String detail = farmInstance.getFarmWorkerDetails(Integer.parseInt(empId.getText()));
        infoArea.setText(detail);
    }

}