package Deque.src.main.java.com.mycompany.deque;

public class Deque {
    private int[] list;
    private int size;
    private int front;
    private int rear;
    private int numItems;

    public Deque(int dequeSize) {
        size = dequeSize;
        list = new int[size];
        front = 0;
        rear = size - 1;
        numItems = 0;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public boolean isFull() {
        return numItems == size;
    }

    public void insertLeft(int val) {
        if (isFull()) {
            System.out.println("Deque is full");
        }
        else {
            if (front == 0) {
                front = size;
            }
            list[--front] = val;
            numItems++;
        }
    }

    public void insertRight(int val) {
        if (isFull()) {
            System.out.println("Deque is full");
        }
        else {
            if (rear == size - 1) {
                rear = -1;
            }
            list[++rear] = val;
            numItems++;
        }
    }

    public int deleteLeft() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        if (front == size) {
            front = 0;
        }
        numItems--;
        return list[front++];
    }

    public int deleteRight() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int tmp = list[rear--];
        if (rear == -1) {
            rear = size - 1;
        }
        numItems--;
        return tmp;
    }
}
