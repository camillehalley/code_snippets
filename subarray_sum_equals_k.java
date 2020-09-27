/***
* Given an array of integers and an integer k, you need to find the total 
* number of continuous subarrays whose sum equals to k.
***/

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> timesSeenSum = new HashMap<>();
        timesSeenSum.put(0,1);
        int sum=0;
        int result=0;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(timesSeenSum.containsKey(sum-k)){
                result+=timesSeenSum.get(sum-k);
            }
            timesSeenSum.put(sum, timesSeenSum.getOrDefault(sum,0)+1);
        }
        return result;
    }
}
