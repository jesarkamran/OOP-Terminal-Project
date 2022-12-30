import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
public class MyAccount extends JFrame
{
    private Accounts currAccount;

    public void setCurrAccount(Accounts currAccount) 
    {
        this.currAccount = currAccount;
    }
    public Accounts getCurrAccount() 
    {
        return currAccount;
    }

    JButton back = new JButton("Back");
    JButton deleteAcc = new JButton("Delete Account");
    JButton deleteSure = new JButton("Sure");
    JButton changePass = new JButton("Change Password");
    JButton enter = new JButton("Enter");

    JLabel label1 = new JLabel("Name");
    JLabel label2 = new JLabel("Age");
    JLabel label3 = new JLabel("Address");
    JLabel label4 = new JLabel("Location City");
    JLabel label5 = new JLabel("Account No");
    JLabel label6 = new JLabel("CNIC NO");
    JLabel label7 = new JLabel("Amount In Account");
    JLabel label15 = new JLabel("Password");
    JLabel label16 = new JLabel("Confirm Password");

    JPasswordField pass = new JPasswordField();
    JPasswordField confirm = new JPasswordField();

    MyAccount(Accounts acc)
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

        //JLabel for Showing USer Details
        JLabel label8 = new JLabel(acc.getName());
        JLabel label9 = new JLabel(""+acc.getAge());
        JLabel label10 = new JLabel(acc.getAddress());
        JLabel label11 = new JLabel(acc.getLocationCity());
        JLabel label12 = new JLabel(acc.getPhoneNo()+"");
        JLabel label13 = new JLabel(acc.getCnic()+"");
        JLabel label14 = new JLabel(acc.getAmountInAccount()+"");

        //Setting color of Output
        label8.setForeground(new Color(34,139,34));
        label9.setForeground(new Color(34,139,34));
        label10.setForeground(new Color(34,139,34));
        label11.setForeground(new Color(34,139,34));
        label12.setForeground(new Color(34,139,34));
        label13.setForeground(new Color(34,139,34));
        label14.setForeground(new Color(34,139,34));

        //Setting their Positon on Jframe
        add(center, BorderLayout.CENTER);
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);
        add(west, BorderLayout.WEST);
        
        //Setting center Layout to NULL
        center.setLayout(null);

        //Setting Background Colors of Panel
        north.setBackground(new Color(0,255,127));
        south.setBackground(new Color(0,255,127));
        center.setBackground(Color.WHITE);
        west.setBackground(new Color(0,255,127));
        east.setBackground(new Color(0,255,127));


        //Adding Heading to the Jframe
        JLabel labelHeading = new JLabel("easypaisa");
        labelHeading.setForeground(new Color(0,0,0));
        labelHeading.setFont(new Font("Calibri", Font.BOLD,50));
        north.add(labelHeading, BorderLayout.NORTH);

        //Setting Font Size of Buttons
        back.setFont(new Font("Calibri", Font.BOLD, 20));
        deleteAcc.setFont(new Font("Calibri", Font.BOLD, 20));
        changePass.setFont(new Font("Calibri", Font.BOLD, 20));
        enter.setFont(new Font("Calibri", Font.BOLD, 20));
        deleteSure.setFont(new Font("Calibri", Font.BOLD, 20));

        //Setting the color of Buttons
        back.setForeground(Color.WHITE);
        deleteAcc.setForeground(Color.WHITE);
        changePass.setForeground(Color.WHITE);
        enter.setForeground(Color.WHITE);
        deleteSure.setForeground(Color.WHITE);

        //Backgound Color Of Buttons
        back.setBackground(new Color(34,139,34));
        deleteAcc.setBackground(new Color(34,139,34));
        changePass.setBackground(new Color(34,139,34));
        enter.setBackground(new Color(34,139,34));
        deleteSure.setBackground(new Color(34,139,34));

        //Setting the position of Buttons
        changePass.setBounds(300,500,300,50);
        deleteAcc.setBounds(800,500,300,50);
        enter.setBounds(1080,370,250,50);
        back.setBounds(540,570,300,50);
        deleteSure.setBounds(1000,570,250,50);

        //setting Font Size of Labels
        label1.setFont(new Font("Calibri", Font.BOLD, 20));
        label2.setFont(new Font("Calibri", Font.BOLD, 20));
        label3.setFont(new Font("Calibri", Font.BOLD, 20));
        label4.setFont(new Font("Calibri", Font.BOLD, 20));
        label5.setFont(new Font("Calibri", Font.BOLD, 20));
        label6.setFont(new Font("Calibri", Font.BOLD, 20));
        label7.setFont(new Font("Calibri", Font.BOLD, 20));
        label8.setFont(new Font("Calibri", Font.BOLD, 20));
        label9.setFont(new Font("Calibri", Font.BOLD, 20));
        label10.setFont(new Font("Calibri", Font.BOLD, 20));
        label11.setFont(new Font("Calibri", Font.BOLD, 20));
        label12.setFont(new Font("Calibri", Font.BOLD, 20));
        label13.setFont(new Font("Calibri", Font.BOLD, 20));
        label14.setFont(new Font("Calibri", Font.BOLD, 20));
        label15.setFont(new Font("Calibri", Font.BOLD, 20));
        label16.setFont(new Font("Calibri", Font.BOLD, 20));
        
        //Setting JText font size
        pass.setFont(new Font("Calibri", Font.BOLD, 20));
        confirm.setFont(new Font("Calibri", Font.BOLD, 20));

        //Hiding Password
        pass.setEchoChar('•');
        confirm.setEchoChar('•');


        //Setting Postion of Labels
        label1.setBounds(0,0,250,50);
        label2.setBounds(0,100,250,50);
        label3.setBounds(0,200,250,50);
        label4.setBounds(0,300,250,50);
        label5.setBounds(700,0,250,50);
        label6.setBounds(700,100,250,50);
        label7.setBounds(700,200,250,50);
        label8.setBounds(400,0,250,50);
        label9.setBounds(400,100,250,50);
        label10.setBounds(400,200,250,50);
        label11.setBounds(400,300,250,50);
        label12.setBounds(1000,0,250,50);
        label13.setBounds(1000,100,250,50);
        label14.setBounds(1000,200,250,50);
        label15.setBounds(0,370,250,50); label15.setVisible(false);
        label16.setBounds(500,370,250,50);label16.setVisible(false);

        //Setting Position TextFields
        pass.setBounds(200,370,250,50);
        confirm.setBounds(800,370,250,50);


        center.add(back);
        center.add(deleteAcc);
        center.add(changePass);
        center.add(deleteSure); deleteSure.setVisible(false);
        center.add(enter); enter.setVisible(false);

        // Adding Jfields
        pass.setVisible(false); confirm.setVisible(false);
        center.add(pass); center.add(confirm); 
        
        //Creating Action listener
        MyActionListener action = new MyActionListener();
        enter.addActionListener(action);
        deleteAcc.addActionListener(action);
        deleteSure.addActionListener(action);
        changePass.addActionListener(action);
        back.addActionListener(action);

        //Adding the Labels
        center.add(label1); center.add(label2);
        center.add(label3); center.add(label4);
        center.add(label5); center.add(label6);
        center.add(label7); center.add(label8);
        center.add(label9); center.add(label10);
        center.add(label11); center.add(label12);
        center.add(label13); center.add(label14);
        center.add(label15); center.add(label16);

        setVisible(true);
    }

    class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("Delete Account")) 
            {
                JOptionPane.showMessageDialog(new JFrame(),"Are your Sure You Want Delete your Accout\n\nThen Click: SURE");
                deleteSure.setVisible(true);
            }
            else if (e.getActionCommand().equals("Sure")) 
            {
                Accounts account = new Accounts();
                ArrayList<Accounts> list = account.readInFile();

                for (int i = 0; i < list.size(); i++) 
                {
                    if (getCurrAccount().getPhoneNo() == list.get(i).getPhoneNo()) 
                    {
                        list.remove(i);
                    }
                }
                Serialization<Accounts> ser = new Serialization<>(new File("EasyAccounts.ser"));
                ser.deleteFile();

                for (Accounts accounts : list) 
                {
                    ser.dataWriting(accounts, true);
                }
                JOptionPane.showMessageDialog(new JFrame(), "Account Deleted Successfully");
                dispose(); new Main();
            }
            else if (e.getActionCommand().equals("Change Password")) 
            {
                label15.setVisible(true); label16.setVisible(true);
                pass.setVisible(true); confirm.setVisible(true);
                enter.setVisible(true);
            }
            else if (e.getActionCommand().equals("Enter")) 
            {

                char[] passwd = pass.getPassword();
                String password = String.valueOf(passwd);
                
                char[] passwdConfirm = confirm.getPassword();
                String passwordConfirm = String.valueOf(passwdConfirm);
                if (password != null && passwdConfirm != null) 
                {
                    passwordConfirm = passwordConfirm.length() == 4? passwordConfirm:"0";
                    password = password.length() == 4? password:"0";
                    int passInt = Integer.parseInt(password);

                    int passConfirm = Integer.parseInt(passwordConfirm);
                    passConfirm = passInt  == passConfirm? passConfirm:0;
                    
                    if (passConfirm != 0) 
                    {
                        Accounts account = new Accounts();
                        ArrayList<Accounts> list = account.readInFile();

                        for (Accounts accounts : list) 
                        {
                            if (getCurrAccount().getPhoneNo() == accounts.getPhoneNo()) 
                            {
                                accounts.setPassword(passConfirm);
                            }
                        }
                        Serialization<Accounts> ser = new Serialization<>(new File("EasyAccounts.ser"));
                        ser.deleteFile();

                        for (Accounts accounts : list) 
                        {
                            ser.dataWriting(accounts, true);
                        }
                        JOptionPane.showMessageDialog(new JFrame(), "Password Changed Successfully");
                    }
                    else
                    {
                        pass.setText(""); confirm.setText("");
                        JOptionPane.showMessageDialog(new JFrame(),"Password didn't match Confirm password");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Can't leave a TextField Empty");
                }

                label15.setVisible(false); label16.setVisible(false);
                pass.setVisible(false); confirm.setVisible(false);
                enter.setVisible(false);
            }
            else if (e.getActionCommand().equals("Back")) 
            {
                dispose(); new SignedIn(getCurrAccount());
            }
        }
    }
}