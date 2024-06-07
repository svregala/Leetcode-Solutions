/*
Given the array of integers nums, you will choose two different indices i and j of that array
Return the maximum value of (nums[i]-1)*(nums[j]-1).
*/

class Solution {
   public int maxProduct(int[] nums) {
      int i=0;
      int j=1;
      for(int k=2; k<nums.length; k++){
         if(nums[k] > nums[j]){
            if(nums[j] > nums[i]){
               i=j;
            }
            j=k;
         }
         else if(nums[k] > nums[i]){
            i=k;
         }
      }

      return (nums[i]-1)*(nums[j]-1);
   }
}

// TC: O(n)
// SC: O(1)