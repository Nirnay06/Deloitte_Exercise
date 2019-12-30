package Exception;

import java.util.Scanner;

class Person{
	int age;
	public Person(int age)
	{
		this.age=age;
	}
	public String toString()
	{
		return "the age of the person is "+age;
	}
	public static void verify(int age) throws PersonException{
		if(age<15)
		{
			throw new PersonException("the age enter is not valid");
		}
		else
		{
			System.out.println("the age entered is valid, age is "+age);
		}
	}
}

 class PersonException extends Exception{
	String msg;
	public PersonException(){
		
	}
	public PersonException(String msg){
		this.msg=msg;
	}
	public String toString(){
		if(msg==null)
		{
			return ("the age is not valid");
		}
		else
			return msg;
	}
}
 
 
 public class Lab5E5{
	 public static void main(String args[])
	 {
		 Scanner scan=new Scanner(System.in);
		 int age=scan.nextInt();
		 Person p=new Person(age);
		 try{
		 	p.verify(age);
		 }
		 catch(Exception e)
		 {
		 	System.out.println(e);
		 }
	 }
 }