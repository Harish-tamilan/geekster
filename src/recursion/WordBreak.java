package recursion;

import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		String arr[] = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", 
				  "and", "cream", "icecream", "man", "go", "mango"};
		
		Scanner sc = new Scanner(System.in);
		
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
		
		//s = sc.next();
		
		wordBreak("ilikeicecreamandmango","",hset);
		
	}

	public static void wordBreak(String ques, String ans, HashSet<String> dictionary) {
		//System.out.println("inside wordbreak");
		if (ques.length() == 0) {
			System.out.println("ans is " + ans);
			return;
		}
		for (int i = 0; i <= ques.length(); i++) {
			String cutString = ques.substring(0, i);
			if (dictionary.contains(cutString)) {
				String restques = ques.substring(i);
				wordBreak(restques, ans + " " + cutString, dictionary);
			}
		}
	}


}
