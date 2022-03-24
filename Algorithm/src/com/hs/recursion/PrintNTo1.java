package com.hs.recursion;

public class PrintNTo1 {
	private void print(int n) {
		if(n==0)
			return;
		
		System.out.println(n);
		print(n-1);
	}

	public static void main(String[] args) {
		int n = 3;
		PrintNTo1 rec = new PrintNTo1();
		rec.print(n);
	}
}
