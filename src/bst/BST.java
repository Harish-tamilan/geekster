package bst;

import java.util.*;

public class BST {
	
	Node root;
	
	public void addViaArray(int[] arr)
	{
		for(int a:arr)
		{
			root = add(a,root);
		}
	}
	
	public Node add(int a,Node root)
	{
		if(root==null)
		{
			root = new Node(a,null,null);
		}
		else
		{
			if(root.data<=a)
			{
				if(root.right!=null)
				{
					add(a,root.right);
				}
				else
				{
					root.right = new Node(a,null,null);
				}
			}
			else
			{
				if(root.left!=null)
				{
					add(a,root.left);
				}
				else
				{
					root.left = new Node(a,null,null);
				}
			}
		}
		
		return root;
	}
	
	
	public void levelOrderTraversal()
	{
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int size = queue.size();
		
		while(queue.size()>0)
		{
			Node node = queue.poll();
			System.out.print(node.data+" ");
			size--;
			if(node.left!=null)
				queue.add(node.left);
			if(node.right!=null)
				queue.add(node.right);
			if(size==0)
			{
				System.out.println();
				size=queue.size();
			}
		}
	}
	
	public int diameterLength()
	{
		Pair p = diameterLength(root);
		return p.diam;
	}
	
	public Pair diameterLength(Node root)
	{
		if(root==null)
		{
			return new Pair(0,0);
		}
		Pair left = diameterLength(root.left);
		Pair right = diameterLength(root.right);
		int h = Math.max(left.height, right.height)+1;
		int diam = left.height+right.height+1;
		int fin = Math.max(diam, Math.max(left.diam, right.diam));
		return new Pair(h,fin);
	}
	
	static class Pair
	{
		int height;
		int diam;
		
		public Pair(int h, int d)
		{
			height = h;
			diam = d;
		}
	}
	
	public void pir(int low, int high)
	{
		pir(root,low,high);
	}
	
	public void pir(Node root, int low, int high)
	{
		if(root==null)
		{
			return;
		}
		if(root.data>high)
		{
			pir(root.left,low,high);
		}
		else if(root.data>=low && root.data<=high)
		{
			pir(root.left,low,high);
			System.out.println(root.data);
			pir(root.right,low,high);
		}
		if(root.data<low)
		{
			pir(root.right,low,high);
		}
	}
	private int sum=0;
	public void replaceWithLargerNodes(Node root)
	{
		if(root==null)
		{
			return;
		}
		
		replaceWithLargerNodes(root.right);
		int temp = root.data;
		root.data = sum;
		sum += temp;
		replaceWithLargerNodes(root.left);
		
	}
	
	public int lca(Node root, int l1, int l2)
	{
		if(root==null)
		{
			return -1;
		}
		
		if(root.data> l1 && root.data>l2)
		{
			return lca(root.left,l1,l2);
		}
		
		else if(root.data< l1 && root.data<l2)
		{
			return lca(root.right,l1,l2);
		}
		else
		{
			return root.data;
		}
	}
	
	public boolean find(Node root,int n)
	{
		if(root==null)
			return false;
		boolean bool;
		if(n<root.data)
		{
			bool = find(root.left,n);
		}
		else if(n>root.data)
		{
			bool = find(root.right,n);
		}
		else
		{
			return true;
		}
		return bool;
	}
	
	public void remove(int n)
	{
		if(find(root,n))
		{
			remove(root,n);
		}
		else
		{
			System.out.println("Node doesn't exist");
		}
	}

	private Node remove(Node root, int n) {
		// TODO Auto-generated method stub
		if(root.data<n)
		{
			root.right = remove(root.right,n);
		}
		else if(root.data>n)
		{
			root.left = remove(root.left,n);
		}
		else
		{
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			else
			{
				Node left = findLast(root.left);
				remove(this.root,left.data);
				root.data = left.data;
			}
		}
		return root;
	}

	private Node findLast(Node left) {
		// TODO Auto-generated method stub
		Node node = left;
		while(node.right!=null)
			node = node.right;
		return node;
	}
	
	public void targetSumPair(Node root, int sum)
	{
		if(root==null)
			return;
		int temp = root.data;
		if(find(this.root,sum-root.data))
		{
			System.out.println(temp+", "+(sum-temp));
			return;
		}
		else
		{
			targetSumPair(root.left, sum);
			targetSumPair(root.right, sum);
		}
	}
	
}
