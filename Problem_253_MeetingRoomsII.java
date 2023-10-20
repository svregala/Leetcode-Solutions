/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.)
(5,10) , (10,15) are non overlapping
*/

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(){
 *       start = 0;
 *       end = 0;
 *     }
 *     Interval(int start, int end) {
 *       this.start = start;
 *       this.end = end;
 *     }
 * }
*/

class Solution {
   public int minMeetingRooms(List<Interval> intervals) {

      // base case
      if(intervals.size()==0 || intervals.size()==1){
         return intervals.size();
      }

      int[] startTime = new int[intervals.size()];
      int[] endTime = new int[intervals.size()];

      for(int i=0; i<intervals.size(); i++){
         startTime[i] = intervals.get(i).start;
         endTime[i] = intervals.get(i).end;
      }

      Arrays.sort(startTime);
      Arrays.sort(endTime);

      int res = 0;
      int count = 0;

      // pointers
      int s = 0;
      int e = 0; 

      while(s < intervals.size()){  // we know s is gonna reach the end before e does
         if(startTime[s] < endTime[e]){ // checking to see if we have another additional meeting going on
            count++; 
            s++;
         }else{   // 
            count--;
            e++;
         }

         res = Math.max(res, count);
      }

      return res;
   }
}

// TC: O(nlogn)
// SC: O(n)

// Similar to meeting rooms I
// minimum number of conference rooms == max number of overlapping meetings at any given point in time
// go through the meeting times and keep a count of the number of meetings occurring at the same time
// sort input array --> 2 input arrays, one for start times and one for end times
   // put all start times in separate array, similarly for all end times
   // e.g. intervals = [(0,30),(5,10),(15,20)]
      // start = [0, 5, 15]
      // end = [10, 20, 30]
   // have a pointer for start array and pointer for end array --> always pick minimum value
      // if the minimum of the two values is the start time, we increment count, then shift start pointer to the next one --> implies we encountered a meeting that started before another ended
      // if equal values or min is end time, visit the end time, so decrement count bc a meeting just ended --> a meeting has to end before the meeting starts