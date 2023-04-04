/*
Given the head of a singly linked list, return true if it is a 
palindrome
 or false otherwise.
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
   public boolean isPalindrome(ListNode head) {
       /*
       Find Middle.
       Reverse Elements after that.
       Compare first with middle, then keep going
       */

       // base case, if size == 0 or 1
       if(head==null || head.next==null){
           return true;
       }

       // Find middle
       ListNode slow = head;
       ListNode fast = head;
       // this will point to the LATTER HALF of the linked list
       while(fast.next!=null && fast.next.next!=null){
           slow = slow.next;
           fast = fast.next.next;
       }

       // Reverse Elements in this half
       ListNode reversed = reverseLL(slow.next);
       ListNode current = head;
       while(reversed != null){
           if(current.val != reversed.val){
               return false;
           }
           reversed = reversed.next;
           current = current.next;
       }
       return true;
   }

   public ListNode reverseLL(ListNode head){
       ListNode curr = head;
       ListNode prev = null;

       while(curr!=null){
           ListNode next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       return prev;
   }
}


