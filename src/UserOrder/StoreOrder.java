package UserOrder;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class StoreOrder {
    public void storeOrderInDB(String user, String hotel, String total) throws Exception{
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://D:\\ANAND\\IdeaProjects\\SwiggyClone\\SwiggyClone.accdb");
            Statement st = con.createStatement();
            Date d = new Date();
            String query = "select email from UserDetails where name = '" + user +"';";
            ResultSet rs = st.executeQuery(query);
            String email = null;
            while(rs.next()){
                email = rs.getString(1);
            }
            query = "insert into OrderDetails(Username, Email, Time, Hotel, Price) values('"+
                    user + "','" +
                    email + "','" +
                    d.toString() +"','" +
                    hotel + "'," +
                    Integer.valueOf(total) + ");";
            st.executeUpdate(query);
            con.close();
    }

    public static void main(String[] args) throws Exception {
        new StoreOrder().storeOrderInDB("Unnamalai", "KFC", "45");
    }
}
