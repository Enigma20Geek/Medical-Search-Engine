import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;  
import jakarta.servlet.http.HttpServlet;  
import jakarta.servlet.http.HttpServletRequest;  
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;  
  
@WebServlet("/verify")  
public class NumberVerifier extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
	    PrintWriter out = response.getWriter();
	    String num=request.getParameter("Num");
	    String name=Form.getName();
	    String username=Form.getUsername();
	    String email=Form.getEmail();
	    String dob=Form.getDob();
	    String city=Form.getCity();
	    String phone=Form.getPhone();
	    String password=Form.getPassword();
	    if(num.equals(Form.getNum()))
	    {
	    	try {
				Class.forName("com.mysql.jdbc.Driver");

				Connection con = DriverManager.getConnection
						("jdbc:mysql://localhost:3306/dbms_project","root",""); //Enter password MySQL
				PreparedStatement ps = con.prepareStatement
						("insert into register values(?,?,?,?,?,?,?)"); 

				ps.setString(1,name);  
				ps.setString(2,username);  
				ps.setString(3,email);
				ps.setString(4,city);
				ps.setString(5,phone);
				ps.setString(6,dob);
				ps.setString(7,password);

				int i=ps.executeUpdate();  
				if(i>0)  {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('You are successfully registered');");
					out.println("location='Login.jsp';");
					out.println("</script>");
				}


			}catch (Exception e2) {System.out.println(e2);}  

	    }
	    else
	    {
	    	out.println("<script type=\"text/javascript\">");
			out.println("alert('Wrong verification number');");
			out.println("location='SignUp.jsp';");
			out.println("</script>");
	    }
//	    out.println("<script type=\"text/javascript\">");
// 	   	out.println("alert('Query Sent Successfully!');");
// 	   	out.println("location='ContactUs.jsp';");
// 	   	out.println("</script>");
	}
}
