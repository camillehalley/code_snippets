/***
* "Given n non-negative integers representing an elevation map where the width of each bar is 1,
* compute how much water it is able to trap after raining." -Leetcode problem 42
* 
* Since water levels can never drop lower than the lower of the tallest points on each side, the this function
* is non-decreasing from the left and non-increasing from the right until reaching the maximum in-between.
* Calculating the maximum seen heights moving in from each side gives us an O(n) approach. 
***/

import java.lang.Math;

class Solution {
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int[] leftMax = new int[height.length];
        int currentMax = height[0];
        for(int i =0; i< height.length; i++){
            currentMax = Math.max(height[i], currentMax);
            leftMax[i] = currentMax;
        }
        currentMax = height[height.length-1];
        int waterTrapped = 0;
        for(int i=height.length-1; i>=0; i--){
            currentMax = Math.max(height[i], currentMax);
            waterTrapped += (Math.min(leftMax[i], currentMax) - height[i]);
        }
        return waterTrapped;
    }
}
