/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. 
There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 */


// Implement a trie node to put inside trie
// don't need to store character in the TrieNode
    // because that's gonna be implicit from the hashmap
    // e.g. adding a character 'a'
        // children.put('a', new TrieNode()); <-- inserting a node

class TrieNode {
   Map<Character, TrieNode> children;
   boolean endOfWord;

   public TrieNode() {
      children = new HashMap<Character, TrieNode>();
      endOfWord = false;
   }
}

class Trie {
   TrieNode root;

   public Trie() {
      root = new TrieNode();
   }
   
   public void insert(String word) {
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
      TrieNode curr = root;
      for(char c : word.toCharArray()){
         if(!curr.children.containsKey(c)){
            return false;
         }
         curr = curr.children.get(c);
      }
      if(curr.endOfWord){
         return true;
      }
      return false;
   }
   
   public boolean startsWith(String prefix) {
      TrieNode curr = root;
      for(char c : prefix.toCharArray()){
         if(!curr.children.containsKey(c)){
            return false;
         }
         curr = curr.children.get(c);
      }
      return true;
   }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and 
// retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

// insert function:
    // if character doesn't exists, add to current node's childen (think root node adding a letter, thus word, for first time)
    // then reassign current to that child node
    // end loop: current is reassigned to the last letter of the word when it reaches this point so mark it as end of word

// insert("apple")
    // create a node for the lowercase letter 'a'
    // create another node for letter 'p'
    // do this for every character in the word we're inserting
    // add as a child of the previous character
    // mark the end of the word, mark 'e' such that it's identified as the end of the word
// we can add a node for each letter in the alphabet, indicating that words that start with 'b' will be continued down that stretch
    // similarly for all the rest of the letters
    // all these letters stem from the root, even though the root doesn't really have a character; it's basically a placeholder node

// search("apple")
    // start at the root; check if this root has a child node that has the first letter, 'a', of the word we're looking for
        // if we find it, then we look for the next character; does node with 'a' have a child node with 'b' character? Yes
    // we go character by character and seeing if a node exists for each character consecutively as a child
        // when we find the last character 'e', we have to CONFIRM if it's marked as being the end of the word; yes
    // operation therefore returns true

// search("app")
    // start from root, we have 'a'
    // then we find the first 'p'
    // then we find the second 'p'
    // --> we found all characters in 'app' but we're NOT returning true because the second 'p' is NOT marked as the end of a word
    // return FALSE

// startsWith("app") --> this function allows us to search prefixes
    // check character by character
    // start 'a', it exists
    // check 'p', it exists
    // check 'p', it exists
    // found all the characters, guaranteed either that this is a word inside trie or there's some word below that's been marked
    // return TRUE

// insert("ape")
    // DONT create new nodes for all letters
    // we have a node with 'a' and 'p' so we leverage them
    // create a new child node of the first 'p' in the trie, child node holds 'e' and mark it as the end of the word

// startsWith('b')
    // start at root and check if it has children that start with 'b'
    // if you use a list as DS to store words, worst case to check prefixes would be O(n) with n==num words
    // check the first layer (it will be worst case 26 elements/letters) --> O(26) = O(1)
    // return FALSE

/*
            root
          a
        p
      p  e
    l
  e
*/
