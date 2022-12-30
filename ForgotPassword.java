import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ForgotPassword extends JFrame
{
    JLabel nameLabel, accNo, backgroundPic; JTextField name, accText;
    ForgotPassword()
    {
        JButton bBack = new JButton("Login Page");
        JButton bGet = new JButton("Get Password");

        bGet.setBackground(new Color(34,139,34));
        bBack.setBackground(new Color(34,139,34));


        bGet.setForeground(new Color(255,255,255));
        bBack.setForeground(new Color(255,255,255));

        MyActionListener action = new MyActionListener();
        bBack.addActionListener(action);
        bGet.addActionListener(action); setTitle("Easypaisa");

        setSize(1500,800); setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel center = new JPanel();
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();

        add(center, BorderLayout.CENTER);
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);
        add(west, BorderLayout.WEST);


        north.setBackground(new Color(0,255,127));
        south.setBackground(new Color(0,255,127));
        center.setBackground(Color.WHITE);
        west.setBackground(new Color(0,255,127));
        east.setBackground(new Color(0,255,127));

        JLabel labelHeading = new JLabel("easypaisa");
        labelHeading.setForeground(new Color(0,0,0));
        labelHeading.setFont(new Font("Calibri", Font.BOLD, 50));
        north.add(labelHeading, BorderLayout.NORTH);

        center.setLayout(null);

        nameLabel = new JLabel("USERNAME");
        name = new JTextField();

        accNo = new JLabel("Account Number");
        accText = new JTextField();

        //Setting the Font Size of Labels and textFields, buttons
        nameLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        accNo.setFont(new Font("Calibri", Font.BOLD, 20));

        name.setFont(new Font("Calibri", Font.BOLD, 15));
        accText.setFont(new Font("Calibri", Font.BOLD, 15));

        bBack.setFont(new Font("Calibri", Font.BOLD, 15));
        bGet.setFont(new Font("Calibri", Font.BOLD, 15));

        //Setting location and Size
        nameLabel.setBounds(800,400, 250, 50);
        name.setBounds(1050,400, 250, 50);
        bGet.setBounds(1050,500, 250, 50);
        bBack.setBounds(770,500, 250, 50);
        accNo.setBounds(800,300, 250, 50);
        accText.setBounds(1050,300, 250, 50);

        //Adding Image
        try {
            ImageIcon img = new ImageIcon(new ImageIcon("Chill.png").getImage().getScaledInstance(800, 650, Image.SCALE_AREA_AVERAGING));
            backgroundPic =  new JLabel(img);
        }catch (Exception e)
        {
            System.out.println("Problem Loading Image");
        }
        backgroundPic.setBounds(0,-50, 750, 720);

        //Adding all 
        center.add(backgroundPic);
        center.add(nameLabel); center.add(name);
        center.add(accNo); center.add(accText);
        center.add(bBack); center.add(bGet);
        setVisible(true);
    }
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Get Password"))
            {
                String accNumber = accText.getText();
                if (accNumber != null)
                {
                    boolean val = false;
                    long accountNumber = Long.parseLong(accNumber);
                    Accounts a = new Accounts();
                    ArrayList<Accounts> list = a.readInFile();
                    for(Accounts accounts: list)
                    {
                        if (accounts.getName().equals(name.getText()) && accounts.getPhoneNo() == accountNumber)
                        {
                                JOptionPane.showMessageDialog(new JFrame(), "Hey! "+accounts.getName()+"\n"+
                                        "Your Easypaisa Acc Password: "+accounts.getPassword()); val = true;
                                break;
                        }
                    }
                    if (!val)
                    {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid Data Given try Again");
                        new ForgotPassword();
                        dispose();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Can't leave a TextField Empty");
                }
            }
            else
            {
                dispose();
            }
        }
    }
}
