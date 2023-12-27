/* 
Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. 
Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), 
that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.
*/

class Solution {
   public int leastInterval(char[] tasks, int n) {
      // base case
      if(n==0){
         return tasks.length;
      }

      // each task takes 1 unit of time
      // minimize idle time

      // count the occurences of each character and store in map
      Map<Character, Integer> count = new HashMap<>();
      for(char c : tasks){
         count.put(c, count.getOrDefault(c, 0)+1);
      }

      // create Max Heap to store the counts
      PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
      for(int val : count.values()){
         max_heap.offer(val);
      }

      // time variable to keep track of time
      // queue of int array for our task scheduler --> [task, idle time]
         // idle time is the time that we're available to put the task back in the max heap
      int time = 0;
      Queue<int[]> q = new LinkedList<>();

      while(!max_heap.isEmpty() || !q.isEmpty()){    // while each one is not empty, that means we have more tasks to process
         time++;

         if(!max_heap.isEmpty()){
            int task = max_heap.poll() - 1; // when we pop from heap, we are processing a task (subtract 1; refer to algo below)

            if(task>0){
               int[] pair = {task, time+n};
               q.add(pair);
            }
         }

         if(!q.isEmpty() && q.peek()[1]==time){
            max_heap.offer(q.poll()[0]);
         }
      }

      return time;
   }
}

// keep track of how many characters of each there is
    // tasks = AAABBCC, n=1
    //          3  2 2
    // idle time is 1

// what order should we process the characters in? 
    // the MORE FREQUENT tasks first because there's some idle time that needs to be in between the same tasks
    // also, processing the more frequent ones first gives us more time to NOT be idle
        // say we DIDN'T do the more frequent ones first, e.g.:
            // C B C B A _ A _ A --> this takes 9 units of time
        // whereas
            // A B C A B C A --> this takes 7 units of time

// to process the more frequent tasks first, we use a MAX HEAP --> allows us to continuously figure out which task is the most frequent
    // we can determine which task is most frequent in log(n) time, better yet log(26) since we only have 26 characters

// ALGORITHM:(refer to above example)
// max heap will have integers, not the characters
    // max heap = [3 2 2]
    // when we pop 3, we have to change it to 2 and then add it to our queue ALONG with the time that we're allowed to add it back to heap
    // we add to the queue because there is some amount of idle time for this task
    // at the current point in time, we are at time=1; we were at time=0 initially and we processed a task to time turned to 1
        // we're at time=1, our idle time for each task is n=1, so we take n=1 and add it to time=1 --> 2
        // thus, our queue will look like queue = [2 2] --> the SECOND '2' is the time at which we can process this task again, 
            // AKA add the FIRST '2' back to the heap when time=2

    // THEN, now we pop the first '2' (in heap) which means we processed the task, so change time to time=2
        // we change 2 to 1 and then add it to our queue along with the time that we're allowed to add it back to the heap
        // currently, time=2
        // currently, our queue will look like queue = [2 2 | 1 3]

    // Now that we are at time=2, the first element in the queue is available now to add back to our heap
        // so pop it from our queue and add it back to our max heap --> [2 2], queue = [1 3]
    
    // Pop the first '2' from heap and add 1 to the queue, add 1 to time so now time=2 so then time=3
        // since time=3, pop 1 3 from the queue and add it back to the heap --> heap = [2 1] and queue = [1 4]

    // Pop the first '2' from heap again and add 1 to the queue, add 1 to time so time=4
        // since time = 4, pop 1 4 from the queue and add it back to the heap --> heap = [1 1] and queue = [1 5]

    // Pop the first '1' from heap, add 1 to time so time=5, and we're done since it's 0 now
        // since time=5, we pop 1 5 from the queue and add it to our heap so our heap is [1 1]

    // then, pop the first 1 from heap, and add 1 to time so time=6 --> our heap is now [1]
        // pop the last element from the heap and add 1 to time so time=7 --> return 7


// TC: O(n) because we have to count the occurence of each task by going through the entire input
    // and we're adding and popping every value to and from the Max Heap
    // More correct TC is O(n*m), given that m is the idle time
        // in the worst case, we have to go through the idle for each task that we have
        // suppose we have task = A A A A A, with n=2 --> 
            // so time complexity is 5*2 since we have to go through the idle time for each task
// SC: O(n), n is total number of tasks




/*
Examples:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8

Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
*/