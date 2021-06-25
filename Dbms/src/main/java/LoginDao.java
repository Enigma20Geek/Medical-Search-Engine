import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	String sql="select * from register where username=? and password=?";
	String url="jdbc:mysql://localhost:3306/dbms_project";
	String uname="root";
	String pass="";//Enter password MySQL
   public boolean check(String username,String password) {
	   try {
		   Class.forName("com.mysql.jdbc.Driver");
		   Connection con=DriverManager.getConnection(url,uname,pass);
		   PreparedStatement st=con.prepareStatement(sql);
		   st.setString(1,username);
		   st.setString(2,password);
		   ResultSet rs=st.executeQuery();
		   if(rs.next()) {
			   return true;
		   }
	   }
	   catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   return false;
   }
   
}
