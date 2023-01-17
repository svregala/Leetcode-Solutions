/* 
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
*/

import java.util.Arrays;

class Solution {
   public int singleNumber(int[] nums) {
       Arrays.sort(nums);
       for(int i=1; i<nums.length; i+=2){
           if(nums[i] != nums[i-1]){
               return nums[i-1];
           }
       }
       return nums[nums.length-1];
   }
}