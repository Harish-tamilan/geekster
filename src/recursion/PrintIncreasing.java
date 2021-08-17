package recursion;

import java.util.*;

public class PrintIncreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n,n2;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		n2 = sc.nextInt();
		
		printIncreasing(n,n2);
		sc.close();
	}

	private static void printIncreasing(int n, int n2) {
		// TODO Auto-generated method stub
		if(n>n2)
			return;
		System.out.println(n);
		printIncreasing(n+1,n2);
	}

}
