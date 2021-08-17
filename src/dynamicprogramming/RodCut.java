package dynamicprogramming;

import java.util.*;

public class RodCut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 3, 5, 6, 15, 17, 25, 24, 48 };
		System.out.println(rodCut(arr, arr.length));
		System.out.println(rodCutting(arr));
	}
	
	public static int rodCut(int[] arr, int n)
	{
		int fin=0;
		int i,j,temp;
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
		sum[1] = arr[1];
		for(i=2;i<n;i++)
		{
			temp = 0;
			sum[i] = arr[i];
			for(j=1;j<i;j++)
			{
				temp = sum[j]+sum[i-j];
				sum[i] = Math.max(sum[i], temp);
			}
		}
		for(int no:sum)
			System.out.print(no+" ");
		System.out.println();
		return sum[n-1];
	}
	
	public static int rodCutting(int[] rod) {
        int[] strg = new int[rod.length];

        strg[0] = rod[0];
        strg[1] = rod[1];

        for (int i = 2; i < rod.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1, c = i - 1; j <= c; j++, c--) {
                max = Math.max(max, strg[j] + strg[c]);
            }

            if (rod[i] > max) {
                max = rod[i];
            }

            strg[i] = max;
        }

        return strg[strg.length - 1];
    }

}
