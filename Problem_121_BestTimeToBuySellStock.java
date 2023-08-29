/* 
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/

class Solution {
    public int maxProfit(int[] prices) {
        // Base case
        if(prices.length==1){
            return 0;
        }

        // two pointer problem
        int left = 0;
        int right = 0;
        int max = 0;
        int temp_max = 0;

        while(right<prices.length){
            // check if profitable (i.e right-left > 0)
            if(prices[left] < prices[right]){
                temp_max = prices[right] - prices[left];
                if(temp_max > max){
                    max = temp_max;
                }
            }
            // we found a NEW left that's less than our current left
            else{
                left = right;
            }
            right++;
        }

        return max;
    }
}