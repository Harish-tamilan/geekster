package dynamicprogramming;

import java.util.*;

public class MaximumSumNoAdjacent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {5, 5, 10, 100, 10, 5};
		
		System.out.println(maximumSumNoAdjacent(arr));
	}

	private static int maximumSumNoAdjacent(int[] arr) {
		// TODO Auto-generated method stub
		int i;
		int in,ex,temp,n=arr.length;
		in = arr[0];
		ex = 0;
		
		for(i=1;i<n;i++)
		{
			temp = in;
			in = arr[i]+ex;
			ex = temp;
		}
		return Math.max(in, ex);
	}
	
	
}
