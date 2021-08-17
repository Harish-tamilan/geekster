package dynamicprogramming;

import java.util.*;

public class MaxProfitWithKTransactions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,n,j;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		j = sc.nextInt();
		for(i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println(maxProfit(j,arr));
	}
	
	public static int maxProfit(int k, int[] prices)
	{
		int[][] t = new int[k+1][prices.length];
		int i,j,max;
		
		for(i=1;i<k+1;i++)
		{
			max = -prices[0];
			for(j=1;j<prices.length;j++)
			{
				t[i][j] = Math.max(t[i][j-1], max+prices[j]);
				max = Math.max(max, t[i-1][j]-prices[j]);
			}
		}
		return t[k][prices.length-1];
	}

}
