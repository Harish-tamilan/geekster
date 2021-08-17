package contest3;

import java.util.*;



public class LargestAreaHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		int n,i;
		n = sc.nextInt();
		int[] l = new int[n];
		int[] r = new int[n];
		int[] arr = new int[n];
		
		for(i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		stack.push(0);
		
		for(i=1;i<n;i++)
		{
			if(arr[stack.peek()]<arr[i])
			{
				//stack.pop();
				//stack.push(i);
			}
			else
			{
				while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
				{
					stack.pop();
				}
				//stack.push(i);
			}
			if(stack.isEmpty())
			{
				l[i] = 0;
			}
			else
			{
				l[i] = stack.peek();
			}
			stack.push(i);
			//System.out.println(stack.list);
		}
		
		System.out.println("Left min");
		
		for(int no:l)
			System.out.print(no+" ");
		
		stack = new Stack<Integer>();
		r[n-1] = n-1;
		stack.push(n-1);
		
		for(i=n-2;i>=0;i--)
		{
			if(arr[stack.peek()]<arr[i])
			{
				//stack.pop();
				//stack.push(i);
			}
			else
			{
				while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
				{
					stack.pop();
				}
				//stack.push(i);
			}
			if(stack.isEmpty())
			{
				r[i] = n-1;
			}
			else
			{
				r[i] = stack.peek();
			}
			stack.push(i);
			//System.out.println(stack.list);
		}
		System.out.println("\nRight min");
		for(int no:r)
			System.out.print(no+" ");
		
		int temp=0,max=0;
		
		for(i=0;i<n;i++)
		{
			temp = arr[i]*(r[i]-l[i]-1);
			if(temp>max)
				max = temp;
		}
		System.out.println("\n"+max);
	}

}
