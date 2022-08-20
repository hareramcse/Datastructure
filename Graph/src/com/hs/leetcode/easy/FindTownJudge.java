package com.hs.leetcode.easy;

public class FindTownJudge {
	public int findJudge(int N, int[][] trust) {
		int[] indegree = new int[N + 1];
		int[] outdegree = new int[N + 1];
		for (int i = 0; i < trust.length; i++) {
			int countOut = outdegree[trust[i][0]];
			outdegree[trust[i][0]] = countOut + 1;
			int countIn = indegree[trust[i][1]];
			indegree[trust[i][1]] = countIn + 1;
		}
		for (int i = 1; i <= N; i++) {
			if (outdegree[i] == 0 && indegree[i] == N - 1) {
				return i; // town judge
			}
		}
		return -1;
	}
}
