import java.sql.*;
public class clearTable {
    public void clear() throws Exception {
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C://Users//ANAND//IdeaProjects//SwiggyClone//SwiggyClone.accdb");
        Statement st = con.createStatement();
        st.executeUpdate("delete * from orderDetails");
        con.close();
    }

    public static void main(String[] args) throws Exception {
        new clearTable().clear();
    }
}
