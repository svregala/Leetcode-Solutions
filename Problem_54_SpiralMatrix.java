/*
Given an m x n matrix, return all elements of the matrix in spiral order.
 */

class Solution {
   public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> res = new ArrayList<>();

      int left = 0;
      int right = matrix[0].length;
      int top = 0;
      int bottom = matrix.length;

      while(left<right && top<bottom){

         // left to right
         for(int i=left; i<right; i++){
            res.add(matrix[top][i]);
         }
         top++;

         // top to bottom
         for(int i=top; i<bottom; i++){
            res.add(matrix[i][right-1]);
         }
         right--;

         // make sure we're still in bounds
         if(!(left<right && top<bottom)){
            break;
         }

         // right to left
         for(int i=right-1; i>left-1; i--){
            res.add(matrix[bottom-1][i]);
         }
         bottom--;

         // bottom to top
         for(int i=bottom-1; i>top-1; i--){
            res.add(matrix[i][left]);
         }
         left+=1;
      }

      return res;
   }
}