package UserOrder;
import java.sql.*;
import java.util.ArrayList;

public class RetrieveHotels {
    public String[] RetrieveData() throws Exception{
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://D://ANAND//IdeaProjects//SwiggyClone//SwiggyClone.accdb");
        Statement st = con.createStatement();
        String query = "select Name from HotelDetails";
        ArrayList <String> hotels = new ArrayList<>();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()){
            hotels.add(rs.getString(1));
        }
        con.close();
        return hotels.toArray(new String[0]);
    }

    public static void main(String[] args){
    }
}
