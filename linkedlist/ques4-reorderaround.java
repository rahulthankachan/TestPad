
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class TestPad {

	private Node head = null;
	private Set<Integer> mapping;

	public static void main(String args[]) {
		TestPad test = new TestPad();

		int[] initialData = new int[] {8,3,1,2,20,22,1,50,2};
		test.initial(initialData);

		test.printList();
		System.out.println("\n\n");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Q4 - Reorder around the index ");
		int index = scanner.nextInt();
		test.printList();
		test.reorderAroundIndex(index);
		test.printList();

}
////////////////////////////////////////////////////////
//////////////////////////////////////////////////

	public void reorderAroundIndex(int index) {

		Node tail = getTailPointer();
		Node indexPointer = getPointerAtIndex(index);
		System.out.println("\n\n");
		System.out.println("The index pointer is " + indexPointer.data);
		System.out.println("The tail pointer is " + tail.data);

		Node temp = head;
		while (temp.data > indexPointer.data && temp != indexPointer) {
			Node lastNode = new Node();
			lastNode.data = temp.data;
			lastNode.next = null;
			tail.next = lastNode;
			head = head.next;
			temp = temp.next;
			tail = tail.next;
		}


		Node runner = temp.next;
		while (runner != indexPointer && temp!= indexPointer) {
			if (runner.data > indexPointer.data) {
				Node lastNode = new Node();
				lastNode.data = runner.data;
				lastNode.next = null;
				tail.next = lastNode;
				tail = tail.next;
				temp.next = temp.next.next;
				runner = runner.next;


			} else {
				temp = temp.next;
				runner = runner.next;
			}
		}



		runner = indexPointer.next;
		temp = indexPointer;

		while(runner!= null) {
			if (indexPointer.data >= runner.data) {
				Node beginNode = new Node();
				beginNode.data = runner.data;
				beginNode.next = head;
				head = beginNode;

				//deletion
				temp.next = temp.next.next;
				runner = runner.next;
			} else {
				temp = temp.next;
				runner = runner.next;
			}
		}
	}


	public Node getTailPointer() {
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}

		return temp;
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

		System.out.println("\n");
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

	public Node() {

	}
}
