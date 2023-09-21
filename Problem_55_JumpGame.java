/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
 */

class Solution {
    public boolean canJump(int[] nums) {

      // GREEDY SOLUTION
      int reachable = 0;
      for(int i=0; i<nums.length; i++){
         if(i>reachable){
               return false;
         }
         reachable = Math.max(reachable, i+nums[i]);
      }
      return true;

        // Greedy solution
        // at each step, keep track of the furthest reachable index
        // for an index to be reachable, each of the previous indices have to be reachable
        // if we encounter an unreachable index, then return false

        /*
        // base case, nums of length 1, we are already at the end
        if(nums.length==1){
            return true;
        }

        // dp bottom up approach
        int n = nums.length;
        boolean[] dp = new boolean[n];    // dp[i] value represents if you can reach the last index starting at that position
        dp[n-1] = true; // base case because you can reach the last index when you're at the last index

        for(int i=n-2; i>=0; i--){
            // cannot make progress with 0 jumps
            if(nums[i]==0){
                dp[i] = false;
            }
            // if the jumps value is at least the amount of steps we have left, then set to true
            else if(nums[i] >= n-i-1){
                dp[i] = true;
            }
            else{
                boolean update = false;
                // search through the jumps you can make given the value at nums[i]
                for(int j=i+1; j<=i+nums[i]; j++){
                    if(dp[j] == true){
                        update = true;
                        break;
                    }
                }
                dp[i] = update;
            }
        }
        
        return dp[0];
        */
    }
}