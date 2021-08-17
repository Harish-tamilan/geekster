package dynamicprogramming;

import java.util.*;

public class TargetSumSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,1,5,6,8,9};
		int sum = 7;
		System.out.println(targetSumSubset(arr,sum));
		System.out.println(TargetSumSubset(arr,sum));
	}

	private static boolean targetSumSubset(int[] arr, int sum) {
		// TODO Auto-generated method stub
		int i,n=arr.length,j;
		boolean[][] mat = new boolean[n+1][sum+1];
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=sum;j++)
			{
				if(mat[i-1][j])
				{
					mat[i][j] = true;
				}
				else if(j-arr[i-1]>=0 && mat[i][j-arr[i-1]] )
				{
					if(Math.abs(j-arr[i-1])!=arr[i-1])
						mat[i][j] = true;
				}
				else if(j==arr[i-1])
				{
					mat[i][j] = true;
				}
			}
		}
		for(i=0;i<=n;i++)
		{
			for(j=0;j<=sum;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		return mat[n][sum];
	}
	 public static boolean TargetSumSubset(int[] arr, int target) {
	        boolean[][] strg = new boolean[arr.length + 1][target + 1];
	        for (int i = 0; i < strg.length; i++) {
	            for (int j = 0; j < strg[0].length; j++) {
	                if (i == 0 && j == 0) {
	                    strg[i][j] = true;
	                } else if (i == 0) {
	                    strg[i][j] = false;
	                } else if (j == 0) {
	                    strg[i][j] = true;
	                } else {
	                    if (strg[i - 1][j]) {
	                        strg[i][j] = true;
	                    } else {
	                        if (j - arr[i - 1] >= 0) {
	                            strg[i][j] = strg[i - 1][j - arr[i - 1]];
	                        }
	                    }
	                }
	            }
	        }
	        for(int i=0;i<strg.length;i++)
	        {
	        	for(int j=0;j<strg[0].length;j++)
	        	{
	        		System.out.print(strg[i][j]+" ");
	        	}
	        	System.out.println();
	        }
	        return strg[strg.length - 1][strg[0].length - 1];
	    }
}
