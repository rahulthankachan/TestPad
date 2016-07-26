
public class TestPad {

	public static void main(String[] args) {

		ListInterface st = new Stack();
		for (int i = 0; i < 10; i++) {
			st.push(i);
		}



		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println("The current element at the top is " + st.peek());
		System.out.println("The lement shown earlier will be popped, element popped is " + st.pop());
		System.out.println("The size of the list is" + ((Stack)st).getSize());


	}
}


class Stack implements ListInterface{
	Node top;
	int size;

	public void push(int data) {

		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		size += 1;
	}

	public int pop() {
		int element = -1;

		if (top == null) {
			return -1;
		} else {
			element = top.data;
			top = top.next;
		}

		size -= 1;

		return element;

	}

	public int peek() {

		return top.data;


	}

	public int getSize() {

		return this.size;

	}



}

class Node {

	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}


interface ListInterface{

	public void push(int data);
	public int pop();
	public int peek();

}
