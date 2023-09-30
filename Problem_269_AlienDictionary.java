/*
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. 
Derive the order of letters in this language.
*/

class Solution{

   // map to keep track of visited nodes
   // for each character, map it to 2 values: FALSE=visited, TRUE=visited AND it's in current path
   // if character is NOT in the visit map at all, then it has not been visited at all
   Map<Character> visit = new HashMap<>();
   String result = "";

   public String alienOrder(String[] words) {
      // adjacency list to create the graph: char to set to make sure we don't have duplicates
      Map<Character, Set<Character>> adj_list = new HashMap<>();
      for(String w : words){
         for(char c : w.toCharArray()){
            adj_list.put(c, new HashSet<>());
         }
      }

      // go through every pair of words
      for(int i=0; i<words.length-1; i++){
         String w1 = words[i];
         String w2 = words[i+1];
         
         int min_length = Math.min(w1.length(), w2.length()); // we only need to go up to the shortest word's length

         // edge case: if prefix of each word is the exact SAME, and the first word is longer than the second word, this means that it is INVALID ordering (apes, ape example)
         if( w1.length() > w2.length() && w1.substring(0,min_length).equals(w2.substring(0,min_length)) ){
            return "";
         }

         // go through every character between w1 and w2, find the first differing character
         // if the same, do nothing; if different add to map
         for(int j=0; j<min_length; j++){
            if(w1.charAt(j) != w2.charAt(j)){
               adj_list.get(w1.charAt(j)).add(w2.charAt(j));
               break; //since we only want the first differing character
            }
         }
      }

      // DFS -- go through each character in adjacency list and call dfs on it
      for(Map.Entry<Character,Set<Character>> entry : adj_list.entrySet()){
         if(dfs(entry.getKey(), adj_list)){
            return "";
         }
      }

      return new StringBuilder(result).reverse().toString();
   }

   // if character/node is inside visit, return the value of it
      // if this method return FALSE, that means the node has been visited
      // if this method returns TRUE, then that means the character/node is ALREADY in the current path 
         // --> we saw a character/node that's already in the current path (we saw it twice, we detected a loop/cycle)
   // otherwise, put it inside the map with a value of true because not only has it been visited, it's ALSO in the current path
   // IMPORTANT: at the end, before we return from the DFS, set value of character to false
      // so this means that the character/node has still been visited, but we set it to false because it's NO longer in the CURRENT path
   // BEFORE we set the value to false, we go through every neighbor/descendant/character that comes after this character, call dfs on each of its neighbors
      // if it returns true, we detected a cycle --> we're telling the recursive call we've detected a loop and we can return immediately
   // POST ORDER DFS: after we've done the recursive call, to our result we can append that character
      // we're building the string in REVERSE order
   private boolean dfs(char c, Map<Character, Set<Character>> adj){
      if(visit.contains(c)){
         return visit.get(c);
      }

      visit.put(c, true);
      for(char nei : adj.get(c)){
         if(dfs(nei, adj)){
            return true;
         }
      }

      visit.put(c, false);
      result += c;
      return false; // default boolean value to return
   }
}

// TOPOLOGICAL SORT -- involves a directed acyclical graph DAG --> has directed edges and no cycles
   // A topological sort is a linear ordering of vertices in a directed acyclic graph (DAG). 
   // Given a DAG G = (V, E), a topological sort algorithm returns a sequence of vertices in which the vertices never come before their predecessors on any paths. 
   // In other words, if (u, v) ∈ E, v never appears before u in the sequence.

   // Notes:
   // Edge case: ape, apes --> ape will always be first
   // in the input, if we're given a list such that apes come BEFORE ape (eg [apes, ape]), then this is INVALID so we return an empty string

   // input array of strings is sorted lexicographically, so we use it to our advantage
   // BEFORE CODING: go through the input words and analyze the words pair by pair to see what kind of conclusions we could come up with
   // keep track of what goes before what
      // suppose the example ["wrt","wrf","er","ett","rftt"]
      // looking at the first 2 pairs, t comes BEFORE f, so t->f, so we're constructing a graph; next would be w->e
   // using these relations, we can build a graph --> then traverse the graph
      // w -> e -> r -> t -> f 
      // OUTPUT = "wertf" 
   // (1) now suppose that after processing the input, we have w -> e -> r -> t -> f -> w 
      // CYCLIC graph, ambiguous order, INVALID solution so return empty string
   // (2) now suppose that "rftt" did NOT exist in our input, we would then have 2 separate graphs: r -> t -> f AND w -> e 
      // this is still valid since there's not contradiction, the ordering still makes sense --> multiple possibilities of ordering:
         // "wertf" OR "rtfwe" OR bfs in which we would have "wretf"
            // note: all valid solutions above because what matters here is that we follow the graph's rules:
            // which is, w MUST come before e, r MUST come before t, t MUST come before f

      // POST ORDER DFS
      // Suppose words = ["A","BA","BC","C"] --> graph: A -> B -> C && A->C
         // if we construct the output just by pure DFS, we could possibly get "ACB" which would be wrong
      // hence post order DFS: adding nodes that are at the end first
         // we start traversing: we start at A, and then go to C; we see that C doesn't have any children so we add that to our output first
            // hence "C", then we pop back to A, and continue the DFS and we get to B, then we continue and get to C but C has been processed
            // hence "CB", then we process A so we get "CBA"
         // in short, we did leaf nodes first, then middle nodes, then beginning node
      // keep track of 2 things:
         // if a node has been visited/processed
         // if a node is in our current path (dictionary); every time we visit a node, we give it a value of false when added to path dictionary
            // then, once it's in our current path we're traversing, then we give it a value of true in the dictionary

   // TC: O(n), n as number of characters in the input, since we're traversing the graph we built
