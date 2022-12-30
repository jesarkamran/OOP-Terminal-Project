import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SignedIn extends JFrame
{
    JLabel sidePic;
    private Accounts currAccount;

    public void setCurrAccount(Accounts currAccount) 
    {
        this.currAccount = currAccount;
    }
    public Accounts getCurrAccount() 
    {
        return currAccount;
    }
    SignedIn(Accounts acc)
    {
        setCurrAccount(acc);
        setSize(1500, 800); setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("EasyPaisa"); setLayout(new BorderLayout());

        //Declaring JPanels
        JPanel center = new JPanel();
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();

        //Setting their Positon on Jframe
        add(center, BorderLayout.CENTER);
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);
        add(west, BorderLayout.WEST);

        JButton easypaisa = new JButton("Easypaisa");
        JButton bankTransfer = new JButton("Bank Transfer");
        JButton billPayment = new JButton("Bill Payment");
        JButton signOut = new JButton("Sign Out");
        JButton myAcc = new JButton("My Account");

        JLabel labelHeading = new JLabel("easypaisa");
        labelHeading.setForeground(new Color(0,0,0));
        labelHeading.setFont(new Font("Calibri", Font.BOLD, 50));
        north.setLayout(new BorderLayout());
        

        //Declaring  Sub JPanels of north Main Panel
        JPanel nNorthPanel = new JPanel();
        JPanel nCenterPanel = new JPanel();
        JPanel nSouthPanel = new JPanel();
        JPanel nEastPanel = new JPanel();
        JPanel nWestpanel = new JPanel();

       
        //Setting color of Sub JPanels of north Main Panel
        nNorthPanel.setBackground(new Color(0,255,127));
        nSouthPanel.setBackground(new Color(0,255,127));
        nCenterPanel.setBackground(Color.WHITE);
        nEastPanel.setBackground(new Color(0,255,127));
        nWestpanel.setBackground(new Color(0,255,127));

        //Setting Positon of Sub JPanels of north Main Panel
        north.add(nCenterPanel, BorderLayout.CENTER);
        north.add(nNorthPanel, BorderLayout.NORTH);
        north.add(nSouthPanel, BorderLayout.SOUTH);
        north.add(nEastPanel, BorderLayout.EAST);
        north.add(nWestpanel, BorderLayout.WEST);
        
        //adding heading label in SubNorth panel of Main North Panel
        nNorthPanel.add(labelHeading);

        //Setting Layout of Sub Center Panel of Main North Panel
        nCenterPanel.setLayout(new GridLayout(3,3));
        
        //Setting color of Main JPanels
        south.setBackground(new Color(0,255,127));
        center.setBackground(new Color(255,255,255));
        west.setBackground(new Color(0,255,127));
        east.setBackground(new Color(0,255,127));

        //Declaring JLabel to Show the Name of User And Balance in Account
        JLabel nameOfUser = new JLabel(acc.getName());
        JLabel amountInAcc = new JLabel(""+acc.getAmountInAccount());
        JLabel userName = new JLabel("User Name");
        JLabel accAmount = new JLabel("Amount in Account");

        //Setting size of Fonts Inside Labels
        nameOfUser.setFont(new Font("Calibri", Font.BOLD, 20));
        amountInAcc.setFont(new Font("Calibri", Font.BOLD, 20));
        userName.setFont(new Font("Calibri", Font.BOLD, 20));
        accAmount.setFont(new Font("Calibri", Font.BOLD, 20));

        //Setting the color of Labels
        nameOfUser.setForeground(Color.BLACK);
        amountInAcc.setForeground(Color.BLACK);
        userName.setForeground(Color.BLACK);
        accAmount.setForeground(Color.BLACK);
        
        nCenterPanel.setBackground(new Color(255,255,255));
        
        //Adjusting Labels To show Data in desired Way
        nCenterPanel.add(userName);
        nCenterPanel.add(nameOfUser);
        nCenterPanel.add(new JLabel("         "));
        nCenterPanel.add(new JLabel("         "));
        nCenterPanel.add(new JLabel("         "));
        nCenterPanel.add(new JLabel("         "));
        nCenterPanel.add(accAmount);
        nCenterPanel.add(amountInAcc);        
        nCenterPanel.add(new JLabel("         "));


        center.setLayout(null);

        //Setting the Fonts of Button and 
        myAcc.setFont(new Font("Calibri", Font.BOLD, 20));
        easypaisa.setFont(new Font("Calibri", Font.BOLD, 20));
        bankTransfer.setFont(new Font("Calibri", Font.BOLD, 20));
        billPayment.setFont(new Font("Calibri", Font.BOLD, 20));
        signOut.setFont(new Font("Calibri", Font.BOLD, 20));
        
        //Color Of Buttons
        myAcc.setBackground(new Color(34,139,34));
        easypaisa.setBackground(new Color(34,139,34));
        bankTransfer.setBackground(new Color(34,139,34));
        billPayment.setBackground(new Color(34,139,34));
        signOut.setBackground(new Color(34,139,34));


        myAcc.setForeground(new Color(255,255,255));
        easypaisa.setForeground(new Color(255,255, 255));
        bankTransfer.setForeground(new Color(255,255,255));
        billPayment.setForeground(new Color(255,255,255));
        signOut.setForeground(new Color(255,255,255));

        //Setting the Locationof Buttons
        easypaisa.setBounds(700, 100, 300, 50);
        bankTransfer.setBounds(1040, 100, 300, 50);

        billPayment.setBounds(700, 200, 300, 50);
        myAcc.setBounds(1040, 200, 300, 50);
        
        signOut.setBounds(800, 300, 400, 50);

        JLabel labelCenter = new JLabel("Send Money to anyone in Pakistan Instantly");
        labelCenter.setFont(new Font("Calibri", Font.BOLD, 20));
        labelCenter.setBounds(700, 0, 600, 100); center.add(labelCenter);

        //Creating MyActionListener Class
        MyActionListener action = new MyActionListener();

        //Setting ActionListener
        myAcc.addActionListener(action);
        easypaisa.addActionListener(action);
        billPayment.addActionListener(action);
        bankTransfer.addActionListener(action);
        signOut.addActionListener(action);

        try {
            ImageIcon img = new ImageIcon(new ImageIcon("EasyPaisa Login Page Pic.png.png").getImage().getScaledInstance(800, 600, Image.SCALE_AREA_AVERAGING));
            sidePic =  new JLabel(img);
        }catch (Exception e)
        {
            System.out.println("Problem Loading Image");
        }

        //Setting Location AND Size of Side PICTURE
        sidePic.setBounds(0,0, 700, 600);
        center.add(sidePic);

        center.add(myAcc); center.add(easypaisa);
        center.add(bankTransfer);
        center.add(billPayment); center.add(signOut);

        setVisible(true);
    }

    class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("Easypaisa"))
            {
                dispose();
                new Easypaisa(getCurrAccount());
            }
            else if (e.getActionCommand().equals("Bank Transfer"))
            {
                dispose();
                new BankTransfer(getCurrAccount());
            }
            else if (e.getActionCommand().equals("Bill Payment"))
            {
                dispose(); new BillPayment(getCurrAccount());
            }
            else if (e.getActionCommand().equals("Sign Out"))
            {
                dispose(); new Main();
            }
            else if (e.getActionCommand().equals("My Account"))
            {
                dispose(); new MyAccount(getCurrAccount());
            }
        }
    }
}
