package graph;

import java.util.*;
import javafx.util.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Graph g = new Graph();
//	       g.addVertex("A");
//	       g.addVertex("B");
//	       g.addVertex("C");
//	       g.addVertex("D");
//	       g.addVertex("E");
//	       g.addVertex("F");
//	       g.addVertex("G");
//	       g.addEdge("A", "B", 10);
//	       g.addEdge("A", "D", 40);
//	       g.addEdge("C", "B", 10);
//	       g.addEdge("E", "F", 3);
//	       g.addEdge("E", "G", 8);
//	       g.addEdge("D", "E", 30);
//	       g.addEdge("C", "E", 10);
//		   g.addVertex("A");
//		   g.addVertex("B");
//		   g.addVertex("C");
//		   g.addVertex("D");
//		   g.addEdge("A", "B", 8);
//		   g.addEdge("C", "D", 9);
//		   g.addEdge("D", "B", 6);
//		   g.addEdge("A", "D", 10);
		   
		   //for prims in geeksgorgeeks example
		   g.addVertex("0");
		   g.addVertex("1");
		   g.addVertex("2");
		   g.addVertex("3");
		   g.addVertex("4");
		   g.addVertex("5");
		   g.addVertex("6");
		   g.addVertex("7");
		   g.addVertex("8");
		   g.addEdge("0", "1", 4);
		   g.addEdge("0", "7", 8);
		   g.addEdge("1", "2", 8);
		   g.addEdge("1", "7", 11);
		   g.addEdge("2", "8", 2);
		   g.addEdge("2", "3", 7);
		   g.addEdge("2", "5", 4);
		   g.addEdge("3", "4", 9);
		   g.addEdge("3", "5", 14);
		   g.addEdge("4", "5", 10);
		   g.addEdge("5", "6", 2);
		   g.addEdge("6", "7", 1);
		   g.addEdge("6", "8", 6);
		   g.addEdge("7", "8", 7);
		   
		   //for djikstra's in techdose example
//		   g.addVertex("0");
//		   g.addVertex("1");
//		   g.addVertex("2");
//		   g.addVertex("3");
//		   g.addVertex("4");
//		   g.addVertex("5");
//		   g.addEdge("0", "1", 1);
//		   g.addEdge("0", "2", 4);
//		   g.addEdge("1", "2", 4);
//		   g.addEdge("1", "3", 2);
//		   g.addEdge("1", "4", 7);
//		   g.addEdge("2", "4", 5);
//		   g.addEdge("2", "3", 3);
//		   g.addEdge("3", "4", 4);
//		   g.addEdge("3", "5", 6);
//		   g.addEdge("4", "5", 7);

	       HashSet<String> visited = new HashSet<>();
	       
	       //System.out.println(g.hasPath("B", "G", visited));
	       //System.out.println(g.printSmallestPath("D", "E", visited,0));
	       //g.getConnectedComponents();
//	       System.out.println(g.isCycle());
//	       System.out.println(g.isCyclic());
	       //System.out.println(g.map);
	       //System.out.println(g.prims());
	       g.djikstra("0");
	     
	}

}
