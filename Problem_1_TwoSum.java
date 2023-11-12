/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int left = target - nums[i];

            if(map.containsKey(left)){
                res[0] = map.get(left);
                res[1] = i;
                return res;
            }

            map.put(nums[i], i);
        }

        return res;
        // TC: O(n)
        // SC: O(n)

        // for each num in nums array, the number we are looking for is the DIFFERENCE between target and num
        // e.g. nums = 2,1,5,3 and target=4
        // say we're at element 1, the value we're looking for is the difference between the target and element 1
        // --> 4-1 = 3 --> 3 is the only value we can add to 1 such that will equal the target, we don't have to
        // check every number, we just want to see if 3 exists...
        // the most efficient way to check if 3 exists is making a hashmap of every value in nums array, 
        //  so we can instanly check if value 3 exists
        // HASMAP: map each num to it's index in nums array
        //    2:0, 1:1, 5:2, 3:3
    }
}