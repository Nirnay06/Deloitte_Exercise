package dao;

import java.sql.*;

import bean.Employee;

public class EmployeeDAO {

	Connection con;
	ResultSet rs;
	PreparedStatement pstmt;
	CallableStatement cstmt;
	Statement stmt;
	
	public EmployeeDAO()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","seed1234");
			System.out.println("connection successful");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public int insert(Employee e)
	{
		System.out.println("In insert");
		int ra=0;
		
		try{
			pstmt=con.prepareStatement("Insert into employee1 values(?,?,?,?,?)");
			pstmt.setInt(1, e.getEid());
			pstmt.setString(2, e.getName());
			pstmt.setString(3, e.getMobile());
			pstmt.setString(4, e.getAddress());
			pstmt.setString(5, e.getRole());
			ra=pstmt.executeUpdate();
			pstmt.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		return ra;
	}
	
	public int update(Employee e)
	{
		int ra=0;
			try{
				pstmt=con.prepareStatement("update employee1 set name=?,mobile=?,address=?,role=? where eid=?");
				pstmt.setInt(5, e.getEid());
				pstmt.setString(1, e.getName());
				pstmt.setString(2, e.getMobile());
				pstmt.setString(3, e.getAddress());
				pstmt.setString(4, e.getRole());
				ra=pstmt.executeUpdate();
				pstmt.close();
				
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			return ra;
	}
	
	
	public int delete(int eid)
	{
		int ra=0;
		try{
			pstmt=con.prepareStatement("delete from employee1 where eid=?");
			pstmt.setInt(1, eid);
			ra=pstmt.executeUpdate();
			pstmt.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		return ra;
	}
	
	
	public ResultSet retrieve(int sid)
	{
		System.out.println("In Retrieve");
		try
		{
			
			pstmt=con.prepareStatement("select * from employee1 where eid=?");
			pstmt.setInt(1,sid);
			rs=pstmt.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}
