package com.hs.medium;

public class JumpGame2 {
	public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int jump = 0;

        while (right < nums.length - 1) {
            int farthest = 0;
            for (int i = left; i <= right; i++)
                farthest = Math.max(farthest, i + nums[i]);

            left = right + 1;
            right = farthest;

            if (left > right)
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