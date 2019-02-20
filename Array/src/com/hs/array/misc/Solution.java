package com.hs.array.misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
	private static class APIModel {
		private String appName;
		private String apiName;
		private int version;

		public APIModel() {

		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((apiName == null) ? 0 : apiName.hashCode());
			result = prime * result + ((appName == null) ? 0 : appName.hashCode());
			result = prime * result + version;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof APIModel))
				return false;
			APIModel other = (APIModel) obj;
			if (apiName == null) {
				if (other.apiName != null)
					return false;
			} else if (!apiName.equals(other.apiName))
				return false;
			if (appName == null) {
				if (other.appName != null)
					return false;
			} else if (!appName.equals(other.appName))
				return false;
			if (version != other.version)
				return false;
			return true;
		}

		public String getAppName() {
			return appName;
		}

		public void setAppName(String appName) {
			this.appName = appName;
		}

		public String getApiName() {
			return apiName;
		}

		public void setApiName(String apiName) {
			this.apiName = apiName;
		}

		public int getVersion() {
			return version;
		}

		public void setVersion(int version) {
			this.version = version;
		}
	}

	public static void main(String[] args) {
		BufferedWriter output = null;
		try {
			Path file = Paths.get("input.txt");

			List<String> readAllLines = Files.readAllLines(file, StandardCharsets.UTF_8);

			List<APIModel> list = new ArrayList<>();
			for (String line : readAllLines) {
				APIModel model = new APIModel();
				String[] str = line.split(", ");
				model.setAppName(str[0]);
				model.setApiName(str[1]);
				model.setVersion(Integer.parseInt(str[2].substring(1)));
				list.add(model);
			}

			Map<APIModel, Integer> map = new HashMap<>();
			for (int i = 0; i < list.size(); i++) {
				String apiName1 = list.get(i).getApiName();
				int version1 = list.get(i).getVersion();
				APIModel minModel = list.get(i);
				int minVersion = version1;
				int maxVersion = version1;
				for (int j = 0; j < list.size(); j++) {
					String apiName2 = list.get(j).getApiName();
					int version2 = list.get(j).getVersion();
					if (apiName1.equals(apiName2) && version2 < minVersion) {
						minModel = list.get(j);
						minVersion = minModel.getVersion();
					}
					if (apiName1.equals(apiName2) && maxVersion < version2) {
						maxVersion = version2;
					}
				}
				map.put(minModel, maxVersion);
			}
			output = new BufferedWriter(new FileWriter("output.txt"));
			for (Entry<APIModel, Integer> entry : map.entrySet()) {
				Integer oldestVersion = entry.getKey().getVersion();
				Integer newestVersion = entry.getValue();
				if (oldestVersion != newestVersion) {
					String st = entry.getKey().getAppName() + " is using " + entry.getKey().getApiName() + " V"
							+ entry.getKey().getVersion() + ", latest version of API is V" + entry.getValue();
					output.write(st);
					output.newLine();
				}
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.flush();
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}