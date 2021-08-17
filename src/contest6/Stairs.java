package contest6;

import java.util.*;

public class Stairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i,count,j,sum=0;
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		int[] arr = new int[n];
		List<Integer> list = new ArrayList<>();
		
		for(i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
			j=1;
			sum=0;
			while(true)
			{
				if(sum>=arr[i])
				{
					break;
				}
				j++;
				sum+=j;
			}
			list.add(j-1);
		}
		System.out.println(list);
	}
}
