package recursion;

import java.util.*;

public class GetBoardPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println("The result is");
		System.out.println(getBoardPaths(n,0,""));
		sc.close();
	}

	private static ArrayList<String> getBoardPaths(int n, int ind, String str) {
		// TODO Auto-generated method stub
		if(n==ind)
		{
			System.out.println(str);
			ArrayList<String> list = new ArrayList<String>();
			list.add("\n");
			return list;
		}
		if(ind>n)
		{
			ArrayList<String> list = new ArrayList<String>();
			return list;
		}
		
		ArrayList<String> res = new ArrayList<String>();
		
		for(int i=1;i<=3;++i)
		{
			ArrayList<String> temp = getBoardPaths(n,i+ind,""+i+ind);
			if(temp.size()>0)
				res.add(""+i+ind);
			
		}
		return res;
	}

}
