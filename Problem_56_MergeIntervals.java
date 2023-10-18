/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */

class Solution {
   public int[][] merge(int[][] intervals) {
      // base case
      if(intervals.length==0 || intervals.length==1){
         return intervals;
      }

      Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
      List<int[]> res = new ArrayList<>();
      res.add(intervals[0]);

      for(int i=1; i<intervals.length; i++){
         int lastEnd = res.get(res.size()-1)[1]; // right bound of last element in result
         int start = intervals[i][0];
         int end = intervals[i][1];

         // case 1: overlapping --> current element's left bound lies inside the last interval in result
               // change right bound to the max of (right bound of current interval, right bound of last element in result)
         if(start <= lastEnd){
            res.get(res.size()-1)[1] = Math.max(end, lastEnd);
         }
         // case 2: non-overlappping, so just add the result
         else{
            res.add(intervals[i]);
         }
      }

      return res.stream().toArray(int[][]::new);
   }
}

// TC: O(nlogn) because of sorting
// SC: O(n) because of result 

/* INITIAL SOLUTION
class Solution {
    public int[][] merge(int[][] intervals) {
        // base case
        if(intervals.length==0 || intervals.length==1){
            return intervals;
        }

        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        List<int[]> res = new ArrayList<>();

        int i=1;
        int[] fir = intervals[0];
        int[] sec = intervals[1];
        int[] merge = new int[2];

        while(i<intervals.length){
            // case 1: non overlapping -- fir before sec
            if(fir[1] < sec[0]){
                int[] to_add = Arrays.copyOf(fir, 2);
                res.add(to_add);
                fir = intervals[i];
            }
            // merge interval if overlapping, otherwise just add to result
            else{
                merge[0] = Math.min(fir[0], sec[0]);
                merge[1] = Math.max(fir[1], sec[1]);
                fir = merge;
            }

            // prevent index out of range
            if(i<intervals.length-1){
                sec = intervals[i+1];
            }
            else{
                if(res.size()>0){
                    int[] last_res = res.get(res.size()-1);
                    // case 1: non overlapping -- last element of res BEFORE fir
                    if(last_res[1] < fir[0]){
                        res.add(fir);
                    }
                    // merge interval if overlapping, otherwise just add to result
                    else{
                        merge[0] = Math.min(fir[0], last_res[0]);
                        merge[1] = Math.max(fir[1], last_res[1]);
                        res.add(merge);
                    }
                }else{
                    res.add(fir);
                }
                break;
            }

            i++;
        }

        return res.stream().toArray(int[][]::new);
    }
}
*/