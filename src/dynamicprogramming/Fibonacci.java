package dynamicprogramming;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(41));
		System.out.println(fib(41, new int[42]));
	}

	public static int fib(int i) {
		// TODO Auto-generated method stub
		if(i==1 || i==2)
			return i-1;
		int ans = fib(i-1)+fib(i-2);
		return ans;
	}
	
	public static int fib(int i, int[] arr)
	{
		if(i==1 || i==2)
			return i-1;
		if(arr[i]!=0)
			return arr[i];
		arr[i] = fib(i-1,arr)+fib(i-2,arr);
		return arr[i];
	}
	

}
