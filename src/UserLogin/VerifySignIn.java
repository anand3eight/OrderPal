package UserLogin;

import java.sql.*;

public class VerifySignIn {
    String user, password;
    public VerifySignIn(String user, String password){
        this.user = user;
        this.password = password;

    }
    public boolean UserSearch() throws Exception{
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://D://ANAND//IdeaProjects//SwiggyClone//SwiggyClone.accdb");
        Statement st = con.createStatement();
        String query = "select Password from UserDetails where Name = '" + this.user + "';";
        ResultSet rs = st.executeQuery(query);
        String pswd = null;
        while(rs.next()){
             pswd = rs.getString(1);
        }
        con.close();
        return this.password.equals(pswd);
    }

    public static void main(String[] args) {
    }
}
