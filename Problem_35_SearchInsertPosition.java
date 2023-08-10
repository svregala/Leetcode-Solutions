/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        // Binary search implementation
        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        while(low <= high){
            mid = (high+low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        if(nums[mid]<target){
            return mid+1;
        }

        return mid;
    }
}