/*** 
* "Given a list of non-negative numbers and a target integer k, write a function 
* to check if the array has a continuous subarray of size at least 2 that sums up 
* to a multiple of k, that is, sums up to n*k where n is also an integer." - Leetcode problem 523
*
* The theorum enabling us to solve this problem in one pass is that if we have an interval i,j
* where j-i>1 and the continuous_sum[i] % k == continuous_sum[j] % k, then the sum of i,j is 
* divisible by k.
***/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderToIndex = new HashMap<>();
        int sum = 0;
        int r;
        
        remainderToIndex.put(0, -1);
        
        for(int i =0; i< nums.length; i++){
            sum+= nums[i];
            r = k != 0 ? sum%k : sum;
            Integer prev = remainderToIndex.get(r);
            
            if(prev != null){
                if(i-prev > 1) return true;
            }
            else{
                remainderToIndex.put(r, i);
            }
        }
        return false;
    }
}
