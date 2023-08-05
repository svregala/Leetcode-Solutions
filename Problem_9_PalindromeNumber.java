/*
Given an integer x, return true if x is a 
palindrome and false otherwise.

Constraints:
-2^31 <= x <= 2^31 - 1
 */

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        String s = Integer.toString(x);
        if(s.length()<2){
            return true;
        }

        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }

        return true;
    }
}