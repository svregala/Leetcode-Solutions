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
        if(head==null || head.next==null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            head = head.next;
            curr.next = prev;
            prev = curr;
            curr = head;
        }

        return prev;
    }
}

// Iterative Solution:
    // TC: O(n) with n==num nodes
    // SC: O(1) constant space

// Recursive Solution:
    // TC: O(n) with n==num nodes
    // SC: O(s) with s==number of times recursive call happens, worst case is size of list so O(n)
/*
public ListNode reverseList(ListNode head) {
    // base case
    if(head==null || head.next==null){
        return head;
    }
    return revHelper(head, null);
}

private ListNode revHelper(ListNode node, ListNode prev){
    if(node==null){
        return prev;
    }
    ListNode temp = node.next;
    node.next = prev;
    return revHelper(temp, node);
}
*/