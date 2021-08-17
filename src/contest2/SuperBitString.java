package contest2;

import java.util.*;

public class SuperBitString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n,n2;
		n = sc.nextInt();
		n2 = sc.nextInt();
		
		String s = Integer.toString(n2,2);
		
		//System.out.println(s);
		
		if(s.length()<n)
		{
			while(s.length()<n)
			{
				s = '0'+s;
			}
		}
		
		List<String> list = new ArrayList<>();
	//	System.out.println(s);
		superBitString(s,"",list);
		Collections.sort(list);
		
		for(String st:list)
		{
			System.out.println(st);
		}
		
		
	}

	private static void superBitString(String ques, String ans, List<String> list) {
		// TODO Auto-generated method stub
		
		if(ques.length()==0)
		{
			list.add(ans);
			return;
		}
		else
		{
			char c = ques.charAt(0);
			if(c=='0')
			{
				superBitString(ques.substring(1),ans+'1',list);
			}
//			else
//			{
//				superBitString(ques.substring(1),ans+c,list);
//			}
			superBitString(ques.substring(1),ans+c,list);
		}
		
	}
	
	

}
