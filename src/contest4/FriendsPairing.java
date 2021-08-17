package contest4;

import java.util.*;

public class FriendsPairing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s ="";
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1;i<=n;i++)
			s+=i;
		System.out.println(subsequence(s,""));
	}

	private static int subsequence(String ques, String ans) {
		// TODO Auto-generated method stub
		if(ques.length()==0)
			return 1;
		
		char c = ques.charAt(0);
		
		return subsequence(ques.substring(1),ans+c)+subsequence(ques.substring(1),ans);
	}
	
	

}
