package com.example.huffman;


public class FrequencyLinkedList {
    public LinkedListNode head;
    
    public FrequencyLinkedList(){
        head = null;
    }

    public void display(){
        LinkedListNode curr = head;
        while (curr != null) {
            if (curr.next == null) {
                curr.display();
            }
            else {
                curr.display();
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println("");
    }
    public LinkedListNode search(char key){
        LinkedListNode curr = head;
        while (curr != null) {
            if (curr.character == key) {
                return curr;
            }
            curr = curr.next;
        }
        return curr;
    }

    public void insert(char key){
        LinkedListNode curr = head;

        if (curr == null) {
            LinkedListNode newNode = new LinkedListNode(key, 1);
            head = newNode;
            return;
        }

        LinkedListNode prev = null;
        
        while (curr != null) {
            if (curr.character == key) {
                curr.frequency++;
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            LinkedListNode newNode = new LinkedListNode(key, 1);
            prev.next = newNode;
        }
    }

    public static void main(String[] args) {
        FrequencyLinkedList ll = new FrequencyLinkedList();
        ll.insert('s');
        ll.insert('s');
        ll.insert('a');
        ll.insert('m');
        ll.insert('u');
        ll.insert('s');
        ll.insert('s');
        ll.insert('m');
        ll.insert('m');
        ll.display();

        String str = "hi, my name is sam";
        FrequencyLinkedList ll2 = new FrequencyLinkedList();
        for (int i = 0; i < str.length(); i++) {
            ll2.insert(str.charAt(i));
        }
        ll2.display();
        System.out.println(ll2.search('s').frequency);
    }
}
