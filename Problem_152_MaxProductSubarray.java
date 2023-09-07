/*
Given an integer array nums, find a 
subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.
*/

class Solution {
   public int maxProduct(int[] nums) {

      // Kadane's algorithm with modifications
      // Case 1: All elements positive --> result is product of all elements in array
      // Case 2: Some elements positive, some negative -->
         // even number of negative elements --> result is product of all elements in array
         // odd number of negative elements --> remove just 1 negative, DP will take care of this
      // Case 3: Contains 0 --> DP will take care of this since we encounter the start of a new subarray

      // keeping a min because on multiplying with any negative number, 
      // min will become max, and max will become min
      int result = nums[0], min = nums[0], max = nums[0];

      // for each index i, keep updating min and max
      for(int i=1; i<nums.length; i++){

         // swap min and max because we encounterd negative number
         if(nums[i]<0){
               int temp = max;
               max = min;
               min = temp;
         }

         // multiplying neg num with max will become min
         // multiplying neg num with min will become max
         max = Math.max(nums[i], max*nums[i]);
         min = Math.min(nums[i], min*nums[i]);

         if(result<max){
               result = max;
         }
      }

      return result;
   }
}