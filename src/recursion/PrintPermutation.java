package recursion;

import java.util.*;

public class PrintPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		printPermutation(s,"");
		sc.close();
	}

	private static void printPermutation(String ques, String ans) {
		// TODO Auto-generated method stub
		if(ques.length()==0)
		{
			System.out.println(ans);
			return;
		}
		
		for(int i=0;i<ques.length();i++)
		{
			printPermutation(ques.substring(0,i)+ques.substring(i+1),ans+ques.charAt(i));
		}
		
		
		
	}
	
	
}
