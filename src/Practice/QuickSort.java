package Practice;

import Algorithms.MergeSortIntArrays;
import princeton.StdRandom;

public class QuickSort {
	public static int[] merge(int[] left, int[] right) {
		int[] temp = new int[left.length + right.length];
		int l = 0, r = 0;
		for (int i = 0; i < left.length; i++)
			temp[i] = left[i];
		int n = left.length;
		for (int i = 0; i < right.length; i++) {
			temp[n + i] = right[i];
		}
		return temp;
	}

	public static int[] sort(int[] arr) {
		if (arr.length <= 1)
			return arr;
			int pivot = 0;
			if (arr.length % 2 == 0)
				pivot = arr.length / 2; // pivot
			else
				pivot = arr.length / 2 + 1;
			int[] left, right;
			int p = arr[pivot];
			left = new int[pivot];
			right = new int[arr.length - pivot];
			// pointers
			int l = 0, r = 0, point = 0;
			for (point = 0; point < arr.length; point++) {
//			if (point != pivot) {
				if (arr[point] <= p && l < left.length) {
//					System.out.println("arr[p]:"+arr[point] + " left[l]:"+left[l]+ " l:"+l);
					left[l] = arr[point];
					l++;
					System.out.print(left.length + " ");
					System.out.println("arr[point]:" + arr[point]);
				}
				if (arr[point] > p && r < right.length) {
					right[r] = arr[point];
					r++;
				}
			}
			left = sort(left);
			right = sort(right);
			arr = merge(left, right);
		
//		left = sort(left);
//		right = sort(right);
//		arr = merge(left, right);
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++)
			arr[i] = 10 - i;
		arr = sort(arr);
		MergeSortIntArrays.printIntArray1D(arr);

	}
}
