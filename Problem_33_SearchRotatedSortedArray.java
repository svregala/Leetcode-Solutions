/*
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.
*/

class Solution {
   public int search(int[] nums, int target) {
      // Binary search implementation -- with a twist -- must find pivot
      // First, decide which sorted half to search through -- at any point during the search in rotated array,
      // the left or right half will always be sorted --> must determine which half we search through

      // Left half (l to m) is sorted if nums[l]<= nums[mid]
         // if nums[l]<=nums[m], it means all elements until midpoint are in correct increasing order
         // Target lies within sorted left half if target < nums[m] AND target >= nums[l]
         // --> move search to left half so update h=m-1
         // Otherwise, target must be in right half --> l=m+1

      // Right half must sorted if left half is NOT sorted
         // Target lies within sorted right half if target >= nums[m] AND target <= nums[h]
         // --> move search to right half so update l=m+1
         // Otherwise, target must be in left half --> h=m-1

      int l=0, h=nums.length-1, m=0;

      while(l<=h){
         m = (l+h)/2;

         if(nums[m] == target){
               return m;
         }
         else if(nums[l] <= nums[m]){ // check if left half is sorted
               if(target < nums[m] && target >= nums[l]){ // check if target lies within sorted left half
                  h=m-1;
               }else{
                  l=m+1;
               }
         }
         else{ // if left is NOT sorted, right half MUST be SORTED
               if(target > nums[m] && target <= nums[h]){
                  l=m+1;
               }else{
                  h=m-1;
               }
         }
      }

      return -1;
   }
}