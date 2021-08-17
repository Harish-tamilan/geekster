package contest3;

import java.util.*;

class Stack<T>
{
	ArrayList<T> list = new ArrayList<>();
	
	public void push(T c)
	{
		list.add(c);
	}
	
	public T pop()
	{
		return list.remove(list.size()-1);
	}
	
	public T peek()
	{
		return list.get(list.size()-1);
	}
	
	public boolean isEmpty()
	{
		return list.size()==0;
	}
}

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int i,n = s.length();
		char c;
		Stack<Character> stack = new Stack();
		c = s.charAt(0);
		stack.push(c);
		
		for(i=1;i<n;i++)
		{
			c = s.charAt(i);
			
			if(stack.isEmpty())
			{
				stack.push(c);
				continue;
			}
			
			if(stack.peek()==c)
			{
				stack.pop();
			}
			else
			{
				stack.push(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty())
		{
			sb.append(stack.pop());
		}
		
		System.out.println(sb.reverse());
		
	}

}



