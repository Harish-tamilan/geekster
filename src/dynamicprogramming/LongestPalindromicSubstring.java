package dynamicprogramming;

import java.util.*;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		Scanner sc = new Scanner(System.in);
		s = sc.next();
		
		//longestPalindromicSubstring2(s);
		longestPalindromicSubstring(s);
		
	}
	public static boolean[][] longestPalindromicSubstring2(String str) {
        boolean[][] strg = new boolean[str.length()][str.length()];

        int longestPalinSubstrLen = 0,n=str.length();
        
        System.out.print("  ");
		for(int i=0;i<n;i++)
		{
			System.out.print(str.charAt(i)+" ");
		}
		System.out.println();

        for (int gap = 0; gap < str.length(); gap++) {
            for (int i = 0, j = gap; j < str.length(); i++, j++) {
            	
                if (gap == 0) {
                    strg[i][j] = true;
                    longestPalinSubstrLen = 1;
                } else if (gap == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        strg[i][j] = true;
                        longestPalinSubstrLen = 2;
                    }
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        strg[i][j] = strg[i + 1][j - 1];
                        if (strg[i + 1][j - 1] == true) {
                            longestPalinSubstrLen = j - i + 1;
                        }

                    }
                }
                
                
            }
        }
        for(int i=0;i<n;i++) {
        	System.out.print(str.charAt(i)+" ");
        	for(int j=0;j<n;j++)
        	{
        		if(strg[i][j])
        			System.out.print("T ");
        		else
        			System.out.print("F ");
        	}
        	System.out.println();
        }
        System.out.println(longestPalinSubstrLen);
        return strg;
    }

	private static void longestPalindromicSubstring(String s) {
		// TODO Auto-generated method stub
		int n = s.length(),i,j,k,len=0,start=0,temp;
		boolean[][] arr = new boolean[n][n];
		System.out.print("  ");
		for(i=0;i<n;i++)
		{
			System.out.print(s.charAt(i)+" ");
		}
		System.out.println();
		for(k=0;k<n;k++)
		{
			for(i=0,j=k;j<n;i++,j++)
			{
				if(k==0)
				{
					arr[i][j] = true;
				}
				
				else if(k==1 && s.charAt(i)==s.charAt(j))
				{
					if(arr[i][j-1])
					{
						arr[i][j] = true;
						temp = (j-i);
						if(temp>len)
						{
							len = temp;
							start = i;
						}
					}
				}
				else if(s.charAt(i)==s.charAt(j) && arr[i+1][j-1])
				{
					arr[i][j] = true;
					temp = (j-i);
					if(temp>len)
					{
						len = temp;
						start = i;
					}
				}
			}
		}
		for(i=0;i<n;i++) {
        	System.out.print(s.charAt(i)+" ");
        	for(j=0;j<n;j++)
        	{
        		if(arr[i][j])
        			System.out.print("T ");
        		else
        			System.out.print("F ");
        	}
        	System.out.println();
        }
       
		System.out.println("Len is "+(len));
		System.out.println("Starting index is "+start);
		System.out.println("String is "+s.substring(start,start+len+1));
	}

}
