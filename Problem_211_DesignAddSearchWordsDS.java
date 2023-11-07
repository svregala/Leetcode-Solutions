/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 */


// Trie Node
class TrieNode {
   Map<Character, TrieNode> children;
   boolean endOfWord;
   
   public TrieNode(){
      children = new HashMap<Character, TrieNode>();
      endOfWord = false;
   }
}

class WordDictionary {
   TrieNode root;

   public WordDictionary() {
      root = new TrieNode();
   }
   
   public void addWord(String word) {
      TrieNode curr = root;
      for(char c : word.toCharArray()){
         if(!curr.children.containsKey(c)){
            curr.children.put(c, new TrieNode());
         }
         curr = curr.children.get(c);
      }
      curr.endOfWord = true;
   }

   public boolean search(String word) {
      return dfs_search(0, root, word);
   }

   private boolean dfs_search(int j, TrieNode root, String w){
      TrieNode curr = root;
      for(int i=j; i<w.length(); i++){
         char c = w.charAt(i);

         if(c=='.'){
            for(TrieNode child : curr.children.values()){
               if(dfs_search(i+1, child, w)){
                  return true;
               }
            }
            return false;
         }
         else{
            if(!curr.children.containsKey(c)){
               return false;
            }
            curr = curr.children.get(c);
         }
      }

      if(curr.endOfWord){
         return true;
      }
      return false;
   }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

// TC: O(n), for well defined words, worst case O(26^n) (n is number of letters)
// SC: O(n), for well defined words

// brute force: 
    // have a list of words, and find words when we search --> not efficient
// optimization: TRIE (Prefix Tree)
    // when we encounter a dot, go through all possible children of that node
    
// search function is recursive
    // if the character is a dot '.', we can potentially go down 26 different paths since the dot can match any 26 characters
        // USE BACKTRACKING/RECURSION
    // dfs_search
        // for each value in the children map, run dfs on it
        // else code block is the iterative portion, if code block is the recursive portion
        // when we're doing dfs, what are we gonna pass in? --> 
            // we want to know what's the remaining portion of the word that we're trying to match
                // pass in starting index j, AKA i+1 because we're going down a child
                    // i+1 is the index of the character we're looking for, skipping the dot so increment i+1
                // pass in the current node in our Trie that we are at --> depending on what we're iterating through (values), pass in that child
            // dfs_search returns a boolean, so if it returns true that means we found one path that matches
            // if we don't find a path when iterating through the children map values, that means we didn't find a path so return false
    // outer for loop of nested loop:
        // always start at j wherever it happens to be
    // calling dfs in search function, main part
        // pass in 0 for j since we're starting at the beginning of the word
        // AND pass in root node of Trie because we're always starting here