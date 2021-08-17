package recursion;

public class Sudoko {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] board =  { {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
		         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
		         {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
		         {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
		         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
		         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
		         {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
		         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
		         {0, 0, 5, 2, 0, 6, 3, 0, 0} };
		
		sudoko(board,0,0);
		
		

	}
	
	private static void sudoko(int[][] board, int i, int j) {
		// TODO Auto-generated method stub
		
		if(i>8)
		{
			for(int i2=0;i2<9;i2++)
			{
				for(int j2=0;j2<9;j2++)
				{
					System.out.print(board[i2][j2]+" ");
				}
				System.out.println();
			}
			return;
		}
			
		
		boolean bool = true;
		int no=1;
		
		while(true)
		{
			if(no>9)
				break;
			if(isSafe(board,i,j,no))
			{
				bool = true;
				break;
			}
			no++;
		}
		if(bool)
		{
			board[i][j] = no;
			if(j==8)
			{
				System.out.println();
//					for(int i2=0;i2<9;i2++)
//						System.out.print(board[i][i2]+" ");
				sudoko(board,i+1,0);
				if(board[i][j]<9)
					board[i][j]+=1;
			}
			
			if(i<=8)
			{
				sudoko(board,i,j+1);
				if(board[i][j]<9) 
					board[i][j]+=1;
			}
		}
		sudoko(board,i,j);
		
	}

	private static boolean isSafe(int[][] board, int row, int col, int n) {
//		for column
		int i,j;
		for (i = 0; i < row; i++) {
			if (board[i][col] == n) {
				return false;
			}
		}
//		for row
		for(i=0;i<col;i++)
			if(board[row][i]==n)
				return false;
		
		int r = (row/3)*3, c=(col/3)*3;
		
		for(i=r;i<r+3;i++)
		{
			for(j=c;j<c+3;j++)
			{
				if(board[i][j]==n)
					return false;
			}
		}

		return true;
	}
}
