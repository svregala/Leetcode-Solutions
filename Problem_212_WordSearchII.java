class TrieNode{
   Map<Character, TrieNode> children;
   boolean endOfWord;

   public TrieNode(){
   children = new HashMap<Character, TrieNode>();
   endOfWord = false;
   }

   public void addWord(String word){
   TrieNode curr = this;
   for(char c : word.toCharArray()){
      if(!curr.children.containsKey(c)){
         curr.children.put(c, new TrieNode());
      }
      curr = curr.children.get(c);
   }
   curr.endOfWord = true;
   }
}

class Solution {
   ArrayList<String> res;
   HashSet<ArrayList<Integer>> visit;
   int row;
   int col;

   public List<String> findWords(char[][] board, String[] words) {
      TrieNode root = new TrieNode();

      for(String w : words){
         root.addWord(w);
      }

      row = board.length;
      col = board[0].length;
      res = new ArrayList<String>();
      visit = new HashSet<ArrayList<Integer>>();

      for(int i=0; i<row; i++){
         for(int j=0; j<col; j++){
            dfs(i, j, root, "", board);
         }
      }

      return res;
   }

   private void dfs(int r, int c, TrieNode node, String word_sf, char[][] board){
      ArrayList<Integer> curr_pos = new ArrayList<>(Arrays.asList(r,c));
      if(r<0 || c<0 || r>=row || c>=col || visit.contains(curr_pos) || !node.children.containsKey(board[r][c])){
         return;
      }

      visit.add(curr_pos);
      node = node.children.get(board[r][c]);
      word_sf += board[r][c];
      if(node.endOfWord){
         if(!res.contains(word_sf)){
            res.add(word_sf);
         }
         
      }

      dfs(r+1, c, node, word_sf, board);
      dfs(r-1, c, node, word_sf, board);
      dfs(r, c+1, node, word_sf, board);
      dfs(r, c-1, node, word_sf, board);

      visit.remove(curr_pos);

      return;
   }
}

// Backtracking Trie
    // run dfs starting from each position A SINGLE TIME because we can check what words we can create starting from that character
    // use a Trie -- we can check all words starting with specific prefix
        // say we're running dfs, and we get to our second letter, and none of the words in the list have a prefix of those two letters
        // then, we don't have to continue the dfs and we just return instantly
    
    // res, it's possible we visit the same word twice so don't return duplicates -- check if it exists in list
    // visit set prevents infinite loops in dfs process, don't repeat the same character twice

    // DFS:
        // pass in row, col, node (current node we're at in Trie depending on what characters we've visited), 
        // and word so far (e.g. if we visited characters "ac", we wanna pass it in)
        // also, if the node we're visiting happens to be the end of the word, take that word and add it in the result
        // Base case: out of bounds, current position is already in visit, 
            // board at position [r][c] is NOT in Trie at the current position that we're at in our Trie node
            // --> the character is NOT in the children of the current node we're visiting => character doesn't exist in the trie
            // ==> not one of the input words we're given
        // after checking base case, add to visit set 
            // --> before we return from dfs function, mark spot as unvisited since we can't revisit it on same path
        // update node to one in the current node's children (character board[r][c]), at this point we know this node exists
        // update word so far, add to it the new character
        // BEFORE doing dfs call on other directions, check if this is the end of the word; if so, add the word to result

    // OPTIMIZATION:
        // if it's a leaf node, remove the word in Trie so that we don't search for the same word twice


// brute force approach
    // for every single word in the list, run a dfs starting at every single position in the board
    // worst case: 4^(m*n) <-- 4 directions, length of dfs is dimensions of board, so this is 1 dfs run
        // doing a dfs at every single position so m*n*4^(m*n)
        // doing this for every single word, so w*m*n*4^(m*n) with w=length of words list 
    // more efficient solution is getting rid of constant w (look above)