/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.
 */

class Solution {
   public int[][] insert(int[][] intervals, int[] newInterval) {
      // base case
      if(intervals.length==0){
         int[][] temp = {newInterval};
         intervals = temp;
         return intervals;
      }

      List<int[]> res = new ArrayList<>();

      for(int i=0; i<intervals.length; i++){
         // case 1: if newInterval falls BEFORE current interval we're at
            // all intervals after that will be non-overlapping, so just add them and return
         if(newInterval[1] < intervals[i][0]){
            res.add(newInterval);
            for(int j=i; j<intervals.length; j++){
               res.add(intervals[j]);
            }
            //intervals = res.stream().toArray(int[][]::new);
            //return intervals;
            return res.stream().toArray(int[][]::new);
         }

         // case 2: newInterval falls AFTER current interval we're at
            // newInterval could still be overlapping with intervals to the right, so don't add newInterval yet
         else if(newInterval[0] > intervals[i][1]){
            res.add(intervals[i]);
         }

         // case 3: newIntervals is OVERLAPPING with the current interval
            // merge with the interval we're at --> min of left value & max of right value of both intervals
            // this new interval could still be overlapping with intervals to the right, so don't add yet
         else{
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
         }
      }

      // if the first if statement never executes, we don't end up adding the newInterval to result
         // consider intervals to be [[1,5]] and newInterval to be [2,3]
      res.add(newInterval);

      //intervals = res.stream().toArray(int[][]::new);
      //return intervals;
      return res.stream().toArray(int[][]::new);
   }
}