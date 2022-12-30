import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
public class SignUp extends JFrame
{
    JLabel label1 = new JLabel("Name");
    JLabel label2 = new JLabel("Location City");
    JLabel label3 = new JLabel("Address");
    JLabel label4 = new JLabel("Age");
    JLabel label5 = new JLabel("Phone No");
    JLabel label6 = new JLabel("CNIC No");
    JLabel label7 = new JLabel("Password");
    JLabel label8 = new JLabel("Confirm Password");

    JTextField text1 = new JTextField();
    JTextField text2 = new JTextField();
    JTextField text3 = new JTextField();
    JTextField text4 = new JTextField();
    JTextField text5 = new JTextField(10);
    JTextField text6 = new JTextField(13);
    JPasswordField text7 = new JPasswordField(4);
    JPasswordField text8 = new JPasswordField(4);

    SignUp()
    {
        setSize(1500, 800); setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); setTitle("Easypaisa");

        JButton bRegisterAccount = new JButton("REGISTER");
        JButton bBack = new JButton("LOGIN");

        //Setting Font Size of Button, Labels and TextFiels
        bRegisterAccount.setFont(new Font("Calibri", Font.BOLD, 20));
        bBack.setFont(new Font("Calibri", Font.BOLD, 20));
        
        text1.setFont(new Font("Calibri", Font.BOLD, 15));
        text2.setFont(new Font("Calibri", Font.BOLD, 15));
        text3.setFont(new Font("Calibri", Font.BOLD, 15));
        text4.setFont(new Font("Calibri", Font.BOLD, 15));
        text5.setFont(new Font("Calibri", Font.BOLD, 15));
        text6.setFont(new Font("Calibri", Font.BOLD, 15));
        text7.setFont(new Font("Calibri", Font.BOLD, 15));
        text8.setFont(new Font("Calibri", Font.BOLD, 15));

        label1.setFont(new Font("Calibri", Font.BOLD, 20));
        label2.setFont(new Font("Calibri", Font.BOLD, 20));
        label3.setFont(new Font("Calibri", Font.BOLD, 20));
        label4.setFont(new Font("Calibri", Font.BOLD, 20));
        label5.setFont(new Font("Calibri", Font.BOLD, 20));
        label6.setFont(new Font("Calibri", Font.BOLD, 20));
        label7.setFont(new Font("Calibri", Font.BOLD, 20));
        label8.setFont(new Font("Calibri", Font.BOLD, 20));

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

        //Hiding the password
        text7.setEchoChar('•');
        text8.setEchoChar('•');
        

        //Setting layout of center to NULL use bounds
        center.setLayout(null);


        //Setting postion and size of Button, textFields and Labels
        label1.setBounds(100, 50, 150, 40); text1.setBounds(300, 50, 300, 50);
        label2.setBounds(100, 150, 150, 40); text2.setBounds(300, 150, 300, 50);
        label3.setBounds(100, 250, 150, 40); text3.setBounds(300, 250, 300, 50);
        label4.setBounds(100, 350, 150, 40); text4.setBounds(300, 350, 300, 50);
        label5.setBounds(650, 50, 150, 40); text5.setBounds(900, 50, 300, 50);
        label6.setBounds(650, 150, 150, 40); text6.setBounds(900, 150, 300, 50);
        label7.setBounds(650, 250, 150, 40); text7.setBounds(900, 250, 300, 50);
        label8.setBounds(650, 350, 300, 40); text8.setBounds(900, 350, 300, 50);
        bBack.setBounds(300, 500, 350, 50); bRegisterAccount.setBounds(800, 500, 350, 50);

        //Setting BackGround and ForeGround color of Button
        bBack.setBackground(new Color(34,139,34));
        bRegisterAccount.setBackground(new Color(34,139,34));

        bBack.setForeground(new Color(255,255,255));
        bRegisterAccount.setForeground(new Color(255,255,255));

        //Adding Action Listener
        MyActionListener action = new MyActionListener();
        bBack.addActionListener(action); bRegisterAccount.addActionListener(action);

        //Adding Buttons, textFields and Labels on Center Panel
        center.add(label1); center.add(text1);
        center.add(label2); center.add(text2);
        center.add(label3); center.add(text3);
        center.add(label4); center.add(text4);
        center.add(label5); center.add(text5);
        center.add(label6); center.add(text6);
        center.add(label7); center.add(text7);
        center.add(label8); center.add(text8);
        center.add(bBack); center.add(bRegisterAccount);
        
        //Setting Color of All BorderLayouts
        north.setBackground(new Color(0,255,127));
        south.setBackground(new Color(0,255,127));
        center.setBackground(Color.WHITE);
        west.setBackground(new Color(0,255,127));
        east.setBackground(new Color(0,255,127));

        //Giving Heading of Easypaisa
        JLabel labelHeading = new JLabel("easypaisa");
        labelHeading.setForeground(new Color(0,0,0));
        labelHeading.setFont(new Font("Calibri", Font.BOLD, 50));
        north.add(labelHeading, BorderLayout.NORTH);
        
        //Setting visibility of JFrame
        setVisible(true);
    }

    class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("REGISTER"))
            {
                String name = text1.getText();
                String location = text2.getText();
                String address = text3.getText();

                String age = text4.getText();
                int intAge = Integer.parseInt(age);
                intAge = intAge >= 18? intAge:0;
                
                String phone = text5.getText();
                phone = phone.length() == 10? phone:"0";
                long phoneNo = Long.parseLong(phone);

                String cnic = text6.getText();
                cnic = cnic.length() == 13? cnic:"0";
                long cNIC = Long.parseLong(cnic);

                char[] passwd = text7.getPassword();
                String password = String.valueOf(passwd);
                password = password.length() == 4? password:"0";
                int pass = Integer.parseInt(password);

                char[] passwdConfirm = text8.getPassword();
                String passwordConfirm = String.valueOf(passwdConfirm);
                passwordConfirm = passwordConfirm.length() == 4? passwordConfirm:"0";
                int passConfirm = Integer.parseInt(passwordConfirm);
                passConfirm = pass  == passConfirm? passConfirm:0;
                if (name != null && location != null && address != null && age != null && phone != null 
                    && cnic != null && password != null && passwordConfirm != null)
                {
                    if (passwordConfirm.length() == 4)
                    {
                        if (passConfirm != 0 ) 
                        {
                            if (name != null&&location!=null&&address!=null&&phoneNo != 0 && cNIC != 0 && intAge != 0) 
                            {
                                Accounts newAcc = new Accounts(name, location,address,intAge,phoneNo,cNIC,passConfirm,500);
                                Serialization<Accounts> ser = new Serialization<Accounts>(new File("EasyAccounts.ser"));
                                ser.dataWriting(newAcc, true);
                                JOptionPane.showMessageDialog(new JFrame(),newAcc.toString()+"\n"+"Account Registered\n Go To Login Page");
                                text1.setText(""); text2.setText("");
                                text3.setText(""); text4.setText("");
                                text5.setText(""); text6.setText("");
                                text7.setText(""); text8.setText("");
                            }
                            else
                            {
                                text4.setText(""); text5.setText("");
                                text6.setText(""); 
                                JOptionPane.showMessageDialog(new JFrame(),"InValid Data Given try ReEntering the Data");
                            }
                        }
                        else
                        {
                            text7.setText(""); text8.setText("");
                            JOptionPane.showMessageDialog(new JFrame(),"Password didn't match Confirm password");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(),"Password Length must be 4");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Can't leave a TextField Empty");
                }
            }
            else if (e.getActionCommand().equals("LOGIN"))
            {
                dispose();
            }
        }
    }
}
