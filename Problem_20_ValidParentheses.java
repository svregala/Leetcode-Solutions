/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every close bracket has a corresponding open bracket of the same type.
*/

import java.util.Stack;

class Solution {
   public boolean isValid(String s) {
       if(s.length()==1){
           return false;
       }
       
       Stack<Character> stack = new Stack<>();
       for(int i=0; i<s.length(); i++){
           if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
               stack.push(s.charAt(i));
           }
           else if(s.charAt(i) == ')'){
               if(stack.empty()){
                   return false;
               }
               if(stack.peek() != '('){
                   return false;
               }
               stack.pop();
           }
           else if(s.charAt(i) == '}'){
               if(stack.empty()){
                   return false;
               }
               if(stack.peek() != '{'){
                   return false;
               }
               stack.pop();
           }
           else{
               if(stack.empty()){
                   return false;
               }
               if(stack.peek() != '['){
                   return false;
               }
               stack.pop();
           }
       }
       if(stack.empty()){
           return true;
       }
       return false;
   }
}