# The Huffman Code
## Overview
- The most common characters are represented by the smallest number of bits.
- A bit representation cannot be the prefix of another bit representation (example: **01** for E and **01**011100 for X).
- Each message has a unique code tailored for the message.

## Decoding
- Given a string of bits, decoding will return a message using a type of binary tree known as a Huffman tree.

### The Huffman Tree
- Characters in the message appear as leaf nodes.
- The higher the frequency, the higher up in the tree they appear.
- Each node has a frequency associated with it.
- The frequency of a leaf node is the frequency of a character, the frequency of a non-leaf node is the frequency of its direct descendents.

### Traversing the Huffman Tree
- Each node has a bit associated with it and decoding a message with a Huffman tree just requires following the bit values relative to the root node.

## Encoding

### Creating the Huffman tree

1. Create a node for each character in the message. A node has the character and its frequency in the message.
2. Make a tree for each of these nodes such that the node is the root.
3. Insert the trees in to a priority queue ordered by ascending frequency. The least frequently used character should be the highest priority.
4. Remove from the queue 2 at a time and make them the children of a new node where the frequency is the sum of the 2 node frequencies. Its character field is blank.
5. Insert this new tree back into the queue.
6. Steps 4 and 5 will repeat until there is a single tree. Once there is a single tree in the queue, the algorithm has finished.

### Coding the message

1. Starting from the root, follow every path to a given leaf node. While traversing, mark a left as 0 and a right as 1. The resulting binary string is the Huffman code.

### Generating the code table

1. The resulting Huffman codes must correspond to a character. The code table is an array that keeps track of which code belongs to which table.