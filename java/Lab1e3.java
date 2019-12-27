package exercise;

import java.util.Scanner;

public class Lab1e3 {
	public static boolean checkNumber(int n)
	{
		String s=Integer.toString(n);
		for(int i=0;i<s.length()-1;i++)
		{
			if(s.charAt(i)<=s.charAt(i+1))
			{
				continue;
			}
			else{
				return false;
			}
			
		}
		return true;
	}
	public static void main(String[] args) {
		
		int n;
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		boolean flag=checkNumber(n);
		if(flag)
		{
			System.out.println("the number is an incresing number");
			
		}
		else
			System.out.println("the numbe is not an incresing number");
	}

}
