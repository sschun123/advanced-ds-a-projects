package Deque.src.main.java.com.mycompany.deque;

public class DequeStack {
    private int max;
    private Deque dq;
    private int numItems;

    public DequeStack(int size) {
        max = size;
        dq = new Deque(max);
        numItems = 0;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public boolean isFull() {
        return numItems == max;
    }

    public void push(int val) {
        if (isFull()) {
            System.out.println("Cannot push, DequeStack is full");
        }
        else {
            dq.insertLeft(val);
            numItems++;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        numItems--;
        return dq.deleteLeft();
    }

    public int peek() {
        int tmp = dq.deleteLeft();
        dq.insertLeft(tmp);
        return tmp;
    }
}
