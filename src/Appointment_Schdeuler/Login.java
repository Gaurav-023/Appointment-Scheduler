package Appointment_Schdeuler;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JTextField textField1;
    JPasswordField passwordField1;
    JButton b1, Signup;

    Login() {
        JLabel label1 = new JLabel("Username");
        label1.setBounds(20, 40, 100, 30);
        label1.setFont(new Font("Calisto MT", Font.BOLD, 18));
        label1.setForeground(Color.BLACK);
        add(label1);

        textField1 = new JTextField();
        textField1.setBounds(150, 40, 150, 30);
        textField1.setForeground(Color.BLACK);
        textField1.setFont(new Font("Calisto MT", Font.PLAIN, 16));
        textField1.setBackground(new Color(243, 242, 246));
        add(textField1);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(20, 80, 100, 30);
        label2.setFont(new Font("Calisto MT", Font.BOLD, 18));
        label2.setForeground(Color.BLACK);
        add(label2);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(150, 80, 150, 30);
        passwordField1.setForeground(Color.BLACK);
        passwordField1.setBackground(new Color(252, 252, 253));
        add(passwordField1);

        b1 = new JButton("Login");
        b1.setBounds(50, 145, 100, 30);
        b1.setForeground(Color.BLACK);
        b1.setBackground(new Color(242, 242, 246));
        b1.addActionListener(this);
        add(b1);

        Signup = new JButton("Signup");
        Signup.setBounds(190, 145, 100, 30);
        Signup.setForeground(Color.BLACK);
        Signup.setBackground(new Color(243, 243, 246));
        Signup.addActionListener(this);
        add(Signup);

        JButton Reset = new JButton("Cancel");
        Reset.setBounds(125, 185, 100, 30);
        Reset.setForeground(Color.BLACK);
        Reset.setBackground(new Color(243, 243, 246));
        Reset.addActionListener(this);
        add(Reset);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Login4.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(270, -10, 350, 600);
        add(image);


        getContentPane().setBackground(new Color(255, 255, 255));
        setLayout(null);

        setResizable(false);
        setLocation(400, 270);
        setSize(600, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                String username = textField1.getText();
                String password = passwordField1.getText();
                Conn c = new Conn();
                String query = "select * from account where username='" + username + "' and password = '" + password + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next())
                {
                    setVisible(false);
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (ae.getSource()==Signup)
        {
            setVisible(false);
            new Signup();

        }
        else
        {
            System.exit(102);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
