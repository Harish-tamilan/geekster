package recursion;

import java.util.*;

public class Recursion {
	
	public void printSubsequence(String ques, String ans)
	{
		if(ques.length()==0)
		{
			System.out.println(ans);
			return;
		}
		printSubsequence(ques.substring(1),ans+ques.charAt(0));
		printSubsequence(ques.substring(1), ans);
	}
	
	public void printPermutation(String ques, String ans)
	{
		if(ques.length()==0)
		{
			System.out.println(ans);
			return;
		}
		for(int i=0;i<ques.length();i++)
		{
			char c = ques.charAt(i);
			String temp = ques.substring(0,i)+ques.substring(i+1,ques.length());
			printPermutation(temp, ans+c);
		}
	}
	
	public void printTargetSubsequence(int ind, int[] arr, String ans, int tar, int sum)
	{
		if(sum==tar)
		{
			System.out.println(ans);
			return;
		}
		if(ind==arr.length)
		{
			return;
		}
		printTargetSubsequence(ind+1, arr, ans, tar, sum);
		sum+=arr[ind];
		printTargetSubsequence(ind+1, arr, ans+","+arr[ind], tar, sum);
	}
	
	public void printMazePath(int i, int j, int r, int c, String ans)
	{
		if(i==r && j==c)
		{
			System.out.println(ans);
			return;
		}
		if(i>r || j>c)
		{
			return;
		}
		
		printMazePath(i+1,j,r,c,ans+'V');
		printMazePath(i,j+1,r,c,ans+'H');
	}
	
	public void nQueens(boolean[][] arr, int i, int j, String ans)
	{
		if(i==arr.length)
		{
			System.out.println(ans);
			return;
		}
		
		for(j=0;j<arr.length;j++)
		{
			if(isSafe(arr,i,j))
			{
				arr[i][j] = true;
				nQueens(arr, i+1, j, ans+"("+i+","+j+") ");
				arr[i][j] = false;
			}
			
		}
	}
	
	private static boolean isSafe(boolean[][] board, int row, int col) {
//		for column
		for (int i = 0; i < row; i++) {
			if (board[i][col] == true) {
				return false;
			}
		}
//		diagonal 1
		int r = row - 1;
		int c = col - 1;
		while (r >= 0 && c >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c--;
		}

//		diagonal 2
		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < board.length) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c++;
		}

		return true;
	}
	
	public void wordBreak(String str, HashSet<String> set, List<String> list)
	{
		if(str.length()==0)
		{
			System.out.println(list);
			list.remove(list.size()-1);
			return;
		}
		for(int i=0;i<=str.length();i++)
		{
			String t = str.substring(0,i);
			if(set.contains(t))
			{
				String temp = str.substring(i);
				list.add(t);
				wordBreak(temp,set,list);
			}
		}
	}

}
