package priorityqueue;

import java.util.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = {1,4,5,6,7,8,9,10};
		Heap hp = new Heap();
		hp.add(arr, false);
		hp.display();
		hp.remove();
		hp.display();
	}

}
