package array;

import java.util.*;

public class PainterPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,k,i;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		int[] arr = new int[n];
		for(i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		painterPartition(arr,n,k);
		
	}

	private static void painterPartition(int[] arr, int n, int k) {
		// TODO Auto-generated method stub
		int low=Integer.MIN_VALUE,high=0,i,mid=0;
		for(i=0;i<n;i++)
		{
			if(arr[i]>low)
				low = arr[i];
			high = high + arr[i];
		}
		System.out.println(" Low Initially : "+low+"\n High Initially : "+high+"\n ");
		while(low<high)
		{
			mid = (low+high)/2;
			int nop = calculatePerson(arr,mid);
			
			if(nop>k)
			{
				low = mid+1;
			}
			else
			{
				high = mid;
			}
		}
		
		System.out.println(low);
	}

	private static int calculatePerson(int[] arr, int mid) {
		// TODO Auto-generated method stub
		int count=1,i,sum=0;
		
		System.out.print("Mid : "+mid);
		
		for(i=0;i<arr.length;i++)
		{
			sum=sum+arr[i];
			if(sum>mid)
			{
				sum = arr[i];
				count++;
			}
		}
		
		
		System.out.println(", NOP : "+count+"\n");
		return count;
	}

}
