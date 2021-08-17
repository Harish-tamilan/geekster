package recursion;

import java.util.Scanner;

public class PrintReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i,n;
		n = sc.nextInt();
		int[] arr = new int[n];
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
		printReverseArray(arr,0);
		sc.close();
	}

	private static void printReverseArray(int[] arr, int i) {
		// TODO Auto-generated method stub
		if(i==arr.length)
			return;
		printReverseArray(arr,i+1);
		System.out.print(arr[i]+" ");
		
	}

}
