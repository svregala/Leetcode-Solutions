/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
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
   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       
       if(list1==null && list2==null){
           return list1;
       }
       else if(list1!=null && list2==null){
           return list1;
       }
       else if(list1==null && list2!=null){
           return list2;
       }
       
       ListNode result;
       if(list1.val <= list2.val){
           result = list1;
           list1 = list1.next;
       }else{
           result = list2;
           list2 = list2.next;
       }
       ListNode curr = result;
       
       while(list1 != null || list2 != null){
           if(list1 != null && list2 != null){
               if(list1.val <= list2.val){
                   curr.next = list1;
                   curr = curr.next;
                   list1 = list1.next;
               }else{
                   curr.next = list2;
                   curr = curr.next;
                   list2 = list2.next;
               }
           }else if(list1 != null && list2 == null){
               curr.next = list1;
               return result;
           }else if(list1 == null && list2 != null){
               curr.next = list2;
               return result;
           }
       }
       
       return result;
   }
}