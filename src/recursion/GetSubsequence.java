package recursion;

import java.util.*;

public class GetSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s;
		s = sc.next();
		System.out.println(getSubsequence(s));
		sc.close();
	}
	
	public static ArrayList<String> getSubsequence(String s)
	{
		if(s.length()==0)
		{
			ArrayList<String> li = new ArrayList<>();
			li.add("");
			return li;
		}
		
		
		
		char c = s.charAt(0);
		String st = s.substring(1);
		ArrayList<String> res = new ArrayList<String>();
		ArrayList<String> temp = getSubsequence(st);
		
		for(String str:temp)
		{
			res.add(str);
			res.add(c+str);
		}
		
		return res;
	}

}
