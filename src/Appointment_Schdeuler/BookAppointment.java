package Appointment_Schdeuler;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.*;

import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;

public class BookAppointment extends JFrame implements ActionListener
{
    Random ran = new Random();
    int number = ran.nextInt(9999);

    JTextField tfname , tffname , tfphone, tfaddress , tfcity, tfstate;
    JDateChooser dcdob , dcdate;
    JComboBox hourComboBox;
    JLabel apid;
    JButton addButton,back;
    BookAppointment() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Add Appointment Details");
        heading.setBounds(45, 25, 550, 55);
        heading.setForeground(Color.ORANGE);
        heading.setFont(new Font("Roboto", Font.BOLD, 42));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

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

        dcdob = new JDateChooser();
        dcdob.setDateFormatString("dd-MMM-yyyy");
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);

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

        hourComboBox = new JComboBox<>(hours);
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
        add(tfstate);

        JLabel labelapid = new JLabel("Appointment No");
        labelapid.setBounds(400, 350, 150, 30);
        labelapid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelapid);

        apid = new JLabel("" + number);
        apid.setBounds(550, 350, 150, 30);
        apid.setFont(new Font("serif", Font.BOLD, 20));
        add(apid);

        JLabel labeldate = new JLabel("Date");
        labeldate.setBounds(50, 350, 150, 30);
        labeldate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldate);

        dcdate = new JDateChooser();
        dcdate.setDateFormatString("dd-MMM-yyyy");
        dcdate.setBounds(200, 350 ,150, 30);
        dcdate.setMinSelectableDate(new Date());
        add(dcdate);

        addButton = new JButton("Book Appointment");
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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bookappointment.jpg"));
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
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String phone = tfphone.getText();
            String address = tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String time = (String) hourComboBox.getSelectedItem();
            String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String id = apid.getText();

            try
            {
                if(name.isEmpty() || fname.isEmpty() || dob.isEmpty() || phone.isEmpty() || address.isEmpty() || time.isEmpty() || city.isEmpty() || state.isEmpty() || date.isEmpty() || id.isEmpty())
                {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
                } else if (isTimeSlotAvailable(date, time))
                {
                        // If the time slot is available, book the appointment
                        Conn conn = new Conn();
                        String query = "insert into bookappointment values('" + name + "','" + fname + "','" + dob + "','" + phone + "','" + address + "','" + time + "','" + city + "','" + state + "','" + date + "','" + id + "')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Booked Successfully");
                        setVisible(false);
                        new Dashboard();
                    } else {
                        // If the time slot is not available, display a message
                        JOptionPane.showMessageDialog(null, "This time slot is already booked. Please choose another time.");
                    }
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
    private boolean isTimeSlotAvailable(String date, String time) {
        try {
            Conn conn = new Conn();
            String query = "select * from bookappointment where date = '" + date + "' and time = '" + time + "'";
            ResultSet rs = conn.s.executeQuery(query);
            // If the ResultSet is empty, the time slot is available
            return !rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false in case of any exception
        }
    }

    public static void main(String[] args)
    {
        new BookAppointment();
    }
}
