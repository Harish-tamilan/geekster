package array;

import java.util.*;

public class FindMissingAndRepeatedNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i,n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		findMissingAndRepeatedNumber(arr,n);
		
	}

	private static void findMissingAndRepeatedNumber(int[] arr, int n) {
		// TODO Auto-generated method stub
		
		int i,zero=0,temp,repeated=0,missing=-1,ind=-1,ind2=-1;
		
		for(i=0;i<n;i++)
		{
			temp = Math.abs(arr[i]);
			if(arr[temp-1]<0)
			{
				repeated = temp;
			}
			else
			{
				arr[temp-1] *= -1;
			}
		}
		
		for(i=0;i<n;i++)
		{
			temp = arr[i];
			if(temp>0)
			{
				missing = i+1;
				break;
			}
		}
		
		
		
		System.out.println("\nMissing : "+missing+", Repeated : "+repeated);
		
	}
	
}
