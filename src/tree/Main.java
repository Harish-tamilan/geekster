package tree;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Node root = new Node(1);
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
        
        Node root2 = new Node(50);
        Tree.add(new Node(25), 50, root2, 'L');
        Tree.add(new Node(75), 50, root2, 'R');
        Tree.add(new Node(12), 25, root2, 'L');
        Tree.add(new Node(13), 12, root2, 'L');
        Tree.add(new Node(37), 25, root2, 'R');
        Tree.add(new Node(30), 37, root2, 'L');
        Tree.add(new Node(40), 37, root2, 'R');
        Tree.add(new Node(62), 75, root2, 'L');
        Tree.add(new Node(87), 75, root2, 'R');
        Tree.add(new Node(60), 62, root2, 'L');
        Tree.add(new Node(70), 62, root2, 'R'); 
//        Tree.add(new Node(71), 70, root, 'R');
//        Tree.add(new Node(72), 71, root, 'R');
//        Tree.add(new Node(14), 13, root, 'L');
        
//        Tree.inOrder(root);
       // Tree.levelOrderTraversal(root);
//        System.out.println();
//        Tree.preOrder(tree.root);
//        System.out.println();
//        Tree.postOrder(tree.root);
//       System.out.println(Tree.findLeft(root, 2));
//        System.out.println(Tree.findHeight(tree.root));
        
      //  System.out.println(Tree.size(root));
      //  System.out.println(Tree.max(root));
        
        //Tree.removeLeaves(root);
        
        //Tree.display(root);
        
//        Tree.printSingleChild(root);
        //Tree.printLeafToNodePath(root, 100, 200, "", 0);
        
       // Tree.printKNodeBelow(75, root, 2);
        
        //System.out.println(Tree.printNodeToRoot(40, root));
        
        //Tree.printLeft(root, 1);
        
        //Tree.printKAway(75, root, 2);
        
       // Tree.printLeftUsingQueue(root);
        
       // Tree.printRightUsingQueue(root);
        
        //Tree.printRight(root, 1);
        //Tree.printKAway(60, root, 3);
        
        //System.out.println(Tree.LowestCommonAncestor(root, 87, 75));
        
       // System.out.println(Tree.findHeight(root));
//        Tree.preOrderIterative(root);
//        System.out.println();
//        Tree.preOrder(root);
        
//        Tree.inOrderIterative(root);
//        System.out.println();
//        Tree.inOrder(root);
        
//        Tree.postOrderIterative(root);
//        System.out.println();
//        Tree.postOrder(root);
        
       // System.out.println(Tree.isBalanced(root));
        
//        Tree.levelOrderTraversal(root);
//        
//        Tree.invertTree(root2);
//        
//        System.out.println("------------------------------------------------");
//        
//        Tree.levelOrderTraversal(root2);
//        
//        System.out.println(Tree.isMirror(root, root2));
        
        //System.out.println(Tree.findDiam(root));
        
//        Tree.levelOrderTraversal(root);
        System.out.println(Tree.deepLeavesSum(root));
//        Tree.deepLevelSum(root,1);
//        System.out.println(Tree.sum);
        
//        Tree.convertToLinkedList(root);
//        
//        Tree.preOrder(root);
        
//        Tree.levelOrderTraversal(root);
//        
//        Tree.levelOrderTraversal2(root);
        
        //System.out.println(Tree.isBst(root));
        
    }

	
}
