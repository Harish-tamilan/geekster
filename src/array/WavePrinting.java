package array;

import java.util.*;

public class WavePrinting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,r,c,j;
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		
		int[][] arr = new int[r][c];
		
		for(i=0;i<r;i++)
		{
			for(j=0;j<c;j++)
			{
				arr[i][j] = sc.nextInt();			
			}
		}
		
		wavePrinting(arr,r,c);
	}

	private static void wavePrinting(int[][] arr, int r, int c) {
		// TODO Auto-generated method stub
		boolean bool = true;
		
		int i=0,j=0;
		
		while(j<c)
		{
			if(bool)
			{
				for(i=0;i<r;i++)
					System.out.print(arr[i][j]+" ");
			}
			else
			{
				for(i=r-1;i>=0;i--)
					System.out.print(arr[i][j]+" ");
			}
			bool = !bool;
			j++;
			System.out.println();
			
		}
		
		
	}

}
