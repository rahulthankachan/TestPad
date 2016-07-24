
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class TestPad {

	private Node head = null;
	private Set<Integer> mapping;


	public static void main(String args[]) {
		TestPad linkedList1 = new TestPad();
		TestPad linkedList2 = new TestPad();

		int[] initialData1 = new int[] {9, 9, 9, 9, 9};
		int[] initialData2 = new int[] {1, 2, 3, 9, 9};
		linkedList1.initial(initialData1);
		linkedList2.initial(initialData2);

		Node sumLinkedlist = sumOfLinkedList(linkedList1.getHead(), linkedList2.getHead());
		printList(sumLinkedlist);

	}


	public static Node sumOfLinkedList(Node l1, Node l2) {

		int len1 = size(l1);
		int len2 = size(l2);

		if (len2 > len1) {
			l1 = paddingHelper(l1, len2 - len1);
		} else if (len1 > len2) {

			l2 = paddingHelper(l2, len1 - len2);
		}

		printList(l1);
		printList(l2);

		//////////////////

		PartialSum sum = addLinkedListHelper(l1, l2);
		
		if (sum.carry == 0) {
			return sum.partialSumHead;
		} else {

			Node result = insertBefore(sum.partialSumHead, sum.carry);
			return result;
		}






	}




	public static PartialSum addLinkedListHelper(Node l1, Node l2) {

	/// partial sum of the number on the right :D /////


		if (l1 == null && l2 == null) {

			PartialSum sum = new PartialSum();
			sum.carry = 0;
			return sum;
		}


		PartialSum partialSum = addLinkedListHelper(l1.next, l2.next);

		int val = partialSum.carry + l1.data + l2.data;

		Node full_result = insertBefore(partialSum.partialSumHead, val % 10);

		partialSum.partialSumHead = full_result;
		partialSum.carry = val / 10;


		return partialSum;

	}

	public static Node insertBefore(Node head, int carry) {

		Node temp = new Node();
		temp.data = carry;
		temp.next = head;
		head = temp;
		return temp;


	}



	public static Node paddingHelper(Node head, int padCount) {
		if (head == null) {
			return null;
		}
		
		while (padCount > 0) {
			Node temp = new Node();
			temp.data = 0;
			temp.next = head;
			head = temp;
			padCount -= 1;
		}


		return head;

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


















////////////////////////////////////////////////////////
//////////////////////////////////////////////////

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

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




class PartialSum {


	public Node partialSumHead = null;
	public int carry = 0;

}
