package com.example.huffman;
public class Node {
    public int frequency;
    public char character;
    public Node left;
    public Node right;

    public Node(char c, int val) {
        this.frequency = val;
        this.character = c;
    }

    public void display() {
        System.out.printf("{ Node %s; %d }\n", character == Character.MIN_VALUE ? "[NULL]" : character, frequency);
    }
}
