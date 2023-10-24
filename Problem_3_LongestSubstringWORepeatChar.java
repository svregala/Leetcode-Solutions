/*
Given a string s, find the length of the longest substring without repeating characters.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // base case
        if(s.length()==0 || s.length()==1){
            return s.length();
        }

        Set<Character> set = new HashSet<>();
        int res=0;
        int l=0;
        
        for(int r=0; r<s.length(); r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res = Math.max(res, r-l+1);
        }

        return res;
    }
}

// SLIDING WINDOW
    // once we reach a duplicate, take it out of set until we no longer have duplicates --> we are shrinking the window
// TC: O(n) -- go through entire list, n==length of string
// SC: O(n) -- string has unique letters


// BEFORE REFINING ORIGINAL SOLUTION ---
/*class Solution{
   public int lengthOfLongestSubstring(String s){
       HashSet<Character> set = new HashSet<>();
       int max = 0;
       int left = 0;

       for(int right=0; right<s.length(); right++){
           if(!set.contains(s.charAt(right))){
            set.add(s.charAt(right));
            max = Math.max(max, right-left+1); // update max by taking max of current max or current gap between left and right
           }else{
            while(s.charAt(left) != s.charAt(right)){ // need this while loop and condition because of cases like "dvdf"
                set.remove(s.charAt(left));
                left++;
            }
            //set.remove(s.charAt(left));
            left++;
            set.add(s.charAt(right));
           }
       }

       return max;
   }
}*/