package graph;

import java.util.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
	       g.addVertex("A");
	       g.addVertex("B");
	       g.addVertex("C");
	       g.addVertex("D");
	       g.addVertex("E");
	       g.addVertex("F");
	       g.addVertex("G");

	       g.addEdge("A", "B", 10);
	       g.addEdge("A", "D", 40);
	       g.addEdge("C", "B", 10);
	      // g.addEdge("C", "D", 10);
	       //g.addEdge("D", "E", 2);
	       g.addEdge("E", "F", 3);
	       //g.addEdge("F", "G", 3);
	       g.addEdge("E", "G", 8);
	       g.addEdge("D", "E", 90);
	       g.addEdge("C", "E", 10);
	       //g.display();
	    //    g.removeEdge("D", "E");
	    //    g.display();
	    //    g.removeVertex("D");
	    //    g.display();
//	       System.out.println(g.countEdges());
//	       System.out.println(g.countVertices());
//	       System.out.println(g.hasPath("A", "G", "", new HashSet<>()));
//	       g.printSmallestPW("A", "F");
//	       g.bfs("A", "G");
//	       g.bfs2("A", "G");
//	       System.out.println("----------------------------------------");
//	       g.dfs("A", "G");
//	       g.dfs2("A", "G");
//	       g.gcc();
//	       System.out.println(g.isCycle());
//	       System.out.println(g.isCyclic());
	       g.bfs2("D","E");
	}

}
