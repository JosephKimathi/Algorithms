package Practice;

import Algorithms.QuickSort;
import edu.princeton.cs.algs4.StdRandom;

public class BubbleSortInt {
	static void sort(int[] arr) {
			int hold = 0; // position 7
		for (int j = 0; j < arr.length; j++) {
			int temp = arr[j]; // value 7
			for (int i = 0; i < arr.length; i++) {
				if (i != j) {
//					System.out.print(temp + " " + arr[i] + "\n");
					if (temp > arr[i]) { // if 7 > 6
						hold = i; // Position 7 changes
						arr[j] = arr[i]; // position 6 moves left with value
//						if (hold == arr.length - 1 || temp < arr[hold + 1])
//						System.out.println(hold);
							arr[hold] = temp; // position 7 placement

					}
//					System.out.println(arr[j]+" "+arr[i]);
				}
			}
		}
	}

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
