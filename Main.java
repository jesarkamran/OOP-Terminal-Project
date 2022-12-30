import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Main extends JFrame
{
    JButton bSignIn, bSignUp, bForgotPass;
    JLabel userNameLabel,passwordLabel, sidePic;

    JTextField userName;
    JPasswordField password;
    Main()
    {
        setSize(1500, 800); setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("EasyPaisa");

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

        pNorth.setSize(200, 300);

        //Setting Background Colors of Panel
        pNorth.setBackground(new Color(0,255,127));
        pSouth.setBackground(new Color(0,255,127));
        pCenter.setBackground(Color.WHITE);
        pWest.setBackground(new Color(0,255,127));
        pEast.setBackground(new Color(0,255,127));

        JLabel labelHeading = new JLabel("easypaisa");
        labelHeading.setForeground(new Color(0,0,0));
        labelHeading.setFont(new Font("Calibri", Font.BOLD, 50));
        pNorth.add(labelHeading, BorderLayout.NORTH);

        bSignIn = new JButton("SignIn");
        bSignUp = new JButton("SignUp");
        bForgotPass = new JButton("Forgot Password");

        userNameLabel = new JLabel("USERNAME");
        passwordLabel = new JLabel("PASSWORD");

        userName = new JTextField();
        password = new JPasswordField(4);

        //Setting Location and Position
        bSignIn.setBounds(600,400, 290, 50);
        bSignUp.setBounds(950,400, 290, 50);
        
        
        userNameLabel.setBounds(600,200, 200, 50);
        passwordLabel.setBounds(600,300, 200, 50);
        
        userName.setBounds(950,200, 290, 50);
        password.setBounds(950,300, 290, 50);

        bForgotPass.setBounds(950,500, 290, 50);
        
        //Background Color changing
        bSignIn.setBackground(new Color(34,139,34));
        bSignUp.setBackground(new Color(34,139,34));
        bForgotPass.setBackground(new Color(34,139,34));


        //Setting the ForeGround and Background Color
        userName.setForeground(Color.BLACK);
        password.setForeground(Color.BLACK);

        bSignIn.setForeground(Color.WHITE);
        bSignUp.setForeground(Color.WHITE);
        bForgotPass.setForeground(Color.WHITE);

        userNameLabel.setBackground(new Color(0x008808));
        userNameLabel.setForeground(Color.BLACK);

        passwordLabel.setBackground(new Color(0x008808));
        passwordLabel.setForeground(Color.BLACK);


        //Setting size of Fonts Label,TextFields, Buttons 
        userNameLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        passwordLabel.setFont(new Font("Calibri", Font.BOLD, 20));

        userName.setFont(new Font("Calibri", Font.BOLD, 15));
        password.setFont(new Font("Calibri", Font.BOLD, 15));

        bSignIn.setFont(new Font("Calibri", Font.BOLD, 15));
        bSignUp.setFont(new Font("Calibri", Font.BOLD, 15));
        bForgotPass.setFont(new Font("Calibri", Font.BOLD, 15));

        //Hiding the password
        password.setEchoChar('•');

        //creatinng Object of MY Object Class
        MyActionListener action = new MyActionListener();

        //adding actionlistener
        bSignIn.addActionListener(action);
        bSignUp.addActionListener(action);
        bForgotPass.addActionListener(action);
        

        //Creating and Adding Exit Button
        JButton bExit = new JButton("Exit");
        bExit.addActionListener(action);
        bExit.setFont(new Font("Calibri", Font.BOLD, 15));
        bExit.setBackground(new Color(34,139,34));
        bExit.setForeground(new Color(255,255,255));
        bExit.setBounds(600,500, 290, 50);


        //adding All
        pCenter.setLayout(null);
        pCenter.add(userNameLabel); pCenter.add(userName);
        pCenter.add(passwordLabel); pCenter.add(password);
        pCenter.add(bSignIn); pCenter.add(bSignUp);
        pCenter.add(bExit); pCenter.add(bForgotPass);

        try {
            ImageIcon img = new ImageIcon(new ImageIcon("SidePic.png").getImage().getScaledInstance(600, 1000, Image.SCALE_AREA_AVERAGING));
            sidePic =  new JLabel(img);
        }catch (Exception e)
        {
            System.out.println("Problem Loading Image");
        }

        //Setting Location AND Size of Side PICTURE
        sidePic.setBounds(0,0, 550, 1000);
        pCenter.add(sidePic);
        setVisible(true);
    }
    
    class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("SignIn"))
            {
                String user = userName.getText();
                char[] pass = password.getPassword();
                String passWord = String.valueOf(pass);
                if (user != null && passWord != null)
                { 
                    userName.setText(""); password.setText("");
                    
                    int keyPassword = Integer.parseInt(passWord);
                    boolean val = false;
                    Accounts acc = new Accounts();
                    ArrayList<Accounts> list = acc.readInFile();
                    for(Accounts accounts: list)
                    {
                        if (accounts.getName().equals(user))
                        {
                            val = true; acc = accounts; break;
                        }
                    }
                    if (val)
                    {
                        if (acc.getPassword() == keyPassword)
                        {
                            password.setText("");
                            dispose(); new SignedIn(acc); 
                        }
                        else
                        {
                            password.setText("");
                            JOptionPane.showMessageDialog(new JFrame(), "Incorrect Password\nIf you have Forgotten the Password try Clicking Forgot Password");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(new JFrame(),"Oops! No Account found \n " +
                                "SignUp and be the part of No:01 Online payment Platform Easypaisa");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Can't leave a TextField Empty");
                }
            }
            else if (e.getActionCommand().equals("SignUp"))
            {
                userName.setText(""); password.setText("");
                new SignUp();
            }
            else if (e.getActionCommand().equals("Forgot Password"))
            {
                userName.setText(""); password.setText("");
                new ForgotPassword();
            }
            else
            {
                dispose();
            }
        }
    }
}
