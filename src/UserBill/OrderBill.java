package UserBill;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
import java.io.*;

public class OrderBill {
    JFrame f;
    JButton generatebill, close;
    JLabel lfile;
    JTextField tfile;
    String user, filename = null;
    String[][] Details;
    HashMap<String, String> userDetails;

    File fl;

    public OrderBill(String user, String[][] Details){
        this.user = user;
        this.Details = Details;
        showOrderBill();
    }

    public void showOrderBill(){
        f = new JFrame("User Bill");
        generatebill = new JButton("Generate Bill");
        generatebill.setBounds(150, 20, 200, 20);
        f.add(generatebill);
        lfile = new JLabel("File Location : ");
        lfile.setBounds(30, 50, 100, 20);
        f.add(lfile);
        tfile = new JTextField();
        tfile.setBounds(140, 50, 210, 20);
        f.add(tfile);
        close = new JButton("Close");
        close.setBounds(150, 80, 200, 20);
        f.add(close);
        JLabel dummy = new JLabel();
        f.add(dummy);

        generatebill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOrderBill();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                tfile.setText(String.valueOf(fl.getAbsoluteFile()));
            }
        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "Thank You for Ordering");
                f.dispose();
            }
        });

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                f.dispose();
            }
        });
        f.setBounds(400, 100, 500, 500);
        f.getContentPane().setBackground(Color.GRAY);
        f.setVisible(true);
    }

    public void FileOrderBill() throws Exception {
        userDetails = new RetrieveDetails().retrieveFromDB(user);
        filename = "D://ANAND//IdeaProjects//SwiggyClone//Orders//Bill_" + userDetails.get("Time").replace(" ", "_").replace(":", "") + ".txt";
        fl = new File(filename);
        FileWriter fw = new FileWriter(fl);
        String Det = "BILL" +
                "\nUser     : " + user +
                "\nTime     : " + userDetails.get("Time") +
                "\nEmail    : " + userDetails.get("Email") +
                "\nHotel    : " + userDetails.get("Hotel") +
                "\n" + String.format("%20s %20s %20s %20s", "Item", "Cost", "Quantity", "Price");
        for(String[] val : Details){
            Det += "\n" + String.format("%20s %20s %20s %20s", val[0], val[1], val[2], String.valueOf(Integer.valueOf(val[1]) * Integer.valueOf(val[2])));
        }
        Det += "\n" + String.format("%62s %20s", "GST", String.valueOf(0.05 * Integer.valueOf(userDetails.get("Total"))));
        Det += "\n" + String.format("%62s %20s", " ", "------------------------");
        Det += "\n" + String.format("%62s %20s", "Total", String.valueOf(1.05 * Integer.valueOf(userDetails.get("Total"))));
        Det += "\n" + String.format("%62s %20s", " ", "------------------------");
        fw.write(Det.toCharArray());
        fw.close();

    }

    public static void main(String[] args) {
    }
}
