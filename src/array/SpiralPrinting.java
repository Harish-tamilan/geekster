package array;

import java.util.Scanner;

public class SpiralPrinting {

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
		
		spiralPrinting(arr,r,c);

	}

	private static void spiralPrinting(int[][] arr, int r, int c) {
		// TODO Auto-generated method stub
		int i=0,j=0,top=0,bottom=r-1,left=0,right=c-1;
		
		while(top<=bottom && left<=right)
		{
			j=top;
			
			while(j<=right)
				System.out.print(arr[top][j++]+" ");
			
			top++;
			
			i=top;
			
			while(i<=bottom)
				System.out.print(arr[i++][right]+" ");
			
			right--;
			
			j = right;
			
			while(j>=left)
				System.out.print(arr[bottom][j--]+" ");
			
			bottom--;
			
			i = bottom;
			
			while(i>=top)
				System.out.print(arr[i--][left]+" ");
			left++;
		}
	}

}
