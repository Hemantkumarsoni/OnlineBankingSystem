package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;


public class SignUp2 extends JFrame implements ActionListener {

    JComboBox rel, catg, inc, edu, occ;
    JTextField textPan, textAadhar;
    JRadioButton s1, s2, e1, e2;
    JButton next;
    int userId;
    SignUp2(int userId) {
        super("KYC Details Page");

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        this.userId = userId;
        JLabel labelPage = new JLabel("Page 2:  "+userId);
        labelPage.setFont(new Font("RaleWay", Font.BOLD, 22));
        labelPage.setBounds(340,20,600,40);
        add(labelPage);

        JLabel labelAcc = new JLabel("Additonal Details");
        labelAcc.setFont(new Font("Raleway", Font.BOLD,22));
        labelAcc.setBounds(300,60,600,40);
        add(labelAcc);

        JLabel labelRel = new JLabel("Religion :");
        labelRel.setFont(new Font("Raleway", Font.BOLD,18));
        labelRel.setBounds(100,120,100,30);
        add(labelRel);

        String religion[] = {"Hindu","Muslim","Sikh", "Christian", "Other"};
        rel = new JComboBox(religion);
        rel.setBackground(Color.white);
        rel.setFont(new Font("Raleway",Font.BOLD,14));
        rel.setBounds(350,120,320,30);
        add(rel);

        JLabel l4 = new JLabel("Category : ");
        l4.setFont(new Font("Raleway", Font.BOLD,18));
        l4.setBounds(100,170,100,30);
        add(l4);

        String Category [] = {"General","OBC","SC", "ST", "Other"};
        catg = new JComboBox(Category);
        catg.setBackground(Color.white);
        catg.setFont(new Font("Raleway",Font.BOLD,14));
        catg.setBounds(350,170,320,30);
        add(catg);

        JLabel labelIncome = new JLabel("Income : ");
        labelIncome.setFont(new Font("Raleway", Font.BOLD,18));
        labelIncome.setBounds(100,220,100,30);
        add(labelIncome);

        String income [] = {"Null","<1,50,000","<2,50,000", "5,00,000", "Uptp 10,00,000","Above 10,00,000"};
        inc = new JComboBox(income);
        inc.setBackground(Color.white);
        inc.setFont(new Font("Raleway",Font.BOLD,14));
        inc.setBounds(350,220,320,30);
        add(inc);

        JLabel labelEdu = new JLabel("Educational : ");
        labelEdu.setFont(new Font("Raleway", Font.BOLD,18));
        labelEdu.setBounds(100,270,150,30);
        add(labelEdu);

        String educational [] = {"Non-Graduate","Graduate","Post-Graduate", "Doctrate", "Others"};
        edu = new JComboBox(educational);
        edu.setBackground(Color.white);
        edu.setFont(new Font("Raleway",Font.BOLD,14));
        edu.setBounds(350,270,320,30);
        add(edu);


        JLabel labelOcc = new JLabel("Occupation : ");
        labelOcc.setFont(new Font("Raleway", Font.BOLD,18));
        labelOcc.setBounds(100,340,150,30);
        add(labelOcc);

        String Occupation [] = {"Salaried","Self-Employed","Business", "Student", "Retired", "Other"};
        occ = new JComboBox(Occupation);
        occ.setBackground(Color.white);
        occ.setFont(new Font("Raleway",Font.BOLD,14));
        occ.setBounds(350,340,320,30);
        add(occ);

        JLabel l8 = new JLabel("PAN Number : ");
        l8.setFont(new Font("Raleway", Font.BOLD,18));
        l8.setBounds(100,390,150,30);
        add(l8);

        textPan = new JTextField();
        textPan.setFont(new Font("Raleway", Font.BOLD,18));
        textPan.setBounds(350,390,320,30);
        add(textPan);

        JLabel l9 = new JLabel("Aadhar Number : ");
        l9.setFont(new Font("Raleway", Font.BOLD,18));
        l9.setBounds(100,440,180,30);
        add(l9);

        textAadhar = new JTextField();
        textAadhar.setFont(new Font("Raleway", Font.BOLD,18));
        textAadhar.setBounds(350,440,320,30);
        add(textAadhar);


        JLabel labelSeniior = new JLabel("Senior Citizen : ");
        labelSeniior.setFont(new Font("Raleway", Font.BOLD,18));
        labelSeniior.setBounds(100,490,180,30);
        add(labelSeniior);

        s1 = new JRadioButton("Yes");
        s1.setFont(new Font("Raleway", Font.BOLD,14));
        s1.setBackground(Color.white);
        s1.setBounds(350,490,100,30);
        add(s1);

        s2 = new JRadioButton("No");
        s2.setFont(new Font("Raleway", Font.BOLD,14));
        s2.setBackground(Color.white);
        s2.setBounds(460,490,100,30);
        add(s2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(s1);
        buttonGroup.add(s2);

        JLabel labelExistAcc = new JLabel("Existing Account : ");
        labelExistAcc.setFont(new Font("Raleway", Font.BOLD,18));
        labelExistAcc.setBounds(100,540,180,30);
        add(labelExistAcc);

        e1 = new JRadioButton("Yes");
        e1.setFont(new Font("Raleway", Font.BOLD,14));
        e1.setBackground(Color.white);
        e1.setBounds(350,540,100,30);
        add(e1);
        e2 = new JRadioButton("No");
        e2.setFont(new Font("Raleway", Font.BOLD,14));
        e2.setBackground(Color.white);
        e2.setBounds(460,540,100,30);
        add(e2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(e1);
        buttonGroup1.add(e2);

        JLabel labelForm = new JLabel("Form No : ");
        labelForm.setFont(new Font("Raleway", Font.BOLD,14));
        labelForm.setBounds(700,10,100,30);
        add(labelForm);

        JLabel textForm = new JLabel(userId+" ");
        textForm.setFont(new Font("Raleway", Font.BOLD,14));
        textForm.setBounds(780,10,60,30);
        add(textForm);

        next = new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(new Color(0, 123, 255));
        next.setForeground(Color.white);
        next.setBounds(570,640,100,30);
        next.addActionListener(this);
        add(next);

        setSize(850,750);
        setLocation(450,80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String religion = (String) rel.getSelectedItem();
        String category = (String) catg.getSelectedItem();
        String income = (String) inc.getSelectedItem();
        String education = (String) edu.getSelectedItem();
        String occupation = (String) occ.getSelectedItem();
        String aadhar = textAadhar.getText();
        String pan = textPan.getText();
        String sCitizen = s1.isSelected() ? "Yes" : s2.isSelected() ? "No" : null;
        String eAccount = e1.isSelected() ? "Yes" : e2.isSelected() ? "No" : null;


        try {
            if(textAadhar.getText().equals("") || textPan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the Fields");
            } else {
                Conn c = new Conn();
                String sql = "INSERT INTO kyc_details "+
                        "(user_id, religion, category, income, education, occupation, pan, aadhar, senior_citizen, existing_account)"+
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement ps = c.connection.prepareStatement(sql);

                ps.setInt(1, userId);
                ps.setString(2, religion);
                ps.setString(3, category);
                ps.setString(4, income);
                ps.setString(5, education);
                ps.setString(6, occupation);
                ps.setString(7, pan);
                ps.setLong(8, Long.parseLong(aadhar));
                ps.setString(9, sCitizen);
                ps.setString(10, eAccount);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "KYC Saved Successfully");
                setVisible(false);
                new Signup3(userId);
            }

        }catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUp2(15);
    }
}
