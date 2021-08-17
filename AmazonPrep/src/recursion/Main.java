package recursion;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recursion r = new Recursion();
		//r.printSubsequence("abcd", "");
		//r.printPermutation("abcd", "");
		int[] arr = {10,20,30,40,5,11,6,9};
		//r.printTargetSubsequence(0, arr, "", 60, 0);
		//r.printMazePath(1, 1, 3, 3, "");
		//r.nQueens(new boolean[4][4], 0, 0, "");
		HashSet<String> hset = new HashSet<>();
		hset.add("i");
		hset.add("like");
		hset.add("sam");
		hset.add("sung");
		hset.add("samsung");
		hset.add("mobiles");
		hset.add("ice");
		hset.add("and");
		hset.add("cream");
		hset.add("icecream");
		hset.add("man");
		hset.add("go");
		hset.add("mango");
		
		r.wordBreak("ilikesamsungmobiles", hset, new ArrayList<>());
	}
}
