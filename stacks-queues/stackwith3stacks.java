import customexceptions.*;

public class TestPad {
    int[] stackPointer = {-1, -1, -1};
    int size = 100;
    int[] buffer = new int[size * 3];

    public static void main(String[] args) {

      TestPad test = new TestPad();
      test.push(1, 1);
      test.push(1, 2);
      test.push(1, 3);
      test.push(0, 0);
      display(test.peek(0));
      display(test.peek(1));
      display(test.peek(2));

    }

    public static void display(int value) {
      System.out.println(value);
    }

    void push(int stackNum, int value) {

      // check if there is an overflow
      if (stackPointer[stackNum] + 1 >= size) {
        throw new StackFullException(stackNum + " IS FULL!!");
      } 
      stackPointer[stackNum]++;
      buffer[getAbsolutePosition(stackNum)] = value;
    }


    int pop(int stackNum) {
      // check if the stack is eptt first
      if (isStackEmpty(stackNum)) {
        throw new StackEmptyException(stackNum + " IS EMPTY!!");
      }

      int index = getAbsolutePosition(stackNum);
      int value = buffer[index];
      buffer[index] = 0;
      stackPointer[stackNum]--;
      return value;
    }

    int peek(int stackNum) {
      if (isStackEmpty(stackNum)) {
        throw new StackEmptyException(stackNum + " IS EMPTY!!");
      } 
      return buffer[getAbsolutePosition(stackNum)];
    }

    int getAbsolutePosition(int stackNum) {
      return stackNum * size + stackPointer[stackNum]; 
    }

    boolean isStackEmpty(int stackNum) {
      return stackPointer[stackNum] == -1;
    }


}


class StackFullException extends RuntimeException {

    public StackFullException(String s) {
      super(s);
    }
}

class StackEmptyException extends RuntimeException {

    public StackEmptyException(String s) {
      super(s);
    }
}


