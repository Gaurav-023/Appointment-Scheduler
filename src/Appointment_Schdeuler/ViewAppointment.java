package Appointment_Schdeuler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ViewAppointment extends JFrame implements ActionListener
{
    JTable table;
    JButton  search, print, update, back;
    Choice Appointmentid;
    ViewAppointment()
    {
        JLabel heading = new JLabel("Your Appointments");
        heading.setBounds(320, 5, 500, 40);
        heading.setFont(new Font("Roboto", Font.BOLD, 25));
        add(heading);

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel searchlbl = new JLabel("Search Your Appointment");
        searchlbl.setBounds(20,45,150,20);
        add(searchlbl);

        Appointmentid = new Choice();
        Appointmentid.setBounds(180,45,150,20);
        add(Appointmentid);

        table = new JTable();

        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from BookAppointment");

            while(rs.next())
            {
                Appointmentid.add(rs.getString("id"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from BookAppointment");
        table.setModel(DbUtils.resultSetToTableModel(rs));

        while(rs.next())
        {
            Appointmentid.add(rs.getString("id"));
        }
        }
        catch (Exception e)

        {
        e.printStackTrace();
        }

        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from BookAppointment");
            table.setModel(DbUtils.resultSetToTableModel(rs));

            while(rs.next())
            {
                Appointmentid.add(rs.getString("id"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        search = new JButton("Search");
        search.setBounds(20,80,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,80,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,80,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,80,80,20);
        back.addActionListener(this);
        add(back);

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,120,900,700);
        add(jsp);

        setResizable(false);
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== search)
        {
            String query = "select * from BookAppointment where id = '"+Appointmentid.getSelectedItem()+"'";
            try
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else if (ae.getSource()==print)
        {
            try
            {
                table.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
        else if (ae.getSource()==update)
        {
            setVisible(false);
            new UpdateAppointment(Appointmentid.getSelectedItem());
        }
        else
        {
            setVisible(false);
            new Dashboard();
        }
    }
    public static void main(String[] args)
    {
        new ViewAppointment();
    }
}


