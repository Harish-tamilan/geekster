package recursion;

import java.util.*;

public class BinaryString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		binaryString(s, new StringBuilder(),0);
	}

	private static void binaryString(String ques, StringBuilder ans,int i) {
		// TODO Auto-generated method stub
		if(ques.length()==i)
		{
			System.out.println(ans);
			return;
		}
		char c = ques.charAt(i);
		
		if(c!='?')
		{
			ans.append(c);
			binaryString(ques,ans,i+1);
			ans.deleteCharAt(ans.length()-1);
		}
		else
		{
			ans.append("0");
			binaryString(ques,ans,i+1);
			ans.deleteCharAt(ans.length()-1);
			ans.append("1");
			binaryString(ques,ans,i+1);
			ans.deleteCharAt(ans.length()-1);
		}
	}

}
