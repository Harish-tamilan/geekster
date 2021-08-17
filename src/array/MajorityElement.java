package array;

import java.util.*;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
		majorityElement(arr,n);
	}
	
	public static void majorityElement(int[] arr, int n)
	{
		// Moore's voting algorithm
		
		int i,count=1,ele=arr[0];
		
		for(i=1;i<n;i++)
		{
			if(count==0)
			{
				ele = arr[i];
				continue;
			}
			if(arr[i]==ele)
				count++;
			else
				count--;
			
		}
		
		count=0;
		
		for(int j:arr)
		{
			if(j==ele)
				count++;
		}
		
		if(count>n/2)
			System.out.println(ele);
		else
			System.out.println("-1");
		
	}

}
