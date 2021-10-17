package com.bridgelabz.algorithm;

public class BubbleSort {
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[j - 1]) < 0) {
					T temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
	}
}

