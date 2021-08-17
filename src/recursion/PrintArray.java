package recursion;

import java.util.*;

public class PrintArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i,n;
		n = sc.nextInt();
		int[] arr = new int[n];
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
		printArray(arr,0);
		sc.close();
	}

	private static void printArray(int[] arr, int i) {
		// TODO Auto-generated method stub
		if(i==arr.length)
			return;
		System.out.print(arr[i]+" ");
		printArray(arr,i+1);
		
	}

}
