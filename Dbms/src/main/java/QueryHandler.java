import java.io.IOException;  
import java.io.PrintWriter;  
  
import jakarta.servlet.ServletException;  
import jakarta.servlet.http.HttpServlet;  
import jakarta.servlet.http.HttpServletRequest;  
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;  
  
@WebServlet("/send")  
public class QueryHandler extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
	    PrintWriter out = response.getWriter();
	    String from=request.getParameter("Email"); 
	    String msg=request.getParameter("message"); 
	    Mailer.send(from, msg);
	    out.println("<script type=\"text/javascript\">");
 	   	out.println("alert('Query Sent Successfully!');");
 	   	out.println("location='ContactUs.jsp';");
 	   	out.println("</script>");
	}
}