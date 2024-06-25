/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.
*/

class Solution {
   public int[] twoSum(int[] numbers, int target) {
      if(numbers.length==2){
         return new int[] {1,2};
      }

      int[] res = new int[2];
      int l=0;
      int r=numbers.length-1;

      while(l<r){
         if(numbers[l]+numbers[r]==target){
            res[0]=l+1;
            res[1]=r+1;
            return res;
         }
         else if(numbers[l]+numbers[r] > target){
            r--;
         }
         else if(numbers[l]+numbers[r] < target){
            l++;
         }
      }

      return res;
   }
}

/*
Optimal solution is using 2 pointer
- if the current sum is Bigger than the target, we need to decrease our sum
- if the current sum is Smaller than the target, we need to increase our sum
   - to do the above, look at below

- left pointer starts at 0
- right pointer starts at len-1
- Shifting pointers
   - if num[l]+num[r] > target, shift right pointer to the left
   - if num[l]+num[r] < target, shift left pointer to the right
   - ^^ the sorted array fact lets us do this

TC: O(n)
SC: O(1)
*/

// Brute force O(n^2) TC