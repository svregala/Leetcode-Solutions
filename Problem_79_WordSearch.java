/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */

class Solution {
   // set to keep track to NOT visit the same character twice within our path
   Set<ArrayList<Integer>> path = new HashSet<>();
   String w = "";
   int ROW = 0;
   int COL = 0;

   public boolean exist(char[][] board, String word) {
      ROW = board.length;
      COL = board[0].length;
      w = word;

      for(int i=0; i<ROW; i++){
         for(int j=0; j<COL; j++){
            if(dfs(i, j, 0, board)){
               return true;
            }
         }
      }

      return false;
   }

   // pass in position of the board that we're at (r,c) AND the current character position in target word (i)
   private boolean dfs(int r, int c, int i, char[][] b){
      
      // if we reach end of word, return
      if(i == w.length()){
         return true;
      }

      // out of bounds, character at position is not equal to letter we are looking for, position is in our path already
      ArrayList<Integer> curr = new ArrayList<>(Arrays.asList(r,c));
      if(r<0 || r>=ROW || c<0 || c>=COL || b[r][c]!=w.charAt(i) || path.contains(curr)){
         return false;
      }

      // at this point, we found a character that we need
      path.add(curr);

      // run dfs on all 4 adjacent positions, if any return true, then our result returns true
      // we only need to find target word one single time so if we find that word, return true
      boolean res = false;
      if(dfs(r-1, c, i+1, b)){
         res = true;
      }
      if(dfs(r, c+1, i+1, b)){
         res = true;
      }
      if(dfs(r+1, c, i+1, b)){
         res = true;
      }
      if(dfs(r, c-1, i+1, b)){
         res = true;
      }

      // remove the position we just added because we're no longer visiting that position
      // returning from function so we don't have to continue to visit that position inside our path
      path.remove(curr);
      return res;
   }
}

// recursively back tracking
// DFS
// TC: O(m * n * 4^L), we call dfs at most m*n times
    // call stack of DFS is length of word
    // we have 4 different branches: up, down, left, right, AKA calling dfs 4 different times
        // dfs runtime is 4^L with L=length of word  