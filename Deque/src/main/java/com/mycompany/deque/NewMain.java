package com.mycompany.deque;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deque dq = new Deque(4);
        dq.insertLeft(10);
        dq.insertLeft(20);
        dq.insertRight(30);
        dq.insertLeft(0);

        int test1 = dq.deleteLeft();
        int test2 = dq.deleteLeft();
        int test3 = dq.deleteRight();
        int test4 = dq.deleteRight();

        System.out.printf("%d %d %d %d\n", test1, test2, test3, test4);

        DequeStack ds = new DequeStack(4);
        ds.push(10);
        ds.push(20);
        System.out.println(ds.peek());
        ds.push(30);
        System.out.println(ds.peek());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        ds.push(10);
        ds.push(20);
        ds.push(30);
        ds.push(40);
        ds.push(50);
    }
    
}
