package dynamicprogramming;

import java.util.*;

public class GoldMine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mine = {{10, 33, 13, 15},
		         {22, 21, 04, 1},
		         {5, 0, 2, 3},
		         {0, 6, 14, 2}};
		
		int[][] mine2 = {{10, 33, 13, 15},
		         {22, 21, 04, 1},
		         {5, 0, 2, 3},
		         {0, 6, 14, 2}};
		         System.out.println(goldMine(mine));
		         System.out.println(goldMine2(mine2));
	}

	private static int goldMine(int[][] mine) {
		// TODO Auto-generated method stub
		int count=0,i,j,temp=0;
		
		int r=mine.length,c=mine[0].length;
		
		for(i=c-2;i>=0;i--)
		{
			for(j=0;j<r;j++)
			{
				temp = mine[j][i+1];
				if(j>0)
				{
					temp = Math.max(mine[j][i+1], mine[j-1][i+1]);
				}
				if(j<r-1)
				{
					temp = Math.max(temp, mine[j+1][i+1]);
				}
				mine[j][i] += temp;
			}
		}
		for(i=0;i<r;i++)
		{
			count = Math.max(count, mine[i][0]);
		}
		for(i=0;i<r;i++)
        {
        	for(j=0;j<c;j++)
        	{
        		System.out.print(mine[i][j]+" ");
        	}
        	System.out.println();
        }
		return count;
	}
	
	 public static int goldMine2(int[][] gold) {
	        int rowMax = gold.length - 1;
	        int colMax = gold[0].length - 1;
	        int[][] costs = new int[rowMax + 1][colMax + 1];

	        for (int i = 0; i <= rowMax; i++) {
	            costs[i][colMax] = gold[i][colMax];
	        }

	        for (int j = colMax - 1; j >= 0; j--) {
	            for (int i = 0; i <= rowMax; i++) {
	                if (i == 0) {
	                    int max = Math.max(costs[i + 1][j + 1], costs[i][j + 1]);
	                    costs[i][j] = gold[i][j] + max;
	                } else if (i == rowMax) {
	                    int max = Math.max(costs[i - 1][j + 1], costs[i][j + 1]);
	                    costs[i][j] = gold[i][j] + max;
	                } else {
	                    int max = Math.max(costs[i + 1][j + 1], Math.max(costs[i - 1][j + 1], costs[i][j + 1]));
	                    costs[i][j] = gold[i][j] + max;
	                }
	            }
	        }

	        int ans = Integer.MIN_VALUE;
	        for (int i = 0; i <= rowMax; i++) {
	            if (costs[i][0] > ans) {
	                ans = costs[i][0];
	            }
	        }
	        for(int i=0;i<=rowMax;i++)
	        {
	        	for(int j=0;j<=colMax;j++)
	        	{
	        		System.out.print(costs[i][j]+" ");
	        	}
	        	System.out.println();
	        }
	        return ans;
	    }
}
