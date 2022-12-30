import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
public class Easypaisa extends JFrame
{
    JTextField enterAccField, enterAmField;
    JLabel nameReceiver = new JLabel("XYZ"), enterAm = new JLabel("Amount");;
    JButton enterAmount = new JButton("EnterAm");
    JButton clear = new JButton("Clear");
    private Accounts currAccount, receiverAcc;


    JLabel label1 = new JLabel("Name");
    JLabel label2 = new JLabel("Phone No");
    JLabel label3 = new JLabel("Amount Sent");

    JLabel succ = new JLabel();
    JLabel rec = new JLabel("Reciever Details");

    JLabel label4 = new JLabel();
    JLabel label5 = new JLabel();
    JLabel label6 = new JLabel();

    Easypaisa(Accounts acc)
    {
        this.currAccount = acc;
        setSize(1500,800); setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); setTitle("Easypaisa");
        
        JPanel pNorth = new JPanel();
        JPanel pSouth = new JPanel();
        JPanel pCenter = new JPanel();
        JPanel pWest = new JPanel();
        JPanel pEast = new JPanel();
        
        //Adding 5 panels
        add(pNorth, BorderLayout.NORTH);
        add(pSouth, BorderLayout.SOUTH);
        add(pCenter, BorderLayout.CENTER);
        add(pWest, BorderLayout.WEST);
        add(pEast, BorderLayout.EAST);

        //Setting Background Colors of Panel
        pNorth.setBackground(new Color(0,255,127));
        pSouth.setBackground(new Color(0,255,127));
        pCenter.setBackground(Color.WHITE);
        pWest.setBackground(new Color(0,255,127));
        pEast.setBackground(new Color(0,255,127));


        JLabel labelHeading = new JLabel("easypaisa");
        labelHeading.setForeground(new Color(0,0,0));
        labelHeading.setFont(new Font("Calibri", Font.BOLD,50));
        pNorth.add(labelHeading, BorderLayout.NORTH);

        //declaring Labels
        JLabel enterAcc =new JLabel("Account Number");

        //Setting Location and Size of Labels
        enterAcc.setBounds(30, 50, 200, 50);
        enterAm.setBounds(600, 50, 200, 50);
        nameReceiver.setBounds(1100, 50, 200, 50);
        label1.setBounds(400, 300, 250, 50);
        label2.setBounds(400, 350, 250, 50);
        label3.setBounds(400, 400, 250, 50);
        label4.setBounds(700, 300, 250, 50);
        label5.setBounds(700, 350, 250, 50);
        label6.setBounds(700, 400, 250, 50);
        succ.setBounds(400, 200, 600, 50);
        rec.setBounds(500, 250, 250, 50);

        //Declaring TextFields
        enterAccField = new JTextField();
        enterAmField = new JTextField();

        //setting the Location of fields
        enterAccField.setBounds(250,50, 200, 50);
        enterAmField.setBounds(800,50, 200, 50);

        //Setting font of Label and fields
        enterAcc.setFont(new Font("Calibri", Font.BOLD, 20));
        enterAm.setFont(new Font("Calibri", Font.BOLD, 20)); enterAm.setVisible(false);
        enterAccField.setFont(new Font("Calibri", Font.BOLD, 15));
        enterAmField.setFont(new Font("Calibri", Font.BOLD, 15));enterAmField.setVisible(false);
        nameReceiver.setFont(new Font("Calibri", Font.BOLD, 20)); nameReceiver.setVisible(false);
        label1.setFont(new Font("Calibri", Font.BOLD, 20)); label1.setVisible(false);
        label2.setFont(new Font("Calibri", Font.BOLD, 20)); label2.setVisible(false);
        label3.setFont(new Font("Calibri", Font.BOLD, 20)); label3.setVisible(false);
        label4.setFont(new Font("Calibri", Font.BOLD, 20)); label4.setVisible(false);
        label5.setFont(new Font("Calibri", Font.BOLD, 20)); label5.setVisible(false);
        label6.setFont(new Font("Calibri", Font.BOLD, 20)); label6.setVisible(false);
        succ.setFont(new Font("Calibri", Font.BOLD, 20)); succ.setVisible(false);
        rec.setFont(new Font("Calibri", Font.BOLD, 20)); rec.setVisible(false);

        //Setting center layout to null
        pCenter.setLayout(null);

        //Enter Button
        JButton enter = new JButton("Enter");
        enter.setFont(new Font("Calibiri", Font.BOLD,15));
        enter.setForeground(new Color(255,255,255));
        enter.setBackground(new Color(34,139,34));
        enter.setBounds(250, 150, 200, 50);

        //Enter Amount Button
        enterAmount.setFont(new Font("Calibiri", Font.BOLD,15));
        enterAmount.setForeground(new Color(255,255,255));
        enterAmount.setBackground(new Color(34,139,34));
        enterAmount.setBounds(800,150, 200, 50);;

        //Back Button
        JButton back = new JButton("Back");
        back.setFont(new Font("Calibiri", Font.BOLD,15));
        back.setForeground(new Color(255,255,255));
        back.setBackground(new Color(34,139,34));
        back.setBounds(30, 150, 200, 50);

        //Clear Button
        clear.setFont(new Font("Calibiri", Font.BOLD,15));
        clear.setForeground(new Color(255,255,255));
        clear.setBackground(new Color(34,139,34));
        clear.setBounds(500, 500, 200, 50);

        //Creating Object of MyActionListener Object
        MyActionListener action = new MyActionListener();
        enter.addActionListener(action);
        enterAmount.addActionListener(action); enterAmount.setVisible(false);
        back.addActionListener(action); clear.addActionListener(action);

        pCenter.add(enterAcc); pCenter.add(enterAccField); pCenter.add(nameReceiver);
        pCenter.add(enterAm); pCenter.add(enterAmField); pCenter.add(back);  pCenter.add(enter);
        pCenter.add(enterAmount); pCenter.add(label1); pCenter.add(label2);
        pCenter.add(label3); pCenter.add(label4); pCenter.add(label5); 
        pCenter.add(label6); pCenter.add(succ); pCenter.add(rec);
        pCenter.add(clear); clear.setVisible(false);
        setVisible(true);
    }

    //Setter getters for Current Account Holder Details
    public void setCurrAccount(Accounts currAccount) 
    {
        this.currAccount = currAccount;
    }
    public Accounts getCurrAccount() 
    {
        return currAccount;
    }

    //Setter and Getters for receiver Account
    public void setReceiverAcc(Accounts receiverAcc) 
    {
        this.receiverAcc = receiverAcc;
    }
    public Accounts getReceiverAcc() 
    {
        return receiverAcc;
    }
    class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("Enter"))
            {
                String acc = enterAccField.getText();
                if (acc != null)
                { 
                    long accNum = Long.parseLong(acc);
                    if (accNum != getCurrAccount().getPhoneNo())
                    {
                        Accounts account = new Accounts();
                        ArrayList<Accounts> list = account.readInFile();
                        boolean val = false;
                        for (Accounts accounts : list) 
                        {
                            if (accounts.getPhoneNo() == accNum) 
                            {
                                setReceiverAcc(accounts);
                                enterAmField.setVisible(true);
                                nameReceiver.setText(accounts.getName());
                                nameReceiver.setVisible(true); 
                                enterAm.setVisible(true);
                                enterAmount.setVisible(true);
                                val = true; break;
                            }
                        }
                        if (!val) 
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "No Easypaisa Account found\n"+"for: "+accNum);
                            enterAccField.setText("");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "Impossible Transaction");
                        enterAccField.setText("");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Can't leave a TextField Empty");
                }
            }
            else if (e.getActionCommand().equals("EnterAm")) 
            {
                String acc = enterAmField.getText();
                double accAmount= Double.parseDouble(acc);
                if (acc != null)
                {    
                    if (accAmount < getCurrAccount().getAmountInAccount() && accAmount > 0) 
                    {
                        Accounts account = new Accounts();
                        ArrayList<Accounts> list = account.readInFile();
                        for (Accounts accounts : list) 
                        {
                            if (accounts.getPhoneNo() == getCurrAccount().getPhoneNo()) 
                            {
                                accounts.setAmountInAccount(accounts.getAmountInAccount()- accAmount);
            
                                setCurrAccount(accounts);
                            }
                            else if (accounts.getPhoneNo() == getReceiverAcc().getPhoneNo()) 
                            {
                                accounts.setAmountInAccount(accounts.getAmountInAccount() + accAmount);
                                setReceiverAcc(accounts);
                            }
                        }
                        Serialization<Accounts> ser = new Serialization<>(new File("EasyAccounts.ser"));
                        ser.deleteFile();

                        for (Accounts accounts : list) 
                        {
                            ser.dataWriting(accounts, true);
                        }
                        JOptionPane.showMessageDialog(new JFrame(), "Money Transfered From: \n\n"+getCurrAccount().toString()+
                                                    "\n\nTo Easypaisa Account of: \n\n"+getReceiverAcc().toString());
                        
                        enterAccField.setText(""); enterAmField.setText("");
                        enterAmField.setVisible(false); nameReceiver.setVisible(false); 
                        enterAm.setVisible(false); enterAmount.setVisible(false);
                        succ.setText("Transaction Successfull from "+getCurrAccount().getName());
                        label4.setText(getReceiverAcc().getName());
                        label5.setText(""+getReceiverAcc().getPhoneNo());
                        label6.setText(""+accAmount);
                        label1.setVisible(true); label2.setVisible(true); label3.setVisible(true);
                        label4.setVisible(true); label5.setVisible(true); label6.setVisible(true);
                        succ.setVisible(true); rec.setVisible(true); clear.setVisible(true);
                        
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid Amount");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Can't leave a TextField Empty");
                }    
            }
            else if (e.getActionCommand().equals("Clear")) 
            {
                label1.setVisible(false); label2.setVisible(false);
                label3.setVisible(false); label4.setVisible(false);
                label5.setVisible(false); label6.setVisible(false);
                succ.setVisible(false); rec.setVisible(false); clear.setVisible(false);

                
            }
            else if (e.getActionCommand().equals("Back")) 
            {
                dispose();
                new SignedIn(getCurrAccount());
            }
        }
    }

}
