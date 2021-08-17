package recursion;

import java.util.Scanner;

public class FindElementLastOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i,n,find;
		n = sc.nextInt();
		find = sc.nextInt();
		int[] arr = new int[n];
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		System.out.println(findElementLastOccurence(arr,0,find)+1);
		
		sc.close();
	}

	private static int findElementLastOccurence(int[] arr, int i,int find) {
		// TODO Auto-generated method stub
		if(i==arr.length-1)
			return -1;
		
		int ind = findElementLastOccurence(arr,i+1,find);
		
		if(arr[i]==find)
			ind = i;
		
		return ind;
	}

}
