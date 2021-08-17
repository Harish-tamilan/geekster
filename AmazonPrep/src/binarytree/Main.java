package binarytree;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(50);
	    Tree.add(new Node(25), 50, root, 'L');
	    Tree.add(new Node(75), 50, root, 'R');
	    Tree.add(new Node(12), 25, root, 'L');
	    Tree.add(new Node(13), 12, root, 'L');
	    Tree.add(new Node(37), 25, root, 'R');
	    Tree.add(new Node(30), 37, root, 'L');
	    Tree.add(new Node(40), 37, root, 'R');
	    Tree.add(new Node(62), 75, root, 'L');
	    Tree.add(new Node(87), 75, root, 'R');
	    Tree.add(new Node(60), 62, root, 'L');
	    Tree.add(new Node(70), 62, root, 'R');
	    //Tree.add(new Node(49), 70, root, 'L');
	    
	    //Tree.levelOrder(root);
	    //System.out.println(Tree.height(root));
	    //System.out.println(Tree.max(root));
	    //Tree.removeLeaves(root);
	    //Tree.levelOrder(root);
	    //Tree.printSingleChild(root);
	    //Tree.printPath(root, 100, 200, "", 0);
	    //Tree.rootToNode(root, 30, "");
	    //System.out.println(Tree.nodeToRoot(root, 30));
	    //Tree.printKDown(root, 3);
	    //Tree.printKAway(75, root, 2);
	    //Tree.leftView(root, 1);
	    //Tree.rightView(root, 1);
	    //System.out.println(Tree.isBalanced(root));
	    //System.out.println(Tree.isBst(root));
//	    Tree.invertTree(root);
//	    Tree.levelOrder(root);
	    //System.out.println(Tree.deepLeavesSum(root));
	    //System.out.println(Tree.deepLevelSum(root, 1));
	    System.out.println(Tree.diam(root));
	}

}
