/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.
*/

class Solution {
   public int maxSubArray(int[] nums) {
      // Kadane's algorithm
      int local_max = 0;
      int global_max = Integer.MIN_VALUE;

      for(int i=0; i<nums.length; i++){
         local_max = Math.max(nums[i], nums[i]+local_max);
         if(local_max > global_max){
               global_max = local_max;
         }
      }

      return global_max;

      /*int max_so_far = Integer.MIN_VALUE;
      int max_ending_here = 0;

      for(int i=0; i<nums.length; i++){
         max_ending_here = max_ending_here + nums[i];

         if(max_so_far < max_ending_here){
               max_so_far = max_ending_here;
         }
         if(max_ending_here < 0){
               max_ending_here = 0;
         }
      }

      return max_so_far;*/
   }
}