package recursion;

import java.util.Scanner;

public class PrintIncreasingDecreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,n2;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		n2 = sc.nextInt();
		
		printIncreasingDecreasing(n,n2);
		sc.close();
	}

	private static void printIncreasingDecreasing(int n, int n2) {
		// TODO Auto-generated method stub
		if(n>n2)
			return;
		System.out.println(n);
		printIncreasingDecreasing(n+1,n2);
		System.out.println(n);
	}

}
