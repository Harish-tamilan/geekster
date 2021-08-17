package recursion;

import java.util.*;

public class PowerBtr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n,pow;
		n = sc.nextInt();
		pow = sc.nextInt();
		System.out.println(powerBtr(n,pow));
		sc.close();
	}

	private static int powerBtr(int n, int pow) {
		// TODO Auto-generated method stub
		if(pow==0)
			return 1;
		int res = powerBtr(n,pow/2);
		if(pow%2==0)
		{
			return res*res;
		}
		else
		{
			return res*res*n;
		}
	}

}
