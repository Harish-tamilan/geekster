package recursion;

import java.util.*;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] arr = new boolean[n][n];
		nQueens(arr,0,"");
		
		System.out.println("\n");
		
		
	}

	private static void nQueens(boolean[][] arr, int i, String ans) {
		// TODO Auto-generated method stub
		if(i==arr.length)
		{
			System.out.println("Ans is : " +ans);
			for(int i2=0;i2<arr.length;i2++)
			{
				//System.out.println("Inside i");
				for(int j=0;j<arr.length;j++)
				{
					System.out.print(arr[i2][j]+" ");
				}
				System.out.println();
			}
			return;
		}
		
		for(int j=0;j<arr.length;j++)
		{
			if(isSafe(arr,i,j))
			{
				arr[i][j] = true;
				nQueens(arr,i+1,ans+"["+i+","+j+"]\t");
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

}
