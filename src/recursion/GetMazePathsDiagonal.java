package recursion;

import java.util.*;

public class GetMazePathsDiagonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getMazePathsDiagonal(0,0,n-1,n-1));
		sc.close();
	}
	
	private static ArrayList<String> getMazePathsDiagonal(int cr, int cc, int er, int ec) {
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
		ArrayList<String> rh = getMazePathsDiagonal(cr,cc+1,er,ec);
		for(String s:rh)
		{
			res.add('H'+s);
		}
		
		
		ArrayList<String> rv = getMazePathsDiagonal(cr+1,cc,er,ec);
		for(String s:rv)
		{
			res.add('V'+s);
		}
		
		ArrayList<String> rd = getMazePathsDiagonal(cr+1,cc+1,er,ec);
		for(String s:rd)
		{
			res.add('D'+s);
		}
		return res;
	}

}
