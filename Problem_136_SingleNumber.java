/* 
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
*/

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;    //since XOR with 0 returns same number 
        for (int i = 0; i < nums.length; i++){
            ans ^= nums[i];    // ans = (ans) XOR (array element at i) 
        }
        return ans;
    }
}

/*
- sort first, then compare each element with previous element --> TC: O(nlogn), SC: O(1)
- hashmap with frequency count --> TC: O(n), SC: O(n)
- XOR --> TC: O(n), SC: O(1)
    - We can use xor operation as it cancel out itself 
        - (i.e. only when values are different in binary representation then give output)

Using Bit Manipulation -

(1) As we know XOR operation with 0 gives the same number
    i.e, a XOR 0 = a
    eg, for decimal no. 2=> 2 XOR 0 = 2
    in binary, 010 XOR 000 = 010

(2) Also we know that , XOR operation with same number gives 0
    i.e, a XOR a = 0
    eg, 2 XOR 2 = 0
    in binary, 010 XOR 010 = 000

(3) XOR is associative (like sum)
    i.e, (2 XOR 3) XOR 4 = 2 XOR (3 XOR 4), So the order doesn't matter in performing XOR operation.
    eg, 2^3^4^6 = 3^2^6^4 = 4^2^6^3 ......

So, using these three properties of XOR , we will solve the question. 
we will take ans variable with 0 as initial value. 
And then for each element i in array, we will perform the XOR operation of the element with 0, 
    ans will become 0 if the same number is found (as a XOR a = 0) and so after the completion of the loop, 
    only element with no duplicate number will remain and will be returned as ans.

*/