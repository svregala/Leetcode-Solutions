/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
*/

class Solution {
   public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(nums);

      for(int i=0; i<nums.length-2; i++){
         if(i>0 && nums[i]==nums[i-1]){
            continue;
         }

         int j=i+1;
         int k=nums.length-1;
         while(j<k){
            // if sum>0, shift right pointer
            if(nums[i]+nums[j]+nums[k] > 0){
               k--;
            }
            // if sum<0, shift left pointer
            else if(nums[i]+nums[j]+nums[k] < 0){
               j++;
            }
            // else, add to result
            else{
               List<Integer> entry = new ArrayList<>();
               entry.add(nums[i]);
               entry.add(nums[j]);
               entry.add(nums[k]);
               res.add(entry);

               // avoid duplicates by also shifting j and k accordingly
               // similar to what we did with i
               while(j<k && nums[j]==nums[j+1]){
                  j++;
               }

               while(j<k && nums[k]==nums[k-1]){
                  k--;
               }

               // move pointers after find the last of the duplicates in the 2 previous while loops
               j++;
               k--;
            }
         }
      }

      return res;
   }
}

/*
Approach 2:
TC: O(nlogn) + O(n^2) ==> O(n^2)
   ^ sorting  ^ one loop to tell us the value at i, and second loop to solve 2Sum II

SC: O(1) --> not including the result

- Sort the input array first
e.g. [-3 3 4 -3 1 2] --> [-3 -3 1 2 3 4]

- first -3 we see that -3 1 2 add up to 0
- second -3 we cannot use this again bc it'll be a duplicate
   - we see that it's left neighbor is also -3, we don't want to use it again
   - we already computed all combos that start with a -3, so we don't need to do it anymore
   - skip it until it's not a -3

IMPORTANT:
- let a, b, c represent the 3 numbers that we're looking for s.t. they add up to 0
- suppose we assign a to the first -3, then finding b and c will be the 2Sum II problem
*/

/*
Approach 1: Brute Force
- Triple nested loop, but it's O(n^3) and prone to adding duplicates
*/