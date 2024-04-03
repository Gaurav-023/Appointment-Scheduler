package Appointment_Schdeuler;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

    JButton create, back;
    JTextField tfname, tfusername, tfpassword, tfanswer;
    Choice security;

    Signup() {

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(54, 54, 54, 253));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblusername.setForeground(Color.WHITE);
        lblusername.setBounds(50, 20, 125, 25);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblname.setForeground(Color.WHITE);
        lblname.setBounds(50, 60, 125, 25);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblpassword.setForeground(Color.WHITE);
        lblpassword.setBounds(50, 100, 125, 25);
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(190, 100, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblsecurity.setForeground(Color.WHITE);
        lblsecurity.setBounds(50, 140, 125, 25);
        p1.add(lblsecurity);

        security = new Choice();
        security.add("Fav Character From TMKOC");
        security.add("Yours 12 Grade Percentage");
        security.add("Fav Bollywood Actor");
        security.setBounds(190, 140, 180, 25);
        p1.add(security);

        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblanswer.setForeground(Color.WHITE);
        lblanswer.setBounds(50, 180, 125, 25);
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(190, 180, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        create = new JButton("Create");
        create.setBackground(new Color(123, 123, 123));
        create.setForeground(Color.white);
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBounds(80, 250, 100, 30);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(new Color(123, 123, 123));
        back.setForeground(Color.white);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBounds(250, 250, 100, 30);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signup3.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 360, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, -10, 450, 360);
        add(image);

        setResizable(false);


        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();

            if (username.isEmpty() || name.isEmpty() || password.isEmpty() || answer.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else {
                String query = "INSERT INTO account VALUES ('" + username + "','" + name + "','" + password + "','" + answer + "')";
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                    setVisible(false);
                    new Login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}

