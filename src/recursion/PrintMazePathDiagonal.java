package recursion;
import java.util.*;

public class PrintMazePathDiagonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int r,c;
		r = sc.nextInt();
		c = sc.nextInt();
		printMazePathDiagonal(0,0,r-1,c-1,"");
	}

	private static void printMazePathDiagonal(int i, int j, int r, int c, String ans) {
		// TODO Auto-generated method stub
		if(i>r || j>c)
			return;
		if(i==r && j==c)
		{
			System.out.println(ans);
		}
		
		printMazePathDiagonal(i+1,j,r,c,ans+"H");
		printMazePathDiagonal(i,j+1,r,c,ans+"V");
		printMazePathDiagonal(i+1,j+1,r,c,ans+"D");
		
	}

}
