/*
Given an integer array nums, move all 0's to the end of it 
while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
*/

class Solution {
   public void moveZeroes(int[] nums) {
       if(nums.length>1){
           int curr = 0;
           int next = 1;
           while(next!=nums.length){
               // Case 1: curr is zero and next is non-zero --> perform switch
               if(nums[curr]==0 && nums[next]!=0){
                   int temp = nums[curr];
                   nums[curr] = nums[next];
                   nums[next] = temp;
                   curr++;
                   next++;
               }
               // Case 2: curr is non-zero and next is zero OR curr+next are non-zero
               // --> no switch needed, increment both indices
               else if((nums[curr]!=0 && (nums[next]==0 || nums[next]!=0))){
                   curr++;
                   next++;
               }
               // Case 3: both curr and next are zero
               else{
                   next++;
               }
           }
           
       }
   }
}