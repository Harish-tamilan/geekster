package dynamicprogramming;

import java.util.*;

public class CoinChangePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,5};
		System.out.println("\n"+coinChangePermutation(arr,7));
		System.out.println("\n"+coinChangePermutation2(arr,7));
	}

	private static int coinChangePermutation(int[] arr, int sum) {
		// TODO Auto-generated method stub
		int count=0,i,n=arr.length,j;
		HashSet<Integer> set = new HashSet<>();
		for(int no:arr)
			set.add(no);
		
		int[] a = new int[sum+1];
		
		if(set.contains(1))
		{
			a[1] = 1;
		}
		
		for(i=2;i<=sum;i++)
		{
			if(set.contains(i))
				count=1;
			else
				count=0;
			
			for(j=1;j<i;j++)
			{
				if(a[j]>0 && a[i-j]>0)
				{
					//if(a[j]!=a[i-j])
						count += Math.max(a[j],a[i-j]);
				}
			}
			a[i] = count;
		}
		for(i=0;i<=sum;i++)
			System.out.print(i+" ");
		System.out.println();
		for(i=0;i<=sum;i++)
			System.out.print(a[i]+" ");
		return a[sum];
	}
	
	public static int coinChangePermutation2(int[] arr, int target) {
        int[] strg = new int[target + 1];

        strg[0] = 1;
        for (int i = 0; i < strg.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i - arr[j] >= 0) {
                    strg[i] += strg[i - arr[j]];
                }
            }
        }
        
        for(int i=0;i<=target;i++)
			System.out.print(strg[i]+" ");

        return strg[strg.length - 1];
    }


}
