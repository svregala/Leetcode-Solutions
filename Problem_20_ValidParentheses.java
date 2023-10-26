/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every close bracket has a corresponding open bracket of the same type.
*/

class Solution {
    public boolean isValid(String s) {
        // base case
        if(s.length()==0){
            return true;
        }else if(s.length()==1){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(char e : s.toCharArray()){
            if(e=='(' || e=='{' || e=='['){
                stack.push(e);
            }
            else if(stack.empty()){
                return false;
            }

            if(e==')' && stack.peek()!='('){
                return false;
            }
            else if(e=='}' && stack.peek()!='{'){
                return false;
            }
            else if(e==']' && stack.peek()!='['){
                return false;
            }
            
            if(e==')' && stack.peek()=='('){
                stack.pop();
            }
            else if(e=='}' && stack.peek()=='{'){
                stack.pop();
            }
            else if(e==']' && stack.peek()=='['){
                stack.pop();
            }
        }

        if(stack.empty()){
            return true;
        }
        return false;
    }
}