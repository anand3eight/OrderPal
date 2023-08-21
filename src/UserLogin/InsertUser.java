package UserLogin;
import java.sql.*;
public class InsertUser {
    String user, password, email, address;
    InsertUser(String user, String password, String email, String address){
        this.user = user;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    public boolean insertUserInDataBase() throws Exception{
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://D://ANAND//IdeaProjects//SwiggyClone//SwiggyClone.accdb");
        Statement st = con.createStatement();
        String query = "insert into UserDetails (Name, Password, Email, Address) values ('" +
                        this.user + "','" +
                        this.password + "','" +
                        this.email + "','" +
                        this.address + "');";
        st.executeUpdate(query);
        con.close();
        return true;
    }

    public static void main(String[] args) {
    }
}
