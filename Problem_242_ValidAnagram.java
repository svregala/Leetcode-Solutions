/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

class Solution {
   public boolean isAnagram(String s, String t) {
      // base case
      if(s.length() != t.length()){
         return false;
      }
      
      HashMap<Character, Integer> map = new HashMap<>();
      for(char c : s.toCharArray()){
         if(!map.containsKey(c)){
            map.put(c, 1);
         }else{
            map.put(c, map.get(c)+1);
         }
      }

      for(char c : t.toCharArray()){
         if(!map.containsKey(c)){
            return false;
         }else{
            map.put(c, map.get(c)-1);
         }
      }

      for(int val : map.values()){
         if(val!=0){
            return false;
         }
      }

      return true;
   }
}

// new solution: TC: O(n), SC:O(n) with n == length of string each string assuming they're the same length
    // use a hash map --> put in letters and frequency count in map of string s --> iterate string t and decrement by 1 existing letters
    // final loop, if found any non zero values, then return false;

// initial solution: sort strings and compare 
    //--> TC: O(nlogn) because of sorting with n==length of string assuming they're the same length, SC:O(1)
/*
public boolean isAnagram(String s, String t) {
    // base case
    if(s.length() != t.length()){
        return false;
    }
    char[] s_arr = s.toCharArray();
    char[] t_arr = t.toCharArray();

    Arrays.sort(s_arr);
    Arrays.sort(t_arr);

    String s_str = new String(s_arr);
    String t_str = new String(t_arr);

    if(s_str.equals(t_str)){
        return true;
    }

    return false;
}
*/