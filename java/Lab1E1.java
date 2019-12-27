package exercise;
import java.util.Scanner;

public class Lab1E1 {
	public static boolean checkDivide(int n)
	{
		if(n%3==0 || n%5==0)
		{
			return true;
		}
		return false;
	}

	public static int calculateSum(int n)
	{
		int sum=0;
		for(int i=1;i<=n;i++)
		{
			if(checkDivide(i))
			{
				sum+=i;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		
		int n;
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		int sum=calculateSum(n);
		System.out.println("the required sum is "+sum);
	}

}
