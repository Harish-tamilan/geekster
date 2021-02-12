package com.arrays;

import java.util.*;

public class KCON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,t,n,k,j;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(i=1;i<=t;i++)
		{
			n = sc.nextInt();
			k = sc.nextInt();
			
			int[] arr = new int[n];
			
			for(j=0;j<n;j++)
			{
				arr[j] = sc.nextInt();
				//System.out.print(arr[]);
			}
			
			int[] fin = new int[n*k];
			
			
			
			for(i=0,j=0;i<n*k;i++) {
				
				fin[i] = arr[j++];
				if(j==n)
					j=0;
				
			}
			System.out.print(kCON(fin,n*k)+" ");
		}
	}

	private static int kCON(int[] fin, int n) {
		// TODO Auto-generated method stub
		int sum=fin[0],temp=fin[0];
		for(int i=1;i<n;i++)
		{
			if((temp+fin[i])<fin[i])
			{
				temp = fin[i];
			}
			else
			{
				temp = temp+fin[i];
			}
			sum = Math.max(sum, temp);
		}
		return sum;
	}

}
