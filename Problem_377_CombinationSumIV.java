/*
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
The test cases are generated so that the answer can fit in a 32-bit integer.

e.g.
Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
 */

class Solution {
   public int combinationSum4(int[] nums, int target) {

      // dp is array where dp[i] represents the number of combinations that can sum up to i
      int[] dp = new int[target+1]; // i = 0, 1, 2, 3, 4

      // all spots are 0, set dp[0]=1 because its the base case representing there's 1 way to reach target sum of 0, using 0 itself
      dp[0] = 1;

      // iterate starting at 1 up to target --> for each i, fill dp[i] with the number of combos that can make up that sum i
      // find dp[i] by looking at previously calculated values --> for every num in nums, add dp[i-num] to dp[i] given i-num>=0
      // --> AKA for each i, we sum up the number of ways to reach sum i by looking at how we could arrive at that sum using 
      // smaller numbers
      for(int i=1; i<=target; i++){
         for(int num : nums){
            if(i-num >= 0){
               dp[i] += dp[i-num];
            }
         }
      }

      return dp[target];

        // TC = O(n*m) --> n size of array nums, m = target
        // SC = O(m)
    
        // decision tree - brute force
        // starting at sum=0, branch off of each number in nums, e.g. nums=[1,2,3]
        // for each number, branch of each number again in nums (branching off means adding)
        // 1, 2, 3 --> 1 branches: 1 2 3 --> we see that 1+1=2, 1+2=3, and 1+3=4
        // we continue this decision tree until each branch reaches a sum greater than target
        // doing the whole decision tree will be a lot of work, so we can reuse some of the work that we did, hence DP

        // intially starting at sum=0, we got 3 subproblems --> we want to find how many possible ways can we reach 
        // the target if we're starting at 1, and then starting at 2, and then 3
        // we saw that there are 3 different ways to get to the target when we start at 1 (DRAW DECISION TREE FOR PROOF)
        // additionally, after drawing the branches starting at 1, we see the different ways of getting to target when
        //  we start at 2 and when we start at 3 (we see this when drawing the branches starting at 1)
        //  starting at the 2 branch (within 1 branch), we see that there are 2 ways to reach to 4 (DRAW DECISION TREE FOR PROOF)
        //  similarly, starting at the 3 branch (within 1 branch), we see there is 1 way to reach to 4

        // bottom up DP --> DP[0] (bottom), how many different ways are we able to sum to target value 0
        //  every value in our input array is positive, so we can just say DP[0]=1 (base case)
        // calculate DP[1] by trying every value in input array and see if they end up equalling 1
        // do DP[4] = DP[4-1] + DP[4-2] + DP[4-3]
        // TC O(n*m) --> double loop, n is nums size and m is target
    }
}