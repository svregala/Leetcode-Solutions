/*
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 */

class Solution {

   int ROW;
   int COL;

   public List<List<Integer>> pacificAtlantic(int[][] heights) {

      ROW = heights.length;
      COL = heights[0].length;

      // 2 hash sets for pacific and atlantic
      // these sets maintain the positions that can reach the pacific and atlantic respectively
      Set<List<Integer>> pac = new HashSet<>();
      Set<List<Integer>> atl = new HashSet<>();

      // go through every position in the first row (next to pacific)
      // AND go through ever position in the last row (next to atlantic)
      for(int j=0; j<COL; j++){
         dfs(0, j, pac, heights[0][j], heights);
         dfs(ROW-1, j, atl, heights[ROW-1][j], heights);
      }

      // similarly, go thru every position in the first column (next to pacific)
      // AND go thru every position in the last column (next to atlantic)
      for(int i=0; i<ROW; i++){
         dfs(i, 0, pac, heights[i][0], heights);
         dfs(i, COL-1, atl, heights[i][COL-1], heights);
      }
      // once the 2 loops above have ran, we'll have marked every single position 
      // that can reach pacific (pac set) and atlantic (atl set)

      pac.retainAll(atl); // intersection of pac and atl
      List<List<Integer>> res = new ArrayList<>(pac);
      return res;

      // TC: O(n*m) with n rows and m columns because we're not revisiting nodes several times
      // in our dfs, if we get to a cell that we ALREADY visited, we just return, we don't have to continue our dfs from a repeated cell
   }

   // dfs function MARKS all nodes that can reach the pacific ocean and atlantic ocean
   private void dfs(int r, int c, Set<List<Integer>> visit, int prevHeight, int[][] height_arr){
      // if we have visited this position OR 
      // if it's out of bounds OR 
      // if height of current cell is less than previous height, return
      if(visit.contains(Arrays.asList(r,c)) || r<0 || c<0 || r==ROW || c==COL || height_arr[r][c] < prevHeight){
         return;
      }

      // if we're NOT returning, we're finding a new cell
      visit.add(Arrays.asList(r,c));

      // then run dfs on all 4 of those neighbors (as given in problem statement - N,E,S,W)
      dfs(r-1, c, visit, height_arr[r][c], height_arr);
      dfs(r, c+1, visit, height_arr[r][c], height_arr);
      dfs(r+1, c, visit, height_arr[r][c], height_arr);
      dfs(r, c-1, visit, height_arr[r][c], height_arr);
   }

}

// start at the rows and columns that are next to the pacific and atlantic
// ie start at row=0, row=m-1, col=0, col=n-1

// first, go through first row which are pacific ocean values
    // from there, run DFS to see all other nodes that can reach the pacific ocean
// do the same thing with the bottom row and seeing which nodes can reach the atlantic ocean
    // maintain all of those ^^ in a hash set 

// NOTE: comment block below pertains to first for loop in main function
    // run dfs on this position, pass in a visit set to this dfs function, pacific set
    // since this is the first row, the first row is next to the pacific ocean
    // I want to visit this position and see which other positions it can reach
    // we know that water FROM the ocean can go to cells that are equal or greater in value

    // if we're gonna visit a cell, we have to make sure we're allowed to visit that cell
    // so pass in a previous height variable representing the previous height we were at
        // since there is NO prev height for the position [0][j], give default value as the same height
        // bc we're allowed to visit cells of the same height

    // ^^ similarly for the bottom row next to the atlantic

// IMPORTANT: we need to start traversing beginning from the TOP & BOTTOM row AND LEFT & RIGHT MOST column
    // reason: take only the top row (pacific), we are searching the whole grid to see if we can 
    // reach the pacific from all positions --> we extend this method to all sides of the grid because
    // we need to see which spots are reachable from both pacific and atlantic sides
    // considering all sides allows us to record positions in the grid that are reachable (either from pacific or atlantic)