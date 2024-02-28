/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

class Solution {
public List<List<String>> groupAnagrams(String[] strs) {

   Map<String, ArrayList<String>> m = new HashMap<>();
   for(String s : strs){
      char[] str = s.toCharArray();
      Arrays.sort(str);
      String key = new String(str);

      if(m.containsKey(key)){
         m.get(key).add(s);
      }else{
         ArrayList<String> val = new ArrayList<>(Arrays.asList(s));
         m.put(key, val);
      }
   }

   return new ArrayList<List<String>>(m.values());
}
}

// TC: O(n*mlogm) with n=length of string list, and m=length of longest string in list
// SC: O(n) with n total elements in hashmap values