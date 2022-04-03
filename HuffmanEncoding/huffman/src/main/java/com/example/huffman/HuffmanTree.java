package com.example.huffman;

/**
 * Hello world!
 *
 */
public class HuffmanTree 
{
    public Node root;
    private FrequencyLinkedList codeTable; 

    public static void main( String[] args )
    {
        HuffmanTree h = new HuffmanTree();
        String s = "Huffman encoding encodes a string into binary representations whose length corresponds to its frequency in the string.";

        String encoded = h.encode(s);
        String decoded = h.decode(encoded);
        System.out.printf("\nORIGINAL STRING\n%s\n", s);
        System.out.printf("\nENCODED\n%s\n", encoded);
        System.out.printf("\nDECODED\n%s\n", decoded);
    }

    public String encode(String str) {
        System.out.println("\nINIT ENCODING");
        String code = "";
        // Create a codeTable with nodes of unique chars and their frequency.
        codeTable = generateFrequencyList(str);
        // Create a Huffman tree
        Node hTree = createHuffmanTree(str);
        System.out.println("\nIN ORDER TRAVERSAL OF HUFFMAN TREE");
        HuffmanTree.inorder(hTree);
        // Build Huffman codes using the Huffman tree and codeTable.
        buildHuffmanCodes(hTree, "");
        System.out.println("\nCODE TABLE");
        codeTable.display();
        // Build the encoded string using the codeTable to find the code for each char in order.
        for (int i = 0; i < str.length(); i++) {
            code += codeTable.search(str.charAt(i)).code;
        }
        return code;
    }

    // Given a Huffman encoded binary string, use the Huffman tree to decode the string.
    public String decode(String binaryStr) {
        Node curr = root;
        Node parent = null;
        String str = "";
        Boolean isLeft = true;
        for (int i = 0; i < binaryStr.length(); i++) {
            char bit = binaryStr.charAt(i);
            parent = curr;
            if (bit == '0') {
                isLeft = true;
                curr = curr.left;
            }
            else if (bit == '1') {
                isLeft = false;
                curr = curr.right;
            }

            if (curr == null) {
                str += parent.character;
                parent = root;
                curr = isLeft ? root.left : root.right;
            }
        }
        return str + curr.character;
    }

    // Creates a Huffman tree using Priority Queue and codeTable
    private Node createHuffmanTree(String str) {
        PriorityQ q = generateQueue(str);
        // remove from q 2 at a time and make them children of a new node until 1 tree remains
        Node n1 = q.delete();
        Node n2 = q.delete();
        while (n2 != null) {
            // Non character nodes use this const as the default character value
            Node charSum = new Node(Character.MIN_VALUE, n1.frequency + n2.frequency);
            charSum.left = n1;
            charSum.right = n2;
            q.insert(charSum);
            n1 = q.delete();
            n2 = q.delete();
        }
        root = n1;
        return n1;
    }

    // Returns a codeTable whose nodes represent a unique character and the frequency of the character.
    private FrequencyLinkedList generateFrequencyList(String str) {
        FrequencyLinkedList ll = new FrequencyLinkedList();
        for (int i = 0; i < str.length(); i++) {
            ll.insert(str.charAt(i));
        }
        return ll;
    }

    // Returns a Priority Queue of character nodes ordered by the frequency of the character.
    private PriorityQ generateQueue(String str) {
        PriorityQ q = new PriorityQ(str.length());
        LinkedListNode curr = codeTable.head;
        while (curr != null) {
            Node charNode = new Node(curr.character, curr.frequency);
            q.insert(charNode);
            curr = curr.next;
        }
        return q;
    }

    private void buildHuffmanCodes(Node node, String code) {
        if (node == null) { return; }
        if (node.left == null && node.right == null) { // hit a leaf node, record the code.
            codeTable.search(node.character).code = code;
        }
        buildHuffmanCodes(node.left, code += "0");
        code = code.substring(0, code.length()-1); // Remove the last char before doing the right encoding.
        buildHuffmanCodes(node.right, code += "1");
    }

    static private void inorder(Node node) {
        if (node == null) { return; }
        inorder(node.left);
        node.display();
        inorder(node.right);
    }
}
