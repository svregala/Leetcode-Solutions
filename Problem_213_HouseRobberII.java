/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */

class Solution {
   public int rob(int[] nums) {
      
      if(nums.length==1){
         return nums[0];
      }else if(nums.length==2){
         return Math.max(nums[0], nums[1]);
      }

      int n = nums.length;
      // dp_1 will represent the max amount of money at each position INCLUDING house number 1 and EXCLUDING house n-1
      //      --> [0, n-2]
      // similarly, dp_2 represents position EXCLUDING house number 1 and INCLUDING house n-1
      //      --> [1, n-1]

      int[] dp_1 = new int[n];
      Arrays.fill(dp_1, 0);
      dp_1[0] = 0;

      int[] dp_2 = new int[n];
      Arrays.fill(dp_2, 0);
      dp_2[0] = 0;

      for(int i=1; i<n; i++){
         if(i-2>=0){
            dp_1[i] = Math.max(dp_1[i-2]+nums[i-1], dp_1[i-1]);
            dp_2[i] = Math.max(dp_2[i-2] + nums[i], dp_2[i-1]);
         }else{
            dp_1[i] = nums[i-1];
            dp_2[i] = nums[i];
         }
      }

      return Math.max(dp_1[n-1], dp_2[n-1]);

      // TC = O(n)
      // SP = O(2n) = O(n)
   }
}