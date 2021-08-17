package stack;

import java.util.*;

public class Util {
	
	public boolean isBalancedParenthesis(String str)
	{
		Stack<Character> stack = new Stack<>();
		char c;
		for(int i=0;i<str.length();i++)
		{
			c = str.charAt(i);
			
			if(c=='{')
			{
				stack.push(c);
			}
			else
			{
				if(stack.isEmpty())
					return false;
				stack.pop();
			}
			
		}
		
		if(stack.size()>0)
			return false;
		
		return true;
	}
	
	public StringBuilder resolvedDirectoryStructure(String s)
	{
		StringBuilder sb = new StringBuilder();
		
		
		String[] arr = s.split("/");
		
		Stack stack = new Stack<String>();
		
		for(String st : arr)
		{
			if(st.equals(".."))
			{
				stack.pop();
			}
			else
			{
				stack.push(st);
			}
		}
		
		while(!stack.isEmpty())
		{
			sb.insert(0, stack.pop()+"/");
		}
		
		sb.deleteCharAt(sb.length()-1);
		
		return sb;
	}

	public List<Integer> nextLargestElement(int[] arr) {
		// TODO Auto-generated method stub
		List<Integer> list = new LinkedList<Integer>();
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(arr[arr.length-1]);
		
		list.add(-1);
		
		for(int i=arr.length-2;i>=0;i--)
		{
			if(stack.peek()>arr[i])
			{
				list.add(0,stack.peek());
				stack.push(arr[i]);
			}
			else
			{
				while(!stack.isEmpty() && stack.peek()<=arr[i] )
				{
					stack.pop();
				}
				if(stack.isEmpty())
				{
					list.add(0,-1);
				}
				else
				{
					list.add(0,stack.peek());
				}
				stack.push(arr[i]);
			}
		}
		
		return list;
	}

	public List<Integer> removeAdjacentElement(int[] arr) {
		// TODO Auto-generated method stub
		List<Integer> list = new LinkedList<>();
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(!stack.isEmpty() && stack.peek()==arr[i])
			{
				stack.pop();
			}
			else
			{
				stack.push(arr[i]);
			}
		}
		
		while(!stack.isEmpty())
		{
			list.add(0,stack.pop());
		}
		return list;
	}

	public void sort(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		
		if(stack.size()==0)
			return;
		
		int temp = stack.pop();
		sort(stack);
		sortHelper(stack,temp);
	}

	private void sortHelper(Stack<Integer> stack, int element) {
		// TODO Auto-generated method stub
		
		if(stack.size()==0 || element>stack.peek())
		{
			stack.push(element);
			return;
		}
		
		int temp = stack.pop();
		sortHelper(stack,element);
		stack.push(temp);
	}

	public List<Integer> stockSpan(int[] arr, int n) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		
		int i,ind;
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		
		for(i=1;i<n;i++)
		{
			ind = stack.peek();
			if(arr[ind]>arr[i])
			{
				list.add(1);
				stack.push(i);
			}
			else
			{
				int temp=0,p;
				while(stack.size()>0 && arr[ind]<=arr[i])
				{
					p = stack.pop();
					temp = i - p+list.get(p);
					if(stack.size()>0)
						ind = stack.peek();
				}
				
				list.add(temp);
				
				stack.push(i);
			}
			System.out.println(stack.arrayList);
		}
		
		return list;
	}

	public int largestAreaHistogram(int[] arr, int n) {
		// TODO Auto-generated method stub
		int max=0,temp=0,i,p,ind;
		
		int[] l = new int[n];
		int[] r = new int[n];
		
		l[0] = 0;
		r[n-1] = n-1;
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		
		for(i=1;i<n;i++)
		{
			p = stack.peek();
			if(arr[p]<arr[i])
			{
				l[i] = p;
				stack.push(i);
			}
			else
			{
				while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
				{
					stack.pop();
				}
				
				if(stack.size()==0)
				{
					l[i] = 0;
				}
				else
				{
					l[i] = stack.peek();
				}
				stack.push(i);
			}
			System.out.println(stack.arrayList);
			
		}
		
		System.out.println("Left min");
		
		for(int no : l)
		{
			System.out.print(no+", ");
		}
		
		stack = new Stack<Integer>();
		stack.push(n-1);
		
		for(i=n-2;i>=0;i--)
		{
			if(arr[stack.peek()]<arr[i])
			{
				r[i] = stack.peek();
				stack.push(i);
			}
			else
			{
				while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
				{
					stack.pop();
				}
				if(stack.isEmpty())
				{
					r[i] = n-1;
				}
				else
				{
					r[i] = stack.peek();
				}
				stack.push(i);
			}
		}
		
		System.out.println("\nRight min");
		
		for(int no: r)
		{
			System.out.print(no+", ");
		}
		
		for(i=0;i<n;i++)
		{
			temp = arr[i]*(r[i]-l[i]-1);
			if(temp>max)
				max = temp;
		}
		
		return max;
	}
	
	public static int largestAreaHistogram2(int[] arr) {
		int[] lb = new int[arr.length];
		int[] rb = new int[arr.length];

//		calculating lb and rb 

		Stack<Integer> st = new Stack<Integer>();
		st.push(0);
		lb[0] = -1;
		for (int i = 1; i < arr.length; i++) {
			while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
				st.pop();
			}

			if (st.size() != 0) {
				lb[i] = st.peek();
			} else {
				lb[i] = -1;
			}
			st.push(i);
			;
		}

		st = new Stack<Integer>();
		st.push(arr.length - 1);
		rb[arr.length - 1] = arr.length;
		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[i] < arr[st.peek()]) {
				st.pop();
			}

			if (st.size() != 0) {
				rb[i] = st.peek();
			} else {
				rb[i] = arr.length;
			}
			st.push(i);
		}

		int maxArea = 0;
		System.out.println("Left min is ");
		for(int i=0;i<lb.length;i++)
			System.out.print(lb[i]+" ");
		
		System.out.println("\nRight min is ");
		for(int i=0;i<lb.length;i++)
			System.out.print(rb[i]+" ");
		
		for (int i = 0; i < arr.length; i++) {
			int area = arr[i] * (rb[i] - lb[i] - 1);

			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
	}
	
	
	public Interval mergeIntervals(List<Interval> li)
	{
		Collections.sort(li);
		System.out.println(li);
		Stack<Interval> stack = new Stack<>();
		Interval intr = new Interval(li.get(0).start,li.get(0).end);
		stack.push(li.get(0));
		
		for(int i=1;i<li.size();i++)
		{
			Interval temp = stack.peek();
			Interval cur = li.get(i);
			if(cur.start<=temp.end)
			{
				if(cur.end>=temp.end)
				{
					intr.end = cur.end;
					
					stack.pop();
					stack.push(intr);
				}
				continue;
			}
			System.out.println(temp.start+"-"+temp.end);
			stack.pop();
			intr.start = cur.start;
			intr.end = cur.end;
			stack.push(intr);
		}
		
		return intr;
	}
	
}


	class Interval implements Comparable<Interval>
	{
		int start;
		int end;
		@Override
		public int compareTo(Interval in) {
			// TODO Auto-generated method stub
			return this.start-in.start;
			 
		}
		
		
		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}


		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
		
		
		
		
	}


