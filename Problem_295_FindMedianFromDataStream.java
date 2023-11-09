/*
The median is the middle value in an ordered integer list. 
If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
*/

class MedianFinder {
   PriorityQueue<Integer> largeHeap;
   PriorityQueue<Integer> smallHeap;

   public MedianFinder() {
      largeHeap = new PriorityQueue<>();
      smallHeap = new PriorityQueue<>(Collections.reverseOrder());
   }
   
   public void addNum(int num) {
      smallHeap.offer(num);

      if(smallHeap.size()>0 && largeHeap.size()>0 && smallHeap.peek()>largeHeap.peek()){
         largeHeap.offer(smallHeap.poll());
      }

      if(smallHeap.size() > largeHeap.size()+1){
         largeHeap.offer(smallHeap.poll());
      }

      if(largeHeap.size() > smallHeap.size()+1){
         smallHeap.offer(largeHeap.poll());
      }
   }
   
   public double findMedian() {
      if(smallHeap.size() > largeHeap.size()){
         return smallHeap.peek();
      }
      if(largeHeap.size() > smallHeap.size()){
         return largeHeap.peek();
      }
      return (Double.valueOf(smallHeap.peek()) + Double.valueOf(largeHeap.peek()))/2;
   }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// Most obvious way to solve problem: Insert elements in-order
    // maintain numbers in sorted array
    // addNum: search for spots where it should be and then shift the rest of the elements --> O(n)
    // e.g. arr = [2,3], addNum(1) --> shift 2 and 3 and put the 1 before both so O(n)
        // addNum(4) --> check if every num and then insert so it's O(n)
        // [1,2,3,4] --> findMedian() --> easy bc it's already sorted --> O(n)

// use heap instead
    // small Heap and large Heap
    // all elements in small Heap are <= all elements in large Heap
    // size of both are always approx. equal, difference is no greater than 1, keep it as balanced as possible
    // adding to a heap is always O(logn) operation, removing is also O(logn)
    // find Max in a maxHeap is O(1), similarly for finding min in minHeap
    // IMPORTANT: small Heap uses a max heap, large Heap uses a min heap
        // reason is for finding the median --> O(1) 
    
