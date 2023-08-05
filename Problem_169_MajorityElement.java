/* 
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. 
You may assume that the majority element always exists in the array.
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
   public int majorityElement(int[] nums) {
       if(nums.length==0){
           return 0;
       }
       if(nums.length==1){
           return nums[0];
       }
       
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int i=0; i<nums.length; i++){
           if(map.containsKey(nums[i])){
               map.put(nums[i], map.get(nums[i])+1);
           }else{
               map.put(nums[i], 1);
           }
       }
       
       int result = nums[0];
       for(Map.Entry<Integer,Integer> elem : map.entrySet()){
           if(elem.getValue() > map.get(result)){
               result = elem.getKey();
           }
       }
       
       return result;
   }
}