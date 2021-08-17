package contest1;

import java.util.*;

public class ValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		char c,temp,temp2;
		
		int i,j,len = s.length();
		
		ArrayList<Character> stack = new ArrayList<>();
		
		boolean bool = true;
		
		for(i=0;i<len;i++)
		{
			c = s.charAt(i);
			if(c=='(' || c=='{' || c=='[')
				stack.add(c);
			else
			{
				if(stack.size()==0)
				{
					bool = false;
					break;
				}
				temp = stack.get(stack.size()-1);
				temp2 = func(c);
				//System.out.println("temp "+temp+", temp2"+temp2+"");
				if(temp==temp2)
					stack.remove(stack.size()-1);
				else
				{
					bool = false;
					break;
				}
			}
			
		}
		if(bool)
			System.out.println(bool);
		else
			System.out.println(bool);
		
	}

	private static char func(char c) {
		// TODO Auto-generated method stub
		
		switch(c)
		{
		case ')':return '(';
		case '}':return '{';
		case ']':return '[';
		default :return '.';
		}
	}

}
