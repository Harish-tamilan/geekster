package recursion;

import java.util.*;

public class PrintMazePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int r,c;
		r = sc.nextInt();
		c = sc.nextInt();
		printMazePath(0,0,r-1,c-1,"");
	}

	private static void printMazePath(int i, int j, int r, int c, String ans) {
		// TODO Auto-generated method stub
		if(i>r || j>c)
			return;
		if(i==r && j==c)
		{
			System.out.println(ans);
		}
		
		printMazePath(i+1,j,r,c,ans+"H");
		printMazePath(i,j+1,r,c,ans+"V");
		
	}

}
