/***
* Given an array nums of n integers where n > 1,  return an array output such that output[i] 
* is equal to the product of all the elements of nums except nums[i].
*
* Multiplying product[0-(i-1)] by product[(i+1)-length] will give us the product of the array
* except i. 
***/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arrayFromLeft = new int[nums.length];
        arrayFromLeft[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            arrayFromLeft[i] = arrayFromLeft[i-1] * nums[i];
        }
        int productFromRight = 1;
        for(int i = nums.length-1; i>0; i--){
            int num = nums[i];
            nums[i] = arrayFromLeft[i-1] * productFromRight;
            productFromRight *= num;
        }
        nums[0] = productFromRight;
        return nums;
    }
}
