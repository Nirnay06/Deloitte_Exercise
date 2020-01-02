package exercise;

import java.io.File;

public class Lab6E4 {
	
	public static void main(String args[])
	{
		File f=new File("C:\\Users\\ADMIN\\Desktop\\css\\p1.jpg");
		boolean b1=f.exists();
		boolean b2=f.canRead();
		boolean b3=f.canWrite();
		long b4=f.length();
		
		if(b1==true)
			System.out.println("the file exists");
		else 
			System.out.println("the file doesnt exists");

		
		
		if(b2==true)
			System.out.println("the file is readable ");
		else 
			System.out.println("the file is not readable");

		
		
		if(b3==true)
			System.out.println("the file is writable ");
		else 
			System.out.println("the file is not writable");
		
		
		System.out.println("the length of the file is "+f.length());
	}

}
