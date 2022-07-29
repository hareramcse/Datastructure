package com.hs.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAdress {
	public int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>();
		for (String email : emails) {
			StringBuilder address = new StringBuilder();
			for (int i = 0; i < email.length(); i++) {
				char ch = email.charAt(i);
				if (ch == '.') {
					continue;
				} else if (ch == '+') {
					while (email.charAt(i) != '@') {
						i++;
					}
					address.append(email.substring(i + 1));
				} else {
					address.append(ch);
				}
			}
			set.add(address.toString());
		}

		return set.size();
	}

	public static void main(String[] args) {
		UniqueEmailAdress obj = new UniqueEmailAdress();
		String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com" };
		int result = obj.numUniqueEmails(emails);
		System.out.println(result);
	}
}