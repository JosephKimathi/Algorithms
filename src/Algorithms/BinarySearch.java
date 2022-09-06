package Algorithms;

/******************************************************************************
 *  Compilation:  javac BinarySearch.java
 *  Execution:    java BinarySearch wordlist.txt < input.txt
 *  Data files:   https://introcs.cs.princeton.edu/java/42sort/emails.txt
 *                https://introcs.cs.princeton.edu/java/42sort/allowlist.txt
 *
 *  Read in an alphabetical list of words from the given file.
 *  Then prompt the user to enter words. The program reports which
 *  words are *not* in the wordlist.
 *
 *  % java BinarySearch allowlist.txt < emails.html
 *  marvin@spam
 *  mallory@spam
 *  eve@airport
 *
 ******************************************************************************/

import princeton.*;

import java.util.Arrays;

public class BinarySearch {

	// return the index of the key in the sorted array a[]; -1 if not found
	public static int search(String key, String[] a) {
		return search(key, a, 0, a.length);
	}

	public static int search(String key, String[] a, int low, int high) {
		// return -1 if not found
		if (high <= low) {
			return -1;
		}

		// compute the mid-point of the range
		int mid = low + (high - low) / 2;

		// compare a[mid] to key
		int cmp = a[mid].compareTo(key);
		if (cmp > 0) {
			return search(key, a, low, mid);
		} else if (cmp < 0) {
			return search(key, a, mid + 1, high);
		}
		return mid;

	}

	// allow list, exception filter
	public static void main(String[] args) {

		System.err.println("Type a filename: ");
		In in = new In(StdIn.readString());
		String s = in.readAll();
		String[] words = s.split("\\s+");
		System.err.println("Done reading words");

		// sort the words (if needed)
		Arrays.sort(words);
		System.err.println("Done sorting words");

		// prompt user to enter a word and check if it's there
		System.err.println("Type words to check: ");
		while (!StdIn.isEmpty()) {
			String key = StdIn.readString();
			int index = search(key, words);
			if (index < 0) {
				System.out.println(key + " not found");
			} else {
				System.out.println(key + " found at index " + index);
			}
		}
	}
}
