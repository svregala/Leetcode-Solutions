/* 
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
If the two linked lists have no intersection at all, return null.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode one = headA;
       ListNode two = headB;
       
       while(one != two){
           one = one!=null ? one.next : headB;
           two = two!=null ? two.next : headA;
       }
       return one;
   }
}