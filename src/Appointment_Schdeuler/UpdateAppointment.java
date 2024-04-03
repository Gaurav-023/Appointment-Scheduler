package Appointment_Schdeuler;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.*;

import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.util.concurrent.LinkedBlockingDeque;

public class UpdateAppointment extends JFrame implements ActionListener
{

    JTextField tfname , tffname , tfphone, tfaddress , tfcity, tfstate;
    JDateChooser dcdate, dcdob;
    JComboBox hourComboBox;
    JLabel apid ;
    JButton addButton,back;
    String Appointmentid;
    UpdateAppointment(String Appointmentid)
    {
        this.Appointmentid = Appointmentid;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Appointment Details");
        heading.setBounds(65, 25, 500, 55);
        heading.setForeground(Color.red);
        heading.setFont(new Font("Tahoma", Font.BOLD, 45));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);

        JLabel labelfname = new JLabel("Father Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(550, 150, 150, 30);
        add(tffname);

        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 200, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(550, 200, 150, 30);
        add(tfphone);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel labeltime = new JLabel("Select Time: ");
        labeltime.setBounds(400, 250, 150, 30);
        labeltime.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeltime);

        String[] hours = new String[11];
        for (int i = 0; i < 11; i++) {
            int hour = (i + 8) % 12;
            if (hour == 0) {
                hour = 12;
            }
            String amPm = (i + 8) < 12 ? "AM" : "PM";
            hours[i] = String.format("%02d", hour) + ".00 " + amPm;
        }

        JLabel hourComboBox = new JLabel();
        hourComboBox.setBounds(550, 250, 150, 30);
        add(hourComboBox);

        JLabel labelcity = new JLabel("City");
        labelcity.setBounds(50, 300, 150, 30);
        labelcity.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelcity);

        tfcity = new JTextField();
        tfcity.setBounds(200, 300, 150, 30);
        add(tfcity);

        JLabel labelstate = new JLabel("State");
        labelstate.setBounds(400, 300, 150, 30);
        labelstate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelstate);

        tfstate = new JTextField();
        tfstate.setBounds(550, 300, 150, 30);
        tfstate.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfstate);

        JLabel labelapid = new JLabel("Appointment No");
        labelapid.setBounds(400, 350, 150, 30);
        labelapid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelapid);

        apid = new JLabel();
        apid.setBounds(550, 350, 150, 30);
        apid.setFont(new Font("serif", Font.PLAIN, 18));
        add(apid);

        JLabel labeldate = new JLabel("Date");
        labeldate.setBounds(50, 350, 150, 30);
        labeldate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldate);

        JLabel lbdate = new JLabel();
        lbdate.setBounds(200, 350 ,150, 30);
        lbdate.setFont(new Font("serif", Font.PLAIN, 18));
        add(lbdate);

        try
        {
            Conn c = new Conn();
            String query = " select * from BookAppointment where id ='"+Appointmentid+"'";
            ResultSet  rs = c.s.executeQuery(query);
            while (rs.next())
            {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfphone.setText(rs.getString("phone"));
                tfaddress.setText(rs.getString("address"));
                hourComboBox.setText(rs.getString("time"));
                tfcity.setText(rs.getString("city"));
                tfstate.setText(rs.getString("state"));
                lbdate.setText(rs.getString("date"));
                apid.setText(rs.getString("id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        addButton = new JButton("Update Appointment");
        addButton.setBounds(310, 420, 180, 35);
        addButton.setBackground(new Color(255, 255, 255, 255));
        addButton.setForeground(Color.BLACK);
        addButton.setFont(new Font("Calisto MT", Font.PLAIN, 16));
        addButton.addActionListener(this);
        add(addButton);

        back = new JButton("Back");
        back.setBounds(700, 10, 180, 35);
        back.setBackground(new Color(0, 0, 0, 255));
        back.setForeground(Color.white);
        back.setFont(new Font("Calisto MT", Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 400, 900, 250);
        add(image);

        setResizable(false);
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==addButton)
        {
            String fname = tffname.getText();
            String phone = tfphone.getText();
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String id = apid.getText();

            try
            {
                Conn conn =new Conn();
                String query = "update BookAppointment set fname= '"+fname+"', phone ='"+phone+"', address = '"+address+"', city = '"+city+"', state = '"+state+"' where id = '"+id+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
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
        new UpdateAppointment("");
    }
}
