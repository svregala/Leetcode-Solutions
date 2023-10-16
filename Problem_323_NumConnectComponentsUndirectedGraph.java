/*
In this problem, there is an undirected graph with n nodes. There is also an edges array. Where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.
You need to return the number of connected components in that graph.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution{

   Map<Integer, ArrayList<Integer>> adj_list = new HashMap<>();
   Set<Integer> visit = new HashSet<>();

   public int countComponents(int n, int[][] edges){
      int result=0;

      // create adjacency list
      for(int[] edge : edges){
         if(!adj_list.containsKey(edge[0])){
            adj_list.put(edge[0], new ArrayList<>(Arrays.asList(edge[1])));
         }else{
            adj_list.get(edge[0]).add(edge[1]);
         }

         if(!adj_list.containsKey(edge[1])){
            adj_list.put(edge[1], new ArrayList<>(Arrays.asList(edge[0])));
         }else{
            adj_list.get(edge[1]).add(edge[0]);
         }
      }

      int i = 0;
      // add to result every time we return from the dfs 
      while(visit.size() != n){
         if(!visit.contains(i)){
            dfs(i);
            result++;
         }
         i++;
      }

      return result;
   }

   private void dfs(int node){
      if(visit.contains(node)){
         return;
      }
      
      visit.add(node);
      
      if(adj_list.containsKey(node)){
         for(int elem : adj_list.get(node)){
            dfs(elem);
         }
      }
   }

}

// TC: O(E+V), with e=num edges and v=num vertices, we have to go through every single edge when we traverse the graph and when we build the adjacency list
// also, we have to go through every node when we traverse the graph