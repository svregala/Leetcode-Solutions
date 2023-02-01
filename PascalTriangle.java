/*
Given an integer numRows, return the first numRows of Pascal's triangle.
*/

import java.util.ArrayList;

class Solution {
   public List<List<Integer>> generate(int numRows) {

       List<List<Integer>> result = new ArrayList<>();
       for (int i=0; i<numRows; i++){

           List<Integer> entry = new ArrayList<>();
           for (int j=0; j<i+1; j++){
               if(j==0 || j==i){
                   entry.add(1);
               }else{
                   entry.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
               }
           }
           result.add(entry);
       }

       return result;

   }
}