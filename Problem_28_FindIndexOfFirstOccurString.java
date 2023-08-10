/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

class Solution {
    public int strStr(String haystack, String needle) {

        if(haystack.length()==needle.length()){
            if(haystack.equals(needle)){
                return 0;
            }
            return -1;
        }

        for(int i=0; i<haystack.length()-needle.length()+1; i++){
            int curr_size = 0;
            int temp_i = i;
            int ret_i = i;
            for(int j=0; j<needle.length(); j++){
                if(needle.charAt(j) != haystack.charAt(temp_i)){
                    break;
                }
                curr_size++;
                temp_i++;
                if(curr_size == needle.length()){
                    return ret_i;
                }
            }
        }

        return -1;
    }
}