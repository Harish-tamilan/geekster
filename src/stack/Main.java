package stack;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//String s = sc.next();
		
		Util util = new Util();
		
		//System.out.println(util.isBalancedParenthesis(s));
		
		//System.out.println(util.resolvedDirectoryStructure(s));
		
		int[] arr = {3,1,3,2,2 };
		
		//System.out.println(util.nextLargestElement(arr));
		
		//System.out.println(util.removeAdjacentElement(arr));
		
		//sorting using stack
//		Stack<Integer> stack = new Stack<>();
//		
//		for(int i:arr)
//		{
//			stack.push(i);
//		}
//		
//		util.sort(stack);
//		
//		List<Integer> list = new LinkedList<>();
//		while(stack.size()>0)
//		{
//			list.add(0,stack.pop());
//		}
//		System.out.println(list);
		
		//System.out.println(util.stockSpan(arr,arr.length));
		
		System.out.println("\n"+util.largestAreaHistogram(arr,arr.length));
		
		System.out.println("\n"+util.largestAreaHistogram2(arr));
		
//		List<Interval> li = new ArrayList<>();
//		li.add(new Interval(6,8));
//		li.add(new Interval(9,15));
//		li.add(new Interval(2,5));
//		li.add(new Interval(5,7));
//		
//		Interval in = util.mergeIntervals(li);
//		System.out.println(in.start+"-"+in.end);
		
	}
	
	

}
