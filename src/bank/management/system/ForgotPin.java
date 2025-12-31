package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class ForgotPin extends JFrame implements ActionListener {
    JTextField card, email, newPin;
    JButton reset, back;

    ForgotPin() {
        super("get pin");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel head = new JLabel("Create Your new Pin");
        head.setBounds(150, 10, 250, 100);
        head.setFont(new Font("Raleway", Font.BOLD, 22));
        add(head);

        JLabel l1 = new JLabel("Card No:");
        l1.setBounds(100,100,100,30);
        add(l1);

        card = new JTextField();
        card.setBounds(220,100,200,30);
        add(card);

        JLabel l2 = new JLabel("Email:");
        l2.setBounds(100,150,100,30);
        add(l2);

        email = new JTextField();
        email.setBounds(220,150,200,30);
        add(email);

        JLabel l3 = new JLabel("New PIN:");
        l3.setBounds(100,200,100,30);
        add(l3);

        newPin = new JTextField();
        newPin.setBounds(220,200,200,30);
        add(newPin);

        reset = new JButton("Reset");
        reset.setBounds(150,260,100,30);
        reset.setBackground(new Color(0, 123, 255));
        reset.addActionListener(this);
        add(reset);

        back = new JButton("Back");
        back.setBounds(270,260,100,30);
        back.setBackground(new Color(0, 123, 255));
        back.addActionListener(this);
        add(back);

        setSize(500,400);
        setLocation(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            Conn c = new Conn();

            if (e.getSource() == reset) {
                if(card.getText().isEmpty() || email.getText().isEmpty() || newPin.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill the text Field");
                    return;
                }

                if(!card.getText().matches("\\d+") && !newPin.getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Invalid details, Give the correct details");
                    card.setText("");
                    newPin.setText("");
                    email.setText("");
                    return;
                }

                String sql =
                        "UPDATE login l JOIN users u ON l.user_id=u.user_id " +
                                "SET l.pin=? WHERE l.card_no=? AND u.email=?";

                PreparedStatement ps = c.connection.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(newPin.getText()));
                ps.setLong(2, Long.parseLong(card.getText()));
                ps.setString(3, email.getText());

                String sqla =
                        "UPDATE accounts a JOIN users u ON a.user_id=u.user_id " +
                                "SET a.pin=? WHERE a.card_no=? AND u.email=?";

                PreparedStatement psa = c.connection.prepareStatement(sqla);
                psa.setInt(1, Integer.parseInt(newPin.getText()));
                psa.setLong(2, Long.parseLong(card.getText()));
                psa.setString(3, email.getText());

                int updated = ps.executeUpdate();
                int updated2 = psa.executeUpdate();

                if (updated > 0 && updated2 > 0) {
                    JOptionPane.showMessageDialog(null, "PIN reset successful");
                    setVisible(false);
                    new Login();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid details");
                }
            }
            else if(e.getSource() == back) {
                setVisible(false);
                new Login();
                dispose();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String args[]) {
        new ForgotPin();
    }
}

