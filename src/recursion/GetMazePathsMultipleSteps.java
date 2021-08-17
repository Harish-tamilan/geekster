package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathsMultipleSteps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getMazePathsMultipleSteps(0,0,n-1,n-1));
		sc.close();
	}
	
	private static ArrayList<String> getMazePathsMultipleSteps(int cr, int cc, int er, int ec) {
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
		for(int i=1;i<=ec;i++)
		{
			ArrayList<String> rh = getMazePathsMultipleSteps(cr,cc+i,er,ec);
			for(String s:rh)
			{
				res.add("H"+i+s);
			}
			
		}
		
		for(int i=1;i<=er;i++)
		{
			ArrayList<String> rv = getMazePathsMultipleSteps(cr+i,cc,er,ec);
			for(String s:rv)
			{
				res.add("V"+i+s);
			}
			
		}
		
		for(int i=1,j=1;i<=ec&&j<=er;i++,j++)
		{
			ArrayList<String> rd = getMazePathsMultipleSteps(cr+j,cc+i,er,ec);
			for(String s:rd)
			{
				res.add("D"+i+s);
			}
			
		}
		return res;
	}

}
