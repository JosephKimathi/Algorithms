package Algorithms;

import edu.princeton.cs.algs4.StdRandom;

public class sorting {

	public static boolean less(Comparable a, Comparable b) {
		if (a.compareTo(b) < 0)
			return true;
		if (b.compareTo(a) < 0)
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Comparable<Integer>[] a = new Comparable[20];
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform(20);
		}
		QuickSort.sort(a);
		for (Comparable<Integer> i : a)
			System.out.println(i);
	}

}
