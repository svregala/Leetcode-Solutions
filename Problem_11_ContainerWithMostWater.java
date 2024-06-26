/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
*/

class Solution {
   public int maxArea(int[] height) {
      int res=0;
      int l=0;
      int r=height.length-1;

      while(l<r){
         int minHeight = Math.min(height[l], height[r]);
         int width = r-l;
         res = Math.max(res, minHeight*width);

         while(l<r && height[l]<=minHeight){
            l++;
         }
         while(l<r && height[r]<=minHeight){
            r--;
         }
      }

      return res;
   }
}

/*
TC: O(n)
SC: O(1)

Make this even faster by shift l until height[l]>minHeight
Similarly, shift r until height[r]>minHeight
- because we only care about bigger heights

if(height[l]<height[r]){
   l++;
}else{
   r--;
}
^^ standard way of shifting

// only move left or right pointers --> move the pointer with smaller height because 
// we want to explore containers with a potential for larger areas
// AKA move the smaller height pointer because we want to always use a bigger height
// since we're exploring containers with BIGGER areas
*/
