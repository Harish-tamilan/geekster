package recursion;

import java.util.*;

public class OddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		oddEven(n);
		sc.close();
	}

	private static void oddEven(int n) {
		// TODO Auto-generated method stub
		
		if(n==0)
			return;
		if(n%2==1)
			System.out.println("Hi "+n);
		oddEven(n-1);
		if(n%2==0)
			System.out.println("Bye "+n);
		
	}
	
	
}
