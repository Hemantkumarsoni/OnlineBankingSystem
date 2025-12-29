package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class ChangePin extends JFrame implements ActionListener {
    String cardno, name;
    JPasswordField pin1, pin2;
    JButton exit, change;
    ChangePin(String info[]) {
        super("Pin Change");
        this.cardno = info[0];
        this.name = info[1];

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel labelName = new JLabel("Account Holder Name :  "+name);
        labelName.setFont(new Font("Raleway", Font.BOLD, 22));
        labelName.setBounds(100, 50, 500, 30);
        add(labelName);

        JLabel labelCard = new JLabel("Card Number :  "+cardno);
        labelCard.setFont(new Font("Raleway", Font.BOLD, 22));
        labelCard.setBounds(100, 100, 500, 30);
        add(labelCard);

        JLabel label = new JLabel("Enter your new pin");
        label.setFont(new Font("Raleway", Font.BOLD, 22));
        label.setBounds(230, 200, 400, 30);
        add(label);

        pin1 = new JPasswordField();
        pin1.setFont(new Font("Raleway", Font.BOLD, 22));
        pin1.setBounds(230, 250, 400, 30);
        add(pin1);

        JLabel label1 = new JLabel("Re-enter new pin");
        label1.setFont(new Font("Raleway", Font.BOLD, 22));
        label1.setBounds(230, 320, 400, 30);
        add(label1);

        pin2 = new JPasswordField();
        pin2.setFont(new Font("Raleway", Font.BOLD, 22));
        pin2.setBounds(230, 370, 400, 30);
        add(pin2);

        exit = new JButton("Exit");
        exit.setFont(new Font("Raleway", Font.BOLD, 22));
        exit.setBounds(100, 500, 100, 50);
        exit.setBackground(new Color(0, 123, 255));
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);

        change = new JButton("Change");
        change.setFont(new Font("Raleway", Font.BOLD, 22));
        change.setBounds(500, 500, 150, 50);
        change.setBackground(new Color(0, 123, 255));
        change.setForeground(Color.white);
        change.addActionListener(this);
        add(change);

        setSize(850, 700);
        setLocation(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == exit) {
                setVisible(false);
                new Main(new String[]{cardno, name});
            }
            else if(e.getSource() == change) {
                String p1 = pin1.getText();
                String p2 = pin2.getText();

                if(p1.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                else if(p2.equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;
                } else if(!p1.equals(p2)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                Conn c = new Conn();

                String q1 = "UPDATE accounts SET pin = ? WHERE card_no = ?";
                PreparedStatement ps1 = c.connection.prepareStatement(q1);
                ps1.setInt(1, Integer.parseInt(p1));
                ps1.setLong(2, Long.parseLong(cardno));
                ps1.executeUpdate();

                String q2 = "UPDATE login SET pin = ? WHERE card_no = ?";
                PreparedStatement ps2 = c.connection.prepareStatement(q2);
                ps2.setInt(1, Integer.parseInt(p1));
                ps2.setLong(2, Long.parseLong(cardno));
                ps2.executeUpdate();

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                setVisible(false);
                new Main(new String[]{cardno, name});

            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] dummy = {"1234567890", "John Doe"};
        new ChangePin(dummy);
    }
}
