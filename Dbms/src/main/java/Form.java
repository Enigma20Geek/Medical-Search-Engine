import java.io.*;  
import java.sql.*;
import java.util.Random;

import jakarta.servlet.ServletException;  
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;  

@WebServlet("/Form")
public class Form extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	boolean ok = true;
	static String num="";
	static String name,username,dob,email,city,phone,password;
	public static String getName() {
		return name;
	}
	public static String getUsername() {
		return username;
	}
	public static String getDob() {
		return dob;
	}
	public static String getEmail() {
		return email;
	}
	public static String getCity() {
		return city;
	}
	public static String getPhone() {
		return phone;
	}
	public static String getPassword() {
		return password;
	}
	public static String getNum() {
		return num;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  

		name=request.getParameter("Name");  
		username=request.getParameter("Username");  
		dob=request.getParameter("DOB");  
		email=request.getParameter("Email");  
		city=request.getParameter("City"); 
		phone=request.getParameter("Phone"); 
		password=request.getParameter("Password"); 

		try {

			String connectionURL = "jdbc:mysql://localhost:3306/dbms_project"; 
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection
					(connectionURL,"root",""); //Enter password MySQL
			PreparedStatement ps = con.prepareStatement("select username from register where username=?");
			ps.setString(1,username);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				ok = false;
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Username is already in use');");
				out.println("location='SignUp.jsp';");
				out.println("</script>");

			}
			ps = con.prepareStatement("select email from register where email=?");
			ps.setString(1,email);
			rs = ps.executeQuery();
			if(ok && rs.next()){
				ok = false;
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Email already registered');");
				out.println("location='SignUp.jsp';");
				out.println("</script>");
			}
		} 
		catch (Exception ex) {
			out.println("Error ->" + ex.getMessage());
		}
		if(ok) {
			num = Integer.toString((int)(Math.random()*9001+1000));
			Mailer.verify(email, num);
			response.sendRedirect("Verify.jsp");  
		}  
	}
}  
