package com.example.circularlinkedlist;

public class Node {
    public int data;
    public Node next;

    public Node(int key) {
        this.data = key;
        this.next = null;
    }

    public String toString() {
        return String.format("<Node %d>", data);
    }
}
