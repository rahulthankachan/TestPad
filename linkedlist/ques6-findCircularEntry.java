
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class TestPad {

	private Node head = null;
	private Set<Integer> mapping;


	public static void main(String args[]) {
		TestPad linkedList1 = new TestPad();


		int[] initialData1 = new int[] {1,2,3,4,5,6,7,8,9, 10};

		linkedList1.setHead(initialize(initialData1));


		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the index at which we want a circular loop");
		int index = scanner.nextInt();

		System.out.println(index);
		creatLoopAtIndex(linkedList1.getHead(), index);

		//printList(linkedList1.getHead());
		//checkForLoop(linkedList1.getHead());
		int data = collisionPointDetection(linkedList1.getHead());
		System.out.println("The data at the entry pointer is " + data);

	}


	public static int collisionPointDetection(Node head) {

		if (checkForLoop(head) == false) {
			return -1;
		} 

		Node collisionPointer = getCollisionPointer(head);
		System.out.println("The collision Pinter data is  " + collisionPointer.data);
		Node slowRunner = head;
		Node entryPoint = null;


		while (slowRunner.next!= null && collisionPointer.next != null) {
			slowRunner = slowRunner.next;
			collisionPointer = collisionPointer.next;
			if (slowRunner == collisionPointer) {
				entryPoint = slowRunner;
				break;
			}
		}


		return slowRunner.data;


	}


	public static Node getCollisionPointer(Node head) {


		Node temp = head;
		Node runner = head;

		while (temp.next != null && runner.next.next != null) {
			temp = temp.next;
			runner = runner.next.next;
			if (temp == runner) {	
				/// Collision
				return temp;
			}

		}

		return null;
	}






	public static boolean checkForLoop(Node head) {

		Node runner = head;
		Node temp = head;
		boolean loopExists = false;

		while (temp.next !=null && runner.next.next!= null) {
			temp = temp.next;
			runner = runner.next.next;
			if (temp == runner) {
				loopExists = true;
				break;
			}
		}

		System.out.println("There is a loop in the LinkedList " + loopExists);
		return loopExists;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}


	public static void creatLoopAtIndex(Node head, int index) {

		Node temp = head;
		if (head == null) {
			return;
		} 

		while (index > 1) {
			temp = temp.next;
			index -= 1;
		}

		Node tail = getTail(head);

		tail.next = temp;

	}

	public static Node getTail(Node head) {

		Node tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}

		return tail;
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










