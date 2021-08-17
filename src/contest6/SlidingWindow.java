package contest6;

import java.util.*;

public class SlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		int n,k,i;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		for(i=0;i<n;i++)
		{
			if(i<k)
			{
				q.add(arr[i]);
			}
			else
			{
				System.out.print(q.peek()+" ");
				q.remove(arr[i-k]);
				q.add(arr[i]);
			}
		}
		System.out.println(q.peek());
	}

}
