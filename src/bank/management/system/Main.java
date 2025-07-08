package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    String cardno, name;
    JButton deposit, withdrawl, mini, enquiry, changePin, exit;
    Main(String info[]) {
        super("");
        this.cardno = info[0];
        this.name = info[1];
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel labelName = new JLabel("Account Holder Name : "+name);
        labelName.setFont(new Font("Raleway", Font.BOLD, 22));
        labelName.setBounds(100, 50, 500, 30);
        add(labelName);

        JLabel labelCard = new JLabel("Card Number :"+cardno);
        labelCard.setFont(new Font("Raleway", Font.BOLD, 22));
        labelCard.setBounds(100, 100, 500, 30);
        add(labelCard);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setFont(new Font("Raleway", Font.BOLD, 22));
        label.setBounds(230, 150, 400, 30);
        add(label);

        deposit = new JButton("DEPOSIT");
        deposit.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit.setBounds(100, 250, 200, 50);
        deposit.setBackground(new Color(0, 123, 255));
        deposit.setForeground(Color.white);
        deposit.addActionListener(this);
        add(deposit);

        withdrawl = new JButton("CASH WITHDRAWAL");
        withdrawl.setFont(new Font("Raleway", Font.BOLD, 14));
        withdrawl.setBounds(100, 330, 200, 50);
        withdrawl.setBackground(new Color(0, 123, 255));
        withdrawl.setForeground(Color.white);
        withdrawl.addActionListener(this);
        add(withdrawl);

        mini = new JButton("MINI STATMAENT");
        mini.setFont(new Font("Raleway", Font.BOLD, 14));
        mini.setBounds(100, 410, 200, 50);
        mini.setBackground(new Color(0, 123, 255));
        mini.setForeground(Color.white);
        mini.addActionListener(this);
        add(mini);

        enquiry = new JButton("BALANCE ENQUIRY");
        enquiry.setFont(new Font("Raleway", Font.BOLD, 14));
        enquiry.setBounds(480, 250, 200, 50);
        enquiry.setBackground(new Color(0, 123, 255));
        enquiry.setForeground(Color.white);
        enquiry.addActionListener(this);
        add(enquiry);

        changePin = new JButton("CHANGE PIN");
        changePin.setFont(new Font("Raleway", Font.BOLD, 14));
        changePin.setBounds(480, 330, 200, 50);
        changePin.setBackground(new Color(0, 123, 255));
        changePin.setForeground(Color.white);
        changePin.addActionListener(this);
        add(changePin);

        exit = new JButton("EXIT");
        exit.setFont(new Font("Raleway", Font.BOLD, 14));
        exit.setBounds(480, 410, 200, 50);
        exit.setBackground(new Color(0, 123, 255));
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);

        setSize(850, 700);
        setLocation(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == deposit) {
                setVisible(false);
                new Deposit(new String[]{cardno, name});
            }
            else if(e.getSource() == withdrawl) {
                setVisible(false);
                new WithDrawal(new String[]{cardno, name});
            }
            else if (e.getSource() == mini) {
                setVisible(false);
                new Mini(new String[]{cardno, name});
            }
            else if(e.getSource() == enquiry) {
                setVisible(false);
                new Enquiry(new String[]{cardno, name});
            }
            else if(e.getSource() == changePin) {
                setVisible(false);
                new ChangePin(new String[]{cardno, name});
            }
            else if (e.getSource() == exit) {
                setVisible(false);
                new Login();
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] dummy = {"1234567890", "John Doe"};
        new Main(dummy);
    }
}
