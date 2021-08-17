package dynamicprogramming;

import java.util.*;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		
		System.out.println(longestIncreasingSubsequence(arr));
	}

	private static int longestIncreasingSubsequence(int[] arr) {
		// TODO Auto-generated method stub
		int len=0,i,j,n=arr.length,temp;
		int[] sub = new int[n];
		sub[0] = 1;
		for(i=1;i<n;i++)
		{
			temp = 0;
			sub[i] = 1;
			for(j=0;j<i;j++)
			{
				if(arr[i]>arr[j])
				{
					temp = Math.max(sub[i], sub[j]+1);
				}
				if(temp>sub[i])
					sub[i] = temp;
			}
		}
		for(int no:sub)
		{
			//System.out.print(no+" ");
			len = Math.max(len, no);
		}
		return len;
	}

}
