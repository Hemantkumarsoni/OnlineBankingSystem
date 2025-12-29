package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class ForgotCard extends JFrame implements ActionListener {
    JTextField email, dob;
    JButton submit, back;

    ForgotCard() {
        super("get card no");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel head = new JLabel("Get your Card no.");
        head.setBounds(150, 10, 250, 100);
        head.setFont(new Font("Raleway", Font.BOLD, 22));
        add(head);

        JLabel l1 = new JLabel("Email:");
        l1.setBounds(100,100,100,30);
        add(l1);

        email = new JTextField();
        email.setBounds(250,100,200,30);
        add(email);

        JLabel l2 = new JLabel("DOB (YYYY-MM-DD) : ");
        l2.setBounds(100,150,150,30);
        add(l2);

        dob = new JTextField();
        dob.setBounds(250,150,200,30);
        add(dob);

        submit = new JButton("Submit");
        submit.setBounds(150,220,100,30);
        submit.setBackground(new Color(0, 123, 255));
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(270,220,100,30);
        back.setBackground(new Color(0, 123, 255));
        back.addActionListener(this);
        add(back);

        setSize(500,350);
        setLocation(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Conn c = new Conn();

            if (e.getSource() == submit) {
                String dt = dob.getText().toString();
                if(email.getText().isEmpty() || dt.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill the details");
                    return;
                }

                DateFormatValidator dfv = new DateFormatValidator();
                if(!dt.isEmpty() && !dfv.isValidDate(dt)) {
                    JOptionPane.showMessageDialog(null, "Invalid Date");
                    dob.setText("");
                    return;
                }

                String sql =
                        "SELECT a.card_no FROM users u " +
                                "JOIN accounts a ON u.user_id = a.user_id " +
                                "WHERE u.email=? AND u.dob=?";

                PreparedStatement ps = c.connection.prepareStatement(sql);
                ps.setString(1, email.getText());
                ps.setString(2, dob.getText());

                var rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null,
                            "Your Card Number: " + rs.getLong("card_no"));
                } else {
                    JOptionPane.showMessageDialog(null, "Details not found");
                }
            } else {
                setVisible(false);
                dispose();
                new Login();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String args[]) {
        new ForgotCard();
    }
}

