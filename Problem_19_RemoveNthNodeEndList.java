/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      // base case
      if(head==null || head.next==null){
         if(n>0){
            return null;
         }

         return head;
      }

      int size = 0;
      ListNode curr = head;
      while(curr!=null){
         size++;
         curr=curr.next;
      }

      int remove = size-n+1;
      int count = 0;
      ListNode prev = head;
      curr = head;
      while(curr!=null){
         count++;
         if(count==remove){
            if(count==1){
               curr = curr.next;
               prev.next = null;
               return curr;
            }
            prev.next = curr.next;
            curr.next = null;
            return head;
         }
         if(count!=1){
            prev = curr;
         }
         curr = curr.next;
      }

      return head;
   }
}