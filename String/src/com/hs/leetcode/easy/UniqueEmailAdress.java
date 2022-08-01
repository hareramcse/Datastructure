package com.hs.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAdress {
	public int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>();
		for (String email : emails) {
			String updatedEmail = getUpdatedEmail(email);
			set.add(updatedEmail);
		}
		return set.size();
	}

	private String getUpdatedEmail(String email) {
		String localName = "";
		int len = email.length();
		char[] chars = email.toCharArray();
		int i = 0;
		while (i < chars.length && chars[i] != '@') {
			if (chars[i] == '.')
				i++;
			else if (chars[i] == '+') {
				while (chars[i] != '@')
					i++;
			} else {
				localName += chars[i];
				i++;
			}
		}

		i++;
		String domainName = "";
		while (i < len) {
			domainName += chars[i];
			i++;
		}
		return localName + "@" + domainName;
	}

	public static void main(String[] args) {
		UniqueEmailAdress obj = new UniqueEmailAdress();
		String[] emails = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com" };
		int result = obj.numUniqueEmails(emails);
		System.out.println(result);
	}
}