/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */

class Solution {
   public boolean containsDuplicate(int[] nums) {
      // base case
      if(nums.length==1){
         return false;
      }

      Set<Integer> s = new HashSet<>();
      for(int n : nums){
         if(s.contains(n)){
            return true;
         }
         s.add(n);
      }

      return false;
   }
}

// TC: O(n), n==nums size -- iterating through whole array
// SC: O(n), n==nums size -- hash set