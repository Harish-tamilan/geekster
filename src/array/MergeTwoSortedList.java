package array;

import java.util.*;

public class MergeTwoSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i,n,n2;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		n2 = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		for(i=0;i<n;i++)
			list.add(sc.nextInt());
		
		for(i=0;i<n2;i++)
			list2.add(sc.nextInt());
		
		List<Integer> fin = mergeTwoSortedList(list,list2);
		
		System.out.println(fin);
		
	}
	
	public static ArrayList<Integer> mergeTwoSortedList(List<Integer> list, List<Integer> list2)
	{
		ArrayList<Integer> li = new ArrayList<>();
		int p,p2,i;
		
		int n = list.size(), n2 = list2.size();
		
		p = 0;
		p2 = 0;
		
		while(p<n || p2<n2)
		{
			if(p==n)
			{
				li.add(list2.get(p2));
				p2++;
				continue;
			}
			
			if(p2==n2)
			{
				li.add(list.get(p));
				p++;
				continue;
			}
			
			
			if(list.get(p)<list2.get(p2))
			{
				li.add(list.get(p));
				p++;
			}
			else
			{
				li.add(list2.get(p2));
				p2++;
			}
		}
		
		
		return li;
	}

}
