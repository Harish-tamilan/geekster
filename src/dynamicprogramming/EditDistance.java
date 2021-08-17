package dynamicprogramming;

import java.util.Scanner;

public class EditDistance {
	
	public static int editDistance(String s,String s2)
	{
		int i,j,r=s.length(),c=s2.length();
		int[][] arr = new int[r+1][c+1];
		for(i=0;i<=r;i++)
		{
			for(j=0;j<=c;j++)
			{
				if(i==0)
					arr[i][j] = j;
				else if(j==0)
					arr[i][j] = i;
				else
				{
					if(s.charAt(i-1)==s2.charAt(j-1))
					{
						arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1])+1);
					}
					else
					{
						arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1]))+1;
					}
				}
			}
		}
		return arr[r][c];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s,s2;
		s = sc.next();
		s2 = sc.next();
		System.out.println(editDistance(s,s2));
	}

}
