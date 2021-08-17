package contest3;

import java.util.*;

public class ScoreOfParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char c;
		Stack<Character> stack = new Stack<>();
		int i,temp,res=0;
		
		for(i=0;i<s.length();i++)
		{
			c = s.charAt(i);
			if(c=='(')
			{
				stack.push(c);
			}
			else
			{
				if(stack.peek()=='(')
				{
					stack.pop();
					stack.push((char)1);
					//res = res+1;
				}
				else
				{
					temp =0;
					while(stack.peek()!='(')
					{
						temp = temp+stack.pop();
					}
					stack.pop();
					temp = temp*2;
					stack.push((char)temp);
				}
			}
			
		}
		if(!stack.isEmpty())
		{
			int fin=0;
			while(!stack.isEmpty())
			{
				fin = fin+stack.pop();
			}
			System.out.println(fin);
		}
		else
		{
			System.out.println(res);
		}
	}

}
