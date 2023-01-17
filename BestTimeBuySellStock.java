/* 
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/

class Solution {
   public int maxProfit(int[] prices) {
       if(prices.length==1){
           return 0;
       }
       
       // two pointer problem
       int left = 0;
       int right = 1;
       int max_prof = 0;
       int temp_prof = 0;
       
       while(right < prices.length){
           if(prices[left] < prices[right]){ // check if profitable
               temp_prof = prices[right] - prices[left];
               max_prof = Math.max(temp_prof, max_prof);
           }else{  // we found a new left that's less than our current left
               left = right;
           }
           right++;
       }
       
       return max_prof;
   }
}