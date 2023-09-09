/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
*/

class Solution {
   public int coinChange(int[] coins, int amount) {
      // Base case
      if(amount==0 || coins.length==0){
         return 0;
      }

      // Dynamic programming
      // opt(amount) = minimum number of coins to pay for amount

      int[] dp = new int[amount+1];
      // fill out with amount+1 because we're never using that amount of coins, only using the amount given in problem
      Arrays.fill(dp, amount+1);
      dp[0] = 0; // intialize --> to pay for 0 amount, it takes 0 coins

      // FOR EACH COIN... 
      // we iterate through each amount (starting at coin value) leading up to full amount
      for(int i=0; i<coins.length; i++){ // iterate through given coins
         for(int j=coins[i]; j<=amount; j++){    // iterate through amount, starting at coin value, up until max amount
            // fill dp[j] with minimum because we're iterating some other coin AND we're already using the least possible coins
            // so we don't want to update this value
            dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);  // coins[i] is the current coin in consideration
         }
      }

      if(dp[amount] == amount+1){
         return -1;
      }
      
      return dp[amount];
      // TC: O(n*amount), with n = coin array size (distinct num of coins) --> 
         // for each given coin, we traverse through the entire amount starting at the coin value
      // SC: O(amount) --> using a dp array of size amount+1
   }
}

/*
coins = [1,2,5]
amount = 4, dp of size 4+1

      dp[0]   dp[1]   dp[2]   dp[3]   dp[4]
j=1     0       1       2       3       4       <-- amount of 1's to fill out amount for 0 amount, 1 amount, 2 amount, 3 amount, 4 amount
j=2                     1       2       2       <-- amount of 2's to fill out amount for 2 amount, 3 amount, 4 amount
j=5                                 
*/