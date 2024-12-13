package com.hs.medium;

public class JumpGame2 {
	public int jump(int[] nums) {
		int start = 0;
		int end = 0;
		int jump = 0;

		while (end < nums.length - 1) {
			int farthest = 0;
			for (int i = start; i <= end; i++) {
				farthest = Math.max(farthest, i + nums[i]);
			}

			start = end + 1;
			end = farthest;

			if (start > end)
				return -1;

			jump++;
		}

		return jump;
	}

	public static void main(String[] args) {
		JumpGame2 obj = new JumpGame2();
		int[] arr = { 2, 3, 1, 1, 4 };
		int result = obj.jump(arr);
		System.out.println(result);
	}
}