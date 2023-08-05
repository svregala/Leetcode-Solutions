/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
 
Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // if strs only had 1 element
        if(strs.length == 1){
            return strs[0];
        }

        String res = "";
        // sort in alphabetical/lexicographical order -- explain why
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];

        // minimum to prevent errors
        for(int i=0; i<Math.min(first.length(), last.length()); i++){
            if(first.charAt(i) != last.charAt(i)){
                return res;
            }
            res += first.charAt(i);
        }

        return res;
    }
}
