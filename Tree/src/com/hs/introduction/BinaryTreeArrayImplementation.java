package com.hs.introduction;

public class BinaryTreeArrayImplementation {
	private static class Array_imp {
		private static String[] str = new String[10];

		/* create root */
		public void root(String data) {
			str[0] = data;
		}

		/* create left son of root */
		public void setLeft(String data, int index) {
			int t = (index * 2) + 1;

			if (str[index] == null) {
				System.out.printf("Can't set child at %d, no parent found\n", t);
			} else {
				str[t] = data;
			}
		}

		/* create right son of root */
		public void setRight(String data, int index) {
			int t = (index * 2) + 2;

			if (str[index] == null) {
				System.out.printf("Can't set child at %d, no parent found\n", t);
			} else {
				str[t] = data;
			}
		}

		public void printTree() {
			for (int i = 0; i < 10; i++) {
				if (str[i] != null)
					System.out.print(str[i]);
				else
					System.out.print("-");

			}
		}
	}

	public static void main(String[] args) {
		Array_imp obj = new Array_imp();
		obj.root("A");
		// obj.set_Left("B", 0);
		obj.setRight("C", 0);
		obj.setLeft("D", 1);
		obj.setRight("E", 1);
		obj.setLeft("F", 2);
		obj.printTree();
	}
}
