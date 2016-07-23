
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class TestPad {

	private Node head = null;
	private Set<Integer> mapping;

	public static void main(String args[]) {
		TestPad test = new TestPad();

		int[] initialData = new int[] {1,2,3,4,3,4,5,5,5,2,7,2,2,22};
		test.initial(initialData);

		test.printList();
		System.out.println("\n\n");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Q3 - Delete given you have access to elements at index ");
		int index = scanner.nextInt();

		test.deleteValueAtIndex(index);

		test.printList();


		


	}
////////////////////////////////////////////////////////
//////////////////////////////////////////////////

	public void deleteValueAtIndex(int index) {

		Node tempIndex = getPointerAtIndex(index);
		System.out.println("The value is " + tempIndex.data);
		while (tempIndex.next != null) {
			tempIndex.data = tempIndex.next.data;
			tempIndex = tempIndex.next;
		}

	}

	public Node getPointerAtIndex(int index) {

		Node temp = head;
		for (int i = 1; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}



////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////
	private void removeDuplicates1() {

		Node temp = head;

		if (head == null) {
			return;
		}

		mapping.add(temp.data);

		while (temp.next != null) {
			if (mapping.contains(temp.next.data)) {
				temp.next = temp.next.next;
			} else {
				mapping.add(temp.next.data);
				temp = temp.next;
			}
		}


	}

	private void removeDuplicates2() {

		Node temp = head;
		if (head == null) {
			return;
		}

		Node runner1 = temp;
		Node runner2;

		while (temp.next != null) {
			runner1 = temp;
			runner2 = runner1.next;
			while (runner2 != null) {
				if (runner2.data == temp.data) {
					runner1.next = runner1.next.next;
					runner2 = runner1.next;
				} else {
					runner1 = runner2;
					runner2 = runner2.next;
				}
			}
			temp = temp.next;
		}
	}
 
	private void initial(int[] initialD) {
		head = null;
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
