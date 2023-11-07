/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */

// DFS SOLUTION - less memory
class Solution {
   int ROW = 0;
   int COL = 0;
   Set<List<Integer>> visit = new HashSet<>();

   public int numIslands(char[][] grid) {
      ROW=grid.length;
      COL=grid[0].length;
      int count = 0;

      for(int i=0; i<ROW; i++){
         for(int j=0; j<COL; j++){
            if(grid[i][j] == '1' && !visit.contains(Arrays.asList(i,j))){
               dfs(grid, i, j);
               count++;
            }
         }
      }

      return count;
   }

   private void dfs(char[][] g, int r, int c){
      // check if cell is in bounds, if it is a land, if we HAVE NOT visited the cell yet
      if(r>=ROW || r<0 || c>=COL || c<0 || g[r][c]=='0' || visit.contains(Arrays.asList(r,c))){
         return;
      }

      visit.add(Arrays.asList(r,c));
      dfs(g, r-1, c); //up,down,left,right
      dfs(g, r+1, c);
      dfs(g, r, c-1);
      dfs(g, r, c+1);
   }
}

 /* BFS SOLUTION BELOW
class Solution {

   // visit set will keep track of positions visited
   Set<List<Integer>> visit = new HashSet<>();
   int ROW = 0;
   int COL = 0;
   // check the adjacent positions of this cell we just popped --> check up, down, left, right
   int[][] directions = { {-1,0}, {1,0}, {0,-1}, {0,1} };

   public int numIslands(char[][] grid) {
      
      // BFS
      ROW = grid.length;
      COL = grid[0].length;
      int islands = 0;

      for(int i=0; i<ROW; i++){
         for(int j=0; j<COL; j++){
            if(grid[i][j]=='1' && !visit.contains(Arrays.asList(i, j))){
               bfs(i, j, grid);
               islands++;
            }
         }
      }
      return islands;
   }

   private void bfs(int r, int c, char[][] g){
      Queue<List<Integer>> q = new LinkedList<>();
      visit.add(Arrays.asList(r, c)); // mark spot as visited
      q.add(Arrays.asList(r,c));

      // while q is not empty, we will expand our island
      while(!q.isEmpty()){
         List<Integer> cell = q.remove();
         int row = cell.get(0);
         int col = cell.get(1);
         
         for(int[] dir : directions){
            // check if position is in bounds, if it's 'a land position, and if we have visited it already 
            // --> add to queue so we could run BFS on this cell as well, and mark as visited so we don't visit twice
            int new_r = row+dir[0];
            int new_c = col+dir[1];
            if( (new_r < ROW && new_r >= 0) && (new_c < COL && new_c >= 0) && g[new_r][new_c]=='1' && !visit.contains(Arrays.asList(new_r, new_c))){
               q.add(Arrays.asList(new_r, new_c));
               visit.add(Arrays.asList(new_r, new_c));
            }
         }
      }
   }
}

// NOTE: below comment pertains to nested loop in main function
// don't need to do anything if we hit a 0
// if we hit 1, traverse it and mark as visited
    // run bfs on that cell
    // increment number of islands --> we ONLY increment num of islands if we get to a "1" we haven't already visited
    // --> SO if we want to increment, we want to make sure we got to a position we haven't visited

*/