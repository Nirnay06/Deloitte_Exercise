package exercise;

import java.util.Arrays;

public class StudentApp {

	public static void main(String[] args) {
		Student []students=new Student[3];
		
		students[0]=new Student(101,"Gargesh","EEE");
		students[1]=new Student(123,"Uttam","IT");
		students[2]=new Student(161,"Neel","CS");
		
		Arrays.sort(students);
		for(int i=0;i<students.length;i++)
			System.out.println(students[i]);	
		

	}

}
