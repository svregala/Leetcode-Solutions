/*
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.
*/

class Solution {
   public int lengthOfLastWord(String s) {

      // alternative solution could be trimming the leading and trailing spaces using s.trim()
      // then, count the letters of the last word

      int res = 0;
      int start = s.length()-1;

      // account for when there exists spaces at the end of string
      while(start != -1 && s.charAt(start)==' '){
         start--;
      }

      // start counting letters of the last word
      while(start!=-1 && s.charAt(start)!=' '){
         res++;
         start--;
      }

      return res;
   }
}