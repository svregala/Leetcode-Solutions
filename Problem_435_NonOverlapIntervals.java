/*
Given an array of intervals intervals where intervals[i] = [starti, endi], 
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 */

class Solution {
   public int eraseOverlapIntervals(int[][] intervals) {
      if(intervals.length==0 || intervals.length==1){
         return 0;
      }

      Arrays.sort(intervals, (a,b)->Integer.compare(a[1],b[1]));
      int res = 0;

      int[] fir = intervals[0];
      int[] sec = intervals[1];
      int i=1;

      while(i<intervals.length){

         if(i==intervals.length-1){
            if(sec[0] < fir[1]){
               res++;
            }
            return res;
         }

         if(sec[0] < fir[1]){
            res++;
            sec = intervals[i+1];
         }else{
            fir = sec;
            sec = intervals[i+1];
         }

         i++;
      }

      return res;
   }
}

// SORT BY END TIMES: why?
   // regardless of a when a meeting starts, a meeting that ends first leaves more time for other meetings to take place
   // we don't want a meeting that starts early and ends late 
   // --> what we care about is when the meeting ends and how much time it leaves for other meetings
   // after sorting, remove overlapping meetings to get maximum meetings or reject minimum meetings

   // consider this example: [[1,100],[11,22],[1,11],[2,12]]
      // we can remove 3 ([11,22],[1,11],[2,12]) OR just 2 ([2,12], [1,100])
      // we choose to remove 2 because it's the minimum number of intervals that must be removed
// res keeps track of the number of removed intervals