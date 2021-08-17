package dynamicprogramming;

import java.util.*;

public class MaximumLengthBinaryStringWithoutAdjacentZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println(maximumLengthBinaryStringWithoutAdjacentZero(n));
		System.out.println(new Fibonacci().fib(n+1));
	}

	private static int maximumLengthBinaryStringWithoutAdjacentZero(int n) {
		// TODO Auto-generated method stub
		int zero = 1, one = 1,i,temp;
		
		for(i=2;i<=n;i++)
		{
			temp = zero;
			zero = one;
			one = one+temp;
		}
		return one+zero;
	}

}
