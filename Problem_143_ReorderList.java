/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
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
   public void reorderList(ListNode head) {
      // base case
      if(head==null || head.next==null || head.next.next==null){
         return;
      }

      // find middle point of list
      ListNode slow = head;
      ListNode fast = head;

      // continue as long as fast is non-null and fast has NOT reached the end of list
      while(fast!=null && fast.next!=null){
         slow = slow.next;
         fast = fast.next.next;
      }

      // at this point, we have the beginning of the second half of the list aka slow.next
      ListNode second = slow.next;
      slow.next = null; // splitting list into 2 different lists, then reverse second half of list
      ListNode prev = null;
      
      // reverse second half of list
      while(second!=null){
         ListNode temp = second.next;
         second.next = prev;
         prev = second;
         second = temp;
      }

      // merge 2 halves of list
      ListNode first = head;
      second = prev;
      // keep going until 1 of pointers are null
      while(second != null){
         ListNode temp1 = first.next;
         ListNode temp2 = second.next;

         first.next = second;
         second.next = temp1;
         
         first = temp1;
         second = temp2;
      }
   }
}
