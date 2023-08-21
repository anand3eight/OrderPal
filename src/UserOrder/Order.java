package UserOrder;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import UserBill.*;
public class Order {
        JFrame f;
        JComboBox <String[]> hotels;
        JLabel item1, item2, item3, item4;
        JLabel cost1, cost2, cost3, cost4;
        JLabel ltotal;
        JTextField totalprice;
        JTextField q1, q2, q3, q4;
        JPanel p1;
        JButton checkprice, confirm;
        String hotelsarr[];
        String result[][];
        String user;
        public Order(String user){
            this.user = user;
            f = new JFrame("User Order");
            RetrieveHotels rh = new RetrieveHotels();
                try {
                        hotelsarr = rh.RetrieveData();
                } catch (Exception e) {
                        throw new RuntimeException(e);
                }
            hotels = new JComboBox(hotelsarr);
            hotels.setBounds(100, 20, 200, 30);
            f.add(hotels);
            item1 = new JLabel();
            item1.setBounds(50, 60, 200, 20);
            f.add(item1);
            cost1 = new JLabel();
            cost1.setBounds(260, 60, 50, 20);
            f.add(cost1);
            q1 = new JTextField("0");
            q1.setBounds(320, 60, 50, 20);
            f.add(q1);
            item2 = new JLabel();
            item2.setBounds(50, 90, 200, 20);
            f.add(item2);
            cost2 = new JLabel();
            cost2.setBounds(260, 90, 50, 20);
            f.add(cost2);
            q2 = new JTextField("0");
            q2.setBounds(320, 90, 50, 20);
            f.add(q2);
            item3 = new JLabel();
            item3.setBounds(50, 120, 50, 20);
            f.add(item3);
            cost3 = new JLabel();
            cost3.setBounds(260, 120, 50, 20);
            f.add(cost3);
            q3 = new JTextField("0");
            q3.setBounds(320, 120, 50, 20);
            f.add(q3);
            item4 = new JLabel();
            item4.setBounds(50, 150, 200, 20);
            f.add(item4);
            cost4 = new JLabel();
            cost4.setBounds(260, 150, 50, 20);
            f.add(cost4);
            q4 = new JTextField("0");
            q4.setBounds(320, 150, 50, 20);
            f.add(q4);
            ltotal = new JLabel("Total : ");
            ltotal.setBounds(50, 180, 100, 20);
            f.add(ltotal);
            totalprice = new JTextField();
            totalprice.setBounds(260, 180, 110, 20);
            f.add(totalprice);
            checkprice = new JButton("Check Price");
            checkprice.setBounds(50, 210, 150, 20);
            f.add(checkprice);
            confirm = new JButton("Confirm Order");
            confirm.setBounds(210, 210, 150, 20);
            f.add(confirm);
            JLabel dummy = new JLabel();
            f.add(dummy);

            hotels.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            int val = hotels.getSelectedIndex() + 1;
                            RetrieveItems ri = new RetrieveItems();
                        try {
                            result = ri.retrieveData(val);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    setItems(result);
                    }
            });

            checkprice.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setCheckprice();
                }
            });

            confirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int val = JOptionPane.showConfirmDialog(f, "Total : " + totalprice.getText() + " Confirm Order?");
                    if(val == JOptionPane.YES_OPTION){
                        StoreOrder so = new StoreOrder();
                        try {
                            so.storeOrderInDB(user, String.valueOf(hotels.getItemAt(hotels.getSelectedIndex())), totalprice.getText());
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        f.dispose();
                        OrderBill ob = new OrderBill(user, wrapBill());

                    }
                }
            });

            f.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    f.dispose();
                }
            });
            f.setBounds(200, 100,700, 700);
            f.getContentPane().setBackground(Color.GRAY);
            f.setVisible(true);
        }

        public void setItems(String result[][]){
            item1.setText(result[0][0]);
            item2.setText(result[0][1]);
            item3.setText(result[0][2]);
            item4.setText(result[0][3]);
            cost1.setText(result[1][0]);
            cost2.setText(result[1][1]);
            cost3.setText(result[1][2]);
            cost4.setText(result[1][3]);
        }

        public void setCheckprice(){
            int total = 0, price1 = 0, price2 = 0, price3 = 0, price4 = 0;
            if(Integer.valueOf(q1.getText()) > 0) {
                price1 = Integer.valueOf(cost1.getText()) * Integer.valueOf(q1.getText());
            }
            if(Integer.valueOf(q2.getText()) > 0) {
                price2 = Integer.valueOf(cost2.getText()) * Integer.valueOf(q2.getText());
            }
            if(Integer.valueOf(q3.getText()) > 0) {
                price3 = Integer.valueOf(cost3.getText()) * Integer.valueOf(q3.getText());
            }
            if(Integer.valueOf(q4.getText()) > 0) {
                price4 = Integer.valueOf(cost4.getText()) * Integer.valueOf(q4.getText());
            }
            total = price1 + price2 + price3 + price4;
            totalprice.setText(String.valueOf(total));
        }

        public String[][] wrapBill(){
            ArrayList<String[]> bill = new ArrayList<>();
            String[] val1, val2, val3, val4;
            if(Integer.valueOf(q1.getText()) > 0) {
                val1 = new String[]{item1.getText(), cost1.getText(), q1.getText()};
                bill.add(val1);
            }
            if(Integer.valueOf(q2.getText()) > 0) {
                val2 = new String[]{item2.getText(), cost2.getText(), q2.getText()};
                bill.add(val2);
            }
            if(Integer.valueOf(q3.getText()) > 0) {
                val3 = new String[]{item3.getText(), cost3.getText(), q3.getText()};
                bill.add(val3);
            }
            if(Integer.valueOf(q4.getText()) > 0) {
                val4 = new String[]{item4.getText(), cost4.getText(), q4.getText()};
                bill.add(val4);
            }
            return bill.toArray(new String[0][]);
        }

        public static void main(String[] args) {
            new Order("Anand");
        }
}
