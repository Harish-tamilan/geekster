package contest4;

import java.util.*;

public class GoodPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int i,n,count=0;
		
		n = sc.nextInt();
		
		int[] arr = new int[n];
		
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		
		for(i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
			if(map.containsKey(arr[i]))
			{
				count = count+map.get(arr[i]).size();
				map.get(arr[i]).add(i);
			}
			else
			{
				map.put(arr[i], new ArrayList<Integer>());
				map.get(arr[i]).add(i);
			}
		}
		//System.out.println(map);
		System.out.println(count);
	}

}
