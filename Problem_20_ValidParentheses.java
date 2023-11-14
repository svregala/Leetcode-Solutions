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
        if(s.length()<2){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }
            else{
                if(stack.empty()){
                    return false;
                }

                if(c==')' && stack.peek()=='('){
                    stack.pop();
                }
                else if(c==']' && stack.peek()=='['){
                    stack.pop();
                }
                else if(c=='}' && stack.peek()=='{'){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }

        if(!stack.empty()){
            return false;
        }
        return true;
    }
}

// TC: O(n), n is string size, iterating through whole string once
// SC: o(n), n is string size, worst case is if string is only composed of '(', '[', and/or '{'