package com.hs.leetcode.easy;

class Pair implements Comparable<Pair> {
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

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "(" + key + ", " + value + ")";
	}
}