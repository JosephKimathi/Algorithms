package Algorithms;

import edu.princeton.cs.algs4.Queue;
import princeton.*;

public class HashTable<Key, Value> {
     private final int m = 1024; // fixed size hashtable
	private final Node[] table = new HashTable.Node[m]; // table

    //A linked list data type
    private class Node {
        private final Key key;
        private Value val;
        private Node next;

        private Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    //Returns a hash value between 0 and m-1
    private int hash(Key key) {
        return Math.abs(key.hashCode() % m);
    }

    //Returns the value associated with the specified key
    //in this symbol table.
    @SuppressWarnings("unchecked")
    public Value get(Key key) {
        int i = hash(key);
        for (Node x = table[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return (Value) x.val;
            }
        }
        return null;
    }

    //Inserts the specified key-value pair into the symbol table,
    //overwriting the old value with the new value if the symbol
    //table already contains the specified key.
    public void put(Key key, Value val) {
        int i = hash(key);
        for (Node x = table[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        table[i] = new Node(key, val, table[i]);
    }

    //Returns all the keys in the symbol table.
    @SuppressWarnings("unchecked")
    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Node x = table[i]; x != null; x = x.next) {
                queue.enqueue((Key) x.key);
            }
        }
        return queue;
    }

    //Tests the HashTable data type.
    public static void main(String[] args) {
        HashTable<String, Integer> st = new HashTable<String, Integer>();
        for (int i = 0; i < 5; i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        // print the keys
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));

    }

}
