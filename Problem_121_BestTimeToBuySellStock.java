/* 
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }

        int res = 0;
        int l=0, r=1;
        while(r<prices.length){
            res = Math.max(res, prices[r]-prices[l]);
            if(prices[r] <= prices[l]){
                l=r;
            }
            r++;
        }

        return res;
    }
}

// Two pointer problem -- update new left pointer if we find one that's less than current one
// TC: O(n), iterating through array of size n
// SC: O(1), only keeping track of max

// Brute force is O(n^2) checking every single pairing