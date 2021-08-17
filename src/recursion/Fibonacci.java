package recursion;

import java.util.*;


public class Fibonacci {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(fibonacci(n));
		sc.close();
	}

	private static int fibonacci(int n) {
		// TODO Auto-generated method stub
		if(n==0 || n==1)
			return n;
		int fib = fibonacci(n-1);
		int fib2 = fibonacci(n-2);
		
		int sum = fib+fib2;
		
		return sum;
	}

}
