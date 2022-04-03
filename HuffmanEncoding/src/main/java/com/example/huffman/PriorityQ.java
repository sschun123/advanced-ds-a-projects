package com.example.huffman;

public class PriorityQ {
    private int max;
    private Node[] priorityQ;
    private int numOfItems;

    public static void main(String[] args) {
        PriorityQ q = new PriorityQ(10);
        q.insert(new Node('c', 10));
        q.insert(new Node('a', 3));
        q.insert(new Node('d', 4));
        q.insert(new Node('e', 3));
        q.insert(new Node('w', 32));
        q.insert(new Node('z', 21));
        q.display();
    }
    
    public PriorityQ(int s){
        max = s;
        priorityQ = new Node[max];
        numOfItems = 0;
    }
    public void insert(Node node){
        int i;
        if(numOfItems == 0) //check if this is the first item
            priorityQ[numOfItems++] = node;
        else{
            for(i = numOfItems -1 ; i >=0 ; i--){
                if(node.frequency > priorityQ[i].frequency)
                    priorityQ[i+1] = priorityQ[i];
                else
                    break;
            }
            priorityQ[i+1] = node;
            numOfItems++;
        }
    }
    public Node delete(){
        if (numOfItems == 0) {
            return null;
        }
        return priorityQ[--numOfItems];
    }
    public Node peek(){
        return priorityQ[numOfItems-1];
    }
    public boolean isEmpty(){
        return numOfItems == 0;
    }
    public boolean isFull(){
        return numOfItems == max;
    }

    public void display() {
        if (numOfItems == 0) {
            System.out.println("Empty");
            return;    
        }
        System.out.println(priorityQ[0].frequency);
        String str = String.format("Back { Node %s: %d } -> ", priorityQ[0].character, priorityQ[0].frequency);
        for (int i = 1; i < numOfItems-1; i++) {
            str += String.format("{ Node %s: %d } -> ", priorityQ[i].character, priorityQ[i].frequency);
        }
        str += String.format("{ Node %s: %d } Front", priorityQ[numOfItems - 1].character, priorityQ[numOfItems - 1].frequency);

        System.out.println(str);
    }
}
