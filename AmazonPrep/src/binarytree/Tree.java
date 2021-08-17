package binarytree;

import java.util.*;


public class Tree {
	
	public static void add(Node node, int n, Node root, char c)
	{
		if(root==null)
			return;
		if(root.data==n)
		{
			if(c=='L')
			{
				root.left = node;
				return;
			}
			else
			{
				root.right = node;
				return;
			}
		}
		add(node, n, root.left, c);
		add(node, n, root.right, c);
	}
	
	public static void levelOrder(Node root)
	{
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int size=queue.size();
		while(!queue.isEmpty())
		{
			Node temp = queue.remove();
			System.out.print(temp.data+" ");
			size--;
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
			if(size==0)
			{
				System.out.println();
				size = queue.size();
			}
			
			
		}
	}
	
	public static int height(Node root)
	{
		if(root==null)
			return 0;
		int left = height(root.left)+1;
		int right = height(root.right)+1;
		return Math.max(left, right);
	}
	
	public static int max(Node root)
	{
		if(root==null)
			return 0;
		
		int lmax = max(root.left);
		int rmax = max(root.right);
		
		int max = Math.max(lmax, rmax);
		return Math.max(max, root.data);
		
	}
	
	public static int removeLeaves(Node root)
	{
		if(root==null)
			return 0;
		if(root.left == null && root.right==null)
			return 1;
		int l = removeLeaves(root.left);
		if(l==1)
			root.left = null;
		int r = removeLeaves(root.right);
		if(r==1)
			root.right = null;
		return 0;
	}
	
	public static void printSingleChild(Node root)
	{
		if(root==null)
			return;
		if(root.left==null && root.right!=null || root.left!=null && root.right==null)
			System.out.print(root.data+" ");
		printSingleChild(root.left);
		printSingleChild(root.right);
	}
	
	//printing paths whose sum is between a defined range
	
	public static void printPath(Node root, int low, int high, String path, int sum)
	{
		if(root==null)
			return;
		if(root.left==null && root.right==null)
		{
			sum += root.data;
			path+="->"+root.data;
			if(sum>=low && sum<=high)
			{
				System.out.println(path);
			}
		}
		printPath(root.left, low, high, path+"->"+root.data, sum+root.data);
		printPath(root.right, low, high, path+"->"+root.data, sum+root.data);
	}
	
	public static void rootToNode(Node root, int n, String ans)
	{
		if(root==null)
			return;
		if(root.data==n)
		{
			System.out.println(ans+" "+root.data);
			return;
		}
		rootToNode(root.left, n, ans+" "+root.data);
		rootToNode(root.right, n, ans+" "+root.data);
	}
	
	public static ArrayList<Node> nodeToRoot(Node root, int n)
	{
		if(root==null)
			return new ArrayList<Node>();
		
		ArrayList<Node> list = nodeToRoot(root.left, n);
		if(root.data==n)
		{
			list.add(root);
			return list;
		}
		if(list.size()>0)
		{
			list.add(root);
			return list;
		}
		ArrayList<Node> list2 = nodeToRoot(root.right,n);
		if(list2.size()>0)
		{
			list2.add(root);
			return list2;
		}
		return list2;
	}
	
	public static void printKDown(Node root, int k)
	{
		if(root==null)
			return;
		if(k==0)
			System.out.println(root.data+" ");
		
		printKDown(root.left, k-1);
		printKDown(root.right, k-1);
	}
	
	public static void printKAway(int n, Node root, int k)
	{
		ArrayList<Node> list = nodeToRoot(root, n);
		printKDown(list.get(0),k);
		int i;
		Node temp;
		for(i=1;i<list.size() && i<k;i++)
		{
			temp = list.get(i);
			if(temp.right==list.get(i-1))
			{
				printKDown(temp.left,k-i-1);
			}
			else
			{
				printKDown(temp.right, k-i-1);
			}
		}
		if(list.size()>k)
			System.out.println(list.get(list.size()-1));
	}
	
	static int level;
	
	public static void leftView(Node root, int level2)
	{
		if(root==null)
			return;
		if(level<level2)
		{
			System.out.print(root.data+" ");
			level = level2;
		}
		
		leftView(root.left, level2+1);
		leftView(root.right, level2+1);
	}
	
	public static void rightView(Node root, int level2)
	
	{
		if(root==null)
			return;
		if(level<level2)
		{
			System.out.print(root.data+" ");
			level = level2;
		}
		
		rightView(root.right, level2+1);
		rightView(root.left, level2+1);
	}
	
	public static boolean isBalanced(Node root)
	{
		Pair p = isBalancedHelper(root);
		return p.bool;
	}
	
	public static Pair isBalancedHelper(Node root)
	{
		if(root==null)
			return new Pair(0,0,true);
		
		Pair left = isBalancedHelper(root.left);
		Pair right = isBalancedHelper(root.right);
		
		if(left.bool==false || right.bool==false)
			return new Pair(0,0,false);
		
		int max = Math.max(left.left, right.right);
		int max2 = Math.max(right.left, right.right);
		
		boolean bool = true;
		if(Math.abs(max-max2)>1)
			bool = false;
		return new Pair(max+1, max2+1,bool);
	}
	
	public static boolean isBst(Node root)
	{
		Pair2 p = isBstHelper(root);
		return p.bool;
	}
	
	
	public static Pair2 isBstHelper(Node root)
	{
//		if(root==null)
//			return new Pair2(0,true);
		if(root.left==null && root.right==null)
			return new Pair2(root.data,root.data,true);
		
		if(root.left==null)
			return new Pair2(root.data, root.right.data,true);
		
		if(root.right==null)
			return new Pair2(root.left.data, root.data,true);
		
		
		
		Pair2 left = isBstHelper(root.left);
		Pair2 right = isBstHelper(root.right);
		
		//int max = Math.max(left.height, right.height);
		
		if(!left.bool || !right.bool)
			return new Pair2(right.max,left.min,false);
		
		boolean bool = true;
		
		if(root.data<=left.max || root.data>right.min)
		{
			bool = false;
		}
 
		return new Pair2(right.max, left.min, bool);	
	}
	
	public static void invertTree(Node root)
	{
		if(root==null)
			return;
		
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invertTree(root.left);
		invertTree(root.right);
	}
	
	static int sum;
	public static int deepLeavesSum(Node root)
	{
		if(root==null)
			return 0;
		if(root.left == null && root.right==null)
			sum += root.data;
		
		deepLeavesSum(root.left);
		deepLeavesSum(root.right);
		
		return sum;
	}
	
	public static int deepLevelSum(Node root, int level2)
	{
		if(root==null)
			return 0;
		
		if(level<level2)
		{
			level = level2;
		}
		
		if(root.left==null && root.right==null)
		{
			if(level2==level)
			{
				sum += root.data;
			}
		}
		
		deepLevelSum(root.left, level2+1);
		deepLevelSum(root.right, level2+1);
		
		return sum;
	}
	
	public static int diam(Node root)
	{
		Pair3 p = diamHelper(root);
		return p.diam;
	}
	
	public static Pair3 diamHelper(Node root)
	{
		if(root==null)
			return new Pair3(0,0);
		
		Pair3 left = diamHelper(root.left);
		Pair3 right = diamHelper(root.right);
		
		int max = Math.max(left.max, right.max)+1;
		
		int diam = Math.max(left.diam, Math.max(right.diam, left.max+right.max+1));
		
		return new Pair3(max, left.max+right.max+1);
	}
	
	static class Pair
	{
		int left;
		int right;
		boolean bool;
		
		public Pair(int left, int right, boolean bool) {
			super();
			this.left = left;
			this.right = right;
			this.bool = bool;
		}
	}
	
	static class Pair2
	{
		int max;
		int min;
		boolean bool;
		
		public Pair2(int max, int min, boolean bool) {
			super();
			this.max = max;
			this.min = min;
			this.bool = bool;
		}
	}
	
	static class Pair3
	{
		int max;
		//int rmax;
		int diam;
		public Pair3(int lmax, int diam) {
			super();
			this.max = lmax;
			this.diam = diam;
		}
	}
	
}
