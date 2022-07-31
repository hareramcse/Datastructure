package com.leetcode.easy;

public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int xor = x ^ y;
		int setBitCount = 0;
		for (int i = 0; i < 32; i++) { // 32 bit
			if (((xor >> i) & 1) == 1) { // right
				setBitCount++;
			}
		}
		return setBitCount;
	}

	public static void main(String[] args) {
		HammingDistance obj = new HammingDistance();
		int x = 1;
		int y = 4;
		int result = obj.hammingDistance(x, y);
		System.out.println(result);
	}
}