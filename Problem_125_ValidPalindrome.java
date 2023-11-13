/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, 
it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
 */


class Solution {
   public boolean isPalindrome(String s) {
      // base case
      if(s.length()<2){
         return true;
      }

      s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
      int l=0, r=s.length()-1;

      while(l<r){
         if(s.charAt(l)!=s.charAt(r)){
            return false;
         }
         l++;
         r--;
      }
      return true;
   }
}

// TC: O(n/2) ~ O(n), with n==length of string s with only alphanumeric characters
// SC: O(1)