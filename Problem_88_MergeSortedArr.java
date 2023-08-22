/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

class Solution {
   public void merge(int[] nums1, int m, int[] nums2, int n) {
      // Base case
      if(m==0 && n==0){
         return;
      }
      else if(n==0){
         return;
      }else if(m==0){
         for(int i=0; i<n; i++){
               nums1[i]= nums2[i];
         }
         return;
      }

      // merge sorted arrays
      int a = m-1; // index at the end of nums1 list (BEFORE the zeros)
      int b = n-1; // index at the end of nums2 list
      int c = m+n-1; // index at the end of nums1 list (AFTER the zeroes)

      // traverse nums2 array because those are the elements we are adding
      while(b>=0){
         // check if a>=0 so that we can still compare nums1[a] with nums2[b]
         // check if nums1[a] > nums2[b] --> change nums1[c] to nums1[a]
         if(a>=0 && nums1[a]>nums2[b]){
               nums1[c] = nums1[a];
               a--;
               c--;
         }
         // entering this assumes either a<0 OR nums1[a] < nums2[b]
         // --> change nums1[c] to nums2[b]
         // when a<0, go through the rest of nums2 and add them accordingly
         else{
               nums1[c] = nums2[b];
               b--;
               c--;
         }   
      }
   }
}