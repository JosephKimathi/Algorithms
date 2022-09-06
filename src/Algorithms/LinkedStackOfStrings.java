package Algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class LinkedStackOfStrings {
    private Node first; // top of the stack
    private int n = 0; // the number of items on the stack

    private class Node {
        private String item;
        private Node next;
    }

    // is the stack empty?
    public boolean isEmpty() {
        return first == null;
    }

    // number of elements on the stack
    public int size() {
        return n;
    }

    // push an element on the stack
    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }
    // pop an element from the stack
    public String pop() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        String item = first.item;
        first = first.next;
        n--;
        return item;
    }

    @Override
    public String toString() {
        String s = " ";
        for (Node cur = first; cur != null; cur = cur.next) {
            s += cur.item + " ";
        }
        return s;
    }

    // test client
    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                stack.push(item);
                StdOut.print("Stack: " + stack.toString());
            } else if (stack.isEmpty()) {
                StdOut.println("BAD INPUT");
            } else  {
                StdOut.println("\u001B[31m" + stack.pop() + " \u001B[0m");
                StdOut.print("Stack: " + stack.toString());
            }
        }
    }


}



