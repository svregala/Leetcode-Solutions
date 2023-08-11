/*
Given two binary strings a and b, return their sum as a binary string.
*/

class Solution {
    public String addBinary(String a, String b) {

        StringBuilder res = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while(i>=0 || j>=0){
            int sum = carry;

            // Subtract by '0' to convert the numbers from a char type into an int, so we can perform operations on the numbers
            if(i>=0){
                sum += a.charAt(i) - '0';
                i--;
            }
            if(j>=0){
                sum += b.charAt(j) - '0';
                j--;
            }
            // if sum is 0, res is 1 --> carry is 0
            // if sum is 1, res is 1 --> carry is 0
            // if sum is 2, res is 0 --> carry is 1
            // if sum is 3, res is 1 --> carry is 1
            if(sum>1){
                carry=1;
            }else{
                carry=0;
            }
            // moduling the sum so, we can get remainder and add it into our result
            res.append(sum%2);
        }

        if(carry != 0){
            res.append(carry);
        }
        // reverse string at the end
        return res.reverse().toString();
    }
}