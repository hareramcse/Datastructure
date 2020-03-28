package com.hs.stack;

public class FindingSpans {
	private int[] findingSpan(int[] arr) {
		int[] spans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int span = 1;
			int j = i - 1;
			while (j >= 0 && arr[j] <= arr[j + 1]) {
				span++;
				j--;
			}
			spans[i] = span;
		}
		return spans;
	}

	public static void main(String[] args) {
		FindingSpans fs = new FindingSpans();
		int[] arr = { 6, 3, 4, 5, 2 };
		int[] res = fs.findingSpan(arr);
		for(int a : res) {
			System.out.println(a);
		}
	}
}
