package dynamicprogramming;

import java.util.*;


public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="AGGTAB",s2="GXTXAYB";
		
		System.out.println(longestCommonSubsequence(s,s2));
	}

	private static int longestCommonSubsequence(String s, String s2) {
		// TODO Auto-generated method stub
		int n=s.length(),n2=s2.length(),i,j;
		int[][] arr = new int[n+1][n2+1];
		arr[0][0] = 1;
		
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n2;j++)
			{
				if(s.charAt(i-1)==s2.charAt(j-1))
				{
					if(i-2>=0 && s.charAt(i-1)==s.charAt(i-2))
						arr[i][j] = arr[i][j-1]+1;
					else
						arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1])+1;
				}
				else
				{
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		
		for(i=0;i<=n2;i++)
		{
			if(i==0)
				System.out.print("    ");
			else
				System.out.print(s2.charAt(i-1)+" ");
		}
		System.out.println();
		for(i=0;i<=n;i++)
		{
			if(i==0)
			{
				System.out.print("  ");
			}
			else
			{
				System.out.print(s.charAt(i-1)+" ");
			}
			for(j=0;j<=n2;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		return arr[n][n2];
	}

}
