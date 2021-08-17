package recursion;

import java.util.*;

public class Lexico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		lexico(1,n);
	
	}
	
	private static void lexico(int ind,int n) {
		// TODO Auto-generated method stub
		if(ind>n)
		{
			return;
		}
		
		System.out.println(ind);
		
		for(int i=0;i<10;i++)
		{
			if(ind*10<=n)
			{
				lexico(ind*10+i,n);
			}
		}
		if(ind<9)
		{
		lexico(ind+1,n);
		}
	}
}
