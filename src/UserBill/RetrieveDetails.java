package UserBill;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RetrieveDetails {
    public HashMap<String, String> retrieveFromDB(String user) throws Exception{
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://D:\\ANAND\\IdeaProjects\\SwiggyClone\\SwiggyClone.accdb");
        Statement st = con.createStatement();
        String query = "select * from OrderDetails where username = '" + user + "'";
        ResultSet rs = st.executeQuery(query);
        HashMap <String, String> details = new HashMap<>();
        while(rs.next()){
            details.put("Email", rs.getString(3));
            details.put("Time", rs.getString(4));
            details.put("Hotel", rs.getString(5));
            details.put("Total", rs.getString(6));
        }
        con.close();
        return details;
    }

    public static void main(String[] args) throws Exception {
    }

}
