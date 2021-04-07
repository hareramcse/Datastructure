package com.hs.stack.geekforgeeks;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder builder = new StringBuilder();
		Stack<Operation> operations = new Stack<Operation>();
		int Q = sc.nextInt();
		for (int i = 0; i < Q; i++) {
			int type = sc.nextInt();
			if (type == 1) {
				String W = sc.next();
				builder.append(W);
				operations.push(new Operation(type, W.length()));
			} else if (type == 2) {
				int k = sc.nextInt();
				String last = builder.substring(builder.length() - k);
				builder.delete(builder.length() - k, builder.length());
				operations.push(new Operation(type, last));
			} else if (type == 3) {
				int k = sc.nextInt();
				System.out.println(builder.charAt(k - 1));
			} else {
				Operation operation = operations.pop();
				if (operation.type == 1) {
					builder.delete(builder.length() - (int) operation.argument, builder.length());
				} else {
					builder.append(operation.argument);
				}
			}
		}
		sc.close();
	}

	public static class Operation {
		int type;
		Object argument;

		Operation(int type, Object argument) {
			this.type = type;
			this.argument = argument;
		}
	}
}