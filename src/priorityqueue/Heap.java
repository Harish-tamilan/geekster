package priorityqueue;

import java.util.*;

public class Heap {
	
	private List<Integer> list = new ArrayList<>();
	boolean isMax;
	
	public void add(int[] arr, boolean bool)
	{
		isMax = bool;
		int p,c;
		list.add(arr[0]);
		for(int i=1;i<arr.length;i++)
		{
			c = i;
			p = (c-1)/2;
			list.add(arr[i]);
			boolean b = isHp(p,c,bool);
			//System.out.println(" For "+arr[i]+", "+b);
			if(!b)
			{
				upHeapify(p,c);
				//upheapify(c);
			}
			//System.out.println(list);
		}
	}
	
	 private void upheapify(int ci) {
	        if (ci == 0) {
	            return;
	        }
	        int pi = (ci - 1) / 2;
	        if (isHP(pi,ci)==false) {
	            swap(pi, ci);
	            upheapify(pi);
	        }
	    }
	 
	private void upHeapify(int p, int c) {
		// TODO Auto-generated method stub
		if(p==0)
		{
			swap(p,c);
			return;
		}
		swap(p,c);
		c = p;
		p = (p-1)/2;
		if(!isHp(p,c,this.isMax))
		{
			upHeapify(p,c);
		}
	}
	
	public void remove()
	{
		swap(0,list.size()-1);
		list.remove(list.size()-1);
		downHeapify(0);
		//downheapify(0);
	}
	
	private void downHeapify(int p) {
		// TODO Auto-generated method stub
		if((2*p+1)>=list.size())
		{
			return;
		}
		int c1 = 2*p+1;
		int c2 = 2*p+2;
		if(c2<list.size())
		{
			if(list.get(c1)>list.get(c2))
			{
				if(!isHp(p,c1,this.isMax))
				{
					swap(p,c1);
					downHeapify(c1);
				}
			}
			else
			{
				if(!isHp(p,c2,this.isMax))
				{
					swap(p,c2);
					downHeapify(c2);
				}
			}
		}
		else
		{
			if(!isHp(p,c1,this.isMax))
			{
				swap(p,c1);
				downHeapify(c1);
			}
		}
	}
	
	 private void downheapify(int pi) {
	        int maxi = pi;
	        int lci = 2 * pi + 1;

	        if (lci < this.list.size() && isHP(maxi,lci)==false) {
	            maxi = lci;
	        }

	        int rci = 2 * pi + 2;
	        if (rci < this.list.size() && isHP(maxi,rci)==false) {
	            maxi = rci;
	        }


	        if (maxi != pi) {
	            swap(pi, maxi);
	            downheapify(maxi);
	        }

	    }
	 public boolean isHP(int pi,int ci){
	        if(isMax==false){
	            return this.list.get(pi)<this.list.get(ci);
	        }else{
	            return this.list.get(pi)>this.list.get(ci);
	        }
	    }
	 
	private void swap(int p, int c) {
		// TODO Auto-generated method stub
		int t = this.list.get(p);
		int t2 = this.list.get(c);
		list.set(p, t2);
		list.set(c, t);
	}

	public boolean isHp(int p, int c, boolean bool)
	{
		if(bool)
			return list.get(p)>=list.get(c);
		else
			return list.get(p)<=list.get(c);
	}
	
	public void display()
	{
		System.out.println(list);
	}

}

//[10, 9, 8, 6, 5, 4, 7, 1]
//[9, 6, 8, 1, 5, 4, 7]

