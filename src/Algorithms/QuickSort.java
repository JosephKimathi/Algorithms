package Algorithms;

import edu.princeton.cs.algs4.StdRandom;

	@SuppressWarnings("rawtypes")
public class QuickSort {

	public QuickSort() {
		// TODO Auto-generated constructor stub
	}

	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a); // Eliminate dependence on input.
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi); // Partition (see page 291).
		sort(a, lo, j - 1); // Sort left part a[lo .. j-1].
		sort(a, j + 1, hi); // Sort right part a[j+1 .. hi].
	}

	private static int partition(Comparable[] a, int lo, int hi) { // Partition into a[lo..i-1], a[i], a[i+1..hi].
		int i = lo, j = hi + 1; // left and right scan indices
		Comparable v = a[lo]; // partitioning item
		while (true) { // Scan right, scan left, check for scan complete, and exchange.
			while (less(a[++i], v))
				if (i == hi)
					break;
			while (less(v, a[--j]))
				if (j == lo)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j); // Put v = a[j] into position
		return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}

	@SuppressWarnings("unchecked")
	public static boolean less(Comparable a, Comparable b) { // page 245
		if (a.compareTo(b) < 0)
			return true;
		if (b.compareTo(a) < 0)
			return true;
		return false;
	}

	private static void exch(Comparable[] a, int i, int j) { // page 245
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
