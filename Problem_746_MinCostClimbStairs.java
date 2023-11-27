/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. 
Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.
*/

class Solution {
   public int minCostClimbingStairs(int[] cost) {
      int n = cost.length;
      int[] dp = new int[n];
      dp[0] = cost[0];
      dp[1] = cost[1];

      for(int i=2; i<n; i++){
         dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
      }

      return Math.min(dp[n-1], dp[n-2]);
   }
}

// TC: O(n), iterating through cost array and filling in dp array a total of n times
// SC: O(n), dp array
    // could be O(1) by changing the cost array in place --> SEE BELOW
    
// DP: the minimum of the last 2 entries in the dp array represents the minimum cost to reach the end
// each entry in the dp array and cost array is used to fill out the future dp entries
// IMPORTANT: each entry in the dp array represents the cost SO FAR of reaching the end
    // e.g.
    // suppose cost == [1,100,1,1,2] --> expected answer is 3
    // the dp array == [1,100,2,3,4] 
        // --> at i==3, it will cost 3 to reach the end
        // --> at i==2, it will cost 2 to get to the next spot (could be the end or not)


/*
public int minCostClimbingStairs(int[] cost) {
    int one = 0;
    int two = 0;

    for (int i = cost.length - 1; i >= 0; i--) {
        cost[i] += Math.min(one, two);
        two = one;
        one = cost[i];
    }

    return Math.min(cost[0], cost[1]);
}
*/