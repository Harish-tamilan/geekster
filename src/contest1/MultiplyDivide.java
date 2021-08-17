package contest1;

import java.util.*;

public class MultiplyDivide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t,n,i;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(i=0;i<t;i++)
		{
			n = sc.nextInt();
			int count=0;
			
			if(n==1)
			{
				list.add(0);
				continue;
			}
			boolean bool = true;
			while(n>0)
			{
				if(n%6==0)
				{
					n=n/6;
					//System.out.println(n);
					count++;
					if(n==1)
					{
						break;
					}
					continue;
				}
				
				n=n*2;
				if(n<0)
				{
					bool = false;
					break;
				}
				//System.out.println(n);
				count++;
				
			}
			if(bool)
				list.add(count);
			else
				list.add(-1);
		}
		
		for(int j:list)
			System.out.println(j);
	}

	
	

}
