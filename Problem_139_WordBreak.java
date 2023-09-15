/* 
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.
*/


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

      // top down approach
      boolean[] dp = new boolean[s.length()+1];
      Arrays.fill(dp, false);
      dp[0] = true;

      // iterate string and see if we find any words from wordDict inside our string
      for(int i=1; i<=s.length(); i++){
         for(String word : wordDict){
            // first condition: see if the string we're comparing has enough letters to compare with word
            // second condition: see if substring starting from index i-word.length up until i is equal to word
            if((i-word.length() >= 0) && (s.substring(i-word.length(), i)).equals(word)){
               dp[i] = dp[i-word.length()]; 
            }

            if(dp[i]){
               break; // reached a match
            }
         }
      }

      return dp[s.length()];

        // DP -- bottom up approach
        /*boolean[] dp = new boolean[s.length()+1];
        Arrays.fill(dp, false);
        // if we can ever get to that last index, we return true --> 
        // e.g. when we get to index i=8, we were able to match the entire string, so we know we could return true
        // base case
        dp[s.length()] = true;

        // bottom up approach, start at end of string
        // for each position i, we want to try every single word in our wordDict and see if the word matches this portion
        for(int i=s.length()-1; i>=0; i--){
            for(String w : wordDict){
                // first, starting at position i, see if string s has enough characters for w to be compared to
                // AND if s starting at index i, up until i+length of word is equal to w 
                if((i+w.length() <= s.length()) && (s.substring(i, i+w.length()).equals(w))){
                    dp[i] = dp[i+w.length()];
                }
                // if we got a single way to word break this starting at index i, we can stop the inner loop
                // we can stop at the first matching word we find
                if(dp[i]){
                    break;
                }
            }
        }

        // TC == O(n*m) --> n is length string, m is size of dictionary
        // SC == O(n)
        return dp[0];*/

        /*
        s="neetcode", wordDict = ["neet", "leet", "code"]
            - go through every index in reverse order
            - 0 1 2 3 4 5 6 7 8
              n e e t c o d e 
        dp[8] = true
        dp[7] = false because "e" does not exist in wordDict
        dp[6] = false because "de" DNE in wordDict
        dp[5] = false
        dp[4] = true because some portion of s starting at index 4 ("code") exists in wordDict
        dp[3] = false bc starting from character 't' (tco, tc, tcode, tcod, etc.), we WONT be able to match any of the words in wordDict
        dp[2] = false because we won't be able to match any of the words in wordDict if we started at index 2
        dp[1] = false
        dp[0] = true --> starting at i=0, we can match one of the words from wordDict with a portion of the string starting at i=0
        - dp[0] = dp[0 + len(w)] --> len(w) is length of the word we were able to match with ("neet" has length 4)
        - dp[0] = dp[0+4] = dp[4] = true

        Now the question becomes: 
        can we break the entire string starting at i=0 (ending where it matched) + another part of the string starting at the ending
        e.g. i=0 to i=3 "neet" exists in wordDict, then check i=4 --> we have that dp[4]=true
        */
    }
}