package graph;

import java.util.*;

public class Graph {
	
	HashMap<String,HashMap<String,Integer>> map = new HashMap<>();
	
	public void addVertex(String n)
	{
		map.put(n, new HashMap<String,Integer>());
	}
	
	public void addEdge(String n, String n2, int w)
	{
		map.get(n).put(n2, w);
		map.get(n2).put(n, w);
	}
	
	public boolean hasPath(String src, String des, HashSet<String> visited)
	{
		if(src.equals(des))
		{
			return true;
		}
		
		visited.add(src);
		boolean bool = false;
		for(String s : map.get(src).keySet())
		{
			//oolean bool = false;
			if(!visited.contains(s))
			{
				bool = hasPath(s,des,visited);
			}
			if(bool)
				return bool;
		}
		return bool;
	}
	int wgt=Integer.MAX_VALUE;
	public int printSmallestPath(String src, String des, HashSet<String> visited, int wt)
	{
		if(src.equals(des))
		{
			wgt = Math.min(wgt, wt);
			return 0;
		}
		visited.add(src);
		for(String s : map.get(src).keySet())
		{
			if(!visited.contains(s))
			{
				printSmallestPath(s,des,visited,wt+map.get(src).get(s));
			}
		}
		visited.remove(src);
		return wgt;
	}
	
	HashSet<String> visited = new HashSet<>();
	
	public void getConnectedComponents()
	{
		for(String s:map.keySet())
		{
			if(!visited.contains(s))
				System.out.println(getConnectedComponents(s));
			path="";
		}
	}
	String path="";
	private String getConnectedComponents(String s) {
		// TODO Auto-generated method stub
		path+=s;
		visited.add(s);
		for(String st : map.get(s).keySet())
		{
			if(!visited.contains(st))
			{
				getConnectedComponents(st);
			}
		}
		return path;
	}
	
	public boolean isCycle()
	{
		boolean bool = false;
		for(String s:map.keySet())
		{
			if(!visited.contains(s))
			{
				bool = isCycle(s);
				if(bool)
					break;
			}
		}
		return bool;
	}
	
	private boolean isCycle(String s) {
		// TODO Auto-generated method stub
		path+=s;
		visited.add(s);
		for(String st : map.get(s).keySet())
		{
			if(!visited.contains(st))
			{
				getConnectedComponents(st);
			}
			else
				return true;
		}
		return false;
	}
	//public void bfs()
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
	
	private class Pair implements Comparable<Pair>{
		String s;
		String d;
		int w;
		public Pair(String s, String d, int w) {
			super();
			this.s = s;
			this.d = d;
			this.w = w;
		}
		@Override
		public int compareTo(Pair arg) {
			// TODO Auto-generated method stub
			return this.w-arg.w;
		}
		@Override
		public String toString() {
			return "Pair [s=" + s + ", d=" + d + ", w=" + w + "]";
		}
		
		
		
	}
	
	public Pair getMin()
	{
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(String s: map.keySet())
		{
			for(String s2 : map.get(s).keySet())
			{
				Pair p = new Pair(s,s2,map.get(s).get(s2));
				pq.add(p);
			}
		}
		return pq.remove();
	}
	
	public Map<String, Map<String, Integer>> prims ()
	{
		Map<String, Map<String, Integer>> map2 = new HashMap<>();
		Pair p = getMin();
		//System.out.println(p);
		HashSet<String> visited = new HashSet<>();
		int size=map.size();
		int count=1;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		map2.put(p.s, new HashMap<String, Integer>());
		pq.add(p);
		visited.add(p.s);
		while(count<size)
		{
			System.out.println("pq is " + pq);
			Pair temp = pq.remove();
			System.out.println("temp is "+temp);
			System.out.println("-----------------------------------------------------------------------------------------");
			if(visited.contains(temp.d))
				continue;
			visited.add(temp.d);
			
			map2.put(temp.d, new HashMap<String, Integer>());
			map2.get(temp.s).put(temp.d, temp.w);
			count++;
			String str = temp.d;
//			System.out.println(str);
//			System.out.println(map.get(str));
			for(String s:map.get(temp.d).keySet())
			{
				//System.out.println("---");
				if(!visited.contains(s))
					pq.add(new Pair(temp.d, s, map.get(temp.d).get(s)));
			}
			
		}
		return map2;
	}
	
	public void djikstra(String src)
	{
		HashMap<String, Integer> cost = new HashMap<>();
		for(String s : map.keySet())
		{
			cost.put(s, Integer.MAX_VALUE);
		}
		cost.replace(src, 0);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair("",src,0));
		HashSet<String> visited = new HashSet<>();
		while(visited.size()<map.size() && !pq.isEmpty())
		{
			Pair p = pq.remove();
			int temp = Math.min(cost.get(p.d),p.w);
			cost.replace(p.d, temp);
			if(!visited.contains(p.d))
				System.out.println(p);
			visited.add(p.d);
			for(String s : map.get(p.d).keySet())
			{
				if(!visited.contains(s))
					pq.add(new Pair(p.d,s,p.w+map.get(p.d).get(s)));
			}
		}
	}
}
