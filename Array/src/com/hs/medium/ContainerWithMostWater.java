package com.hs.medium;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
        int maxWater = 0;
        int start =0;
        int end = height.length - 1;
		
        while(start < end){
            int length = Math.min(height[start], height[end]);
			int width = end - start;
			maxWater = Math.max(maxWater, length * width);
            if(height[start] > height[end]){
                end--;
            }else{
                start++;
            }
        }
		return maxWater;
    }

	public static void main(String[] args) {
		int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		ContainerWithMostWater obj = new ContainerWithMostWater();
		int maxArea = obj.maxArea(arr);
		System.out.println(maxArea);
	}
}