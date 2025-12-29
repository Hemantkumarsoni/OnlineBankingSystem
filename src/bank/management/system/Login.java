package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel label, labelCard, labelPassword;
    JTextField textCardNo;
    JPasswordField textPassword;
    JButton signin, clear, signup;
    Login() {
        super("Login Page");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        label = new JLabel("Welcome To Bank");
        label.setForeground(Color.blue);
        label.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label.setBounds(230,50,450,40);
        add(label);


        labelCard = new JLabel("Card No:");
        labelCard.setFont(new Font("Ralway", Font.BOLD, 28));
        labelCard.setBounds(100,150,375,30);
        add(labelCard);

        textCardNo = new JTextField(15);
        textCardNo.setBounds(325,150,230,30);
        textCardNo.setFont(new Font("Arial", Font.BOLD,14));
        add(textCardNo);

        labelPassword = new JLabel("Enter Password:");
        labelPassword.setFont(new Font("Ralway", Font.BOLD, 28));
        labelPassword.setBounds(100, 240,375, 30);
        add(labelPassword);

        textPassword = new JPasswordField(15);
        textPassword.setBounds(325,240,230,30);
        textPassword.setFont(new Font("Arial", Font.BOLD,14));
        add(textPassword);

        JLabel forgotCard = new JLabel("<HTML><U>Forgot Card No?</U></HTML>");
        forgotCard.setForeground(Color.BLUE);
        forgotCard.setBounds(100, 300, 150, 20);
        add(forgotCard);

        JLabel forgotPin = new JLabel("<HTML><U>Forgot PIN?</U></HTML>");
        forgotPin.setForeground(Color.BLUE);
        forgotPin.setBounds(270, 300, 150, 20);
        add(forgotPin);

        forgotCard.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new ForgotCard();
            }
        });

        forgotPin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new ForgotPin();
            }
        });



        signin = new JButton("SIGN IN");
        signin.setFont(new Font("Arial", Font.BOLD, 14));
        signin.setForeground(Color.WHITE);
        signin.setBackground(new Color(0, 123, 255));
        signin.setBounds(150,350,100, 30);
        signin.addActionListener(this);
        add(signin);

        clear = new JButton("CLEAR");
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setForeground(Color.white);
        clear.setBackground(new Color(0, 123, 255));
        clear.setBounds(350, 350, 100, 30);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setFont(new Font("Arial", Font.BOLD, 14));
        signup.setForeground(Color.white);
        signup.setBackground(new Color(0, 123, 255));
        signup.setBounds(550, 350, 100, 30);
        signup.addActionListener(this);
        add(signup);

//        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/netBank.jpg"));
//        Image iii2 = iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
//        ImageIcon iii3 = new ImageIcon(iii2);
//        JLabel iiimage = new JLabel(iii3);
//        iiimage.setBounds(0,0,850,480);
//        add(iiimage);

        setSize(850, 480);
        setLocation(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signin) {

            String cardno = textCardNo.getText();
            String pin = textPassword.getText();

            if(cardno.isEmpty() || pin.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill the card no or pin first");
            }

            try {
                Conn c = new Conn();

                String loginSql = "SELECT user_id FROM login WHERE card_no = ? AND pin = ?";
                PreparedStatement ps = c.connection.prepareStatement(loginSql);
                ps.setLong(1, Long.parseLong(cardno));
                ps.setInt(2, Integer.parseInt(pin));

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int userId = rs.getInt("user_id");

                    String userSql = "SELECT name FROM users WHERE user_id = ?";
                    PreparedStatement ps2 = c.connection.prepareStatement(userSql);
                    ps2.setInt(1, userId);

                    ResultSet rs2 = ps2.executeQuery();

                    String name = "";
                    if (rs2.next()) {
                        name = rs2.getString("name");
                    }

                    String info[] = {cardno, name};
                    setVisible(false);
                    new Main(info);

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                textCardNo.setText("");
                textPassword.setText("");
                ex.printStackTrace();
            }
        }

        else if (e.getSource() == clear) {
            textCardNo.setText("");
            textPassword.setText("");
        }

        else if (e.getSource() == signup) {
            setVisible(false);
            new SignUp();
        }
    }


    public static void main(String[] args) {
        new Login();
    }
}
