package exercise;

import java.util.Scanner;

public class Lab6E5 {
	public static boolean check(String s)
	{
		boolean flag=true;
		for(int i=0;i<s.length()-1;i++)
		{
			if(s.charAt(i+1)-s.charAt(i)>0){
				flag=true;
			}
			else 
				return false;
		}
		return flag;
	}
public static void main(String args[])
{
	Scanner scan=new Scanner(System.in);
	System.out.println("enter the string to check:");
	String s=scan.next();
	boolean b=check(s);
	if(b==true)
		System.out.println("String is a positive string");
	else
		System.out.println("string is a negative String");
	
}
}
