/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), 
ans[i] is the number of 1's in the binary representation of i.
*/

class Solution {
   public int[] countBits(int n) {
      int[] dp = new int[n+1];
      dp[0] = 0;
      int offset = 1;

      for(int i=1; i<=n; i++){
         if(offset*2==i){
            offset = i;
         }
         dp[i] = 1 + dp[i-offset];
      }

      return dp;
   }
}

// TC: O(n) from our dynamic programming approach
// SC: O(n) because of the dp array

// for every value in 0-n, each value must be represented in the array as the number of 1's in the binary representation
// e.g n=2, NOTE: the leading 0's don't matter 
    // 0: 0000 --> 0
    // 1: 0001 --> 1
    // 2: 0010 --> 1
    // --> output == [0,1,1]

// Brute force: O(nlogn)
    // 3: 011
        // 3%2 = 1, then 3/2 = 01 = 1
        // 1%2 = 1, then 1/2 = 0 = 0 --> stop when we get to 0
    // we repeat the above process for numbers 0,1,2
    // time complexity is log(n) because for any integer n, how many times can you divide it by 2? --> log_2(n)
    // we do this for all integers 0-n, so the total time complexity will be nlog(n), thus O(nlogn)

// We can eliminate repeated work and we'll take it down to O(n)
    /*
    num | binary rep | # of 1's
    0 - 0000 --> 0
    1 - 0001 --> 1
    2 - 0010 --> 1
    3 - 0011 --> 2
    4 - 0100 --> 1
    5 - 0101 --> 2
    6 - 0110 --> 2
    7 - 0111 --> 3
    8 - 1000 --> 1
    */
    // for 4-7, we have a 1 in the most significant place (2nd spot)
        // also in the 3rd & 4th spot of the bin rep, we see a repeat of the previous 4 we just calculated:
            // 00, 01, 10, 11
    // if we take 0 = 0000 and just add a 1 to in in the 2nd spot, then we get 4 = 0100
    // if we take 1 = 0001 and add 1 to the 2nd spot, we get 5 = 0101

    // THUS, when we get to 4 = 0100, all we need to do is offset it by 4 and count how many 1's there are after offsetting by 4
        // since 0 = 0000 has ZERO 1's, then we do 1 + dp[0] = 1 + 0 = 1
    // at 5 = 0101, all we need to do is just 1 + dp[5-4] = 1 + dp[1] = 1 + 1 = 2
    // at 7 = 0111, dp[7] = 1 + dp[7-4] = 1 + dp[3] = 1 + 2 = 3

    // AFTER 7, we have 8 = 1000 -- the 1 is even more significant than 4 = 0100
        // 8 = 1000, the offset is NOT 4... we offset by 8!
        // 8 = 1000, 1 + dp[n-8]

    // for each value, the equation is gonna be 1 + dp[n-something] <-- something is OFFSET!!
        // the OFFSET is the most significant bit we've reached so far
        // the most significant bits are [1, 2, 4, 8, 16, ...] --> we know a bit is just a power of 2

    // IMPORTANT: (refer to significant bits array ^)
        // base case is 0 = 0000 --> zero 1's
        // 1 - 0001 --> 1 + dp[n-1] --> because 1 is the most significant bit we've reached so far is in the ONES place
        // 2 - 0010 --> 1 + dp[n-2] --> because 2 is the most significant bit we've reached so far
        // 3 - 0011 --> 1 + dp[n-2] --> because 2 is the most significant bit we've reached so far
        // 4 - 0100 --> 1 + dp[n-4]
            // we've reached a new power of 2
        // at 8 - 1000, we reached a new power of 2
            // NOTE: how do we know if we reached a new power of 2? 
            // --> say the current power of 2 is 2, as in 2 - 0010 --> 1 + dp[n-2]
            // multiply the current power of 2 by 2
            // say we're at 3 - 0011 --> we check if 2*2 = 3? It's NOT, so we did NOT reach a new power of 2
            // BUT say we're at 4 - 0100 --> check if 2*2 = 4 --. It IS! so we reached a new power of 2, so change OFFSET
        // say we are at n=7, 7 - 0111 --> check if 4*2 = 7 --> NOPE!
            // when we get to n=8, we have 4*2 = 8 so yes change OFFSET!
        // at 8*2 = 16 --> at n=16, we reach a new power of 2
