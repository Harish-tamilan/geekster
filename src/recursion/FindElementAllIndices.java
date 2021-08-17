package recursion;

import java.util.Scanner;

public class FindElementAllIndices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i,n,find;
		n = sc.nextInt();
		find = sc.nextInt();
		int[] arr = new int[n];
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		int[] fin = findElementAllIndices(arr,0,find,0);
		
		
		
		for(int j:fin)
		{
			System.out.print((j+1)+" ");
		}
		
		sc.close();
	}

	private static int[] findElementAllIndices(int[] arr, int i, int find,int k) {
		// TODO Auto-generated method stub
		if(i==arr.length)
			return new int[k];
		if(arr[i]==find)
		{
			int[] res = findElementAllIndices(arr,i+1,find,k+1);
			res[k] = i;
			return res;
		}
		else
		{
			int[] res = findElementAllIndices(arr,i+1,find,k);
			return res;
		}
			
	}
	
	
}
