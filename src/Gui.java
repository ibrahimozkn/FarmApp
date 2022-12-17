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

    JAddCow addCowScreen = new JAddCow();

    FarmMe farmInstance;

    public void showGUI(FarmMe farmInstance)
    {
        farmInstance = this.farmInstance;

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
        opt2.setActionCommand("addSheep");


        opt1.addActionListener(this);



        menu.add(opt1);
        menu.add(opt2);
        menu.add(opt3);

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

        if(event.equalsIgnoreCase("addCowScreen")){
            addCowScreen.showAddCowScreen();
        }

    }

}

class JAddCow extends JFrame implements ActionListener{
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

    public void showAddCowScreen(){
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


        boolean result = FarmMe.instance.addCow(Integer.parseInt(tagId.getText()), male.getText().isEmpty() ? "female" : "male", date, purchased.getText().isEmpty() ? true : false, Double.parseDouble(weight.getText()));
        FarmMe.instance.listCow();
        if(result == false){
            System.out.println("Error dialog");
        }else{
            addCowScreen.setVisible(false);
        }
    }

}
