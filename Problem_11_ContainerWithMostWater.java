/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
*/

class Solution {
   public int maxArea(int[] height) {
      // 2 pointer solution
      int res = 0;
      int left = 0;
      int right = height.length-1;

      while(left < right){
         int min_height = Math.min(height[left], height[right]);
         int curr_area = min_height*(right-left);

         if(res < curr_area){
            res = curr_area;
         }

         // only move left or right pointers --> move the pointer with smaller height because 
         // we want to explore containers with a potential for larger areas
         // AKA move the smaller height pointer because we want to always use a bigger height
         // since we're exploring containers with BIGGER areas
         if(height[left] < height[right]){
            left++;
         }else{
            right--;
         }
      }

      return res;
   }
}