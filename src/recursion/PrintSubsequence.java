package recursion;

import java.util.*;

public class PrintSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		printSubsequence(s,"");
	}

	private static void printSubsequence(String ques,String ans) {
		// TODO Auto-generated method stub
		if(ques.length()==0)
		{
			System.out.println(ans);
			return;
		}
		
		printSubsequence(ques.substring(1),ans+ques.charAt(0));
		printSubsequence(ques.substring(1),ans);
	}

}
