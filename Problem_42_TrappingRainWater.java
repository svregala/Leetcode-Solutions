/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
*/


class Solution {
   public int trap(int[] height) {
      if(height.length==0){
         return 0;
      }

      int res=0;
      int left=0;
      int right=height.length-1;

      int maxL=height[left];
      int maxR=height[right];

      while(left < right){
         if(maxL<=maxR){
            left++;
            maxL = Math.max(maxL, height[left]);
            res += maxL - height[left]; // this is NEVER going to be negative because we update maxL before computation
            // maxL-height[left] will be between 0 and maxL, never negative
         }else{
            right--;
            maxR = Math.max(maxR, height[right]);
            res += maxR - height[right]; // this is NEVER going to be negative because we update maxR before computation
            // maxL-height[right] will be between 0 and maxR, never negative
         }

         /*
         Reason we can do the above:
         - we add to result only whichever is smaller between maxL and maxR because the minimum is the bottleneck
         - if maxL=2 and maxR=100, we calculate using the smaller of the two options
         */
      }

      return res;
   }
}


/*
APPROACH 2:
TC: O(n)
SC: O(1)

- shift the left and right one according to what's smaller

- left and right pointer
- maxL & maxR keeping track of max height at each pointer
- IMPORTANT: shift 

input    [4 2 0 3 2 5]
         L         R

- amount of water trapped so far starting from the left is 0
- at this point, maxL=4, maxR=5, so we shift the left pointer since L<R (if L==R, shift whichever, choose L)
- L now points to 2, then calculate how much water can be trapped so 4-2=2 --> res=2
- now, shift L, so L points to 0 --> 4-0=4 --> res=6
- now, shift L, so L points to 3 --> 4-3=1 --> res=7
- not, shift L, so L points to 2 --> 4-2=2 --> res=9

*/



/*
APPROACH 1:

TC: O(3n) ~ O(n)
SC: O(2n) ~ O(n)

min(l,r)-h[i]
l and r are the maximum heights

- to know how much water we can trap at index i, we need to know the max left and right height of every single position

- for maxLeft, iterate left to right
- for maxRight, iterate right to left
- min(L,R) will tell us how much water we can trap
input    [4 2 0 3 2 5]
maxLeft   0 4 4 4 4 4
maxRight  5 5 5 5 5 0
min(L,R)  0 4 4 4 4 4


public int trap(int[] height) {
   int res=0;
   int[] mL = new int[height.length];
   int[] mR = new int[height.length];

   int maxL=0;
   int maxR=0;
   for(int i=1; i<height.length; i++){
      maxL = Math.max(maxL, height[i-1]);
      mL[i] = maxL;
   }
   for(int i=height.length-2; i>=0; i--){
      maxR = Math.max(maxR, height[i+1]);
      mR[i] = maxR;
   }

   for(int i=0; i<height.length; i++){
      int diff = Math.min(mL[i], mR[i])-height[i];
      if(diff > 0){
         res+=diff;
      }
   }

   return res;
}

*/