package com.hs.gs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class ApacheLog {
	public static String findTopIpaddress(String[] lines) {
		Map<String, Integer> counter = new HashMap<>();
		Arrays.stream(lines).forEach((line) -> {
			String ipAddress = line.split(" ")[0];
			Integer count = counter.getOrDefault(ipAddress, 0);
			counter.put(ipAddress, count + 1);
		});

		StringJoiner sj = new StringJoiner(",");
		final Integer max = counter.entrySet().stream().max((p1, p2) -> p1.getValue() > p2.getValue() ? 1 : -1).get()
				.getValue();
		counter.entrySet().stream().filter(p -> max == p.getValue())
				.sorted((p1, p2) -> p1.getValue() > p2.getValue() ? 1 : -1).forEach(p -> sj.add(p.getKey()));
		return sj.toString();

	}

	public static void main(String[] args) {

		String lines[] = new String[] { "10.0.0.1 - log entry 1 11", "10.0.0.1 - log entry 2 213",
				"10.0.0.2 - log entry 133132" };
		String result = findTopIpaddress(lines);

		if (result.equals("10.0.0.1")) {
			System.out.println("Test passed");

		} else {
			System.out.println("Test failed");

		}

	}
}
