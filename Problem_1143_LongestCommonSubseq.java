/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // 2D dp problem -- explain why
        // dp[i][j] represents the longest common subsequence of text1[0 ... i] & text2[0 ... j]
        /*
                    j
                
                a   c   e   
            a   3           0
            b       2       0
        i   c       2       0
            d           1   0
            e           1   0
                0   0   0   0

            FILLED out array below
                  j
                
                a   c   e   
            a   3   2   1   0
            b   2   2   1   0
        i   c   2   2   1   0
            d   1   1   1   0
            e   1   1   1   0
                0   0   0   0
        
        - each cell, we put a value in --> DP bottom up, start from bottom and get the answer at the end of top
        - go down DIAGONALLY once we find a match in both strings -- this way we can look at the remainder of both strings
            - when characters match, we add 1 to its diagonal
        - if characters don't match, take the max of the value in DOWN and value in RIGHT
        - 0's because the longest subsequence length between empty string and non-empty string is 0
        - once we reach the bottom, we take the path along where we came from
            - bottom up dp --> solve it in reverse order
        - the LCS between "de" and "e" is 1
        - NOTE: there's only 2 cases, when the characters match AND don't match each other
        */

      int[][] dp = new int[text1.length()+1][text2.length()+1];
      // Arrays.fill(dp, 0); // not needed because default initialization of arrays is with 0 values

      // nested loop -- iterate through this 2D grid in reverse order --> start at bottom right of matrix
      for(int i=text1.length()-1; i>=0; i--){
         for(int j=text2.length()-1; j>=0; j--){
            // 2 conditions
            // 1) if characters in both strings match each other --> dp[i][j] = 1 plus diagonal
            // 2) if they do NOT --> dp[i][j] = max of 2 values, value to right dp[i][j+1] & value to bottom dp[i+1][j]
            if(text1.charAt(i) == text2.charAt(j)){
               dp[i][j] = dp[i+1][j+1] + 1;
            }else{
               dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
            }
         }
      }

      return dp[0][0];
        // TC: O(n*m) given n is text1 length, and m is text 2 length
        // SC: O(n*m) because we have dp array
    }
}