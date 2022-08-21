package com.hs.basic;

public class PrintNToOne {
	public void print(int n) {
		if (n < 1)
			return;
		System.out.println(n);
		print(n-1);
	}

	public static void main(String[] args) {
		PrintOneToN obj = new PrintOneToN();
		obj.print(3);
	}
}
