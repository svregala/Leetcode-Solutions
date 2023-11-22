/*
Design a class to find the kth largest element in a stream. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:
KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
*/

class KthLargest {
   PriorityQueue<Integer> minHeap;
   int k;

   public KthLargest(int k, int[] nums) {
      this.k = k;
      minHeap = new PriorityQueue<>();
      for(int elem : nums){
         add(elem);
      }
   }
   
   public int add(int val) {
      if(minHeap.size() < k){
         minHeap.add(val);
      }
      else if(minHeap.peek() < val){
         minHeap.poll();
         minHeap.add(val);
      }

      return minHeap.peek();
   }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

// Approach: minHeap with the top k largest elements
// SC: O(k), since minHeap is of size k
// TC: construction is O(nlogk), n==num elements in array, k is size of minHeap and it's given
    // n because we go through each element of array
    // adding to array is log k -- log k because that's the max size of our heap; 
    // if the next element to be added is greater than the minimum in heap, then take out the minimum and add the next element
    // IMPORTANT: minHeap contains ONLY k largest elements
    
    