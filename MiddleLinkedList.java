/*
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.
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
   public ListNode middleNode(ListNode head) {

       if(head==null || head.next==null){
           return head;
       }

       int count=0;
       ListNode curr = head;
       while(curr!=null){
           count++;
           curr = curr.next;
       }

       int middle = count/2; // 2, 3
       curr = head;
       count=0;
       while(count<middle){
           count++;
           curr = curr.next;
       }

       return curr;
   }
}