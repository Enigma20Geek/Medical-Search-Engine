import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;  

@WebServlet("/view")
public class DiseaseInfo extends HttpServlet {  
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String diseaseName = request.getParameter("Name");
		String sql="select * from disease_info where Disease=?";
		String url="jdbc:mysql://localhost:3306/dbms_project";
		String uname="root";
		String pass="" //Enter ur password for MySQL;
		try {
			Connection con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,diseaseName);
			ResultSet rs=st.executeQuery();
			ArrayList<String> symptoms = new ArrayList<String>();
			while(rs.next())
			{
				symptoms.add(rs.getString("Symptoms"));
			}
			sql="select * from disease_info1 where Disease=?";
			st=con.prepareStatement(sql);
			st.setString(1,diseaseName);
			rs=st.executeQuery();
			ArrayList<String> medicines = new ArrayList<String>();
			while(rs.next())
			{
				medicines.add(rs.getString("Medicines"));
			}
			String[] prices = new String[medicines.size()];
			for(int i=0;i<medicines.size();i++)
			{
				sql="select * from med_info where medicine=?";
				st=con.prepareStatement(sql);
				st.setString(1,medicines.get(i));
				rs=st.executeQuery();
				rs.next();
				prices[i]=rs.getString("price_min");
				prices[i]+="-";
				prices[i]+=rs.getString("price_max");
			}
			HttpSession session=request.getSession();
			session.setAttribute("name", diseaseName);
			session.setAttribute("symp", symptoms);
			session.setAttribute("med", medicines);
			session.setAttribute("price", prices);
			response.sendRedirect("View.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}  
