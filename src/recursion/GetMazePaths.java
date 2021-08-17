package recursion;

import java.util.*;

public class GetMazePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getMazePaths(0,0,n-1,n-1));
		/*ans HHVV
		, HVHV
		, HVVH
		, VHHV
		, VHVH
		, VVHH*/
		sc.close();
	}

	private static ArrayList<String> getMazePaths(int cr, int cc, int er, int ec) {
		// TODO Auto-generated method stub
		if(cr==er && cc==ec)
		{
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}
		if(cr>er || cc>ec)
		{
			ArrayList<String> list = new ArrayList<String>();
			
			return list;
		}
		
		ArrayList<String> res = new ArrayList<>();
		ArrayList<String> rh = getMazePaths(cr,cc+1,er,ec);
		for(String s:rh)
		{
			res.add('H'+s);
		}
		
		ArrayList<String> rv = getMazePaths(cr+1,cc,er,ec);
		for(String s:rv)
		{
			res.add('V'+s);
		}
		return res;
	}

}
