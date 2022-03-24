package com.hs.recursion;

public class KthSymbolInGrammer {

	private int kthSymbol(int n, int k) {
		if (n == 1 && k == 1) {
			return 0;
		}

		int mid = (int) (Math.pow(2, n - 1)/2);
		if (k <= mid) {
			return kthSymbol(n - 1, k);
		}else {
			return 1 ^ kthSymbol(n - 1, k - mid);
		}
	}

	public static void main(String[] args) {
		KthSymbolInGrammer rev = new KthSymbolInGrammer();
		int n = 4;
		int k = 4;

		int kthSymbol = rev.kthSymbol(n, k);
		System.out.println(kthSymbol);
	}
}