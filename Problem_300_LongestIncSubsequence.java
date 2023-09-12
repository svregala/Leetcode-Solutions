/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.
*/

class Solution {
   public int lengthOfLIS(int[] nums) {
      
      // Dynamic programming
      // tails array is an array storing the smallest tail of increasing subsequences
      // with length i+1 in tails[i] --> tails is a increasing array
      // --> possible to do a binary search in tails array to find the one that needs update
      // Each time, do one of the two:
         // (1) if n is larger than all tails, append it, increase the size by 1
         // (2) if tails[i-1] < n <= tails[i], update tails[i]
      int[] tails = new int[nums.length];
      int size = 0;
      for(int n : nums){
         int i=0;
         int j=size;

         while(i < j){
            int mid = (i+j)/2;
            if (tails[mid] < n){
               i = mid+1;
            }else{
               j = mid;
            }
         }

         tails[i] = n;
         if(i == size){
            size++;
         }
      }

      return size;
   }
}