package recursion;

import java.util.*;

public class PrintKPC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s,ques="";
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		
		
		printKPC(s,"");
		
	}
	
	public static void printKPC(String ques,String ans)
	{
		if(ques.length()==0)
		{
			System.out.println(ans);
			return;
		}
		
		char c = ques.charAt(0);
		String s = getCode(c);
		String temp = ques.substring(1);
		for(int i=0;i<s.length();i++)
		{
			printKPC(temp,ans+s.charAt(i));
		}
	}
	
	
	
	private static String getCode(char c) {
		// TODO Auto-generated method stub
		
		switch(c)
		{
			case '1': return "abc";
			case '2': return "def";
			case '3': return "ghi";
			case '4': return "jkl";
			case '5': return "mno";
			case '6': return "pqr";
			case '7': return "stu";
			case '8': return "vwx";
			case '9': return "yz";
			case '0': return " ";
			default: return "";
		}
	}

}
