package tree;

import java.util.*;

public class Tree {

	public static void preOrder(Node root) {

        if(root == null)
            return;

        //start is from middle
        System.out.print(root.data + " ");
        //left is second
        preOrder(root.left);
        //right is third
        preOrder(root.right);

    }

    public static void inOrder(Node root) {

        if(root == null) {
            return;
        }
        //start from left
        inOrder(root.left);
        //middle is second
        System.out.print(root.data + " ");
        //right is third
        inOrder(root.right);
    }

    public static void postOrder(Node root) {

        if(root == null) {
            return;
        }

        //start from left
        postOrder(root.left);

        //right is second
        postOrder(root.right);

        //middle is last
        System.out.print(root.data + " ");
    }

    public static int findHeight(Node root) {

        if(root == null)
            return 0;
        int left = findHeight(root.left)+1;
        int right = findHeight(root.right)+1;
        return Math.max(left, right);
    }

    public static int findLeft(Node root , int number) {

        if(root == null || root.left == null)
            return -1;
        if(root.data == number)
            return root.left.data;

        int fromLeft = findLeft(root.left, number);
        int fromRight = findLeft(root.right, number);

        return fromLeft != -1 ? fromLeft : fromRight;
    }

    public static Node find(int number, Node root) {
        if(root == null)
            return null;
        if(root.data == number)
            return root;

        Node fromLeft = find(number,root.left);
        Node fromRight = find(number, root.right);

        return fromLeft != null ? fromLeft : fromRight;
    }

    public static void add(Node newNode, int atWhichToAdd ,Node root, Character position) {

        if(root == null) {
            root = newNode;
            return;
        }
        Node current = find(atWhichToAdd, root);
        if(position == 'L' && current.left == null) {
            current.left = newNode;
            return;
        } else if(position == 'R' && current.right == null) {
            current.right = newNode;
            return;
        }
        throw new RuntimeException("already node present");

    }

    public static void levelOrderTraversal(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currSize = 0;
            Node curr = queue.poll();
            if(curr == null) {
                System.out.println();
                if(queue.size() != 0)
                    queue.add(null);
                continue;
            }
            System.out.print(curr.data + " ");
            if(curr.left != null) {
                queue.add(curr.left);
            }
            if(curr.right != null) {
                queue.add(curr.right);
            }
        }
    }
    
    public static void levelOrderTraversal2(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int size = queue.size();
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            size--;
            System.out.print(curr.data + " ");
            
            if(curr.left != null) {
                queue.add(curr.left);
            }
            if(curr.right != null) {
                queue.add(curr.right);
            }
            if(size==0)
            {
            	System.out.println();
            	size = queue.size();
            }
        }
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
    
    public static int min(Node root)
    {
    	if(root==null)
    		return Integer.MAX_VALUE;
    	
    	int lmin = min(root.left);
    	int rmin = min(root.right);
    	
    	int min = Math.min(lmin, rmin);
    	return Math.min(min, root.data);
    }
    
    
    public static int size(Node root)
    {
    	if(root==null)
    		return 0;
    	int lsize = size(root.left);
    	int rsize = size(root.right);
    	return lsize+rsize+1;
    }
    
    public static int removeLeaves(Node root) {

        if(root == null) {
            return 0;
        }
        if(root.left==null && root.right==null)
        	return 1;
        
        	
        //start from left
       int l = removeLeaves(root.left);
       if(l==1)
    	   root.left = null;
       
        
        int r = removeLeaves(root.right);
        
        if(r==1)
        	root.right = null;
        
        return 0;
        
    }
    
    public static void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
		str += node.left != null ? node.left.data + "->" : ".->";
		str += node.right != null ? node.data + "<-" + node.right.data : node.data + "<-.";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
    
    public static void printSingleChild(Node root)
    {
    	if(root==null)
    	{
    		return;
    	}
    	
    	if(root.left == null && root.right!=null)
    	{
    		System.out.println(root.right.data);
    	}
    	
    	if(root.left != null && root.right==null)
    	{
    		System.out.println(root.left.data);
    	}
    	
    	printSingleChild(root.left);
    	printSingleChild(root.right);
    	
    }
    
    public static void printLeafToNodePath(Node root, int low,int high, String ans, int sum)
    {
    	if(root==null)
    	{
    		return;
    	}
    	
    	if(root.left==null && root.right==null)
    	{
    		sum = sum+root.data;
    		ans = ans+root.data+" ";
    		if(sum>=low && sum<=high)
    		{
    			System.out.println(ans);
    		}
    	}
    	
    	printLeafToNodePath(root.left,low,high,ans+root.data+" ",sum+root.data);
    	printLeafToNodePath(root.right,low,high,ans+root.data+" ",sum+root.data);
    	
    }
    
    public static void printKNodeBelow(int n, Node root, int k)
    {
    	if(root==null)
    		return;
    	printKNodeBelow(n,root.left,k);
    	if(root.data==n)
    	{
    		printKNodeBelow(root,k);
    		return;
    	}
    	printKNodeBelow(n,root.right,k);
    }

	private static void printKNodeBelow(Node root, int k) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		
		if(k==0)
		{
			System.out.println(root.data);
			return;
		}
		
		printKNodeBelow(root.left,k-1);
		
		printKNodeBelow(root.right,k-1);
		
	}
	
	public static ArrayList<Node> printNodeToRoot(int i, Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return new ArrayList<Node>();
		
		
		
		ArrayList<Node>list = printNodeToRoot(i,root.left);
		if(root.data==i)
		{
			list.add(root);
			return list;
		}
		if(list.size()>0)
		{
			list.add(root);
			return list;
		}
		ArrayList<Node> list2 = printNodeToRoot(i,root.right);
		
		if(root.data==i)
		{
			list2.add(root);
			return list2;
		}
		if(list2.size()>0)
		{
			list2.add(root);
			return list2;
		}
		return list2;
	}
	
	public static void printKAway(int n, Node root, int k)
	{
		ArrayList<Node> list = printNodeToRoot(n,root);
		printKNodeBelow(list.get(0),k);
		int i;
		Node temp;
		for(i=1;i<list.size() && i<k;i++)
		{
			temp = list.get(i);
			if(temp.right==list.get(i-1))
			{
				printKNodeBelow(temp.left,k-i-1);
			}
			else
			{
				printKNodeBelow(temp.right,k-i-1);
			}
		}
		//System.out.println(list);
		if(list.size()>k)
			System.out.println(list.get(list.size()-1));
	}

	
	
	static int max_level = 0;
	public static void printLeft(Node root, int level)
	{
		if(root==null)
			return;
		
		if(max_level<level)
		{
			System.out.println(root.data);
			max_level = level;
		}
		
		printLeft(root.left,level+1);
		printLeft(root.right,level+1);
	}
	
	public static void printLeftUsingQueue(Node root)
	{
		Queue<Node> queue = new LinkedList<>();
		int i,n;
		queue.add(root);
		while(queue.size()>0)
		{
			
			n = queue.size();
			i = n;
			while(i>0)
			{
				Node node = queue.poll();
				
					if(i==n)
						System.out.println(node.data);
					if(node.left!=null)
						queue.add(node.left);
					if(node.right!=null)
						queue.add(node.right);
				
					
				i--;
			}
			//System.out.println();
//			Node node = queue.poll();
//			if(node!=null)
//			{
//				//System.out.println(node.data);
//				queue.add(node.left);
//				queue.add(node.right);
//			}
		}
	}
	
	public static void printRightUsingQueue(Node root)
	{
		Queue<Node> queue = new LinkedList<>();
		int i,n;
		queue.add(root);
		while(queue.size()>0)
		{
			
			n = queue.size();
			i = n;
			while(i>0)
			{
				Node node = queue.poll();
				
					if(i==1)
						System.out.println(node.data);
					if(node.left!=null)
						queue.add(node.left);
					if(node.right!=null)
						queue.add(node.right);
				
					
				i--;
			}
			//System.out.println();
//			Node node = queue.poll();
//			if(node!=null)
//			{
//				//System.out.println(node.data);
//				queue.add(node.left);
//				queue.add(node.right);
//			}
		}
	}
	
	static int max_level2 = 0;
	public static void printRight(Node root, int level)
	{
		if(root==null)
			return;
		
		if(max_level2<level)
		{
			System.out.println(root.data);
			max_level2 = level;
		}
		
		printRight(root.right,level+1);
		printRight(root.left,level+1);
		
	}
	
	 public static int LowestCommonAncestor(Node root,int n1, int n2) {
		   ArrayList<Node> arrayList1 = printNodeToRoot(n1,root);
		   ArrayList<Node> arrayList2 = printNodeToRoot(n2,root);

		   int i = arrayList1.size()-1;
		   int j = arrayList2.size()-1;

		   while (arrayList1.get(i) == arrayList2.get(j)) {
		   	   if(arrayList1.get(i).data == n2 || arrayList2.get(j).data == n1) {
		   	   		return arrayList1.get(i+1).data;
			   }
		       i--;
		       j--;
	       }
		   return arrayList1.get(i+1).data;

	    }
	 
	 public static void preOrderIterative(Node root)
	 {
		 Stack<Pair> stack = new Stack<>();
		 stack.push(new Pair(root,0));
		 
		 while(stack.size()>0)
		 {
			 Pair p = stack.peek();
			 
			 if(p.wc==0)
			 {
				 System.out.print(p.node.data+" ");
				 p.wc = 1;
				 if(p.node.left!=null)
				 {
					 stack.push(new Pair(p.node.left,0));
				 }
			 }
			 else if(p.wc==1)
			 {
				 
				 p.wc = 2;
				 if(p.node.right!=null)
				 {
					 stack.push(new Pair(p.node.right,0));
				 }
			 }
			 else
			 {
				 stack.pop();
			 }
		 }
	 }
	 
	 public static void inOrderIterative(Node root)
	 {
		 Stack<Pair> stack = new Stack<>();
		 stack.push(new Pair(root,0));
		 
		 while(stack.size()>0)
		 {
			 Pair p = stack.peek();
			 
			 if(p.wc==0)
			 {
				 p.wc = 1;
				 if(p.node.left!=null)
				 {
					 stack.push(new Pair(p.node.left,0));
				 }
			 }
			 else if(p.wc==1)
			 {
				 System.out.print(p.node.data+" ");
				 p.wc = 2;
				 if(p.node.right!=null)
				 {
					 stack.push(new Pair(p.node.right,0));
				 }
			 }
			 else
			 {
				 stack.pop();
			 }
		 }
	 }
	 
	 public static void postOrderIterative(Node root)
	 {
		 Stack<Pair> stack = new Stack<>();
		 stack.push(new Pair(root,0));
		 
		 while(stack.size()>0)
		 {
			 Pair p = stack.peek();
			 
			 if(p.wc==0)
			 {
				 p.wc = 1;
				 if(p.node.left!=null)
				 {
					 stack.push(new Pair(p.node.left,0));
				 }
			 }
			 else if(p.wc==1)
			 {
				 
				 p.wc = 2;
				 if(p.node.right!=null)
				 {
					 stack.push(new Pair(p.node.right,0));
				 }
			 }
			 else
			 {
				 System.out.print(p.node.data+" ");
				 stack.pop();
			 }
		 }
	 }
	 
	 public static boolean isBalanced(Node root)
	 {
		 return isBalancedHelper(root).bool;
	 }
	 
	 
	  private static Pair2 isBalancedHelper(Node root) {
		// TODO Auto-generated method stub
		  if(root==null)
		  {
			  return new Pair2(root,0,true);
		  }
		  
		  Pair2 lp = isBalancedHelper(root.left);
		  Pair2 rp = isBalancedHelper(root.right);
		  
		  int h = Math.max(lp.height, rp.height);
		  
		  if(lp.bool==false || rp.bool==false)
		  {
			  return new Pair2(root,h+1,false);
		  }
		  
		  if(Math.abs(lp.height-rp.height)>1)
		  {
			  return new Pair2(root,h+1,false);
		  }
		  
		return new Pair2(root,h+1,true);
	}
	  
	public static int findDiam(Node root)
	{
		return findDiamHelper(root).diam;
	}
	
	public static Pair3 findDiamHelper(Node root)
	{
		if(root==null)
		{
			return new Pair3(0,0);
		}
		
		Pair3 p1 = findDiamHelper(root.left);
		Pair3 p2 = findDiamHelper(root.right);
		
		int h = Math.max(p1.height, p2.height)+1;
		int diam = p1.height + p2.height +1;
		int d = Math.max(diam, Math.max(p1.diam,p2.diam));
		
		return new Pair3(h,d);
	}

	public static boolean isBst(Node node) {
		return isBstHelper(node).Isbalanced;
	}

	private static pair4 isBstHelper(Node node) {
		if (node == null) {
			pair4 p = new pair4();
			p.Isbalanced = true;
			p.max = Integer.MIN_VALUE;
			p.min = Integer.MAX_VALUE;
			return p;
		}

		pair4 lpair = isBstHelper(node.left);
		pair4 rpair = isBstHelper(node.right);

		if (lpair.Isbalanced == false || rpair.Isbalanced == false) {
			pair4 p = new pair4();
			p.Isbalanced = false;
			return p;
		}

		pair4 mpair = new pair4();
		mpair.max = Math.max(lpair.max, Math.max(rpair.max, node.data));
		mpair.min = Math.min(lpair.min, Math.min(rpair.min, node.data));
//		mpair.max = rpair.max;
//		mpair.min = lpair.min;
		if (node.data > lpair.max && node.data < rpair.min) {
			mpair.Isbalanced = true;
		}

		return mpair;
	}

	public static void invertTree(Node root)
	{
		if(root==null)
			return;
		
		Node node = root.left;
		root.left = root.right;
		root.right = node;
		
		invertTree(root.left);
		invertTree(root.right);
	}
	
	public static boolean isMirror(Node root, Node root2)
	{
		if(root==null && root2==null)
			return true;
		
		
		if(root.data!=root2.data)
			return false;
		
		if(root!=null && root2!=null)
			return isMirror(root.left,root2.right) && isMirror(root.right,root2.left);
		
		return false;
	}
	
	public static int deepLeavesSum(Node node)
	{
		if(node==null)
			return 0;
		
		int sum=0;
		if(node.left == null && node.right == null)
		{
			return node.data;
		}
		sum = sum+deepLeavesSum(node.left);
		sum = sum+deepLeavesSum(node.right);
		return sum;
	}
	static int sum=0;
	public static void deepLevelSum(Node root, int level) {

		if(root == null)
			return;

		if(max_level == level) {
			sum = sum + root.data;
		}

		if(max_level < level) {
			sum = root.data;
			max_level = level;
		}
		deepLevelSum(root.left, level+1);
		deepLevelSum(root.right, level+1);
	}
	
	public static void convertToLinkedList(Node root) {
		if(root == null)
			return;
		if(root.left == null && root.right == null)
			return;
		if(root.left != null) {
			convertToLinkedList(root.left);
			Node temp = root.right;
			root.right = root.left;
			root.left = null;

			Node curr = root.right;
			while (curr.right != null) {
				curr = curr.right;
			}
			curr.right = temp;
		}
		convertToLinkedList(root.right);
	}

	static class Pair
	  {
		  Node node;
		  int wc;
		  
		  public Pair(Node node, int wc)
		  {
			  this.node =  node;
			  this.wc = wc;
		  }
	  }
	  
	  static class Pair2
	  {
		  Node node;
		  int height;
		  boolean bool;
		  
		  public Pair2(Node node, int height, boolean bool)
		  {
			  this.node = node;
			  this.height = height;
			  this.bool = bool;
		  }
	  }
	  
	  static class Pair3
	  {
		  
		  int height;
		  int diam;
		  
		  public Pair3( int height, int diam)
		  {
			  
			  this.height = height;
			  this.diam = diam;
		  }
	  }
	  
	  private static class pair4 {
			int max;
			int min;
			boolean Isbalanced;
		}
	
}		
		