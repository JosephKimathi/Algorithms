package Algorithms;
import stdlib.*;

/******************************************************************************
 *  Compilation:  javac Insertion.java
 *  Execution:    java Insertion < input.txt
 *  Data files:   https://introcs.cs.princeton.edu/java/43sort/8words.txt
 *                https://introcs.cs.princeton.edu/java/43sort/TomSawyer.txt
 *
 *  Reads in strings from standard input and prints them in sorted order.
 *  Uses insertion sort.
 *
 *  % java Insertion < 8words.txt
 *  and but had him his the was you
 *
 ******************************************************************************/

public class Insertion {

    static final boolean DEBUG = true;

    public static void sort(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1].compareTo(array[j]) > 0) {
                    if (i == j) printList(array, j);
                    exchange(array, j - 1, j);
                    printList(array, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void printList(Comparable[] array, int j) {
        if (DEBUG) {
            for (int i = 0; i < array.length; i++) {
                if (i == j) {
                    System.out.print("\u001B[31m" + array[i] + " \u001B[0m");
                } else {
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println(" ");
        }
    }

    // exchange array[i] and array[j]
    private static void exchange(Comparable[] array, int i, int j) {
        Comparable tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // read in a sequence of words from standard input and
    // print them in sorted order
    public static void main(String[] args) {
        System.out.println("Type a filename that contains a list of items to sort: ");
        String filename = StdIn.readString();
        In in = new In(filename);
        String[] array = in.readAllStrings();
        sort(array);
        for (int i = 0; i < array.length; i++) {
            StdOut.print(array[i] + " ");
        }
        StdOut.println();
    }
}


