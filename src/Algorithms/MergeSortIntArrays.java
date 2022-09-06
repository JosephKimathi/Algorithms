package Algorithms;

public class MergeSortIntArrays {
//	MergeSort(arr[], a,  b)
//	If b > a
//	     1. Find the middle point to divide the array into two halves:  
//	             middle m = (l+r)/2
//	     2. Cala mergeSort for first half:   
//	             Cala mergeSort(arr, a, m)
//	     3. Cala mergeSort for second half:
//	             Cala mergeSort(arr, m+1, b)
//	     4. Merge the two halves sorted in step 2 and 3:
//	             Cala merge(arr, a, m, b)
//	
	private static int[] merge(int[] left, int[] right) {
		int[] ans = new int[left.length + right.length];
		int l, r, a;
		l = r = a = 0;
		while (l < left.length || r < right.length) {
			if (l < left.length && r < right.length) {
				if (left[l] <= right[r]) {
					ans[a] = left[l];
					a++;
					l++;
				} else if (right[r] < left[l]) {
					ans[a] = right[r];
					r++;
					a++;
				}
			} else if (l < left.length && r >= right.length) {
				ans[a] = left[l];
				a++;
				l++;
			} else if (r < right.length && l >= left.length) {
				ans[a] = right[r];
				r++;
				a++;
			}
		}

		System.out.println("end r: " +r);
		return ans;

	}

	// Main function that sorts arr[l..r] using
	// merge()
	public static int[] sort(int arr[]) {
		int mid = arr.length/2;
		int left[] = new int[mid];
		int right[] = new int[arr.length - mid];
		if (arr.length <= 1)
			return arr;
		for (int i = 0; i < left.length; i++)
			left[i] = arr[i];

		for (int j = 0; j < right.length; j++)
			right[j] = arr[mid + j];
		left = sort(left);
		right = sort(right);
		arr = merge(left, right);
		return arr;

	}
//	public static void Sort(int[]arr) {
//		arr = sort(arr);
//	}

	public static void printIntArray1D(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void printlnArray1D(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.println(arr[i] + " ");
	}

	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i =0;i<10;i++) {
			arr[i] = 10-i;
		}
		arr = sort(arr);
//		Sort(arr);
		printIntArray1D(arr);
	}

}
