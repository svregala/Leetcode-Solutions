/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
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

// --- AFTER REFINING SOLUTION ---
class Solution{
   public ListNode addTwoNumbers(ListNode l1, ListNode l2){
       ListNode res = new ListNode();
       ListNode curr = res;
       int first_digit = 0;
       int second_digit = 0;
       int sum_val = 0;

       while(l1!=null || l2!=null || first_digit == 1){
           sum_val = first_digit;
           
           if(l1!=null){
               sum_val+=l1.val;
               l1 = l1.next;
           }

           if(l2!=null){
               sum_val+=l2.val;
               l2 = l2.next;
           }
           
           first_digit = sum_val/10; // num/10 --> first digit
           second_digit = sum_val%10; // num%10 --> second digit

           ListNode node = new ListNode(second_digit);

           curr.next = node;
           curr = curr.next;
       }

       return res.next; // return res.next because we do curr.next = node which assigns res.next to a node on the first iteration
   }
}

/* --- BEFORE REFINING SOLUTION ---
class Solution {
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

       ListNode res = new ListNode();
       ListNode curr = new ListNode();
       ListNode ptr_1 = l1;
       ListNode ptr_2 = l2;
       int count = 0;
       int first_digit = 0;

       while(ptr_1!=null || ptr_2!=null){
           int sum_val = 0;
           // Case 1: there are still node values to be added from both lists
           if(ptr_1!=null && ptr_2!=null){
               sum_val = ptr_1.val + ptr_2.val + first_digit;
               String str = String.valueOf(sum_val);

               // sum is > 9
               if(str.length() > 1){
                   first_digit = Integer.parseInt(str)/10; // num/10 --> first digit
                   int second_digit = Integer.parseInt(str)%10; // num%10 --> second digit
                   ListNode first_node = new ListNode(second_digit);
                   if(count==0){
                       res = first_node;
                       curr = first_node;
                   }else{
                       curr.next = first_node;
                       curr = curr.next;
                   }
               }
               // sum is < 10
               else{
                   ListNode node = new ListNode(sum_val);
                   if(count==0){
                       res = node;
                       curr = node;
                   }else{
                       curr.next = node;
                       curr = curr.next;
                   }
                   first_digit = 0;  // reassign to 0 because for this iteration, the sum was < 10, essential for absolute last part
               }

               count++;
           }
           
           // Case 2: Either l1 or l2 don't have anymore things to add, 
           //in which case just iterate through remaining list and add those
           else{
               ListNode node = new ListNode();
               if(ptr_1!=null){
                   sum_val = ptr_1.val + first_digit;
                   String str = String.valueOf(sum_val);

                   if(str.length() > 1){
                       first_digit = Integer.parseInt(str)/10; // num/10 --> first digit
                       int second_digit = Integer.parseInt(str)%10; // num%10 --> second digit
                       node = new ListNode(second_digit);
                       
                   }else{
                       node = new ListNode(sum_val);
                       first_digit = 0;  // reassign to 0 because for this iteration, the sum was < 10, essential for absolute last part
                   }
                   curr.next = node;
                   curr = curr.next;
               }
               else if(ptr_2!=null){
                   sum_val = ptr_2.val + first_digit;
                   String str = String.valueOf(sum_val);

                   if(str.length() > 1){
                       first_digit = Integer.parseInt(str)/10; // num/10 --> first digit
                       int second_digit = Integer.parseInt(str)%10; // num%10 --> second digit
                       node = new ListNode(second_digit);
                   }else{
                       node = new ListNode(sum_val);
                       first_digit = 0;  // reassign to 0 because for this iteration, the sum was < 10, essential for absolute last part
                   }
                   curr.next = node;
                   curr = curr.next;
               }
           }

           if(ptr_1!=null){
               ptr_1 = ptr_1.next;
           }
           if(ptr_2!=null){
               ptr_2 = ptr_2.next;
           }
       }

       // handle the case for when there exists 2 digits for the absolute LAST sum
       if(first_digit>0){
           ListNode last_node = new ListNode(first_digit);
           curr.next = last_node;
       }
       
       return res;
   }
}
*/