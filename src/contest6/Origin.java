package contest6;

import java.util.*;

public class Origin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Character,Integer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int n,n2,i;
		n = sc.nextInt();
		n2 = sc.nextInt();
		char c;
		for(i=0;i<n;i++)
		{
			c = sc.next().charAt(0);
			if(map.containsKey(c))
				map.replace(c, map.get(c)+1);
			else
				map.put(c,1);
		}
		boolean bool = true;
		for(i=0;i<n2;i++)
		{
			c = sc.next().charAt(0);
			if(map.containsKey(c))
				map.replace(c, map.get(c)-1);
			else
			{
				bool = false;
				break;
			}
			if(map.get(c)==0)
				map.remove(c);
			
		}
		
		if(bool)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}

}
