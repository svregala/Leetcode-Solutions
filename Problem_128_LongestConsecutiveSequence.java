/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
 */

class Solution {
   public int longestConsecutive(int[] nums) {
      if(nums.length==0 || nums.length==1){
         return nums.length;
      }

      Set<Integer> s = new HashSet<>();
      for(int num:nums){
         s.add(num);
      }

      int maxCount = 1;
      for(int n : nums){
         // check if start of sequence, AKA no left neighbor
         if(!s.contains(n-1)){
            int count = 1;
            int next = n+1;
            // get each consecutive number and see if it exists in set
            while(s.contains(next)){
               count++;
               next+=1;
            }
            maxCount = Math.max(maxCount, count);
         }

         // check if res is more than half of the nums size --> it means we already found the longest existing sequence
         if(maxCount>nums.length/2){
            return maxCount;
         }
      }

      return maxCount;
   }
}

// identify the sequences in nums
// each sequence has start value -- find start value by checking if it has a left 
// Basic idea:
    // put nums elements in a set
    // iterate through nums, check if each item is the start value by checking if there exists a left neighbor
    // if there is NO left neighbor, then that's the start of a sequence; begin to look for the next element using our set
        // keep a count while repeatedly checking for the next element