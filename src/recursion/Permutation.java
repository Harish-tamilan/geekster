package recursion;

import java.util.*;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		permutation(n+"","");
	}

	private static void permutation(String ques, String ans) {
		// TODO Auto-generated method stub
		
		if(ques.length()==0)
		{
			System.out.println(ans);
			return;
		}
		
		for(int i=0;i<ques.length();i++)
		{
			char c = ques.charAt(i);
			permutation(ques.substring(0,i)+ques.substring(i+1),ans+c);
		}
		
	}

}
