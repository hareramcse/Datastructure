package com.hs.recursion;

public class Print1ToN {
	private void print(int n) {
		if(n==0)
			return;
		
		print(n-1);
		System.out.println(n);
	}

	public static void main(String[] args) {
		int n = 3;
		Print1ToN rec = new Print1ToN();
		rec.print(n);
	}
}
