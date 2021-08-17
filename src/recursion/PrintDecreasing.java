package recursion;

import java.util.Scanner;

public class PrintDecreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,n2;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		n2 = sc.nextInt();
		
		printDecreasing(n,n2);
		sc.close();
	}

	private static void printDecreasing(int n, int n2) {
		// TODO Auto-generated method stub
		if(n>n2)
			return;
		printDecreasing(n+1,n2);
		System.out.println(n);
	}

}
