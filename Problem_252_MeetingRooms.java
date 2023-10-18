/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
*/

import java.util.List;

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
   public boolean canAttendMeetings(List<Interval> intervals) {
      if(intervals.size()==0 || intervals.size()==1){
         return true;
      }
      Collections.sort(intervals, new IntervalComp());

      for(int i=0; i<intervals.size()-1; i++){
         if(intervals.get(i).end > intervals.get(i+1).start){
            return false;
         }
      }

      return true;
   }

   public class IntervalComp implements Comparator<Interval>{
      @Override
      public int compare(Interval int1, Interval int2){
         // Compare based on the 'start' field
         return Integer.compare(int1.start, int2.start);
      }
   }
}
// SORT based on the start value of each interval
// TC: nlogn