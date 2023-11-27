/* 
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

class Solution {
    public int climbStairs(int n) {
        // base case
        if(n==1 || n==2){
            return n;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

// TC: O(n), fill in the values of each entry in the array, we go through 1 to n entries
// SC: O(n), array is of size n+1

// Dynamic programming - use previous values to calculate current
// opt(i) = number of distinct ways to climb to the top