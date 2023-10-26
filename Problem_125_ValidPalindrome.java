/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, 
it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
 */


class Solution {
   public boolean isPalindrome(String s) {
      // base case
      if(s.length()==0 || s.length()==1){
         return true;
      }

      String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

      int l = 0;
      int r = str.length()-1;

      while(l<r){
         if(str.charAt(l) != str.charAt(r)){
            return false;
         }
         l++;
         r--;
      }

      return true;
   }
}