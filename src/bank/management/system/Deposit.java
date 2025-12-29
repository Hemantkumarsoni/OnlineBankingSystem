package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String cardno, name;
    JButton exit, confirm;
    JTextField depAmount;
    Deposit(String info[]) {
        super("Deposit Page");
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

        JLabel label = new JLabel("Please Enter the Amount You Want To Deposit");
        label.setFont(new Font("Raleway", Font.BOLD, 22));
        label.setBounds(200, 250, 500, 30);
        add(label);

        depAmount = new JTextField();
        depAmount.setFont(new Font("Raleway", Font.BOLD, 18));
        depAmount.setBounds(200, 350, 400, 30);
        add(depAmount);

        exit = new JButton("Exit");
        exit.setFont(new Font("Raleway", Font.BOLD, 22));
        exit.setBounds(100, 500, 100, 50);
        exit.setBackground(new Color(0, 123, 255));
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);

        confirm = new JButton("Confirm");
        confirm.setFont(new Font("Raleway", Font.BOLD, 22));
        confirm.setBounds(600, 500, 200, 50);
        confirm.setBackground(new Color(0, 123, 255));
        confirm.setForeground(Color.white);
        confirm.addActionListener(this);
        add(confirm);

        setSize(850, 700);
        setLocation(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == exit) {
                setVisible(false);
                new Main(new String[]{cardno, name});
            }
            else if (e.getSource() == confirm) {

                if (depAmount.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter amount");
                    return;
                }

                int amount = Integer.parseInt(depAmount.getText());

                Conn c = new Conn();

                String sql = "INSERT INTO transactions (card_no, txn_type, amount) VALUES (?, ?, ?)";

                PreparedStatement ps = c.connection.prepareStatement(sql);
                ps.setLong(1, Long.parseLong(cardno));
                ps.setString(2, "Deposit");
                ps.setInt(3, amount);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,
                        "Rs. " + amount + " successfully deposited");

                setVisible(false);
                new Main(new String[]{cardno, name});
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Transaction failed");
        }
    }


    public static void main(String[] args) {
        String[] dummy = {"1234567890", "John Doe"};
        new Deposit(dummy);
    }
}
