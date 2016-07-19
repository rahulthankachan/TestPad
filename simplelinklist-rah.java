
import java.util.Scanner;

public class TestPad {

	private Node head = null;

	public static void main(String args[]) {
		TestPad test = new TestPad();

		int[] initialData = new int[] {1, 2, 3, 4};

		test.initial(initialData); // initialize the Linked list
		test.printList(); // Prints
		System.out.println("\n");

		/// Delete the Node
		System.out.println("Enter the element to be deleted ");
		Scanner sc = new Scanner(System.in);
		int del = sc.nextInt();
		System.out.println("The element added to delete is " + del);

		System.out.println("Deleted at position " + test.deleteNode(del));

		System.out.println("The linked list after deletion is ");

		test.printList();
		

		System.out.println("\n\n The count is " + test.getCount());

		System.out.println("Enter the element which has to be searched ");
		int checkElement = sc.nextInt();

		System.out.println("The element " + checkElement + " exists :" + test.elementExists(checkElement));

		System.out.println("The minimum in the Linked list is " + test.getMin());
		System.out.println("The maximum in the Linked list is " + test.getMax());



	}
 
	private void initial(int[] initialD) {

		for (int i = 0; i < initialD.length; i++) {
			appendNode(initialD[i]);
		}

	}

	public void appendNode (int value){

		Node temp;
		if (this.head == null) {

			// first element
			temp = new Node(value);
			temp.next = null;
			this.head = temp;

		} else {

			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			Node tempNew = new Node(value);
			tempNew.next = null;
			temp.next = tempNew;
			
		}

	}

	public int getCount() {

		int count = 0;
		Node temp = head;
		while (temp != null) {
			count += 1;
			temp = temp.next;

		}

		return count;

	}
	public void printList() {

		if (getCount() == 0) {
			System.out.println("There are no elements in the Linked List");

		} else {

			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data);
				if (temp.next !=null) {
					System.out.print("-> ");
					}
				temp = temp.next;
			}
		}
	}


	////// Deletion ///////

	public int deleteNode(int value) {

		Node temp = head;
		int index = 0;

		// base check
		if (head.data == value) {
			head = head.next;
			return index;
		}

		Node runner = head;
		while (runner.next != null) {
			index += 1;
			if (runner.next.data == value) {
				runner.next = runner.next.next;
				return index;
			} else {
				runner = runner.next;
			}

		}

		return -1;



	}


	//// Searching an element ////

	private boolean elementExists(int value) {

		Node temp = head;
		while (temp != null) {
			if (temp.data == value) {
				return true;
			}
			temp = temp.next;
		}
		
		return false;
	}


	/// minimum in the list ///

	private int getMin() {


		Node temp = head;
		int min = temp.data;
		while (temp != null) {
			if (temp.data < min) {
				min = temp.data;
			}
			temp = temp.next;
		}

		return min;
	}

	private int getMax() {

		Node temp = head;
		int max = temp.data;
		while (temp != null) {

			if (temp.data > max) {
				max = temp.data;
			}
			temp = temp.next;
		}

		return max;

	}
}


class Node {
	public Node next;
	public int data;

	public Node(int value) {
		this.data = value;

	}
}
