/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */

class Solution {
   public void rotate(int[][] matrix) {
      // base case
      if(matrix.length == 1){
         return;
      }

      int n = matrix.length-1;
      int left = 0;
      int right = n;

      int top = 0, bottom = 0;
      int topLeft = 0;

      while(left<right){
         for(int i=0; i<right-left; i++){ // iterate through entire row except last element
            // since matrix is n x n
            top = left;
            bottom = right;

            // save the top left value
            topLeft = matrix[top][left+i];

            // move bottom left into top left
            matrix[top][left+i] = matrix[bottom-i][left];

            // move bottom right to bottom left
            matrix[bottom-i][left] = matrix[bottom][right-i];

            // move top right to bottom right
            matrix[bottom][right-i] = matrix[top+i][right];

            // move top left to top right
            matrix[top+i][right] = topLeft;
         }
         left++;
         right--;
      }
   }
}

// square matrix - TC:O(n^2), SC:O(1)