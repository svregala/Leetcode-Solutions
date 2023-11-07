/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
   public ListNode mergeKLists(ListNode[] lists) {
      PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val-b.val);
      
      for(ListNode node : lists){
         if(node!=null){
            minHeap.offer(node);
         }
      }

      if(minHeap.isEmpty()){
         return null;
      }

      ListNode head = new ListNode();
      ListNode curr = head;
      while(!minHeap.isEmpty()){
         curr.next = minHeap.poll();
         if(curr.next.next != null){
            minHeap.offer(curr.next.next);
         }
         curr = curr.next;
      }
      curr.next = null;
      return head.next;
   }
}

// Heap solution: 
// TC: nlog(k) because k is constantly matching the list size
    // TC would be nlog(n) if all elements are added to minHeap at once
// SC: 

// creating min heap is O(k * log(k)), where 'k' is the number of linked lists 
    // insertion operation into the min-heap has a time complexity of O(log(k))
    // the number of times we're doing insertion operation is k times
    // extraction is O(log(k)) because once we remove the minimum (root), we have to maintain structure

// total number of nodes in all lists is 'n', and in the worst case, each node is added to and removed from the min-heap once
    // this step has a time complexity of O(n * log(k))

// overall time complexity is dominated by the merging step, which is O(n * log(k))
    // where 'n' is the total number of nodes across all linked lists, and 'k' is the number of linked lists

// insertion and extraction of nodes from the min-heap each have a time complexity of O(log(k))
    // Since these operations are done for each of the 'n' nodes, the total time complexity becomes O(n * log(k))