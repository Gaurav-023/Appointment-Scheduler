package Appointment_Schdeuler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener
{
    JButton add, view, update, remove;
    Dashboard()
    {
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dashboard2.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_SMOOTH);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);

        add = new JButton("Book Appointment");
        add.setBounds(70,450,220,50);
        add.setBackground(new Color(128, 255, 219, 255));
        add.setForeground(Color.BLACK);
        add.setFont(new Font("Calisto MT", Font.PLAIN, 16));
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Appointment");
        view.setBounds(320,450,220,50);
        view.setBackground(new Color(128, 255, 219, 255));
        view.setForeground(Color.BLACK);
        view.setFont(new Font("Calisto MT", Font.PLAIN, 16));
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Update Appointment");
        update.setBounds(70,520,220,50);
        update.setBackground(new Color(128, 255, 219, 255));
        update.setForeground(Color.BLACK);
        update.setFont(new Font("Calisto MT", Font.PLAIN, 16));
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("Cancel Appointment");
        remove.setBounds(320,520,220,50);
        remove.setBackground(new Color(128, 255, 219, 255));
        remove.setForeground(Color.BLACK);
        remove.setFont(new Font("Calisto MT", Font.PLAIN, 16));
        remove.addActionListener(this);
        image.add(remove);


        setResizable(false);
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource() ==add)
       {
            setVisible(false);
            new BookAppointment();
       }
       else if (ae.getSource() ==view)
       {
           setVisible(false);
           new ViewAppointment();

       }
       else if(ae.getSource() == update)
       {
            setVisible(false);
            new ViewAppointment();
       }
       else
       {
            setVisible(false);
            new RemoveAppointment();
       }
    }
    public static void main(String[] args) {
        new Dashboard();
    }
}