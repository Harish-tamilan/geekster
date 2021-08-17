package contest4;

import java.util.*;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,n,max=Integer.MIN_VALUE,count=0,cur;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		int[] pro = new int[n];
		
		for(i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
			if(arr[i]<0)
				count++;
		}
		
		max = cur = arr[0];
		if(arr[0]<0)
			count--;
		
		System.out.println(count);
		
		for(i=1;i<n;i++)
		{
			if(arr[i]<0)
				count--;
			
			if(count>0 && cur!=0)
			{
				cur = cur*arr[i];
			}
			else
			{
				if(cur*arr[i]>cur)
				{
					cur*=arr[i];
				}
				else
				{
						cur = arr[i];
				}
				System.out.println("else part");
			}
			if(cur>max)
				max = cur;
			System.out.println("cur : "+cur+", max : "+max);
		}
		
		System.out.println(max);
	}

}
