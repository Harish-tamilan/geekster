package bst;

import java.util.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {10, 5, 4, 20, 21, 18, 19};
		 BST bst = new BST();
		 bst.addViaArray(arr);
		 bst.levelOrderTraversal();
		 //System.out.println(bst.diameterLength());
//		bst.pir(10, 20);
//		 System.out.println("After replacing with larger nodes");
//		 bst.replaceWithLargerNodes(bst.root);
//		 bst.levelOrderTraversal();
//		 System.out.println(bst.lca(bst.root, 19, 18));
//		 System.out.println(bst.find(bst.root, 40));
//		 bst.remove(19);
//		 System.out.println("After removal");
//		 bst.levelOrderTraversal();
		 System.out.println("Target sum pair");
		 bst.targetSumPair(bst.root, 24);
	}

}
