package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {
    String cardno, name, totAmt;
    JButton exit;
    Mini(String info[]) {
        super("");
        this.cardno = info[0];
        this.name = info[1];

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setFont(new Font("Monospaced", Font.BOLD, 14));
        textArea.setBounds(300, 250, 650, 350);

        JLabel labelName = new JLabel("Account Holder Name : "+name);
        labelName.setFont(new Font("Raleway", Font.BOLD, 22));
        labelName.setBounds(100, 30, 500, 30);
        add(labelName);

        JLabel labelCard = new JLabel("Card Number :"+cardno);
        labelCard.setFont(new Font("Raleway", Font.BOLD, 22));
        labelCard.setBounds(100, 70, 500, 30);
        add(labelCard);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setFont(new Font("Raleway", Font.BOLD, 22));
        label.setBounds(100, 110, 500, 30);
        add(label);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(100, 160, 600, 300);
        add(scrollPane);

        exit = new JButton("Exit");
        exit.setFont(new Font("Raleway", Font.BOLD, 22));
        exit.setBounds(100, 520, 120, 40);
        exit.setBackground(new Color(0, 123, 255));
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);

        try{
            Conn mini = new Conn();
            ResultSet resultSet = mini.statement.executeQuery("select * from bank where card_no = '"+cardno+"'");

            int balance = 0;
            StringBuilder sb = new StringBuilder();
            sb.append("Date\t\t\t\t\tType\t\tAmount\n");
            sb.append("--------------------------------------------------------------\n");

            while (resultSet.next()){
                String date = resultSet.getString("date");
                String type = resultSet.getString("type");
                String amount = resultSet.getString("amount");

                sb.append(resultSet.getString("date"))
                        .append("\t\t")
                        .append(resultSet.getString("type"))
                        .append("\t\t")
                        .append(resultSet.getString("amount"))
                        .append("\n\n");

                if (resultSet.getString("type").equals("DEPOSIT")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

            textArea.setText(sb.toString());
            totAmt = ""+balance;
            JLabel labelBalance = new JLabel("Your Balance is : "+ totAmt);
            labelBalance.setFont(new Font("System", Font.BOLD, 22));
            labelBalance.setBounds(100, 470, 400, 30);
            add(labelBalance);

        }catch (Exception e){
            e.printStackTrace();
        }

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
        new Mini(dummy);
    }
}
