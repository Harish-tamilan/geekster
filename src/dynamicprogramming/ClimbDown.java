package dynamicprogramming;

public class ClimbDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbDown(18, new int[19]));
		System.out.println(climbDown(18));
	}

	private static int climbDown(int n, int[] arr) {
		// TODO Auto-generated method stub
		if(n<0)
			return 0;
		if(n==1 || n==0)
			return 1;
		if(arr[n]!=0)
			return arr[n];
		
		arr[n] = climbDown(n-1,arr)+climbDown(n-2,arr)+climbDown(n-3,arr);
		
		return arr[n];
	}
	
	public static int climbDown(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 1 || n == 0) {
            return 1;
        }
        return climbDown(n - 1) + climbDown(n - 2) + climbDown(n - 3);
    }
	
	

}
