/*
Given two integers a and b, return the sum of the two integers without using the operators + and -.
(Bitwise)
*/

class Solution {
   public int getSum(int a, int b) {
      // use bitwise XOR operator -->
      // bitwise XOR operator returns a 1 in each bit position where 
      // the corresponding bits of its two operands are different

      // base case
      if(a==0){
         return b;
      }
      if(b==0){
         return a;
      }

      // "and" & operation between a and b to find a carry
      // if a and b are both 1 at the same digit, it creates one carry
      // because you can only use 0 and 1 in binary, if you add 1+1 together, it will roll over
      // to the next digit, and the value will be 0 at this digit
      // if they are both 0 or only one of them is 0, it doesn't need a carry

      // bitwise XOR between a and b to find the different bit
      // using ^ operator is kind of adding a and b together (a+b) but ignoring the digit
      // that a and b are both 1 since we took care of this at the carry step

      // doing left shift for the carry because the carry gets added to the next digit to the left
      while(b!=0){
         int carry = a & b; 
         a = a ^ b; // "XOR" ^ operation to find the different bit, assign to a
         b = carry << 1; // shift the carry 1 position to the left and assign to b
         // iterate until no carry left
      }

      return a;
   }
}