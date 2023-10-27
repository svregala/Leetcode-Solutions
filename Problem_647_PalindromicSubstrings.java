/*
Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.
 */

class Solution {
   public int countSubstrings(String s) {
      // base case
      if(s.length()<=1){
         return s.length();
      }

      int count = 0;
      for(int i=0; i<s.length(); i++){
         int l=i, r=i;
         while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            count++;
            l--;
            r++;
         }

         l=i;
         r=i+1;
         while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            count++;
            l--;
            r++;
         }
      }

      return count;
   }
}