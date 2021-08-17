package priorityqueue;

import java.util.*;

public class PriorityQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1,23,12,9,30,2,50};
//		printKlargest(arr,2);
//	    printKlargestBetter(arr,2);
//		int[] arr ={30,10,40,20,50,70,80,60,110,90,100,120};
//	    almostSorted(arr,2);
		List<List<Integer>> lists = new ArrayList<>();
	    lists.add(new ArrayList<>(Arrays.asList(10,20,30,40,50)));
	    lists.add(new ArrayList<>(Arrays.asList(5,10,15,20,25)));
	    lists.add(new ArrayList<>(Arrays.asList(1,2,3,4,5)));
	    lists.add(new ArrayList<>(Arrays.asList(3,6,9,12)));
	    mergeKSortedLists(lists,lists.size());
	}

	private static void printKlargest(int[] arr, int k) {
		// TODO Auto-generated method stub
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int no:arr)
        {
        	pq.add(no);
        }
        
        for(int i=0;i<k;i++)
        {
        	System.out.print(pq.poll()+", ");
        }
	}

	private static void printKlargestBetter(int[] arr, int k) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int no:arr)
		{
			if(pq.size()<k)
			{
				pq.add(no);
			}
			else
			{
				if(no>pq.peek())
				{
					pq.poll();
					pq.add(no);
				}
			}
		}
		for(int i=0;i<k;i++)
		{
			System.out.print(pq.poll()+", ");
		}
	}
	
	public static void almostSorted(int[]arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<arr.length;i++){
            if(i<k+1){
                pq.add(arr[i]);
            }else{
                arr[i-k-1] = pq.remove();
                pq.add(arr[i]);
            }
        }

        for(int i=arr.length-k-1;i<arr.length;i++){
            arr[i] = pq.remove();
        }

        for(int val:arr){
            System.out.println(val);
        }
    }
	
	public static void mergeKSortedLists(List<List<Integer>> list, int k)
	{
		List<Integer> fin = new ArrayList<>();
		int i=0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(i=0;i<k;i++)
		{
			Pair p = new Pair(i,0,list.get(i).get(0));
			pq.add(p);
		}
		while(!pq.isEmpty())
		{
			Pair temp = pq.remove();
			fin.add(temp.data);
			if(temp.di<list.get(temp.li).size()-1)
			{
				Pair p2 = new Pair();
				p2.di = temp.di+1;
				p2.li = temp.li;
				p2.data = list.get(p2.li).get(p2.di);
				pq.add(p2);
			}
		}
		
		System.out.println(fin);
		
	}
	
	static class Pair implements Comparable<Pair>
	{
		int li;
		int  di;
		int data;
		
		public Pair()
		{
			
		}
		public Pair(int li, int di, int data) {
			super();
			this.li = li;
			this.di = di;
			this.data = data;
		}

		@Override
		public int compareTo(Pair p) {
			// TODO Auto-generated method stub
			return this.data-p.data;
		}
	}
}
