package JDBCProgs;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCApp {

	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	CallableStatement callstmt;
	static int authorCount=0;
	static int bookCount=0;
	
	public JDBCApp()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","seed1234");
			System.out.println("Database Connected....");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	}
	public void insertAuthor()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter first name of author:");
		String fname=scan.next();
		System.out.println("enter middle name of author:");
		String mname=scan.next();
		System.out.println("enter last name of author:");
		String lname=scan.next();
		System.out.println("enter phone no of author:");
		String phone=scan.next();
		
		
		
try{
		authorCount++;
		pstmt=con.prepareStatement("Insert into author values(?,?,?,?,?)");
		pstmt.setInt(1, authorCount);
		pstmt.setString(2, fname);
		pstmt.setString(3, mname);
		pstmt.setString(4, lname);
		pstmt.setString(5, phone);
		
		int ra=pstmt.executeUpdate();
		if(ra>0)
			System.out.println("author details committed");
		else 
			System.out.println("author detials not comitted");
		pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	public void insertBook()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter title of book:");
		String title=scan.next();
		System.out.println("enter price of book:");
		int price=scan.nextInt();
	try{
				bookCount++;
				pstmt=con.prepareStatement("Insert into book values(?,?,?)");
				pstmt.setInt(1, bookCount);
				pstmt.setString(2,title );
				pstmt.setInt(3, price);
				
				int ra=pstmt.executeUpdate();
				if(ra>0)
					System.out.println("book details committed");
				else 
					System.out.println("book detials not comitted");
				pstmt.close();
			}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
	public void insertBookAuthor()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("enter the author id:");
		int authorid=scan.nextInt();
		System.out.println("enter the ISBN:");
		int bookid=scan.nextInt();
		
		try 
		{
			pstmt=con.prepareStatement("select * from author where authorid=?");
			pstmt.setInt(1, authorid);
			int ra=pstmt.executeUpdate();
			if(ra<1)
			{
				System.out.println("Author doesnot exist, create one");
				insertAuthor();
			}
			pstmt=con.prepareStatement("select * from book where isbn=?");
			pstmt.setInt(1, bookid);
			int ra1=pstmt.executeUpdate();
			if(ra1<1)
			{
				System.out.println("book doesnot exist, create one");
				insertAuthor();
			}
			
			pstmt=con.prepareStatement("insert into bookauthor values(?,?)");
			pstmt.setInt(1, bookid);
			pstmt.setInt(2,authorid);
			int ra3=pstmt.executeUpdate();
			if(ra3<1)
			{
				System.out.println("error");
	
			}
			else 
			{
				System.out.println("book author succesfully created");
			}
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void insertData()
	{
		
			Scanner scan=new Scanner(System.in);
			System.out.println("do you want to insert book or author");
			String choice=scan.next();
			if(choice=="author")
			{
				insertAuthor();
				insertBookAuthor();
			//insert into author
			//call insert into book_author
			}
			else if(choice=="book")
			{
				insertBook();
				insertBookAuthor();
				//insert into book 
				//call insert into book_author
			}
	}
	
	public void getBooksByAuthor(int authorid)
	{
		
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery("Select * from book join bookauthor using(ISBN) where authorid="+authorid);
			while(rs.next())
			{
				System.out.println("ISBn : "+rs.getInt("ISBN"));
				System.out.println("title : "+rs.getString("title"));
				System.out.println("price : "+rs.getInt("price"));
				System.out.println("");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void updateBook(int authorid)
	{
		Scanner scan=new Scanner (System.in);
		try{
		System.out.println("enter the new price:");
		int price=scan.nextInt();
		//System.out.println("nirnay");
		//pstmt=con.prepareStatement("update book set price=? where isbn in (select isbn from bookauthor where authorid=?)");
		pstmt=con.prepareStatement("update book set price=? where isbn in (select isbn from bookauthor where authorid=?)" );
		pstmt.setInt(1, price);
		pstmt.setInt(2, authorid);
		//System.out.println("pratik");
		//int rs=pstmt.executeUpdate();
		//System.out.println("mittal");
		int ra2=pstmt.executeUpdate();
		if(ra2>0)
			System.out.println("price updated for author name"+ra2);
		else
			System.out.println("author is not updated..");
		pstmt.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	public static void main(String args[])
	{
		JDBCApp j=new JDBCApp();
	
		Scanner scan=new Scanner(System.in);
		do{
		System.out.println("1.insert author");
		System.out.println("2.insert book");
		System.out.println("3.insert into book author table");
		System.out.println("4.select books using author id");
		System.out.println("5.update the book price written by a user");
		System.out.println("6. exit");
		System.out.println("enter your choice:");
		int c=scan.nextInt();
		if(c==1)
		{
			j.insertAuthor();
		}
		else if(c==2)
		{
			j.insertBook();
		}
		else if(c==3)
		{
			j.insertBookAuthor();
		}
		else if(c==4)
		{
			System.out.println("enter the author id:");
			int authorid=scan.nextInt();
			j.getBooksByAuthor(authorid);
		}
		else if(c==5)
		{
			System.out.println("enter the author id:");
			int authorid=scan.nextInt();
			j.updateBook(authorid);
		}
		else if(c==6)
		{
			break;
		}
		}while(true);
	}
}
