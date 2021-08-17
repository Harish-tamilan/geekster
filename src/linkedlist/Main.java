package linkedlist;

import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkedList = new LinkedList();
		linkedList.addLast(1);
		linkedList.addLast(3);
		linkedList.addLast(5);
		linkedList.addLast(7);
		linkedList.addLast(9);
		linkedList.addLast(11);
		
		LinkedList linkedList2 = new LinkedList();
		linkedList2.addLast(2);
		linkedList2.addLast(4);
		linkedList2.addLast(6);
		linkedList2.addLast(8);
		linkedList2.addLast(10);
		
		//System.out.println(linkedList.isPalindrome());
		System.out.println("The actual list is ");
		linkedList.display();
		
//		System.out.println("\nThe actual list 2 is ");
//		linkedList2.display();
//		
		//linkedList.fold();
		//linkedList.reverseDataRecursion();
		//System.out.println(linkedList.kthElementFromLastIteration(5));
//		System.out.println(linkedList.kthElementFromLastRecursion(4));
//		
//		LinkedList l3 = new LinkedList();
//		l3 = l3.mergeTwoSortedList(linkedList.getHead(),linkedList2.getHead());
//		System.out.println("The merged list is ");
//		l3.display();
//		System.out.println("The list after reversing is");
//		linkedList.reversePointerRecursion();
//		linkedList.display();
		
//		linkedList.makeCycle();
//		
//		System.out.println(linkedList.isCycle());
//		
//		System.out.println("The cycle is at "+ linkedList.findCycle().getData());
//		
		
		linkedList.setHead(linkedList.reverseInGroup(linkedList.getHead(), 2));
		linkedList.display();
		
	}
	
}
