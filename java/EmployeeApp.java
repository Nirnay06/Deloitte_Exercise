package exercise;

import java.util.Arrays;

public class EmployeeApp {

	public static void main(String args[])
	{
		Employee[] employees=new Employee[10];
		employees[0]=new Employee(10,"abc","manager");
		employees[1]=new Employee(12,"efg","IT");
		employees[2]=new Employee(33,"hij","CSO");
		employees[3]=new Employee(14,"klm","CEO");
		employees[4]=new Employee(5,"nop","CTO");
		employees[5]=new Employee(66,"qrs","ADMIN");
		employees[6]=new Employee(997,"tuv","MANAGEMENT");
		employees[7]=new Employee(80,"wxy","OFFICER");
		employees[8]=new Employee(9,"zab","osd");
		employees[9]=new Employee(60,"cde","Legal");
		
		
		Arrays.sort(employees);
		
		for(int i=0;i<10;i++)
		{
			System.out.println(employees[i]);
		}
		
		
		
	}
}
