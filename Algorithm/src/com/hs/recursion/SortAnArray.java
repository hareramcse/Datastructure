package com.hs.recursion;

import java.util.ArrayList;
import java.util.List;

public class SortAnArray {
	private void sort(List<Integer> list) {
		if (list.size() == 1) {
			return;
		}

		Integer temp = list.remove(list.size() - 1);
		sort(list);
		insert(list, temp);
	}

	private void insert(List<Integer> list, int temp) {
		if (list.size() == 0 || list.get(list.size() - 1) < temp) {
			list.add(temp);
			return;
		}

		Integer t = list.remove(list.size() - 1);
		insert(list, temp);
		list.add(t);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 0, 5, 2 };
		SortAnArray saa = new SortAnArray();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		saa.sort(list);
		System.out.println(list);
	}
}
