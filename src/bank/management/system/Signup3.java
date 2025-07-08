package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton ac1, ac2, ac3, ac4;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton submit, cancel;
    String formno = "1234";
    Signup3(String formno) {
        super("Application Form");

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        this.formno = formno;
        JLabel labelForm = new JLabel("Form No : ");
        labelForm.setFont(new Font("Raleway", Font.BOLD,14));
        labelForm.setBounds(700,10,100,30);
        add(labelForm);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD,14));
        l13.setBounds(760,10,60,30);
        add(l13);

        JLabel l1 = new JLabel("Page 3:");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(300,20,400,40);
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(280,70,400,40);
        add(l2);

        JLabel l3 = new JLabel("Account Type:");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100,140,200,30);
        add(l3);

        ac1 = new JRadioButton("Saving Account");
        ac1.setFont(new Font("Raleway",Font.BOLD,16));
        ac1.setBackground(Color.white);
        ac1.setBounds(100,180,150,30);
        add(ac1);

        ac2 = new JRadioButton("Fixed Deposit Account");
        ac2.setFont(new Font("Raleway",Font.BOLD,16));
        ac2.setBackground(Color.white);
        ac2.setBounds(350,180,300,30);
        add(ac2);

        ac3 = new JRadioButton("Current Account");
        ac3.setFont(new Font("Raleway",Font.BOLD,16));
        ac3.setBackground(Color.white);
        ac3.setBounds(100,220,250,30);
        add(ac3);

        ac4 = new JRadioButton("Recurring Deposit Account");
        ac4.setFont(new Font("Raleway",Font.BOLD,16));
        ac4.setBackground(Color.white);
        ac4.setBounds(350,220,250,30);
        add(ac4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(ac1);
        buttonGroup.add(ac2);
        buttonGroup.add(ac3);
        buttonGroup.add(ac4);

        JLabel labelCard = new JLabel("Card Number:");
        labelCard.setFont(new Font("Raleway",Font.BOLD,18));
        labelCard.setBounds(100,300,200,30);
        add(labelCard);

        JLabel label16Dig = new JLabel("(Your 16-digit Card Number)");
        label16Dig.setFont(new Font("Raleway",Font.BOLD,12));
        label16Dig.setBounds(100,330,200,20);
        add(label16Dig);

        JLabel labelcardNo = new JLabel("XXXX-XXXX-XXXX-4841");
        labelcardNo.setFont(new Font("Raleway",Font.BOLD,18));
        labelcardNo.setBounds(330,300,250,30);
        add(labelcardNo);

        JLabel labelCardInfo = new JLabel("(It would appear on atm card/cheque Book and Statements)");
        labelCardInfo.setFont(new Font("Raleway",Font.BOLD,12));
        labelCardInfo.setBounds(330,330,500,20);
        add(labelCardInfo);

        JLabel labelPin = new JLabel("PIN:");
        labelPin.setFont(new Font("Raleway",Font.BOLD,18));
        labelPin.setBounds(100,370,200,30);
        add(labelPin);

        JLabel label4Dig = new JLabel("XXXX");
        label4Dig.setFont(new Font("Raleway",Font.BOLD,18));
        label4Dig.setBounds(330,370,200,30);
        add(label4Dig);

        JLabel labelPass = new JLabel("(4-digit Password)");
        labelPass.setFont(new Font("Raleway",Font.BOLD,12));
        labelPass.setBounds(100,400,200,20);
        add(labelPass);

        JLabel labelSer = new JLabel("Services Required:");
        labelSer.setFont(new Font("Raleway",Font.BOLD,18));
        labelSer.setBounds(100,450,200,30);
        add(labelSer);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        JCheckBox declar = new JCheckBox("I here by decleares that the above entered details correct to the best of my knlowledge.",true);
        declar.setBackground(Color.white);
        declar.setFont(new Font("Raleway",Font.BOLD,12));
        declar.setBounds(100,680,600,20);
        add(declar);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD,14));
        submit.setBackground(new Color(0, 123, 255));
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD,14));
        cancel.setBackground(new Color(0, 123, 255));
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(850,800);
        setLocation(400,20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accType = null;
        if(ac1.isSelected()) {
            accType = "Saving Account";
        }
        else if(ac2.isSelected()) {
            accType = "Fixed Deposit Account";
        }
        else if(ac3.isSelected()) {
            accType = "Current Account";
        }
        else if(ac4.isSelected()) {
            accType = "Recurring Deposit Account";
        }

        Random ran = new Random();
        long card = (ran.nextLong() % 90000000L) + 1409963000000000L;
        String cardno = "" + Math.abs(card);

        long pin = (ran.nextLong() % 9000L)+ 1000L;
        String pinno = "" + Math.abs(pin);

        String fac = "";
        if(c1.isSelected()){
            fac = fac+"ATM CARD ";
        }
        if (c2.isSelected()) {
            fac = fac+"Internet Banking";
        }
        if (c3.isSelected()) {
            fac = fac+"Mobile Banking";
        }
        if (c4.isSelected()) {
            fac = fac+"EMAIL Alerts";
        }
        if (c5.isSelected()) {
            fac=fac+"Cheque Book";
        }
        if (c6.isSelected()) {
            fac=fac+"E-Statement";
        }

        try {
            if (e.getSource() == submit){
                if (accType.equals("")){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }else {
                    Conn c3 = new Conn();
                    String q1 = "insert into signup3 values('"+formno+"', '"+accType+"','"+cardno+"','"+pin+"','"+fac+"')";
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c3.statement.executeUpdate(q1);
                    c3.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardno+"\n Pin : "+pin );
                    setVisible(false);
                }
            } else if (e.getSource() == cancel) {
                System.exit(0);
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
