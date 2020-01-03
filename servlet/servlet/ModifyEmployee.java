package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmployeeDAO;

@WebServlet("/Modify")
public class ModifyEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Employee emp;
	EmployeeDAO dao;
	PrintWriter out;
	
    public ModifyEmployee() {
    
    	dao=new EmployeeDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{
			out=response.getWriter();
			int eid=Integer.parseInt(request.getParameter("eid"));
			int ra=dao.delete(eid);
			if(ra>0)
				out.println("<font color=green>Employee Details Deleted Succcessfully.</font><br>");
			else
				out.println("<font color=red>employee Details are not deleted.</font><br>");
			out.println("To Go Back To The Form <a href='http://localhost:9080/Examples/home.html'>Click Here</a>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out=response.getWriter();
		int eid=Integer.parseInt(request.getParameter("eid"));
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		String role=request.getParameter("role");
		emp=new Employee(eid, name, mobile, address, role);
		
		int ra=dao.update(emp);
		if(ra>0)
			out.println("<font color=green>employee Details Updated Succcessfully.</font>");
		else
			out.println("<font color=red>employee Details are not Updated.</font>");
		out.println("To Go Back To The Form <a href='http://localhost:9090/Examples/home.html'>Click Here</a>");
	}

}
