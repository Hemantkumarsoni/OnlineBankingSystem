package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class SignUp extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    JTextField textName, textFname, textEmail, textAdd, textCity, textPin, textState, dateChooser;
    JRadioButton r1, r2, m1, m2;
    JButton next, back;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " "+Math.abs(first4);
    SignUp() {
        super("Application Form");

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        label1 = new JLabel("APPLICATION FORM NO. "+first);
        label1.setBounds(200, 20, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 26));
        add(label1);

        label2 = new JLabel("Page 1");
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        label2.setBounds(330, 70, 600, 30);
        add(label2);

        label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        label3.setBounds(290, 110, 600, 30);
        add(label3);

        JLabel labelName = new JLabel("Name : ");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(100, 190, 150, 30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(300, 190, 400, 30);
        add(textName);

        JLabel labelF = new JLabel("Father name : ");
        labelF.setFont(new Font("Raleway", Font.BOLD, 20));
        labelF.setBounds(100, 240, 150, 30);
        add(labelF);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway", Font.BOLD, 14));
        textFname.setBounds(300, 240, 400, 30);
        add(textFname);

        JLabel DOB = new JLabel("Date of Birth : ");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100, 340, 200, 30);
        add(DOB);

        dateChooser = new JTextField();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,340,400,30);
        add(dateChooser);


        JLabel labelG = new JLabel("Gender : ");
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        labelG.setBounds(100, 290, 200, 30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setBackground(Color.white);
        r1.setFont(new Font("RaleWay", Font.BOLD, 14));
        r1.setBounds(300, 290, 60, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(Color.white);
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBounds(450, 290, 90, 30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelEmail = new JLabel("E-mail : ");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(100, 390, 200, 30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Ralwway", Font.BOLD, 14));
        textEmail.setBounds(300, 390, 400, 30);
        add(textEmail);

        JLabel labelM = new JLabel("Marital status : ");
        labelM.setFont(new Font("Raleway", Font.BOLD, 20));
        labelM.setBounds(100, 440, 400, 30);
        add(labelM);

        m1 = new JRadioButton("Married");
        m1.setBackground(Color.white);
        m1.setFont(new Font("Raleway", Font.BOLD, 14));
        m1.setBounds(300, 440, 100, 30);;
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBackground(Color.white);
        m2.setBounds(450, 440, 100, 30);
        m2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(m2);

        ButtonGroup buttonGroupM = new ButtonGroup();
        buttonGroupM.add(m1);
        buttonGroupM.add(m2);

        JLabel labelAdd = new JLabel("Address : ");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAdd.setBounds(100, 490, 150, 30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway", Font.BOLD, 14));
        textAdd.setBounds(300, 490, 400, 30);
        add(textAdd);

        JLabel labelCity = new JLabel("City : ");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCity.setBounds(100, 540, 150, 30);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway", Font.BOLD, 14));
        textCity.setBounds(300, 540, 400, 30);
        add(textCity);

        JLabel labelPin = new JLabel("Pin code : ");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPin.setBounds(100, 590, 200, 30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway", Font.BOLD, 14));
        textPin.setBounds(300, 590, 400, 30);
        add(textPin);

        JLabel labelState = new JLabel("State : ");
        labelState .setFont(new Font("Raleway", Font.BOLD, 20));
        labelState .setBounds(100, 640, 200, 30);
        add(labelState );

        textState = new JTextField();
        textState.setFont(new Font("Raleway", Font.BOLD, 14));
        textState.setBounds(300, 640, 400, 30);
        add(textState);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setForeground(Color.WHITE);
        next.setBackground(new Color(0, 123, 255));
        next.setBounds(620, 710, 80, 30);
        next.addActionListener(this);
        add(next);

        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 20));
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(0, 123, 255));
        back.setBounds(150, 710, 90, 30);
        back.addActionListener(this);
        add(back);

        setSize(850, 800);
        setLocation(360, 40);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String form = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String gender = null;
        if(r1.isSelected()) {
            gender = "Male";
        }
        else if(r2.isSelected()) {
            gender = "Female";
        }
        String dob = dateChooser.getText();
        String email = textEmail.getText();
        String marital = null;
        if(m1.isSelected()) {
            marital = "Married";
        }
        else if(m2.isSelected()) {
            marital = "Unmarried";
        }
        String address = textAdd.getText();
        String city = textCity.getText();
        String pin = textPin.getText();
        String state = textState.getText();

        try {
            if (e.getSource() == back) {
                setVisible(false);
                new Login();
            }
            else if (textName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the Text field");
            }
            else if(e.getSource() == next){
                Conn c1 = new Conn();
                String q = "insert into signup values('" + form + "', '" + name + "', '" + fname + "', '" + gender + "', '" + dob + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + pin + "', '" + state + "')";
                c1.statement.executeUpdate(q);
                new SignUp2(form);
                setVisible(false);
            }

        } catch (Exception E) {
            E.printStackTrace();

        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
