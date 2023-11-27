/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

- Starting with any positive integer, replace the number by the sum of the squares of its digits.
- Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
- Those numbers for which this process ends in 1 are happy.

Return true if n is a happy number, and false if not.
*/

class Solution {
   public boolean isHappy(int n) {
      // base case
      if(n==1){
         return true;
      }

      Set<Integer> visit = new HashSet<>();
      while(!visit.contains(n)){
         visit.add(n);
         n = sumOfSquares(n);

         if(n==1){
            return true;
         }
      }

      return false;
   }

   private int sumOfSquares(int num){
      int sum = 0;
      String numStr = Integer.toString(num);
      for(int i=0; i<numStr.length(); i++){
         int digit = Character.getNumericValue(numStr.charAt(i));
         sum += digit * digit;
      }
      return sum;
   }

    /*
    public int sumOfSquares(int n) {
        int sum = 0;

        while (n != 0) {
            int digit = n % 10;     // mod to get the ones place digit
            digit = digit * digit;
            sum += digit;
            n = n / 10;             // integer division drops the ones place --> 19/10 = 1
        }

        return sum;
    }
    */
}

// TC: O(k): k can be less or more than n, k == number of iterations to either reach 1 or detect a cycle (read problem statement)
// SC: O(m): m is the number of different numbers encountered in the process

// NOTE BELOW, Algorithm:
// continuously reassign n
// visit set helps us detect a cycle --> continue while loop until we run into an existing element --> return false
// if we run into n==1, return true right away

// whether it's a 1 or not, it's gonna loop endlessly
    // 1^2=1^2=1 --> infinite loop
    // even if we never reach a 1, we'll still be stuck in infinite loop

// e.g. n=19
    // 19 --> 82 --> 68 --> 100 --> 1
// e.g. n=2
    //  2 --> 4 --> 16 --> 37 --> 30 --> 9 --> 81 --> 65 --> 61 --> 37 (we already hit 37)
// IMPORTANT: we have to check if we run into the same number again, use hash set