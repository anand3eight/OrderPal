package UserLogin;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import UserOrder.*;
public class SignIn {
    JFrame f;
    JLabel lusername, lpassword;
    JTextField username;
    JPasswordField password;
    JButton signIn, signUp;
    public void setSignInFrame(){
        f = new JFrame("User Login");
        lusername = new JLabel("User : ");
        lusername.setBounds(120, 180, 100, 20);
        f.add(lusername);
        username = new JTextField();
        username.setBounds(220, 180, 100, 20);
        f.add(username);
        lpassword = new JLabel("Password : ");
        lpassword.setBounds(120, 210, 100, 20);
        f.add(lpassword);
        password = new JPasswordField();
        password.setBounds(220, 210, 100, 20);
        f.add(password);
        signIn = new JButton("Sign In");
        signIn.setBounds(120, 240, 95, 20);
        f.add(signIn);
        signUp = new JButton("Sign Up");
        signUp.setBounds(220, 240, 100, 20);
        f.add(signUp);
        JLabel dummy = new JLabel();
        f.add(dummy);
        f.setBounds(400, 100, 500, 500);
        f.getContentPane().setBackground(Color.GRAY);
        f.setVisible(true);

        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VerifySignIn vsi = new VerifySignIn(username.getText(), String.valueOf(password.getPassword()));
                try {
                    if(!vsi.UserSearch()) {
                        JOptionPane.showMessageDialog(f, "Invalid UserName/Password");
                    }
                    else{
                        JOptionPane.showMessageDialog(f, "Login Successful");
                        new Order(username.getText());
                        f.dispose();
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
            });

        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Signing Up");
                SignUp su = new SignUp();
            }
        });
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });

    }

    public static void main(String[] args) {
    }
}
