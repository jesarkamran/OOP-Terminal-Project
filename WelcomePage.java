import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame
{
    JLabel displayImage;

    WelcomePage()
    {
        setSize(1400,750);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); setTitle("Easypaisa");

        try {
            ImageIcon img = new ImageIcon(new ImageIcon("LogoEasypaisa.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING));
            displayImage =  new JLabel(img);
        }catch (Exception e)
        {
            System.out.println("Problem Loading Image");
        }
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
        center.setBackground(new Color(0,255,127));
        south.setBackground(new Color(0,255,127));
        east.setBackground(new Color(0,255,127));
        west.setBackground(new Color(0,255,127));

        center.setLayout(null);
        displayImage.setBounds(450,250, 200, 200);
        JLabel welcome = new JLabel("WELCOME TO EASYPAISA");
        welcome.setForeground(Color.BLACK);
        welcome.setFont(new Font("Calibri", Font.BOLD, 16));
        welcome.setBounds(650,350, 400, 100);
        center.add(welcome);
        center.add(displayImage);
        setVisible(true);
    }
}
