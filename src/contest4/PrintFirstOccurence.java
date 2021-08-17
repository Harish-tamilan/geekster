package contest4;

import java.util.*;

public class PrintFirstOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int t,n,i,j;
		t = sc.nextInt();
		List<StringBuilder> list = new ArrayList<>();
		
		for(i=0;i<t;i++)
		{
			
			String s = sc.next();
			HashSet<Character> set = new HashSet<>();
			
			char c;
			StringBuilder sb = new StringBuilder();
			
			for(j=0;j<s.length();j++)
			{
				c = s.charAt(j);
				if(set.contains(c))
					continue;
				else
				{
					sb.append(c);
					set.add(c);
				}
			}
			
			list.add(sb);
			
		}
		
		for(StringBuilder st:list)
			System.out.println(st);
	}

}
