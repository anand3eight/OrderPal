package UserLogin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp {
    JFrame f;
    JLabel heading, lname, lpassword, lconfirmpassword, laddress, lemail;
    JTextField name, address, email;
    JPasswordField password, confirmpassword;
    JButton signUp;
    public SignUp(){
        f = new JFrame("User SignUp");
        heading = new JLabel("DETAILS");
        heading.setBounds(20, 20, 100, 20);
        f.add(heading);
        lname = new JLabel("User : ");
        lname.setBounds(20, 50, 70, 20);
        f.add(lname);
        name = new JTextField();
        name.setBounds(100, 50, 100, 20);
        f.add(name);
        lpassword = new JLabel("Password : ");
        lpassword.setBounds(20, 80, 70, 20);
        f.add(lpassword);
        password = new JPasswordField();
        password.setBounds(100, 80, 100, 20);
        f.add(password);
        lconfirmpassword = new JLabel("Confirm : ");
        lconfirmpassword.setBounds(20, 110, 70, 20);
        f.add(lconfirmpassword);
        confirmpassword = new JPasswordField();
        confirmpassword.setBounds(100, 110, 100, 20);
        f.add(confirmpassword);
        lemail = new JLabel("Email : ");
        lemail.setBounds(20, 140, 70, 20);
        f.add(lemail);
        email = new JTextField();
        email.setBounds(100, 140, 100, 20);
        f.add(email);
        laddress = new JLabel("Address : ");
        laddress.setBounds(20, 170, 70, 20);
        f.add(laddress);
        address = new JTextField();
        address.setBounds(100, 170, 100, 20);
        f.add(address);
        signUp = new JButton("SignUp");
        signUp.setBounds(50, 200, 120, 20);
        f.add(signUp);
        JLabel dummy = new JLabel();
        f.add(dummy);
        f.getContentPane().setBackground(Color.GRAY);
        f.setBounds(300, 100, 500, 500);
        f.setVisible(true);

        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int val = JOptionPane.showConfirmDialog(f, "Are you Sure?");
                if(val == JOptionPane.YES_OPTION){
                if(!String.valueOf(password.getPassword()).equals(String.valueOf(confirmpassword.getPassword())) || String.valueOf(password.getPassword()).length() < 9){
                    JOptionPane.showMessageDialog(f, "Enter Valid Password");
                }
                else if(!checkEmail(email.getText())){
                    JOptionPane.showMessageDialog(f, "Enter Valid Email");
                }
                else{
                    InsertUser iu = new InsertUser(name.getText(), String.valueOf(password.getPassword()), email.getText(), address.getText());
                    try {
                        if(iu.insertUserInDataBase()){
                            JOptionPane.showMessageDialog(f, "Successfully Registered");
                            f.dispose();
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
            }
        });

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });
    }
    public boolean checkEmail(String email){
        String regex = "^([A-Za-z0-9_]+)@([a-z]+)\\.([a-z]+)$";
        Pattern pt = Pattern.compile(regex);
        Matcher mt = pt.matcher(email);
        return mt.matches();
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
