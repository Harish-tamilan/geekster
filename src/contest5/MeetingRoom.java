package contest5;

import java.util.*;

public class MeetingRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n,i,j,count=0;
		n = sc.nextInt();
		
		List<Pair> list = new ArrayList<Pair>();
		
		for(i=0;i<n;i++)
		{
			list.add(new Pair(sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(list);
		
		int[] arr = new int[n];
		
		Arrays.fill(arr, 1);
		
		int[] end = new int[n];
		
		arr[0] = 1;
		end[0] = list.get(0).end;
		
		for(Pair p : list)
		{
			System.out.println(p.start+" "+p.end);
		}
		
		System.out.println("arr[i] : "+arr[0]+", end[i] : "+end[0]);
		
		for(i=1;i<n;i++)
		{
			for(j=0;j<i;j++)
			{
				if(end[j]<list.get(i).start)
				{
					arr[i] = Math.max(arr[i], arr[j]+1);
					end[i] = Math.max(list.get(i).end, end[j]);
				}
			}
			if(arr[i]>count)
				count=arr[i];
			
			System.out.println("arr[i] : "+arr[i]+", end[i] : "+end[i]);
			
		}
		
		System.out.println(count);
		
	}
	
	static class Pair implements Comparable<Pair>
	{
		int start;
		int end;
		
		
		
		public Pair(int st, int en)
		{
			start = st;
			end = en;
		}

		@Override
		public int compareTo(Pair p) {
			// TODO Auto-generated method stub
			return this.start-p.start;
		}

		@Override
		public String toString() {
			return "Pair [start=" + start + ", end=" + end + "]";
		}	
		
		
	}
}
