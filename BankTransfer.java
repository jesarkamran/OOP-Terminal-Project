import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import java.util.ArrayList;
public class BankTransfer extends JFrame
{
    JTextField enterAccField, enterAmField;
    JLabel nameReceiver = new JLabel("XYZ"), enterAm = new JLabel("Amount");;
    JButton enterAmount = new JButton("EnterAm");
    private Accounts currAccount; BankAccounts receiverAcc;
    BankTransfer(Accounts acc)
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

        //Creating Object of MyActionListener Object
        MyActionListener action = new MyActionListener();
        enter.addActionListener(action);
        enterAmount.addActionListener(action); enterAmount.setVisible(false);
        back.addActionListener(action);

        pCenter.add(enterAcc); pCenter.add(enterAccField); pCenter.add(nameReceiver);
        pCenter.add(enterAm); pCenter.add(enterAmField); pCenter.add(back);  pCenter.add(enter);
        pCenter.add(enterAmount);
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
    public void setReceiverAcc(BankAccounts receiverAcc) 
    {
        this.receiverAcc = receiverAcc;
    }
    public BankAccounts getReceiverAcc() 
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
                    BankAccounts account = new BankAccounts();
                    ArrayList<BankAccounts> list = account.readInFile();
                    boolean val = false;
                    for (BankAccounts accounts : list) 
                    {
                        if (accounts.getAccountNo() == accNum) 
                        {
                            setReceiverAcc(accounts);
                            enterAmField.setVisible(true);
                            nameReceiver.setText(accounts.getAccountHolderName());
                            nameReceiver.setVisible(true); 
                            enterAm.setVisible(true);
                            enterAmount.setVisible(true);
                            val = true; break;
                        }
                    }
                    if (!val) 
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "No Easypaisa Account found\n"+"for: "+accNum);
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
                if (acc != null)
                { 
                    int accAmount= Integer.parseInt(acc);
                    if (accAmount < getCurrAccount().getAmountInAccount() && accAmount > 0)
                    {    
                        //Updating Data in File of Easypaisa Account
                        Accounts account = new Accounts();
                        ArrayList<Accounts> list = account.readInFile();
                        for (Accounts accounts : list) 
                        {
                            if (accounts.getPhoneNo() == getCurrAccount().getPhoneNo()) 
                            {
                                accounts.setAmountInAccount(accounts.getAmountInAccount()- accAmount);
                                account = accounts;
                            }
                        }
                        Serialization<Accounts> ser = new Serialization<>(new File("EasyAccounts.ser"));
                        ser.deleteFile();

                        for (Accounts accounts : list) 
                        {
                            ser.dataWriting(accounts, true);
                        }
                        
                        //Updating Data in Bank Accounts File
                        BankAccounts account2 = new BankAccounts();
                        ArrayList<BankAccounts> list2 = account2.readInFile();
                        for (BankAccounts accounts : list2) 
                        {
                            if (accounts.getAccountNo() == getReceiverAcc().getAccountNo()) 
                            {
                                accounts.setAmountInAccount(accounts.getAmountInAccount() + accAmount);
                                setReceiverAcc(accounts);
                            }
                        }
                        Serialization<BankAccounts> ser2 = new Serialization<>(new File("Accounts.ser"));
                        ser2.deleteFile();

                        for (BankAccounts accounts : list2) 
                        {
                            ser2.dataWriting(accounts, true);
                        }
                        JOptionPane.showMessageDialog(new JFrame(), "Money Transfered From: \n\n"+account.toString()+
                                                    "\n\nTo Bank Account of: \n\n"+getReceiverAcc().toString());
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
            else if (e.getActionCommand().equals("Back")) 
            {
                dispose(); new SignedIn(getCurrAccount());
            }
        }
    }

}
