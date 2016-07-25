
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class TestPad {

	private Node head = null;
	private Set<Integer> mapping;


	public static void main(String args[]) {
		TestPad linkedList1 = new TestPad();


		int[] initialData1 = new int[] {1,2,3,2,1};

		linkedList1.setHead(initialize(initialData1));
		boolean result = isPallindrone(linkedList1.getHead());

		if (result) {
			System.out.println("The linked list is Boolean Rahul");
		} else {
			System.out.println("The linked list is not Boolean");
		}

	}

	public static boolean isPallindrone(Node head) {

		Result r = isPallindroneHelper(head, size(head));
		return r.result;


	}


	/// The retunr is always an Object
	public static Result isPallindroneHelper(Node head, int length) {

		// base condition //
		if (length == 0 || head == null) {
			return new Result(null, true);
		} else if (length == 1) {
			return new Result (head.next, true);
		} else if (length == 2) {
			return new Result(head.next.next, head.data == head.next.data);
		}

 		// This will always will be the partial result //
		Result partial = isPallindroneHelper(head.next, length - 2);

		if (partial.result == false || partial.node == null) // no element
		{
			return partial;
		} else {
			partial.result = (head.data == partial.node.data);
			partial.node = partial.node.next;

			return partial;
		}
	}





	public static int size(Node node) {

		if (node == null) {
			return 0;
		}

		int count = 0;
		Node temp = node;
		while (temp != null) {
			count += 1;
			temp = temp.next;
		}

		return count;
	}


	public static void printList(Node head) {

		System.out.println("\n");
		Node temp = head;

		while (temp != null) {
			if (temp.next != null) {
				System.out.print(temp.data + "->");	
			} else {
				System.out.print(temp.data + "\n");
			}

			temp = temp.next;
		}
	}


	public static Node initialize(int[] values) {

		Node head = null;
		for (int i = 0; i < values.length; i++) {
			
			head = insertion(head, values[i]);
		}

		return head;
	}

	public static Node insertion (Node head, int value) {

		if (head == null) {
			Node temp =  new Node (value);
			temp.next = null;
			temp.prev = null;
			return temp;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		Node newNode = new Node(value);
		temp.next = newNode;
		newNode.prev = temp;
		return head;

	}


	public Node getHead() {

		return this.head;

	}

	public void setHead(Node head) {
		this.head = head;
	}




}


class Node {

	int data;
	Node next = null;
	Node prev = null;

	public Node(int data) {
		this.data = data;
	}

	public Node() {


	}
}


class Result {


	Node node;
	boolean result;

	public Result(Node next, boolean result) {
		this.node = next;
		this.result = result;
	}
}










