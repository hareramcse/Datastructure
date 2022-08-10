package com.hs.leetcode.easy;

public class Pair implements Comparable<Pair> {
	public int key;
	public int value;

	Pair(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int compareTo(Pair p) {
		if (this.key == p.key)
			return p.value - this.value;
		return this.key - p.key;
	}
}
