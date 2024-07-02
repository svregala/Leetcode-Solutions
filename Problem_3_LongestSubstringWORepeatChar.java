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


/*class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2){
            return s.length();
        }

        int res=0;
        int l=0;
        int r=1;
        Set<Character> charSet = new HashSet<>();
        charSet.add(s.charAt(l));
        
        while(r<s.length()){
            while(l<r && charSet.contains(s.charAt(r))){
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            r++;
            
            res = Math.max(res, r-l);
        }

        return res;
    }
}*/

/*
TC: O(n), iterate through whole list
SC: O(n), set data structure will have n elements if String has unique letters
*/