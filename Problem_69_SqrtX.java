/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator
*/

class Solution {
   public int mySqrt(int x) {
      // Base case
      if(x==0 || x==1){
         return x;
      }

      // Binary search to look for closest square root
      int start = 1;
      int end = x;
      int mid = 0;

      while(start <= end){
         mid = start + (end-start)/2;

         // If the square of the middle value is less than x, move start to right (set to mid+1)
         if ((long)mid*(long)mid < (long)x){
            start = mid + 1;
         }
         // If the square of the middle value is greater than x, move end to left (set to mid-1)
         else if((long)mid*(long)mid > (long)x){
               end = mid-1;
      
         // If square of middle value is x, return mid
         }else{
            return mid;
         }
      }

      // loop ends when start > end --> end is integer value of square root
      // round value of end to nearest integer since integer division is used in calculations
      return Math.round(end);
   }
}