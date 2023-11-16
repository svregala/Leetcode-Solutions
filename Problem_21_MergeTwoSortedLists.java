/* 
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
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
        // base case
        if(list1==null){
            return list2;
        }
        else if(list2==null){
            return list1;
        }

        // assign head of merged list
        ListNode head = null;
        if(list1.val<=list2.val){
            head = list1;
            list1 = list1.next;
        }else{
            head = list2;
            list2 = list2.next;
        }

        ListNode curr = head;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            }else{
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
        }

        // attach last elements
        if(list1==null){
            curr.next = list2;
        }else{
            curr.next = list1;
        }

        return head;
    }
}
// TC: O(n) with n = total nodes in both list1 and list 2, 
    // worst case is iterating through each node in both list1 and list 2
// SC: O(1) because created only 2 extra listnodes