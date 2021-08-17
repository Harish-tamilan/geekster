package contest1;

import java.util.*;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i,n,t,j;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(i=0;i<t;i++)
		{
			n = sc.nextInt();
			int[] arr = new int[n];
			for(j=0;j<arr.length;j++)
			{
				arr[j] = sc.nextInt();
			}
			list.add(func(arr,n));
		}
		
		for(String s:list)
			System.out.println(s);
	}

	private static String func(int[] arr, int n) {
		// TODO Auto-generated method stub
		String s ="";
		int min=Integer.MAX_VALUE;
		int i,j,temp;
		for(i=0;i<n;i++)
		{
			if(min>arr[i])
				min = arr[i];
		}
		//System.out.println("Min is "+min);
		for(i=0;i<n;i++)
		{
			for(j=i+1;j<n;j++)
			{
				int gcd = gcd(arr[i],arr[j]);
				//System.out.println("GCD of "+arr[i]+", "+arr[j]+"is "+gcd);
				if(gcd==min && arr[i]>arr[j])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
//			for(j=0;j<n;j++)
//				System.out.print(arr[j]+" ");
			//System.out.println();
			if(isDecreasing(arr,n))
				return "YES";
		}
		if(isDecreasing(arr,n))
			return "YES";
		
		return "NO";
	}

	private static boolean isDecreasing(int[] arr, int n) {
		// TODO Auto-generated method stub
		int i;
		for(i=1;i<n;i++)
		{
			if(arr[i]<arr[i-1])
				return false;
		}
		return true;
	}

	private static int gcd(int i, int j) {
		// TODO Auto-generated method stub
		int no = Math.min(i, j);
		while(no>=1)
		{
			if(i%no==0 && j%no==0)
				return no;
			no--;
		}
		//System.out.println("GCD of "+i+", "+j+"is "+no);
		return 1;
	}
	
	

}
