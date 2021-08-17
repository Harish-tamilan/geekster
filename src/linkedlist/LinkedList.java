package linkedlist;

public class LinkedList {

	private Node head;
	private int size;
	private Node tail;

	public void addFirst(int data) {
		Node temp = new Node(data);
		addFirst(temp);
	}

	public void addFirst(Node node) {
		if (this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			node.setNext(head);
			this.head = node;
		}
		this.size++;
	}

	public void addLast(int data) {
		Node temp = new Node(data);
		this.addLast(temp);
	}

	public void addLast(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
		this.size++;
	}

	public void addAtPos(int data, int pos) throws Exception {
		addAtPos(new Node(data), pos);
	}

	public void addAtPos(Node node, int pos) throws Exception {
		if (pos < 0 || pos > size)
			throw new Exception("position cannot be less than 0 and greater that size");
		if (pos == 0) {
			addFirst(node);
		} else if (pos == size) {
			addLast(node);
		} else {
			int count = 0;
			Node current = head;
			while (count < pos - 1) {
				current = current.getNext();
				count++;
			}
			node.setNext(current.getNext());
			current.setNext(node);
			size++;
		}
	}

	public Node removeFirst() throws Exception {
		Node removedNode = head;
		if (size == 0) {
			throw new Exception("there is no data");
		}
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			Node temp = head.getNext();
			head.setNext(null);
			head = temp;
		}
		size--;
		return removedNode;
	}

	public Node removeLast() throws Exception {
		Node removedNode = tail;
		if (size == 0) {
			throw new Exception("there is no data");
		}

		if (size == 1) {
			head = null;
			tail = null;
		}
		Node current = head;
		int count = 0;
		while (count < size - 2) {
			current = current.getNext();
			count++;
		}
		tail = current;
		current.setNext(current.getNext().getNext());
		this.size--;
		return removedNode;
	}

	public Node removeAtPos(int pos) throws Exception {
		if (pos < 0 || pos > size - 1) {
			throw new Exception("position cannot be less than 0 and greater that size");
		} else if (pos == 0) {
			removeFirst();
		} else if (pos == size - 1) {
			removeLast();
		} else {
			Node current = head;
			int count = 0;
			while (count < pos - 1) {
				current = current.getNext();
				count++;
			}
			Node temp = current.getNext().getNext();
			current.getNext().setNext(null);
			current.setNext(temp);
			size--;
		}
		return head;
	}

	public Node findMidWithSize() throws Exception {
		if (size == 0) {
			throw new Exception("there is no data");
		}
		int count = 0;
		Node current = head;
		int n = 0;
		if (size % 2 == 0) {
			n = (size / 2) - 1;
		} else {
			n = (size / 2);
		}
		while (count < n) {
			current = current.getNext();
			count++;
		}
		return current;
	}

	public Node findMidWithoutSize() throws Exception {
		if (size == 0) {
			throw new Exception("there is no data");
		}
		Node rabbit = head;
		Node tortoise = head;
		while (rabbit.getNext() != null && rabbit.getNext().getNext() != null) {
			rabbit = rabbit.getNext().getNext();
			tortoise = tortoise.getNext();
		}
		return tortoise;
	}

	public int getFirst() {
		if (this.size == 0) {
			return -1;
		}

		return this.head.getData();
	}

	public int getLast() {
		if (this.size == 0) {
			return -1;
		}

		return this.tail.getData();
	}

	public int getAt(int idx) {
		if (idx >= this.size || idx < 0) {
			return -1;
		}

		int count = 0;
		Node temp = this.head;
		while (count < idx) {
			temp = temp.getNext();
			count++;
		}

		return temp.getData();
	}

	public Node getNodeAt(int idx) throws Exception {
		if (idx >= this.size || idx < 0) {
			throw new Exception("Not Possible Index");
		}

		int count = 0;
		Node temp = this.head;
		while (count < idx) {
			temp = temp.getNext();
			count++;
		}

		return temp;
	}

	public void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.getData() + "->");
			current = current.getNext();
		}
		System.out.println();
	}

	public void reverseDI() throws Exception {
		int l = 0;
		int r = this.size - 1;
		while (l < r) {
			Node lNode = getNodeAt(l);
			Node rNode = getNodeAt(r);

//			swap
			int temp = lNode.getData();
			lNode.setData(rNode.getData());
			rNode.setData(temp);
			l++;
			r--;
		}
	}
	Node leftHelper;
	 
	public boolean isPalindrome()
	{
		this.leftHelper = this.head;
		return isPalindrome(this.head);
	}

	private boolean isPalindrome(Node right) {
		// TODO Auto-generated method stub
		if(right==null)
			return true;
		
		boolean bool = isPalindrome(right.getNext());
		if(!bool)
			return false;
		
		if(leftHelper.getData()!=right.getData())
			return false;
		
		leftHelper = leftHelper.getNext();
		
		return true;
	}
	
	public void fold()
	{
		leftHelper = this.head;
		fold(this.head,0);
	}

	private void fold(Node right,int fl) {
		// TODO Auto-generated method stub
		
		if(right==null)
			return;
		fold(right.getNext(),fl+1);
		if(fl>size/2)
		{
			Node curLeft = leftHelper.getNext();
			leftHelper.setNext(right);
			right.setNext(curLeft);
			leftHelper = curLeft;
		}

		if(fl==size/2)
		{
			right.setNext(null);
			tail = right;
		}
	}
	
	public void reverseDataRecursion()
	{
		leftHelper = this.head;
		reverseDataRecursion(this.head,0);
	}

	private void reverseDataRecursion(Node right, int fl) {
		// TODO Auto-generated method stub
		if(right==null)
			return;
		
		reverseDataRecursion(right.getNext(),fl+1);
		
		if(fl>=size/2)
		{
			int temp;
			temp = leftHelper.getData();
			leftHelper.setData(right.getData());
			right.setData(temp);
			leftHelper = leftHelper.getNext();
		}	
		
	}
	
	public int kthElementFromLastIteration(int k)
	{
		Node fast = head;
		Node slow = head;
		while(k>0)
		{
			fast = fast.getNext();
			k--;
		}
		
		while(fast!=null)
		{
			fast = fast.getNext();
			slow = slow.getNext();
		}
		
		return slow.getData();
	}
	
	public int kthElementFromLastRecursion(int k)
	{
		leftHelper = this.head;
		return kthElementFromLastRecursion(this.head,k,0);
	}

	private int kthElementFromLastRecursion(Node right, int k, int fl) {
		// TODO Auto-generated method stub
		if(right==null)
			return 0;
		
		int data = kthElementFromLastRecursion(right.getNext(),k,fl+1);
		if(fl==size-k)
			return right.getData();
		
		return data;
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public LinkedList mergeTwoSortedList(Node n1, Node n2)
	{
		LinkedList n3 = new LinkedList();
		
		while(n1!=null && n2!=null)
		{
			if(n1.getData()<n2.getData())
			{
				n3.addLast(n1.getData());
				n1 = n1.getNext();
			}
			else
			{
				n3.addLast(n2.getData());
				n2 = n2.getNext();
			}
		}
		
		while(n1!=null)
		{
			n3.addLast(n1.getData());
			n1 = n1.getNext();
		}
		
		while(n2!=null)
		{
			n3.addLast(n2.getData());
			n2 = n2.getNext();
		} 
		
		return n3;
	}
	
	public void reversePointerRecursion()
	{
		reversePointerRecursion(this.head);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.setNext(null);
	}
	
	public void reversePointerRecursion(Node right)
	{
		if(right.getNext()==null)
			return;
		reversePointerRecursion(right.getNext());
		right.getNext().setNext(right);
	}
	
	public void makeCycle()
	{
		this.tail.setNext(this.head);
	}
	
	public boolean isCycle()
	{
		Node fast = this.head.getNext().getNext();
		Node slow = this.head;
		
		while(fast!=null && fast.getNext()!=null && slow!=null)
		{
			if(fast==slow)
			{
				System.out.println(fast.getData());
				return true;
			}
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		System.out.println(fast.getData());
		return false;
	}
	
	public Node findCycle() {
		Node curr = head;
		boolean isCycle = this.isCycle();
		if(!isCycle)
			return head;
		Node slow = head.getNext();
		Node fast = head.getNext().getNext();
		while (slow != fast) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		slow = head;
		Node prev = fast;
		while (slow != fast) {
			prev = fast;
			slow = slow.getNext();
			fast = fast.getNext();
		}
		return prev;
	}
	
	public Node reverseInGroup(Node head, int k)
	{
		Node cur = head;
		Node prev = null;
		Node next = null;
			int i=0;
			
			while(cur!=null && i<k)
			{
				next = cur.getNext();
				cur.setNext(prev);
				prev = cur;
				cur = next;
				i++;
			}
			
		if(next!=null)
			head.setNext(reverseInGroup(cur,k));
		
		return prev;
	}
	
//	public Node reverseInGroup(Node tempHead, int k) {
//		Node curr = tempHead;
//		Node prev = null;
//		Node nextOne = null;
//		int count = 0;
//		//normal reverse code
//		while(count < k && curr != null) {
//			nextOne =  curr.getNext(); //2
//			curr.setNext(prev);
//			prev = curr;
//			curr = nextOne;
//			count++;
//		}
//		if(nextOne != null)
//			//recursive call for next set of nodes
//			tempHead.setNext(reverseInGroup(nextOne, k));
//		return prev;
//	}
	
}
