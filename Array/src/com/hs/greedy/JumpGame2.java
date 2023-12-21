package com.hs.greedy;

public class JumpGame2 {
	public int jump(int[] nums) {
		int jumps = 0;
		int current = 0;
		int farthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			farthest = Math.max(farthest, i + nums[i]);
			if (i == current) {
				current = farthest;
				jumps++;
			}
		}
		return jumps;
	}

	public static void main(String[] args) {
		JumpGame2 obj = new JumpGame2();
		int[] arr = { 2, 3, 1, 1, 4 };
		int result = obj.jump(arr);
		System.out.println(result);
	}
}
