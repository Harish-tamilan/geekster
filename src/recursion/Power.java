package recursion;

import java.util.*;

public class Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n,pow;
		n = sc.nextInt();
		pow = sc.nextInt();
		System.out.println(power(n,pow));
		sc.close();
	}

	private static int power(int n, int pow) {
		// TODO Auto-generated method stub
		if(pow==0)
			return 1;
		int res = n * power(n,pow-1);
		return res;
	}

}
