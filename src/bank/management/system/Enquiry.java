package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Enquiry extends JFrame implements ActionListener {
    String cardno, name, totAmount;
    JButton exit;
    Enquiry(String info[]) {
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

        try {
            Conn draw = new Conn();
            String q = "select * from bank where card_no = '" + cardno + "' ";
            ResultSet resultSet = draw.statement.executeQuery(q);

            int balance = 0;
            Date date = new Date();
            while (resultSet.next()) {
                if (resultSet.getString("type").equals("DEPOSIT")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            totAmount = ""+balance;
        } catch (Exception E) {
            E.printStackTrace();
        }

        JLabel label = new JLabel("Your Current Balance is Rs "+totAmount);
        label.setFont(new Font("Raleway", Font.BOLD, 22));
        label.setBounds(230, 300, 400, 30);
        add(label);


        exit = new JButton("Exit");
        exit.setFont(new Font("Raleway", Font.BOLD, 22));
        exit.setBounds(100, 500, 100, 50);
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
            if(e.getSource() == exit) {
                setVisible(false);
                new Main(new String[]{cardno, name});
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] dummy = {"1234567890", "John Doe"};
        new Enquiry(dummy);
    }
}
