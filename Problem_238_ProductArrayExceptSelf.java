class Solution {
   public int[] productExceptSelf(int[] nums) {
      int len = nums.length;
      int[] res = new int[len];

      int left = 1;
      for(int i=0; i<len; i++){
         res[i] = left;
         left *= nums[i];
      }

      int right = 1;
      for(int i=len-1; i>=0; i--){
         res[i] *= right;
         right *= nums[i];
      }
      
      return res;
   }
}
// TC: 2n ~ O(n), iterate throught nums array twice
// SC: O(n), result array

/*
BEFORE SPACE OPTIMIZATION:
TC: 3n ~ O(n), 3 num array iterations
SC: 3n ~ O(n), 3 arrays (prefix, suffix, & result arrays)

public int[] productExceptSelf(int[] nums) {
   int[] res = new int[nums.length];

   int[] pre = new int[nums.length];
   int[] suf = new int[nums.length];
   pre[0] = 1;
   suf[suf.length-1] = 1;

   for(int i=1; i<nums.length; i++){
      pre[i] = pre[i-1] * nums[i-1];
   }
   for(int i=nums.length-2; i>=0; i--){
      suf[i] = suf[i+1] * nums[i+1];
   }

   for(int i=0; i<res.length; i++){
      res[i] = pre[i] * suf[i];
   }

   return res;
}
*/