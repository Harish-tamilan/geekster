package recursion;

import java.util.*;

public class FindLastOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int i,n,k;
		n = sc.nextInt();
		k = sc.nextInt();
		int[] arr = new int[n];
		
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		System.out.println(findLastOccurence(arr,0,k));
		sc.close();
	}

	private static int findLastOccurence(int[] arr, int i, int k) {
		// TODO Auto-generated method stub
		if(i==arr.length)
			return -1;
	
		int ind = findLastOccurence(arr, i+1, k);
		
		if(ind==-1)
		{
			if(arr[i]==k)
				return i;
			else
				return ind;
		}
		else
		{
			return ind;
		}
		
	}
	
	
}
