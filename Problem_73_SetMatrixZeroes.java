/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.
 */

class Solution {
   public void setZeroes(int[][] matrix) {
      int m = matrix.length;
      int n = matrix[0].length;

      boolean rowZero = false;    // indicator if first row should turn to 0's

      for(int i=0; i<m; i++){
         for(int j=0; j<n; j++){
            if(matrix[i][j] == 0){
               matrix[0][j] = 0;
               if(i>0){
                  matrix[i][0] = 0;
               }else{
                  rowZero = true;
               }
            }
         }
      }

      // handle all rows/cols other than first row/col
      for(int i=1; i<m; i++){
         for(int j=1; j<n; j++){
            if(matrix[i][0]==0 || matrix[0][j]==0){
               matrix[i][j]=0;
            }
         }
      }

      // if it happened that matrix[0][0] was changed to 0, change whole column to 0
      if(matrix[0][0]==0){
         for(int i=0; i<m; i++){
            matrix[i][0] = 0;
         }
      }

      // if rowZero should be turned to 0's, 0 out whole row
      if(rowZero){
         for(int j=0; j<n; j++){
            matrix[0][j] = 0;
         }
      }
   }
}
// optimal approach: using only constant space -- 1 cell for overlap
    // rowZero tells us if first row is 0 or not
    // then, determine which rows/columns need to be 0
    // use first row and first column as ways to store indicators for which positions should be zero

// Initial approach: using size m array (for row) and size n array (for col)
    // keep track of which positions should be changed to 0
    // TC: O(2*m*n) = O(mn)
    // SC: O(m+n)
    /*
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(row[i] || col[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }
    */
