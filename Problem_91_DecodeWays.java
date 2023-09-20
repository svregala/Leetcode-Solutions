/*
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). 

For example, "11106" can be mapped into:
"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.
The test cases are generated so that the answer fits in a 32-bit integer.
 */

class Solution {
   public int numDecodings(String s) {
      
      // base case
      if(s.length()==0){
         return 0;
      }
      // if it's only 1 character, return 1
      else if(s.length() == 1){
         if(s.equals("0")){
            return 0;
         }
         return 1;
      }

      // any number that starts with 0 is invalid to decode
      if(s.charAt(0) == '0'){
         return 0;
      }

      // each value in dp array will represent the number of ways to decode up until that position in string
      int[] dp = new int[s.length()+1];
      Arrays.fill(dp, 0);
      // base case -- set dp[0]=1 and dp[1]=1 since we took care of when it's an empty string and when it's length 1
      dp[0] = 1;
      dp[1] = 1;

      for(int i=2; i<=s.length(); i++){
         int one_digit = Integer.parseInt(s.substring(i-1, i));
         int two_digit = Integer.parseInt(s.substring(i-2, i));
         if(one_digit>=1 && one_digit<=9){
            dp[i] += dp[i-1];
         }
         if(two_digit>=10 && two_digit<=26){
            dp[i] += dp[i-2];
         }
      }

      return dp[s.length()];

        // dp[0]=1 is base case
        // dp[1]=1 when there's one character
        // start loop at i=2 up until <= s.length and we're looking at at most 2 digits before i bc the biggest valid code is 26 (has 2 digits)
        // check if str(i-1,i) is between 1 and 9 inclusive and if so, add dp[i-1] to dp[i] (which is initially 0)
        // similarly, check if str(i-2,i) is between 10 and 26 inclusive and if so, 
            // add dp[i-2] to dp[i] (which could be 0 or whatever one_digit added)
    }
}