/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */

class Solution {
   public int characterReplacement(String s, int k) {
      Map<Character, Integer> letter_ct = new HashMap<>();
      int res = 0;
      
      int l = 0;
      for(int r=0; r<s.length(); r++){
         if(!letter_ct.containsKey(s.charAt(r))){
            letter_ct.put(s.charAt(r), 1);
         }else{
            letter_ct.put(s.charAt(r), letter_ct.get(s.charAt(r))+1);
         }

         int maxValue = Collections.max(letter_ct.values());
         // make sure current window is valid before updating result
         while( (r-l+1) - maxValue > k){
            letter_ct.put(s.charAt(l), letter_ct.get(s.charAt(l))-1);
            l++;
         }

         res = Math.max(res, r-l+1);
      }

      return res;
   }
}
// O(26*n) ~ O(n)
// replace the characters that appear less frequently since number of replacements is limited
    // want all characters in a window to match the most common character in that window
// Hashmap or array to keep track of the number of occurrences for each letter
    // ABABBA, k=2
    // windowLen - count["B"] --> take the window you currently have (BABB) and take the count of the most frequent character
    // 4-3 = 1 --> 
    // value 1 tells us the number of characters in our window that we need to replace in order to match the most frequent character in the window (B)
    // 4-3 <= k=2 --> as long as this condition is true, that means our current window is VALID
        // we have enough replacements to make those replacements in our current window
// How are we gonna know which character in the most frequent? Taking a map of counts and returning the max
    // the map could have at most 26 letters bc of alphabet, so still O(26)
// need a sliding window technique in addition to calculating windowLen - count["B"]
    // start at beginning of string, expand the window as much as we can as long as it meets the condition: windowLen - count["B"] <= k
        // if condition is not valid, take the left pointer and shift it until it becomes valid again
    // initially, left pointer is at beginning, right pointer as well
    // update result as we calculate windowLen - count["insert letter"] --> update with value of window length as long as condition is met
// shift right pointer, increment count of letter OR add in a new letter -- then, calculate windowLen - count["B"]
    // given ABABBA, if left=0, right=5 --> 6-3=3 > k so we shift left pointer --> shrink size of window until valid
        // NOTE: when shifting left pointer, decrement the count of the letter we moved from
// stop loop when right pointer cannot be shifted anymore