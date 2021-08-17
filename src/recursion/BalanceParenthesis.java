package recursion;

import java.util.*;

public class BalanceParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		Scanner sc = new Scanner(System.in);
		//s = sc.next();
		s = "(()";
		balanceParenthesis(s,"",0,0, s.length());
		
	}

	private static void balanceParenthesis(String ques, String ans, int o, int c, int n) {
		// TODO Auto-generated method stub
		if(c>o)
			return;
		if(o>(n/2))
			return;
		if(ques.length()==0)
		{
			if(o==c)
				System.out.println("Answer is "+ans);
			return;
		}
		char ch = ques.charAt(0);
		if(ch=='(')
			o++;
		else
			c++;
		
		ques = ques.substring(1);
		balanceParenthesis(ques,ans+ch,o,c,n);
		balanceParenthesis(ques,ans,o,c,n);
		
	}

}
