/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring
of s such that every character in t (including duplicates) is included in the window. If there is no such substring, 
return the empty string "".

The testcases will be generated such that the answer is unique.
*/

class Solution {
   public String minWindow(String s, String t) {
      // base case
      if(t.equals("")){
         return "";
      }

      Map<Character, Integer> t_count = new HashMap<>();
      Map<Character, Integer> window = new HashMap<>();

      for(char l : t.toCharArray()){
         if(!t_count.containsKey(l)){
            t_count.put(l, 1);
         }else{
            t_count.put(l, t_count.get(l)+1);
         }
      }
      System.out.println("size is: " + t_count.size());
      int have = 0, need = t_count.size();
      int[] res = new int[2];
      int res_len = Integer.MAX_VALUE;
      
      int l = 0; // left pointer
      for(int r=0; r<s.length(); r++){
         char c = s.charAt(r);

         if(!window.containsKey(c)){
            window.put(c, 1);
         }else{
            window.put(c, window.get(c)+1);
         }

         // check if c in t_count, then check to see if value in window map is the same as value in t_count map
         if(t_count.containsKey(c) && window.get(c).equals(t_count.get(c))){
            have++;
         }

         while(have == need){
            // update result if the size of current window is less than current result length
            if(r-l+1 < res_len){
               res[0] = l;
               res[1] = r;
               res_len = r-l+1;
            }

            char l_c = s.charAt(l);
            window.put(l_c, window.get(l_c)-1);

            if(t_count.containsKey(l_c) && window.get(l_c)<t_count.get(l_c)){
               have--;
            }

            l++;
         }
      }

      if(res_len != Integer.MAX_VALUE){
         return s.substring(res[0], res[1]+1);
      }
      
      return "";
   }
}
// TC: O(n) --> we added each character once (O(1)), removed a character once (O(1))
    // when we added and removed a character, we did at most 2 operations -- update a spot in map and update have&need
// Hashmaps: one for t string, and another for window string
    // map for t string: for each substring we look at in string s, we wanna make sure it has all letters of string t
    // it has to pass the condition imposed in the hashmap for string t, e.g. A:2, B:1, C:3
        // substring needs to have at least 2 A's, 1 B, 3 C's
    // map for window: hashmap for the window --> how many of each letter do we have
    // big picture: t string map is telling us how much we NEED of each letter && window map is telling us how much we HAVE of each letter
// before checking the condition that the hashmap window has all the letters we need, we have a have & need integer values
    // instead of going through entire list in the map, have and need will keep track of how much we have so far
    // the only operation we do are checking if the value of a key in window map is equal to the value of the same key in t map
        // AND comparing if have==need
    // this is to eliminate more operations done, since we don't have to iterate through entire map each time checking if the values match
// have==need tells us that the substring that l and r pointers point to contains the letters of t string
    // this is a possible result, record index l and r and the length between
    // at this point, we MOVE the l pointer until the condition is NOT met (until have != need)

// Notes:
    // need = count_t.size() because it contains all the unique characters we need as well as their count
