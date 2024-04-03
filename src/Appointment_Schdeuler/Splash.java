package Appointment_Schdeuler;

import javax.swing.*;

public class Splash extends JFrame {
    Splash()
    {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icon/splash.gif"));
            JLabel label = new JLabel(imageIcon);
            label.setBounds(-5,-12,858,680);
            add(label);

        setLayout(null);
        setResizable(false);
        setLocation(300,100);
        setSize(858,680);
        setVisible(true);


        try
            {
                Thread.sleep(6000);
                setVisible(false);
                new Login();
            }
            catch(Exception a)
            {
                a.printStackTrace();
            }

    }
    public static void main(String[] args) {
        new Splash();

    }
}
