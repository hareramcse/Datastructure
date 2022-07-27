package com.hs.leetcode;

public class PrintAllSubSeq {
	private void printAllSubSeq(String ip, String op) {
		if (ip.length() == 0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;
		op2 = op2 + ip.charAt(0);
		ip = ip.substring(1);
		printAllSubSeq(ip, op1);
		printAllSubSeq(ip, op2);
	}

	public static void main(String[] args) {
		String ip = "abc";
		String op = "";
		PrintAllSubSeq pas = new PrintAllSubSeq();
		pas.printAllSubSeq(ip, op);
	}
}
