package Exception;

import java.util.Scanner;

class Employee1{
	private int id;
	private String name;
	private int salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee1(int id, String name, int salary) {
		
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public String toString(){
		return "[employee: id = "+id+", name = "+name+", salary = "+salary+" ]";
	}
	public void verify() throws EmployeeException{
		if(salary<3000)
		{
			throw new EmployeeException("the salary is not valid");
		}
		else
			System.out.println(this);
	}
}

class EmployeeException extends Exception{
	String msg;
	public EmployeeException(){
		
	}
	public EmployeeException(String msg)
	{
		this.msg=msg;
	}
	public String toString(){
		if(msg==null)
		{
			return ("the salary is not valid");
		}
		else
			return msg;
	}
}
public class Lab5E6 {
public static void main(String args[])
{
	Scanner scan =new Scanner(System.in);
	System.out.println("enter the id:");
	int id=scan.nextInt();
	System.out.println("enter the name:");
	String name=scan.next();
	System.out.println("enter the salary:");
	int salary=scan.nextInt();
	
	Employee1 e=new Employee1(id, name, salary);
	try{
		e.verify();
	}
	catch(EmployeeException e1)
	{
		System.out.println(e1);
	}
}
}
