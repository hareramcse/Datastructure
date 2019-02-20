package com.hs.array.misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class UniqueImages {
	public static class Image {
		private String filename;
		private int width;
		private int height;

		public Image(String filename, int width, int height) {
			this.filename = filename;
			this.width = width;
			this.height = height;
		}

		// We need to override the hashcode method and bellow change we need to add
		// to find the uniqueness of the image as per the given condition
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			String[] components = filename.split("\\.");
			result = prime * result + ((components[0] == null) ? 0 : components[0].hashCode());
			result = prime * result + height * width;
			return result;
		}

		/**
		 * Two Images are considered equal if they have the same filename (without the
		 * extension), and the same number of pixels. Thus, flag.jpg with width=60
		 * height=40 is equal to flag.gif with width=40 and height=60
		 */
		public boolean equals(Object other) {
			Image o = (Image) other;
			if (filename == null || o.filename == null)
				return false;
			String[] components = filename.split("\\.");
			String[] ocomponents = o.filename.split("\\.");
			return components[0].equals(ocomponents[0]) && width * height == o.width * o.height;
		}

		public String toString() {
			return "Image: filename=" + filename + " Size=" + width * height;
		}
	}

	public static void printImages(Set<Image> images) {
		for (Image image : images) {
			System.out.println(image);
		}
	}

	public static void main(String[] args) {
		Image[] images = { new Image("flag.jpg", 40, 60), new Image("flag.gif", 40, 60),
				new Image("smile.gif", 100, 200), new Image("smile.gif", 50, 400), new Image("other.jpg", 40, 60),
				new Image("lenna.jpg", 512, 512), new Image("Lenna.jpg", 512, 512) };
		Set<Image> set = new HashSet<Image>(Arrays.asList(images));
		UniqueImages.printImages(set);
	}
}