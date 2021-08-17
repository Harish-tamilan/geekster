package recursion;

import java.util.*;

public class KPC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(kPC(s));
		sc.close();
	}

	private static ArrayList<String> kPC(String s) {
		// TODO Auto-generated method stub
		if(s.length()==0)
		{
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		}
		
		char c = s.charAt(0);
		String st = getCode(c);
		
		List<String> temp = kPC(s.substring(1));
		ArrayList<String> res = new ArrayList<String>();
		
		for(String str:temp)
		{
			for(int i=0;i<st.length();i++)
			{
				char ch = st.charAt(i);
				res.add(ch+str);
			}
		}
		
		return res;
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
