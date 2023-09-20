/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */

class Solution {
   public int uniquePaths(int m, int n) {
      // dp
      int[][] dp = new int[m][n];
      for(int i=0; i<m; i++){
         dp[i][n-1] = 1;
      }
      for(int j=0; j<n; j++){
         dp[m-1][j] = 1;
      }

      for(int i=m-2; i>=0; i--){
         for(int j=n-2; j>=0; j--){
            dp[i][j] = dp[i][j+1] + dp[i+1][j];
         }
      }

      return dp[0][0];

      // dp table cell represents the number of unique paths starting at that cell -- BOTTOM UP APPROACH
      // initialize rightmost column and bottom row of table to 1 because there's only 1 way to reach the end in those rows and columns
         // i.e. moving all the way down or moving all the way right --> 1 path
      // fill up the table starting at the appropriate spot
         // for each cell the number of unique paths is the sum from the cell BELOW and the cell TO THE RIGHT (draw chart to help understand)
         // return dp[0][0]
   }
}