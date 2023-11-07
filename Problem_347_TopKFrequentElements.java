/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
*/

class Solution {
   public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> freq = new HashMap<>();
      List<Integer>[] arr_count = (List<Integer>[]) new List[nums.length+1];

      for(int n : nums){
         freq.put(n, freq.getOrDefault(n, 0)+1);
      }

      for (int i=0; i<nums.length+1; i++) {
         arr_count[i] = new ArrayList<>();
      }

      for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
         arr_count[entry.getValue()].add(entry.getKey());
      }

      int[] res = new int[k];
      int j=0;
      for(int i=arr_count.length-1; i>0; i--){
         for(int num : arr_count[i]){
            res[j] = num;
            j++;
            if(j==k){
               return res;
            }
         }
      }

      return res;
   }
}

// Approach 1: sort by descending order of values, then add the top 2 most frequent elements --> O(nlogn)

// Approach 2: add to maxheap all values of frequency map, then pop the top k elements --> O(nlogn)
    // popping and restructuring heap takes log n time, and we do this at most k times, so klogn
    // O(nlogn) + O(klog(n) = O(nlogn)

// Approach 3: Add to MIN heap all keys of map except if minHeap size is > k, pop the minimum
    // this way, we get left with the top 3 (say k=3) HIGHEST elements
    // O(nlog(k)) because we're keeping the heap size at most k elements
        // we perform insertion operation at most n times, and insertion operation takes logk time so --> O(nlog(k))

// Approach 4: Bucket sort, i is the count and is mapped to values (the values are the numbers with the corresponding i count)
    // e.g. [1,1,1,2,2,3], k = 2
    // 0   1     2    3    4    5    6
    // n [100]  [2]  [1]   []   []  []
    // O(n) TC


/* APPROACH 3
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();
    for(int n : nums){
        freq.put(n, freq.getOrDefault(n, 0)+1);
    }

    int[] res = new int[k];
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> freq.get(a)-freq.get(b));

    for(int num : freq.keySet()){
        minHeap.offer(num);
        if(minHeap.size()>k){
            minHeap.poll();
        }
    }

    for(int i=0; i<k; i++){
        res[i] = minHeap.poll();
    }
    return res;
}

*/