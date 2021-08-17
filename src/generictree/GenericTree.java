package generictree;

import java.util.*;

public class GenericTree {
	
	Node root;
	
	private class Node
	{
		int data;
		List<Node> children;
		
		public Node(int node, List<Node> children)
		{
			this.data = node;
			this.children = children;
		}

		@Override
		public String toString() {
			return "Node [node=" + data + "]";
		}
		
		
	}
	
	public GenericTree(int[] arr)
	{
		Stack<Node> stack = new Stack<>();
		
		for(int n:arr)
		{
			if(n==-1)
			{
				stack.pop();
			}
			else
			{
				Node node2 = new Node(n,new ArrayList<Node>());
				if(root==null)
				{					
					root = node2;
				}
				else
				{
					Node temp = stack.peek();				
					temp.children.add(node2);
				}
				stack.push(node2);				
			}
		} 
	}
	
	public int size(Node root, int size)
	{
		
		for(Node node : root.children)
		{
			size = size(node,size)+1;
			
		}
		return size;
	}
	
	public void displayUsingQueue(Node root)
	{
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int size = queue.size();
		
		while(queue.size()>0)
		{
			Node node = queue.poll();
			System.out.print(node.data);
			//System.out.println(node.children);
			size--;
			for(Node temp:node.children)
			{
				queue.add(temp);
			}
			if(size==0)
			{
				System.out.println();
				size = queue.size();
			}		
		}
	}

	public void display(Node root) {
		// TODO Auto-generated method stub
		String s = root.data+"-> ";
		for(Node node : root.children)
		{
			s=s+node.data+", ";
		}
		s=s+".";
		System.out.println(s);
		
		for(Node node:root.children)
		{
			display(node);
		}
	}
	
	public int max(Node root)
	{
		int max = root.data;
		for(Node node:root.children)
		{
			max = Math.max(max, max(node));
		}
		return max;
	}
	
	public int height(Node root)
	{
		int ht = 0;
		
		for(Node node : root.children)
		{
			ht = Math.max(ht, height(node));
		}
		ht++;
		return ht;
	}
	
	public boolean find(Node root, int data)
	{
		boolean bool = root.data==data;
		
		for(Node node:root.children)
		{
			if(bool)
				return true;
			bool = find(node,data);
		}
		return bool;
	}
	
	public List<Node> nodeToRoot(Node root, int data)
	{
		
		List<Node> list = new ArrayList<>();
		
		if(root.data==data)
		{
			list.add(root);
			return list;
		}
		
		for(Node node : root.children)
		{
			
			list = nodeToRoot(node, data);
			if(list.size()>0)
			{
				list.add(root);
				return list;
			}
		}
		return list;
	}
	
	public int removeLeaves(Node root)
	{
		if(root.children.size()==0)
			return 1;
		
		for(int i=0;i<root.children.size();i++)
		{
			Node node = root.children.get(i);
			int n = removeLeaves(node);
			if(n==1)
			{
				root.children.remove(node);
				i--;
			}
		}
		
		return 0;
	}
	
	public void makeMirror(Node root)
	{
		for(Node node:root.children)
		{
			makeMirror(node);
		}
		int l = 0;
        int r = root.children.size() - 1;
        while (l < r) {
            Node leftNode = root.children.get(l);
            Node rightNode = root.children.get(r);
            root.children.set(l, rightNode);
            root.children.set(r, leftNode);
            l++;
            r--;
        }
        //System.out.println(root+"->"+root.children);
	}
	
	public void linearise(Node root)
	{
		for(Node node:root.children)
		{
			linearise(node);
		}
		
		while(root.children.size()>1)
		{
			Node last = root.children.remove(root.children.size()-1);
			Node slast = root.children.get(root.children.size()-1);
			Node tail = getTail(slast);
			tail.children.add(last);
		}
	}
	
	public Node getTail(Node node)
	{
		while(node.children.size()>0)
		{
			node = node.children.get(0);
		}
		return node;
	}
	
	public Node linearise2(Node root)
	{
		if(root.children.size()==0)
			return root;
		
		Node last = linearise2(root.children.get(root.children.size()-1));
		
		while(root.children.size()>1)
		{
			Node last2 = root.children.remove(root.children.size()-1);
			Node slast = root.children.get(root.children.size()-1);
			Node tail = linearise2(slast);
			tail.children.add(last2);
		}
		return last;
	}
	
	public boolean isSimilarShaped(Node root, Node root2)
	{
		if(root.children.size()!=root2.children.size())
		{
			return false;
		}
		
		for(int i=0;i<root.children.size();i++)
		{
			Node node = root.children.get(i);
			Node node2 = root2.children.get(i);
			boolean bool = isSimilarShaped(node,node2);
			if(!bool)
				return false;
		}
		return true;
	}
	
	public boolean isMirror(Node root, Node root2)
	{
		if(root.children.size()!=root2.children.size())
			return false;
		
		for(int i=0,j=root.children.size()-1;i<root.children.size();i++,j--)
		{
			Node node = root.children.get(i);
			Node node2 = root2.children.get(j);
			boolean bool = isMirror(node,node2);
			if(!bool)
				return false;
		}
		int l = 0;
        int r = root.children.size() - 1;
        while (l < r) {
            Node leftNode = root.children.get(l);
            Node rightNode = root2.children.get(r);
            l++;
            r--;
            if(leftNode.data!=rightNode.data)
            	return false;
            
        }
        return true;
		
	}
	
	public int oddEvenLevelDifference(Node root)
	{
		int diff = 0,odd=0,even=0;
		boolean bool = false;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		int size = queue.size();
		even+=root.data;
		while(queue.size()>0)
		{
			Node node = queue.poll();
			size--;
			if(bool)
			{
				for(Node temp:node.children)
				{
					even+=temp.data;
					queue.add(temp);
				}
			}
			else
			{
				for(Node temp:node.children)
				{
					odd+=temp.data;
					queue.add(temp);
				}
			}
			if(size==0)
			{
				bool = !bool;
				size = queue.size();
			}
		}
		diff=Math.abs(even-odd);
		return diff;
	}
	
}
