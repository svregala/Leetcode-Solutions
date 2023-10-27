/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 */

public class Solution {
   /*
   * @param strs: a list of strings
   * @return: encodes a list of strings to a single string.
   */
   public String encode(List<String> strs) {
      String res = "";
      for(String s : strs){
         String pre = String.valueOf(s.length()) + "#";
         res += pre+s;
      }
      return res;
   }

   /*
   * @param str: A string
   * @return: decodes a single string to a list of strings
   */
   public List<String> decode(String str) {
      List<String> res = new ArrayList<>();
        
      int i = 0;
      while(i<str.length()){
         // find the delimiter, AKA end of integer
         int j = i;
         while(str.charAt(j) != '#'){
            j++;
         }
         int length = Integer.parseInt(str.substring(i, j));
         res.add(str.substring(j+1, length+j+1));

         i = length + j + 1;
      }

      return res;
   }
}
// Encoder Decoder
   // challenge: how to come up with a delimiter to indicate where a word starts and ends
   // have some sort of character to separate words
   // store number and then a delimiter sign --> number represents length of word

   // process the string, and find the delimiter sign aka end of integer so we can account for cases like 2, 45, 321 characters long
   // length variable on line 33 tells us how many following characters we have to read after j to get every character
   // each iteration of the loop will read one entire word
   // reassign i to length+j+1


// Encoder and Decoder are both O(n)