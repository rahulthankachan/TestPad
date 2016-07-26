import java.util.Scanner;


public class TestPad {

	public static void main(String[] args) {

		QueueInterface qq = new Queue();
		int option = 0;

		Scanner scanner = new Scanner(System.in);

		do {

			System.out.println("1. Enque \n\n2. Deque \n3. Exit: ");
			option = scanner.nextInt();

			if (option == 1) {
				System.out.println("Enter the data ");
				qq.enqueue(scanner.nextInt());
			} else if (option == 2) {
				System.out.println("The item remove is " + qq.dequeue());
			}
		} while (option != 3);


	}
}



class Queue implements QueueInterface{

	Node first, last = null;

	public void enqueue(int data) {

		Node newNode = new Node(data);
		newNode.next = null;
		if (last == null) {
			last = newNode;
			first = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
	}

	public int dequeue() {

		int element = -1;

		element = first.data;
		first = first.next;
		if (first == null) {
			last = null;
		}

		return element;

	}


}

class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
}


interface QueueInterface {

	public void enqueue(int data);
	public int dequeue();
}
