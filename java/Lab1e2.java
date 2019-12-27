package exercise;

import java.util.Scanner;

public class Lab1e2 {
	
	public static int calculateDifference(int n)
	{
		int sum1=0,sum2=0;
		for(int i=1;i<=n;i++)
		{
			sum1+=Math.pow(i, 2);
			sum2+=i;
		}
		int sum3=(int)Math.pow((double)sum2, 2);
		return(sum1-sum3);
	}

	public static void main(String[] args) {
	
		int n;
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		int sum=calculateDifference(n);
		System.out.println("the required sum is "+sum);

	}
	
}

