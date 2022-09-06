package Algorithms;

import edu.princeton.cs.algs4.Queue;
import princeton.*;


public class BinarySearchTree<Key extends Comparable<Key>, Value>{
    private Node root;      // root of the Binary Search Tree

    private class Node {
        private final Key key;
        private Value val;
        private Node left, right;  //left and right subtrees

        public Node(Key k, Value v) {
            this.key = k;
            this.val = v;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null) return null;
        if (key == null) throw new IllegalArgumentException("key is null");
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    public Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val);
        if (key == null) throw new IllegalArgumentException("key is null");
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        return x;
    }

    // @return all keys in the symbol table
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        keysInOrder(root, queue);
        return queue;
    }

    private void keysInOrder(Node x, Queue<Key> queue) {
        if (x == null) return;
        keysInOrder(x.left, queue);
        queue.enqueue(x.key);
        keysInOrder(x.right, queue);
    }

    /**
     * Unit tests the {@code BinarySearchTree} data type.
     */
    public static void main(String[] args) {
        StdOut.println("How many words do you want to add? ");
        int count = StdIn.readInt();

        StdOut.println("Type " + count + " words: ");
        BinarySearchTree<String, Integer> st = new BinarySearchTree<String, Integer>();
        for (int i = 0; i < count; i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        StdOut.println("");
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));

     }

}




