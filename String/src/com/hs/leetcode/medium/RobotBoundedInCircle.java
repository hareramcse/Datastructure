package com.hs.leetcode.medium;

public class RobotBoundedInCircle {
	int up = 0;
	int left = 1;
	int down = 2;
	int right = 3;
	int orginDirection = up;

	public boolean isRobotBounded(String instructions) {
		int currentDirection = orginDirection;
		int row = 0, column = 0;

		for (char ch : instructions.toCharArray()) {
			if (ch == 'G') {
				if (currentDirection == up) {
					row--;
				} else if (currentDirection == down) {
					row++;
				} else if (currentDirection == left) {
					column--;
				} else if (currentDirection == right) {
					column++;
				}
			} else if (ch == 'L') {
				currentDirection++;
				if (currentDirection > right)
					currentDirection = up;
			} else if (ch == 'R') {
				currentDirection--;
				if (currentDirection < up)
					currentDirection = right;
			}
		}

		boolean posChannged = row != 0 || column != 0;
		if (!posChannged)
			return true;

		if (currentDirection != orginDirection)
			return true;

		return false;
	}

	public static void main(String[] args) {
		RobotBoundedInCircle obj = new RobotBoundedInCircle();
		String instructions = "GL";
		boolean result = obj.isRobotBounded(instructions);
		System.out.println(result);
	}
}