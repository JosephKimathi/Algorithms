package Practice;

import Algorithms.QuickSort;
import edu.princeton.cs.algs4.StdRandom;

public class NEW {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out.println("hi");
		Comparable<Integer>[] a = new Comparable[20];
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform(20);
		}
		QuickSort.sort(a);
		for (Comparable<Integer> i : a)
			System.out.println(i);
	}

}
