/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. 
Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.
*/

class Solution {
   public int lastStoneWeight(int[] stones) {
      // base case
      if(stones.length==1){
         return stones[0];
      }

      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
      for(int elem:stones){
         maxHeap.offer(elem);
      }

      int x=0, y=0;
      while(maxHeap.size()>1){
         y=maxHeap.poll();
         x=maxHeap.poll();
         if(x!=y){
            maxHeap.offer(y-x);
         }
      }

      if(maxHeap.size()==0){
         return 0;
      }
      return maxHeap.poll();
   }
}

// TC: O(nlogn), with n==stones size -- iterating through every element, max heap insertion is log(n)
// SC: O(n), max heap of size n