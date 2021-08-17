package hashmap;

import java.util.*;

public class HashMapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = {2,12,9,16,10,5,3,20,25,11,1,8,6};
//		longestSequence(arr);
//		longestSequence2(arr);
//		
//		System.out.println(groupAnagrams(Arrays.asList("cat", "rabbit", "dog", "act", "god")));
		System.out.println(longestUniqueSubstringLength("repeating"));
		System.out.println(longestUniqueSubstringLength2("repeating"));
	}
	
	 public static void longestSequence2(int[] arr){
	        HashMap<Integer,Boolean> map = new HashMap<>();
	        for(int val:arr){
	           map.put(val,false);
	        } 

	        for(int val:arr){
	           if(map.containsKey(val-1)==false){
	              map.put(val,true);
	           }
	        }

	        int sidx = -1;
	        int maxCount = 0;
	        for(int val:arr){
	           int count =1;
	           if(map.get(val)==true){
	              while(map.containsKey(val+count)){
	                 count++;
	              }
	            //   count--;
	              if(count>maxCount){
	                 maxCount = count;
	                 sidx = val;
	              }
	           }
	        }

	        System.out.println(sidx+" "+maxCount);
	     }
	
	public static void longestSequence(int[] arr)
	{
		int count=0,ind=0;
		HashMap<Integer,Boolean> map = new HashMap<>();
		int i,n=arr.length;
		for(int no:arr)
		{
			map.put(no,true);
		}
		for(int no:arr)
		{
			if(map.containsKey(no-1))
				map.replace(no,false);
		}
		System.out.println(map);
		for(int j=0;j<n;j++)
		{
			int no = arr[j];
			i=1;
			
			if(map.get(no))
			{
				while(map.containsKey(no+i))
				{
					i++;
				}
				if(i>count)
				{
					count = i;
					ind = no;
				}
			}
		}
		System.out.println("Ind : "+ind+", len : "+count);
	}
	
	public static List<List<String>> groupAnagrams(List<String> list)
	{
		List<List<String>> res = new ArrayList<List<String>>();
		
		HashMap<HashMap<Character,Integer>,List<String>> main = new HashMap<>();
		
		for(String s:list)
		{
			HashMap<Character,Integer> map = new HashMap<>();
			for(int i=0;i<s.length();i++)
			{
				char c = s.charAt(i);
				if(map.containsKey(c))
				{
					map.replace(c, map.get(c)+1);
				}
				else
				{
					map.put(c, 1);
				}
			}
			if(main.containsKey(map))
			{
				main.get(map).add(s);
			}
			else
			{
				List<String> temp = new ArrayList<>();
				temp.add(s);
				main.put(map, temp);
			}
		}
		//System.out.println(main);
		for(Map.Entry<HashMap<Character,Integer>,List<String>> mp : main.entrySet())
		{
			res.add(mp.getValue());
		}
		return res;
	}
	
	public static int longestUniqueSubstringLength(String s)
	{
		int len=0;
		
		int i,j,start=0,n=s.length();
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
		char c;
		
		int temp=0;
		
		for(i=0;i<n;i++)
		{
			c = s.charAt(i);
			if(map.containsKey(c))
			{
				start = Math.max(map.get(c)+1, start);
				map.replace(c, i);
			}
			else
			{
				map.put(c,i);
			}
			
			len = Math.max(len, i-start+1);
		}
		
		return len;
	}
	
	 public static int longestUniqueSubstringLength2(String string) {
	        
	        int max_length = Integer.MIN_VALUE;
	        int start = 0;
	        HashMap<Character, Integer> hashMap = new HashMap<>();
	        for(int end = 0; end < string.length(); end++) {
	           
	           if(hashMap.containsKey(string.charAt(end))) {
	              start = Math.max(start, hashMap.get(string.charAt(end)) + 1);
	              hashMap.put(string.charAt(end), end);
	           } else {
	              hashMap.put(string.charAt(end), end);
	           }
	           max_length = Math.max(max_length, end-start+1); //6
	           
	        }
	        return max_length;
	     }
	
}
