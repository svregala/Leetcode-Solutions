/*
Given a string s, find the length of the longest substring without repeating characters.
*/

// SLIDING WINDOW APPROACH TO REDUCE RUNTIME
// AFTER REFINING ORIGINAL SOLUTION
class Solution{
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
}
// BEFORE REFINING ORIGINAL SOLUTION ---
/*class Solution {
   public int lengthOfLongestSubstring(String s) {
       
       if(s.length() == 0){
           return 0;
       }

       int max=0;
       HashSet<Character> set = new HashSet<>();

       // expected worst case is n*(n/2)
       // outerloop for declaring starting point for each inner loop iteration
       for(int i=0; i<s.length(); i++){

           if(max>s.length()/2 && i>s.length()/2){
               return max;
           }

           // variable for keeping a temporary count
           int curr_max = 0;
           // clear HashSet before each inner loop iteration
           set.clear();
           for(int j=i; j<s.length(); j++){
               if(!set.contains(s.charAt(j))){
                   curr_max++;
                   set.add(s.charAt(j));
               }else{
                   break;
               }

               if(curr_max>max){
                   max=curr_max;
               }
           }
       }

       return max;
   }
}*/