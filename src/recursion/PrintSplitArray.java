package recursion;

import java.util.*;

public class PrintSplitArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		printSplitArray(arr,0,n,0,0,"","");
	}

	private static void printSplitArray(int[] arr, int i, int n, int sg1, int sg2, String ques, String ans) {
		// TODO Auto-generated method stub
		if(i==n)
		{
			if(sg1==sg2 && sg1!=0)
			{
				System.out.println(ques+" | "+ans);
			}
			return;
		}
		
		
		printSplitArray(arr,i+1,n,sg1,sg2,ques,ans);
		printSplitArray(arr,i+1,n,sg1+arr[i],sg2,ques+" "+arr[i],ans);
		printSplitArray(arr,i+1,n,sg1,sg2+arr[i],ques,ans+" "+arr[i]);
		
	}

}
