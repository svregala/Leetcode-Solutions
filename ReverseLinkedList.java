/* 
Given the head of a singly linked list, reverse the list, and return the reversed list.
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
   public ListNode reverseList(ListNode head) {
       if(head==null){
           return null;
       }
       if(head.next==null){
           return head;
       }
       
       ListNode prev = head;
       ListNode curr = head;
       ListNode temp = head.next;
       // take care of first element
       curr.next = null;
       curr = temp;
       temp = temp.next;
       curr.next = prev;
       
       while(temp!=null){
           prev = curr;
           curr = temp;
           temp = temp.next;
           curr.next = prev;
       }
       
       return curr;
   }
}