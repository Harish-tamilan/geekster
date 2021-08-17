package recursion;

import java.util.*;

public class KPartitionEqualSum {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,k,i;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		int[] arr = new int[n];
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		kPartitionEqualSum(arr,0,n,k,list,new int[k]);
	}

	private static void kPartitionEqualSum(int[] arr, int i, int n, int k, ArrayList<ArrayList<Integer>> list,int[] sum) {
		// TODO Auto-generated method stub
		if(i==n)
		{
			if(list.size()==k)
			{
				boolean bool = true;
				for(int i2=1;i2<k;i2++)
				{
					if(sum[i2]!=sum[i2-1])
					{
						bool = false;
						break;
					}
				}
				if(bool)
					System.out.println(list);
			}
			return;
		}
		
		if(list.size()==0)
		{
			list.add(new ArrayList<Integer>());
			list.get(0).add(arr[i]);
			sum[0] = sum[0]+arr[i];
			kPartitionEqualSum(arr,i+1,n,k,list,sum);
			sum[0] = sum[0]-arr[i];
			list.remove(0);
		}
		
		for(int j=0;j<list.size();j++)
		{
			list.get(j).add(arr[i]);
			sum[j] = sum[j]+arr[i];
			kPartitionEqualSum(arr,i+1,n,k,list,sum);
			list.get(j).remove(list.get(j).size()-1);
			sum[j] = sum[j] - arr[i];
		}
		
		list.add(new ArrayList<Integer>());
		list.get(list.size()-1).add(arr[i]);
		sum[list.size()-1] = sum[list.size()-1]+arr[i];
		kPartitionEqualSum(arr,i+1,n,k,list,sum);
		sum[list.size()-1] -= arr[i];
		list.remove(list.size()-1);
	}

}
