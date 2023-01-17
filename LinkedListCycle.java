/* 
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
   public boolean hasCycle(ListNode head) {
       if(head==null){
           return false;
       }
       
       ListNode fast = head;
       ListNode slow = head;
       
       while(fast!=null && fast.next!=null){
           
           // if there exists a cycle, fast and slow are going to eventually be equal
           // think of 2 people racing on a track where one is 2x faster than the other
           fast = fast.next.next;  
           slow = slow.next;
           
           if(fast == slow){
               return true;
           }
           
       }
       return false;
   }
}