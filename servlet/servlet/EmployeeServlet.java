package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.Employee;
import dao.EmployeeDAO;

@WebServlet("/Employee")
public class EmployeeServlet extends HttpServlet {
	Employee emp;
	EmployeeDAO dao;
	PrintWriter out;
	private static final long serialVersionUID = 1L;
 
    public EmployeeServlet() {
      dao=new EmployeeDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try
		{
			out=response.getWriter();
			int sid=Integer.parseInt(request.getParameter("eid"));
			ResultSet res=dao.retrieve(sid);
			out.println("<table border=3><tr><th>employee Id</th><th>employee Name</th><th>Mobile No</th><th>Address</th><th>role</th></tr>");
			while(res.next())
			{
				out.println("<tr>");
				out.println("<td>"+res.getInt("eid")+"</td>");
				out.println("<td>"+res.getString("name")+"</td>");
				out.println("<td>"+res.getString("mobile")+"</td>");
				out.println("<td>"+res.getString("address")+"</td>");
				out.println("<td>"+res.getString("role")+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("To Go Back To The Form <a href='http://localhost:9080/Examples/home.html'>Click Here</a>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		int eid=Integer.parseInt(request.getParameter("eid"));
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		String role=request.getParameter("role");
		
		emp=new Employee(eid,name,mobile,address,role);
		int ra=dao.insert(emp);
		if(ra>0)
			out.println("<font color=green>employee Details Inserted Succcessfully.</font>");
		else
			out.println("<font color=red>employee Details are not inserted.</font>");
		out.println("To Go Back To The Form <a href='http://localhost:9080/Examples/home.html'>Click Here</a>");
			
	}

}
