/*
Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
*/

class NumArray {
   int[] prefix;

   public NumArray(int[] nums) {
      prefix = new int[nums.length+1];
      for(int i=0; i<nums.length; i++){
         prefix[i+1] = prefix[i] + nums[i];
      }
   }
   
   public int sumRange(int left, int right) {
      return prefix[right+1] - prefix[left];
   }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

// TC: O(n) constructor to initialize the prefix array, but this is only done once for every new nums array
// TC: O(1) for sumRange
// SC: O(n) for prefix array