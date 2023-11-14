/*
Given an array of integers nums which is sorted in ascending order, and an integer target, 
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
*/

class Solution {
   public int search(int[] nums, int target) {
      int l=0, r=nums.length-1;
      int mid = 0;

      while(l<=r){
         mid = (r+l)/2;
         if(target==nums[mid]){
            return mid;
         }
         else if(target<nums[mid]){
            r=mid-1;
         }
         else{
            l=mid+1;
         }
      }

      return -1;
   }
}

// TC: O(logn) due to binary search
// SC: O(1) since we use constant space