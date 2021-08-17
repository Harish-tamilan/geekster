package array;

import java.util.*;

public class EveryElementRepeatedExceptOne {

	// use the x-or operation to find the non-repeated element
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n,i;
		n = sc.nextInt();
		int[] arr = new int[n];
		
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		everyElementRepeatedExceptOne(arr,n);
	}

	private static void everyElementRepeatedExceptOne(int[] arr, int n) {
		// TODO Auto-generated method stub
		int result,i;
		result = arr[0];
		
		for(i=1;i<n;i++)
		{
			result = result^arr[i];
		}
		System.out.println(result);
	}
	
	

}
