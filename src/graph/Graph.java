package graph;

import java.util.*;

public class Graph {
	
	HashMap<String,HashMap<String,Integer>> map = new HashMap<>();
	
	public boolean containsVertex(String s)
	{
		return map.containsKey(s);
	}
	
	public void addVertex(String s)
	{
		if(!containsVertex(s))
		{
			map.put(s,new HashMap<>());
		}
	}
	
	public boolean containsEdge(String s, String s2)
	{
		if(map.containsKey(s)&&map.containsKey(s2))
		{
			return map.get(s).containsKey(s2);
		}
		return false;
	}
	
	public void addEdge(String s, String s2, int n)
	{
		if(map.containsKey(s)&&map.containsKey(s2))
		{
			map.get(s).put(s2,n);
			map.get(s2).put(s,n);
		}
	}
	
	public int countVertices(){
        return map.size();
    }

    public int countEdges(){
        ArrayList<String> vnames = new ArrayList<>(map.keySet());
        int count =0;
        for(String vname:vnames){
            count+= map.get(vname).size();
        }

        return count/2;
    }

    public void removeEdge(String v1name,String v2name){
        if(containsEdge(v1name, v2name)){
            map.get(v1name).remove(v2name);
            map.get(v2name).remove(v1name);
        }
    }

    public void removeVertex(String vname){
        if(containsVertex(vname)){
            ArrayList<String> nbrs = new ArrayList<>(map.get(vname).keySet());
            for(String nbr:nbrs){
                removeEdge(nbr, vname);
            }
            map.remove(vname);
        }
    }

    public void display(){
        System.out.println("----------------------------------------");
        ArrayList<String> vnames = new ArrayList<>(map.keySet());

        for(String vname:vnames){
            System.out.println(vname+"-"+map.get(vname));
        }
    }
    
    public boolean hasPath(String src, String dest, String path, HashSet<String> visited)
    {
    	if(src.equals(dest))
    	{
    		path+=src;
    		System.out.println(path);
    		return true;
    	}
    	path+=src;
    	visited.add(src);
    	boolean bool=false;
    	for(String s : map.get(src).keySet())
    	{
    		if(!visited.contains(s))
    			bool = hasPath(s,dest,path,visited);
    		if(bool)
    		{
    			return bool;
    		}
    	}
    	return bool;
    }
    
    private static String smallestPath = "";
    private static int minimumWeight = Integer.MAX_VALUE;
    
    public void printSmallestPW(String source, String destination) {
        HashSet<String> visited = new HashSet<>();
        smallestPath = "";
        minimumWeight = Integer.MAX_VALUE;
        printSmallestPW(source, destination, visited, source, 0);
        System.out.println(smallestPath + "->" + minimumWeight);
    }

	private void printSmallestPW(String src, String dest, HashSet<String> visited, String ans, int wt) {
		// TODO Auto-generated method stub
		if(src.equals(dest))
		{
			if(wt<minimumWeight)
			{
				minimumWeight = wt;
				smallestPath = ans;
			}
			return;
		}
		visited.add(src);
		for(String s : map.get(src).keySet())
		{
			if(!visited.contains(s))
			{
				printSmallestPW(s,dest,visited,ans+s,wt+map.get(src).get(s));
			}

		}
		visited.remove(src);
	}
	
	static class Pair
	{
		String v;
		String p;
		int wt;
		public Pair(String v, String p, int wt) {
			super();
			this.v = v;
			this.p = p;
			this.wt = wt;
		}
		
	}
	
	public void bfs(String src, String dest)
	{
		Pair pair = new Pair(src,src,0);
		Queue<Pair> queue = new LinkedList<>();
		queue.add(pair);
		HashSet<String> visited = new HashSet<>();
		while(!queue.isEmpty())
		{
			Pair temp = queue.poll();
			System.out.println(temp.v+"@"+temp.p+"->"+temp.wt);
			visited.add(temp.v);
			if(temp.v.equals(dest))
				return;
			for(String s : map.get(temp.v).keySet())
			{
				if(!visited.contains(s))
				{
					queue.add(new Pair(s,temp.p+s,temp.wt+map.get(temp.v).get(s)));
				}
			}
		}
	}
	
	public void dfs(String src, String dest)
	{
		Pair pair = new Pair(src,src,0);
		Stack<Pair> stack = new Stack<>();
		stack.push(pair);
		HashSet<String> visited = new HashSet<>();
		while(!stack.isEmpty())
		{
			Pair temp = stack.pop();
			System.out.println(temp.v+"@"+temp.p+"->"+temp.wt);
			visited.add(temp.v);
			if(temp.v.equals(dest))
				return;
			for(String s : map.get(temp.v).keySet())
			{
				if(!visited.contains(s))
				{
					stack.push(new Pair(s,temp.p+s,temp.wt+map.get(temp.v).get(s)));
				}
			}
		}
	}
	
	private class Tpair {
        String v;
        String p;
        int w;

        public Tpair(String v, String p, int w) {
            this.v = v;
            this.p = p;
            this.w = w;
        }
    }

    public boolean bfs2(String s, String d) {
        Tpair pair = new Tpair(s, s, 0);

        HashSet<String> visited = new HashSet<>();
        LinkedList<Tpair> q = new LinkedList<>();
        q.addLast(pair);
        while (q.size() > 0) {
            Tpair rem = q.removeFirst();
            visited.add(rem.v);
            System.out.println(rem.v + "@" + rem.p);
            if (rem.v.equals(d)) {
                return true;
            }
            for (String n : map.get(rem.v).keySet()) {
                if (visited.contains(n) == false) {
                    Tpair npair = new Tpair(n, rem.p + n, rem.w + map.get(rem.v).get(n));
                    q.addLast(npair);
                }
            }
        }

        return false;
    }

    public boolean dfs2(String s, String d) {
        Tpair pair = new Tpair(s, s, 0);

        HashSet<String> visited = new HashSet<>();
        LinkedList<Tpair> stack = new LinkedList<>();
        stack.addFirst(pair);
        while (stack.size() > 0) {
            Tpair rem = stack.removeFirst();
            visited.add(rem.v);
            System.out.println(rem.v + "@" + rem.p);
            if (rem.v.equals(d)) {
                return true;
            }
            for (String n : map.get(rem.v).keySet()) {
                if (visited.contains(n) == false) {
                    Tpair npair = new Tpair(n, rem.p + n, rem.w + map.get(rem.v).get(n));
                    stack.addFirst(npair);
                }
            }
        }

        return false;
    }
    
    public void gcc()
    {
    	//Tpair pair = new Tpair("A", "A", 0);

        HashSet<String> visited = new HashSet<>();
        
        for(String s : map.keySet())
        {
        	if(visited.contains(s))
        	{
        		continue;
        	}
        	Tpair pair = new Tpair(s, s, 0);
        	LinkedList<Tpair> stack = new LinkedList<>();
            stack.addFirst(pair);
	        while (stack.size() > 0) {
	            Tpair rem = stack.removeFirst();
	            if(visited.contains(rem.v))
	            	continue;
	            visited.add(rem.v);
	            System.out.print(rem.v);
	           
	            for (String n : map.get(rem.v).keySet()) {
	                if (visited.contains(n) == false) {
	                    Tpair npair = new Tpair(n, rem.p + n, rem.w + map.get(rem.v).get(n));
	                    stack.addFirst(npair);
	                }
	            }
	        }
	        System.out.println();
        }
    }
    
    public boolean isCycle()
    {
    	HashSet<String> visited = new HashSet<>();
        
        for(String s : map.keySet())
        {
        	if(visited.contains(s))
        	{
        		continue;
        	}
        	Tpair pair = new Tpair(s, s, 0);
        	LinkedList<Tpair> stack = new LinkedList<>();
            stack.addFirst(pair);
	        while (stack.size() > 0) {
	            Tpair rem = stack.removeFirst();
	            
	            //System.out.print(rem.v);
	            if(visited.contains(rem.v))
	            {
	            	return true;
	            }
	            visited.add(rem.v);
	            for (String n : map.get(rem.v).keySet()) {
	                if (visited.contains(n) == false) {
	                    Tpair npair = new Tpair(n, rem.p + n, rem.w + map.get(rem.v).get(n));
	                    stack.addFirst(npair);
	                }
	            }
	        }
	        System.out.println();
        }
        return false;
    }
    
    public boolean isCyclic(){
        HashSet<String> visited = new HashSet<>();
        for (String vertex : map.keySet()) {
            if(visited.contains(vertex)){
                continue;
            }
            Tpair pair = new Tpair(vertex, vertex, 0);

            LinkedList<Tpair> q = new LinkedList<>();
            q.addLast(pair);
            while (q.size() > 0) {
                Tpair rem = q.removeFirst();
                if (visited.contains(rem.v)) {
                    return true;
                }
                visited.add(rem.v);
                for (String n : map.get(rem.v).keySet()) {
                    if (visited.contains(n) == false) {
                        Tpair npair = new Tpair(n, rem.p + n, rem.w + map.get(rem.v).get(n));
                        q.addLast(npair);
                    }
                }
            }
        }
        return false;
    }
}
