/*
Write a function that takes the binary representation of an unsigned integer 
and returns the number of '1' bits it has (also known as the Hamming weight).

Note:
Note that in some languages, such as Java, there is no unsigned integer type. 
In this case, the input will be given as a signed integer type. 
It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
*/

public class Solution {
   // you need to treat n as an unsigned value
   public int hammingWeight(int n) {
      int count = 0;
      for(int i=0; i<32; i++){
         if((n&1)!=0){
            count++;
         }
         n = n>>1;
      }
      return count;

      /*int count = 0;
      while (n != 0) {
         n = n & (n - 1);
         count++;
      }
      return count;*/
   }
}

// TC: O(32) ~ O(1)
// SC: O(1), no extra memory needed
    // this approach looks at every single bit, even bits that are NOT 1's
    // second approach only looks at the spots that 1's, faster but still the same O(1)

// Every input is a 32-bit integer


// e.g. 1011
// FIRST SOLUTION:
    // starting with the bit on the right side, how do we know if it's a 1 or a 0
    // first way: "and" it with the integer 1, i.e. 1&0 --> 0, 0&0 --> 0, 1&1 --> 1
    // second way: modding by 2, i.e. 1011%2 --> seeing if the remainder is a 1 or 0

    // bit shift the bits to the right by 1 --> can use bit shift operator or just divide by 2

// SECOND SOLUTION:
    // say n=10000001
    // then, n-1 = 10000000
    // then, n & (n-1) = 10000001 & 10000000 = 10000000
    // so n = 10000000
    // increment count
    
    // so now, n=10000000
    // then, n-1 = 01111111
    // then, n & (n-1) = 10000000 & 01111111 = 00000000
    // so n = 00000000
    // increment count

    // exit while loop