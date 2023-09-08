/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
*/

class Solution {
   public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(nums);

      for(int i=0; i<nums.length-2; i++){
         // Skip duplicates for i (since we're already checking values that work with that i)
         if(i>0 && nums[i] == nums[i-1]){
            continue;
         }

         // note that nums was sorted
         int j = i+1;
         int k = nums.length-1;

         while(j<k){
            int sum = nums[i]+nums[j]+nums[k];

            if(sum == 0){
               // found triplet with 0 sum
               res.add(Arrays.asList(nums[i], nums[j], nums[k]));

               // skip duplicate elements for j
               while(j<k && nums[j] == nums[j+1]){
                  j++;
               }

               // skip duplicate elements for k
               while(j<k && nums[k] == nums[k-1]){
                  k--;
               }
               
               // move pointers
               j++;
               k--;
            }
            else if(sum<0){
               // sum is less than 0, increment j to increase sum (array is sorted)
               j++;
            }
            else{
               // sum is greater than 0, decrement k to decrease sum (array is sorted)
               k--;
            }
         }
      }

      return res;
   }
}