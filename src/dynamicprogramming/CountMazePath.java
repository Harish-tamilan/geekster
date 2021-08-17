package dynamicprogramming;

public class CountMazePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countMazePath(4,3));
		System.out.println(countMazePath2(4,3));
	}
	
	public static int countMazePath(int r, int c)
	{
		int[][] maze = new int[r+1][c+1];
		int i,j,count=0;
		maze[r][c] = 1;
		maze[r-1][c] = 1;
		maze[r][c-1] = 1;
		for(i=r;i>=0;i--)
		{
			for(j=c;j>=0;j--)
			{
				count=0;
				if(maze[i][j]!=0)
					continue;
				if(i+1<=r)
				{
					count+=maze[i+1][j];
				}
				if(j+1<=c)
				{
					count+=maze[i][j+1];
				}
				maze[i][j] = count;
			}
		}
		return maze[0][0];
	}
	
	 public static int countMazePath2(int dr, int dc) {
	        int[][] strg = new int[dr + 1][dc + 1];
	        for (int i = dr; i >= 0; i--) {
	            for (int j = dc; j >= 0; j--) {
	                if (i == dr && j == dc) {
	                    strg[dr][dc] = 1;
	                } else if (i == dr) {
	                    strg[i][j] = strg[i][j + 1];
	                } else if (j == dc) {
	                    strg[i][j] = strg[i + 1][j];
	                } else {
	                    strg[i][j] = strg[i + 1][j] + strg[i][j + 1];
	                }
	            }
	        }

	        return strg[0][0];
	    }

}
