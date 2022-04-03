package com.example.circularlinkedlist;

public class CircularLinkedList 
{
    Node curr;
    
    public void insert(int key) {
        Node newNode = new Node(key);
        if (curr == null) {
            curr = newNode;
            curr.next = curr;
        }
        else {
            Node tmp = curr.next;
            curr.next = newNode;
            newNode.next = tmp;
        }
    }

    public boolean delete() {
        if (curr == null) {
            return false;
        }
        else if (curr.next == curr) {
            curr = null;
            return true;
        }
        curr.next = curr.next.next;
        return true;
    }

    public Node search(int key) {
        int tmp = curr.data;
        step();
        while(tmp != curr.data) {
            if (curr.data == key) {
                return curr;
            }
            step();
        }
        return null;
    }

    public Node step() {
        if (curr == null) {
            System.out.println("Cannot step, list is empty.");
            return null;
        }
        curr = curr.next;
        return curr;
    }

    public String toString() {
        if (curr == null) {
            return "list is empty";
        }
        String nodes = "";
        Node tmp = curr;
        nodes += String.format("%s (curr) -> ", tmp.toString());
        step();
        while(curr != tmp) {
            nodes += String.format("%s -> ", curr.toString());
            step();
        }
        nodes += String.format("%s (curr)", tmp.toString());
        return nodes;
    }

    public void display() {
        System.out.println(toString());
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(1);
        cll.insert(2);
        cll.insert(3);
        cll.insert(4);
        cll.insert(5);
        cll.insert(6);
        cll.display();
        System.out.printf("Stepping from %s to %s\n", cll.curr, cll.curr.next);
        cll.step();
        cll.display();
        System.out.printf("Stepping from %s to %s\n", cll.curr, cll.curr.next);
        cll.step();
        cll.display();
        System.out.printf("Stepping from %s to %s\n", cll.curr, cll.curr.next);
        cll.step();
        cll.display();
        System.out.printf("Stepping from %s to %s\n", cll.curr, cll.curr.next);
        cll.step();
        cll.display();
        System.out.printf("Deleting %s, success: %s\n", cll.curr.next.toString(), cll.delete());
        cll.display();
        System.out.printf("Deleting %s, success: %s\n", cll.curr.next.toString(), cll.delete());
        cll.display();
        System.out.printf("Searching 4: %s\n", cll.search(4));
        System.out.printf("Searching 43: %s\n", cll.search(43));
        System.out.printf("Searching 3: %s\n", cll.search(3));
        System.out.printf("Deleting %s, success: %s\n", cll.curr.next.toString(), cll.delete());
        cll.display();
        System.out.printf("Deleting %s, success: %s\n", cll.curr.next.toString(), cll.delete());
        cll.display();
        System.out.printf("Deleting %s, success: %s\n", cll.curr.next.toString(), cll.delete());
        cll.display();
        System.out.printf("Deleting %s, success: %s\n", cll.curr.next.toString(), cll.delete());
        cll.display();
        System.out.printf("Cannot delete because list is empty, success: %s\n", cll.delete());
        cll.display();
    }
}
