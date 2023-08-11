/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
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
   public ListNode deleteDuplicates(ListNode head) {
      // Base case
      if(head==null || head.next==null){
         return head;
      }
      
      /*Set<Integer> in = new HashSet<>();

      ListNode prev = head;
      in.add(prev.val);
      ListNode curr = head.next;
      while(curr!=null){
         if(!in.contains(curr.val)){
               in.add(curr.val);
               prev = curr;
               curr = curr.next;
         }else{
               prev.next = curr.next;
               //curr.next = null;
               curr = prev.next;
         }
      }*/

      ListNode curr=head;
      while(curr!=null && curr.next!=null){
         if(curr.val == curr.next.val){
               curr.next = curr.next.next; // make curr.next point to the next one over
               continue;   // go to the next iteration
         }
         curr = curr.next;
      }

      return head;
   }
}