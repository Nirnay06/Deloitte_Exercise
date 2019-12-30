package Exception;

import java.util.Scanner;

class EmployeeException extends Exception{
	String msg;
	public EmployeeException()
	{
		
	}
	public EmployeeException(String msg)
	{
		this.msg=msg;
	}
	public String toString(){
		if(msg==null)
		{
			return ("either first name and last name is null ");
		}
		else 
			return msg;
	}
}
class Employee{
	private String fname;
	private String lname;
	
	public Employee(String fname,String lname)
	{
		this.fname=fname;
		this.lname=lname;
	}
	public Employee()
	{
		this.fname=null;
		this.lname=null;
	}
	public Employee(String fname)
	{
		this.fname=fname;
		this.lname=lname;
	}
	public void verify() throws EmployeeException{
		if(fname==null && lname!=null)
		{
			throw new EmployeeException("first name is empty");
		}
		
		if(fname!=null && lname==null)
		{
			throw new EmployeeException("last  name is empty");
		}
		if(fname==null && lname==null)
		{
			throw new EmployeeException("first and last name both are null");
		}
	}
	
}
public class Lab5E4 {
	public static void main(String agrs[])
	{
		String fname;
		String lname;
		Scanner scan=new Scanner(System.in);
		do {
		System.out.println("do you want to enter first name(1/0)");
		byte ch=scan.nextByte();
		 fname=null;
		
		if(ch==1){
		System.out.print("enter the first name:");
		fname=scan.next();
		if(!fname.matches("[A-Z]*[a-z]*"))
		{
			System.out.println("enter a valid first name");
			continue;
		}
		else{
			break;
		}
		}
		}while(true);
		do{
		System.out.println("do you want to enter last name(1/0)");
		byte ch1=scan.nextByte();
		lname=null;
		
		if(ch1==1){
		System.out.print("enter the last name:");
		lname=scan.next();
		if(!lname.matches("[A-Z]*[a-z]*"))
		{
			System.out.println("enter a valid last name");
			continue;
		}
		else {
			break;
		}
		}
		}while(true);
		Employee e=new Employee(fname,lname);
		
		try{
			e.verify();
			System.out.println("\nfirst name is "+fname);
			System.out.println("last name is "+lname);
			System.out.println("user successfully created");
		}
		
		catch(EmployeeException e1)
		{
			System.out.println(e1);
		}
	}

}
