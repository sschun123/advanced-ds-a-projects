package com.example.huffman;

public class LinkedListNode {
    int frequency;
    char character;
    String code;
    LinkedListNode next;
    
    public LinkedListNode(char c, int data){
        this.frequency = data;
        this.character = c;
        this.next = null;
    }

    public void display() {
        System.out.printf("{ Node %s; %d; %s }", character, frequency, code);
    }
}
