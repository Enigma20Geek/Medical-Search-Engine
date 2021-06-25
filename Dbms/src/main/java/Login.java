

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpSession;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter out = response.getWriter();
		LoginDao dao=new LoginDao();
		if(dao.check(username, password)) {
			HttpSession session=request.getSession();
			session.setAttribute("uname", username);
			out.println("<script type=\"text/javascript\">");
	    	out.println("alert('Login Successful! Welcome "+username+"!');");
	    	out.println("location='home.jsp';");
	    	out.println("</script>");
		}
		else {
			out.println("<script type=\"text/javascript\">");
	    	out.println("alert('No user data found. Register yourself!');");
	    	out.println("location='SignUp.jsp';");
	    	out.println("</script>");
		}
	}


}
