package generictree;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,5,-1,6,-1,-1,3,7,-1,-1,4,8};
		
		int[] arr3 = {10,20,50,-1,60,-1,-1,30,70,-1,-1,40,80};
		
		int[] arr2 = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		
		GenericTree gt = new GenericTree(arr2);
		
		GenericTree gt2 = new GenericTree(arr);
		
		//gt2.makeMirror(gt2.root);
		
		
//		System.out.println(gt.size(gt.root,1));
		
		//gt.displayUsingQueue(gt.root);
		gt.display(gt.root);
//		System.out.println(gt.max(gt.root));
//		System.out.println(gt.height(gt.root));
//		System.out.println(gt.find(gt.root, 3));
//		System.out.println(gt.nodeToRoot(gt.root, 4));
//		gt.removeLeaves(gt.root);
//		System.out.println("After removal");
//		gt.display(gt.root);
//		System.out.println("After mirror");
//		gt.makeMirror(gt.root);
//		gt.linearise(gt.root);
//		System.out.println("After linearise");
//		gt.display(gt.root);
//		
//		gt.linearise2(gt.root);
//		System.out.println("After linearise2");
//		gt.display(gt.root);
//		
//		System.out.println(gt.isSimilarShaped(gt.root,gt2.root));
//		
//		System.out.println(gt.isMirror(gt.root, gt2.root));
		
		System.out.println(gt.oddEvenLevelDifference(gt.root));
		
		
		
	}

}
