/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */

class Solution {
   public int rob(int[] nums) {
      
      // take care of base case
      if(nums.length==1){
         return nums[0];
      }

      int[] dp = new int[nums.length+1];
      // base case for dp array
      Arrays.fill(dp, 0);
      dp[0] = 0;

      for(int i=1; i<=nums.length; i++){
         if(i-2>=0){
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i-1]);
         }else{
            dp[i] = nums[i-1];
         }
      }

      return dp[nums.length];

      // each value in dp array will represent the most money you can get at that point (position in array, AKA house)
      // TC = O(n) with n = array size
      // SC = O(n)
   }
}