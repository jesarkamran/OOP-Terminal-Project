import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BillPayment extends JFrame
{
    JTextField enterAccField, enterAmField;
    JLabel nameReceiver = new JLabel("XYZ"), enterAm = new JLabel("Amount");;
    JButton enterAmount = new JButton("EnterAm");
    private Accounts currAccount; BillData receiverAcc;
    BillPayment(Accounts acc)
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
        JLabel enterAcc =new JLabel("Bill ID");

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

    //Setter and Getters for BIllDAta
    public void setReceiverAcc(BillData receiverAcc) 
    {
        this.receiverAcc = receiverAcc;
    }
    public BillData getReceiverAcc() 
    {
        return receiverAcc;
    }

    public double taxCharges(String type)
    {
        if (type.equals("Electricity")) {
            return 40;
        }
        else if (type.equals("Internet")) {
            return 50;
        }
        else
        {
            return 20;
        }
    }

    private String type;
    public void setType(String type) 
    {
        this.type = type;
    }
    public String getTypeSting() {
        return type;
    }

    class MyActionListener implements ActionListener
    {

        Accounts account = new Accounts();
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("Enter"))
            {
                String acc = enterAccField.getText();
                if (acc != null)
                {
                    if (acc.length() == 5)
                    {
                        int billid = Integer.parseInt(acc);
                        BillData account = new BillData();
                        ArrayList<BillData> list = account.readInFile();
                        boolean val = false;
                        for (BillData bill : list) 
                        {
                            if (bill.getBillId() == billid) 
                            {
                                setReceiverAcc(bill); setType(bill.getBillType());
                                System.out.println(type);
                                enterAmField.setVisible(true);
                                nameReceiver.setText(bill.getBillType());
                                nameReceiver.setVisible(true); 
                                enterAm.setVisible(true);
                                enterAmount.setVisible(true);
                                val = true; break;
                            }
                        }
                        if (!val) 
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "No Bill Type found\n"+"for: "+billid);
                            enterAccField.setText("");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid Length of ID");
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
                String am = enterAmField.getText();
                if (am != null)
                {
                    if (am.length() < 10)
                    {
                        int billAmount = Integer.parseInt(am);
                        if (billAmount < getCurrAccount().getAmountInAccount() && billAmount > 0)
                        {    
                            //Updating Data in File of Easypaisa Account
                            ArrayList<Accounts> list = account.readInFile();
                            for (Accounts accounts : list) 
                            {
                                if (accounts.getPhoneNo() == getCurrAccount().getPhoneNo()) 
                                {
                                    accounts.setAmountInAccount(accounts.getAmountInAccount()- (billAmount+taxCharges(getTypeSting())));
                                    account = accounts;
                                    setCurrAccount(accounts);
                                }
                            }
                            Serialization<Accounts> ser = new Serialization<>(new File("EasyAccounts.ser"));
                            ser.deleteFile();

                            for (Accounts accounts : list) 
                            {
                                ser.dataWriting(accounts, true);
                            }
                            JOptionPane.showMessageDialog(new JFrame(), "BILL PAID "+"\n"+
                                                                        "Name: "+account.getName()+"\n"+
                                                                        "Account No: "+ account.getPhoneNo()+"\n\n"+
                                                                        "Charges: "+(billAmount+taxCharges(type))+"\n"+
                                                                        "BILL TYPE"+"\n"+getTypeSting());
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "Invalid Amount");
                            enterAmField.setText("");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid Length Amount");
                        enterAmField.setText("");
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
