package UserOrder;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class RetrieveItems {
    public String[][] retrieveData(int ch) throws Exception{
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://D://ANAND//IdeaProjects//SwiggyClone//SwiggyClone.accdb");
        Statement st = con.createStatement();
        HashMap <Integer, String> tablemap = new HashMap<>();
        tablemap.put(1, "KFC");
        tablemap.put(2, "McDonalds");
        tablemap.put(3, "Starbucks");
        tablemap.put(4, "Subway");
        String query = "select item, price from " + tablemap.get(ch) + ";";
        ArrayList<String> items = new ArrayList<>();
        ArrayList<String> prices = new ArrayList<>();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()){
            items.add(rs.getString(1));
            prices.add(rs.getString(2));
        }
        String[][] result = new String[2][];
        result[0] = items.toArray(new String[0]);
        result[1] = prices.toArray(new String[0]);
        return result;
    }

    public static void main(String[] args) {
    }
}
