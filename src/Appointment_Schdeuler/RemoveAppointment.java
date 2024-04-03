package Appointment_Schdeuler;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class RemoveAppointment extends JFrame implements ActionListener
{
    Choice capid;
    JButton delete, back;
    RemoveAppointment()
    {
        JLabel heading = new JLabel("Cancel Your Appointment");
        heading.setBounds(20, 5, 500, 50);
        heading.setForeground(new Color(102,51,153));
        heading.setFont(new Font("Roboto", Font.BOLD, 30));
        add(heading);

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel labelapid = new JLabel("Appointment Id");
        labelapid.setBounds(50,65,100,30);
        add(labelapid);

        capid = new Choice();
        capid.setBounds(200,65,150,30);
        add(capid);

        JLabel labelname= new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200,100,100,30);
        add(lblname);

        JLabel labelphone= new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        add(labelphone);

        JLabel lblphone = new JLabel();
        lblphone.setBounds(200,150,100,30);
        add(lblphone);

        JLabel labeladdress= new JLabel("Address");
        labeladdress.setBounds(50,200,100,30);
        add(labeladdress);

        JLabel lbladdress = new JLabel();
        lbladdress.setBounds(200,200,150,30);
        add(lbladdress);

        try
        {
            Conn c = new Conn();
            String query = " select * from BookAppointment";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                capid.add(rs.getString("id"));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        capid.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie)
            {
                try
                {
                    Conn c = new Conn();
                    String query = " select * from BookAppointment where id = '"+capid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next())
                    {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lbladdress.setText(rs.getString("address"));

                    }

                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(60,300,100,30);
        delete.setBackground(new Color(102,51,153));
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(200,300,100,30);
        back.setBackground(new Color(102,51,153));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 25, 500, 300);
        add(image);

        setResizable(false);
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==delete)
        {
            try
            {
                Conn c = new Conn();
                String query = " delete from BookAppointment where id = '"+capid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Appointment Cancelled Successfully");
                setVisible(false);
                new Dashboard();
            }
            catch (Exception e)
            {
                 e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new Dashboard();
        }

    }
    public static void main(String[] args)
    {
        new RemoveAppointment();
    }
}

