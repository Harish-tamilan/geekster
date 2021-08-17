package recursion;

import java.util.*;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n,i;
		n = sc.nextInt();
		int[] arr = new int[n];
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		mergeSort(arr,0,n-1);
		
		for(i=0;i<n;i++)
			System.out.print(arr[i]+" ");
	}

	

	public static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int mid = l + (r - l) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			mergeTwoSortedArrays(arr, l, mid, r);
		}
	}

	private static void mergeTwoSortedArrays(int[] arr, int l, int m, int r) {
		int size1 = m - l + 1;
		int size2 = r - m;

		int arr1[] = new int[size1];
		int arr2[] = new int[size2];
		for (int i = 0; i < size1; i++) {
			arr1[i] = arr[l + i];
		}

		for (int i = 0; i < size2; i++) {
			arr2[i] = arr[m + i + 1];
		}

		int i = 0, j = 0;
		int k = l;
		while (i < size1 && j < size2) {
			if (arr1[i] < arr2[j]) {
				arr[k] = arr1[i];
				i++;
			} else {
				arr[k] = arr2[j];
				j++;
			}
			k++;
		}

		while (i < size1) {
			arr[k] = arr1[i];
			i++;
			k++;
		}

		while (j < size2) {
			arr[k] = arr2[j];
			j++;
			k++;
		}
	}
}
