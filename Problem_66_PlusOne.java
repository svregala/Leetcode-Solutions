/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. 
The digits are ordered from most significant to least significant in left-to-right order. 
The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.
 */

class Solution {
   public int[] plusOne(int[] digits) {
      // start from the end of array, if digit is >9, convert it to 0
      // if digits is <9, add 1 to it, then return digits
      for(int i=digits.length-1; i>=0; i--){
         if(digits[i]<9){
            digits[i]++;
            return digits;
         }
         digits[i]=0;
      }

      // after turning numbers to 0, add 1 to beginning of array
      // IMPORTANT: at this point, converted everything to 0, so we have to add a 1 at the beginning
      digits = new int[digits.length+1];
      digits[0] = 1;
   
      return digits;
   }
}

// TC: O(n), worst case is iterating through whole array and turning all digits to 0
// SC: O(n), worst case is reaching the end of for loop (since everything was converted to 0) and then creating new array to return