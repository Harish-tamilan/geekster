package recursion;

import java.util.*;

public class MaxElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i,n;
		n = sc.nextInt();
		
		int[] arr = new int[n];
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		System.out.println(maxElementInArray(arr,0));
		sc.close();
	}

	private static int maxElementInArray(int[] arr, int i) {
		// TODO Auto-generated method stub
		if(i==arr.length-1)
			return arr[i];
		int max = maxElementInArray(arr,i+1);
		max = Math.max(arr[i], max);
		return max;
	}
	
	
}
