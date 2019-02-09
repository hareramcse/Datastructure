package com.hs.basic;

public class DeciamlToBinary {
	public void decimalToBinary(int num) {
		if (num > 0) {
			decimalToBinary(num / 2);
			System.out.print(num % 2 + " ");
		}
	}

	public int binaryToDecimal(String binInput) {
		int len = binInput.length();
		if (len == 0) {
			return 0;
		}
		String now = binInput.substring(0, 1);
		String later = binInput.substring(1);
		return Integer.parseInt(now) * (int) Math.pow(2, len - 1) + binaryToDecimal(later);
	}

	public static void main(String[] args) {
		int num = 12;
		DeciamlToBinary dtb = new DeciamlToBinary();
		dtb.decimalToBinary(num);
		int value = dtb.binaryToDecimal("1100");
		System.out.println();
		System.out.println(value);
	}

}