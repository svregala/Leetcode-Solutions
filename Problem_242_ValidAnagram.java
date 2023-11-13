/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

class Solution {
   public boolean isAnagram(String s, String t) {
      if(s.length() != t.length()){
         return false;
      }

      Map<Character, Integer> map = new HashMap<>();
      for(int i=0; i<s.length(); i++){
         map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
         map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
      }

      for(int val : map.values()){
         if(val!=0){
            return false;
         }
      }

      return true;
   }
}

// TC: O(n), SC: O(1) bc of map (map or array will be at most size 26)
    // use a hash map --> put in letters and frequency count in map of string s --> iterate string t and decrement by 1 existing letters
    // final loop, if found any non zero values, then return false;

// TC: O(nlogn) due to sorting, SC: O(n+n)~O(n) bc of array --> O(1) map or array will be at most size 26
/*
public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()){
        return false;
    }

    char[] s_arr = s.toCharArray();
    char[] t_arr = t.toCharArray();

    Arrays.sort(s_arr);
    Arrays.sort(t_arr);

    for(int i=0; i<s_arr.length; i++){
        if(s_arr[i] != t_arr[i]){
            return false;
        }
    }

    return true;
}
*/