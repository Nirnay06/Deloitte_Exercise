package lab6;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SumToken {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter n values");
		String val=sc.nextLine();
		StringTokenizer st = new StringTokenizer(val);
		int sum=0,temp;
		while(st.hasMoreTokens())
		{
			temp=Integer.parseInt(st.nextToken());
			System.out.println(temp);
			sum=sum+temp;
		}
		System.out.println("sum="+sum);
	}

}
