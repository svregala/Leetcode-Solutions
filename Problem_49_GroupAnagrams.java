/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

class Solution {
   public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> anagrams = new HashMap<>();

      for(String s : strs){
         char[] s_arr = s.toCharArray();
         Arrays.sort(s_arr);

         String temp_str = new String(s_arr);
         if(!anagrams.containsKey(temp_str)){
            anagrams.put(temp_str, new ArrayList<>(Arrays.asList(s)));
         }else{
            anagrams.get(temp_str).add(s);
         }
      }

      return new ArrayList<>(anagrams.values());
   }
}

// TC: O(n*mlogm) with n=length of string list, and m=length of longest string in list
// SC: O(n)