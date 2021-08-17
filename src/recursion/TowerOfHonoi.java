package recursion;

import java.util.*;

public class TowerOfHonoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//a is source, b is helper, c is destination
		toh(3,'A','B','C');
	}

	public static void toh(int n, char src, char dest, char help){
		if(n==0){
			return;
		}
		toh(n-1,src,help,dest);
		System.out.println("Move "+n+"th disk from "+src+" to "+dest);
		toh(n-1,help,dest,src);
	}

}
