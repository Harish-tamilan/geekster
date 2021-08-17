package recursion;

import java.util.*;

public class PrintTargetSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n,i,k;
		n = sc.nextInt();
		k = sc.nextInt();
		int[] arr = new int[n];
		for(i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		printTargetSubsequence(arr,0,n,k,"");
	}

	private static void printTargetSubsequence(int[] arr, int i, int n, int k, String ans) {
		// TODO Auto-generated method stub
		if(i==n)
		{
			if(k==0)
			{
				System.out.println("The subsequence is " + ans);
				return;
			}
			else
			{
				return;
			}
		}
		
		printTargetSubsequence(arr,i+1,n,k-arr[i],ans+arr[i]);
		printTargetSubsequence(arr,i+1,n,k,ans);
	}

}
