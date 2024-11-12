package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hs.graph.mst.DisjointSet;

public class AccountsMerge {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		int V = accounts.size();
		DisjointSet ds = new DisjointSet(V);
		Map<String, Integer> mapMailNode = new HashMap<>();

		for (int i = 0; i < V; i++) {
			for (int j = 1; j < accounts.get(i).size(); j++) {
				String mail = accounts.get(i).get(j);
				if (mapMailNode.containsKey(mail) == false) {
					mapMailNode.put(mail, i);
				} else {
					ds.unionBySize(i, mapMailNode.get(mail));
				}
			}
		}

		@SuppressWarnings("unchecked")
		List<String>[] mergedMail = new ArrayList[V];
		for (int i = 0; i < V; i++)
			mergedMail[i] = new ArrayList<String>();
		
		for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
			String mail = it.getKey();
			int node = ds.findUPar(it.getValue());
			mergedMail[node].add(mail);
		}

		List<List<String>> ans = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			if (mergedMail[i].size() == 0)
				continue;
			
			Collections.sort(mergedMail[i]);
			List<String> temp = new ArrayList<>();
			temp.add(accounts.get(i).get(0));
			for (String it : mergedMail[i]) {
				temp.add(it);
			}
			ans.add(temp);
		}
		return ans;
	}
}