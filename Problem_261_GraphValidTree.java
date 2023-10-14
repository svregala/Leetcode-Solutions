/*
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.
 */

// Valid Tree: no cycles and every node connected

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution{

   // set to keep track of nodes we visited
   Set<Integer> visit = new HashSet<>();
   // adjacency list: key == node value, value == empty list
   Map<Integer, ArrayList<Integer>> adj_list = new HashMap<>();

   public boolean validTree(int n, int[][] edges){

      if(n==0){
         return true;
      }

      // create adjacency list
      for(int[] edge : edges){
         if(!adj_list.containsKey(edge[0])){
            adj_list.put(edge[0], new ArrayList<>(Arrays.asList(edge[1])));
         }else{
            adj_list.get(edge[0]).add(edge[1]);
         }
      }

      if(!dfs(0, -1)){  // loop detection
         return false;
      }

      if(n == visit.size()){  // connectivity detection
         return true;
      }

      return false;
   }

   // pass in node we're visiting & previous node we visited
   private boolean dfs(int node, int prev){
      // base case: if node in visit set, we detected a loop, return false
      if(visit.contains(node)){
         return false;
      }

      visit.add(node);
      // visit every neighbor of node
      if(adj_list.containsKey(node)){
         for(int nei : adj_list.get(node)){
            if(nei==prev){ // if nei is equal to prev node (node we came from), skip that iteration
               continue;
            }
            // detected a loop
            if(!dfs(nei, node)){
               return false;
            }
         }
      }

      return true; // no loop detected
   }

}

// DFS --> for every node, visit it's neighbors recursively and continue to do that until we visited every node that's connected to the 0 node
// at the end, take the number of input nodes we're given and check if the n umber of visited nodes matches 
   // if # of visited nodes matches the input value n, that means every node inside the graph is connected
// during DFS, detect a cycle by keeping a previous value so that we don't visit that value again from the current node which will give us a false positive

// TC: we visit node at most once, and each edge at most once, TC will be num edges + num vertices --> O(E+V)
// SP: O(E+V) since we're doing this recursively and we create an adjacency list