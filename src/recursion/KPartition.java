package recursion;

import java.util.*;

public class KPartition {

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
		
		kPartition(arr,0,n,k,list);
	}

	private static void kPartition(int[] arr, int i, int n, int k, ArrayList<ArrayList<Integer>> list) {
		// TODO Auto-generated method stub
		if(i==n)
		{
			if(list.size()==k)
				System.out.println(list);
			return;
		}
		
		if(list.size()==0)
		{
			list.add(new ArrayList<Integer>());
			list.get(0).add(arr[i]);
			kPartition(arr,i+1,n,k,list);
			list.remove(0);  
		}
		
		for(int j=0;j<list.size();j++)
		{
			list.get(j).add(arr[i]);
			kPartition(arr,i+1,n,k,list);
			list.get(j).remove(list.get(j).size()-1);
		}
		
		list.add(new ArrayList<Integer>());
		list.get(list.size()-1).add(arr[i]);
		kPartition(arr,i+1,n,k,list);
		list.remove(list.size()-1);
	}
}
