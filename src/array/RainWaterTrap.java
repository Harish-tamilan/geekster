package array;

import java.util.*;

public class RainWaterTrap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i,n;
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		int[] height = new int[n];
		
		for(i=0;i<n;i++)
		{
			height[i] = sc.nextInt();
		}
		
		trap(height,n);
		
		
	}
	
	public static void trap(int[] height, int n)
	{
		int i,sum=0,temp;
		int[] lmax = new int[n];
		int[] rmax = new int[n];
		
		lmax[0] = height[0];
		rmax[n-1] = height[n-1];
		
		for(i=1;i<n;i++)
		{
			lmax[i] = Math.max(lmax[i-1],height[i]);
		}
		
		for(i=n-2;i>=0;i--)
		{
			rmax[i] = Math.max(rmax[i+1], height[i]);
		}
		
		System.out.println("The left max is ");
		
		for(i=0;i<n;i++)
			System.out.print(lmax[i]+" ");
		
		System.out.println();
		
		System.out.println("The right max is ");
		
		for(i=0;i<n;i++)
			System.out.print(rmax[i]+" ");
		
		System.out.println();
		for(i=0;i<n;i++)
		{
			temp = Math.min(lmax[i], rmax[i]);
			if(temp>height[i])
			{
				sum = sum + temp - height[i];
			}
		}
		
		System.out.println(sum);
	}

}
