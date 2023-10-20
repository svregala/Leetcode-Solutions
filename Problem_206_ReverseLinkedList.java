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
        // base case
        if(head==null){
            return null;
        }else if(head.next==null){
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode fut = head.next.next;
        head.next = null;

        while(curr != null){
            // curr reached last element
            if(fut == null){
                curr.next = prev;
                prev = curr;
                curr = fut;

                return prev;
            }

            curr.next = prev;
            prev = curr;
            curr = fut;
            fut = fut.next;
        }

        return head;
    }
}