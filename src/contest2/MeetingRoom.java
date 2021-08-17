package contest2;

import java.util.*;

public class MeetingRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		
		int i;
		for(i=0;i<n;i++)
		{
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		int[] res = new int[n];
		int[][] temp = new int[n][2];
		
		temp[0][0] = arr[0][0];
		temp[0][1] = arr[0][1];
		
		res[0] = 1;
		
		
	}
}
