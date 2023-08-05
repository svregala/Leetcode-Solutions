/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
*/

class Solution {
   public int searchInsert(int[] nums, int target) {
       int start = 0;
       int end = nums.length-1;
       int middle = 0;
       
       while(start <= end){
           middle = (start+end)/2;
           if(nums[middle] == target){
               return middle;
           }else if(target < nums[middle]){
               end = middle-1;
           }else{
               start = middle+1;
           }
       }
       
       if(nums[middle]<target){
           return middle+1;
       }
       return middle;
   }
}