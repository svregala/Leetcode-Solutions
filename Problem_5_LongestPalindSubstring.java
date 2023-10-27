/*
Given a string s, return the longest 
palindromic substring in s.
 */

class Solution {
   public String longestPalindrome(String s) {
      // base case
      if(s.length()<=1){
         return s;
      }

      String res = "";
      int resLen = 0;

      for(int i=0; i<s.length(); i++){
         // odd length
         int l=i, r=i; // center position
         while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            if(r-l+1 > resLen){
               res = s.substring(l, r+1);
               resLen = res.length();
            }
            l--;
            r++;
         }

         // even length -- there is no center position so assign l,r accordingly
         l=i;
         r=i+1;
         while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            if(r-l+1 > resLen){
               res = s.substring(l, r+1);
               resLen = res.length();
            }
            l--;
            r++;
         }
      }

      return res;
   }
}
// brute force is O(n^3), explain why --> checking every possible substring will take n^2 and checking if palindrome will be n --> n^3
// new approach: check if string is palindrome starting from the CENTER
// approach: find the longest palindrome where the letter is the center of the palindrome
    // new way of finding palindrome
    // babsd --> the longest palindrome with 'a' in the center is 3
// TC: O(n^2)
    // iterate through string, let each character we visit be the "center" of the palindrome