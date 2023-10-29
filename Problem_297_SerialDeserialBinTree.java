/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String res = "";    // for ENCOODER
    int i = 0;       // for DECODER
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      if(root==null){
         return "";
      }
      dfs_encode(root);
      return res.substring(0, res.length()-1);
   }

    private void dfs_encode(TreeNode node){
      if(node==null){
         res += "N,";
         return;
      }

      res += Integer.toString(node.val)+",";
      dfs_encode(node.left);
      dfs_encode(node.right);
   }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if(data.length()==0){
         return null;
      }

      String[] arr = data.split(",");
      return dfs_decode(arr);
   }

    private TreeNode dfs_decode(String[] a){
      if(a[i].equals("N")){
         i++;
         return null;
      }
      
      TreeNode node = new TreeNode(Integer.parseInt(a[i]));
      i++;

      node.left = dfs_decode(a);
      node.right = dfs_decode(a);

      return node;
   }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

// TC: O(n), both encoder and decoder visit each node once
// SC: O(n), for both encoder and decoder
// 2 global variables, one for encoder and another for decoder
    // left=0 for decoder because that'll be our left pointer, initialized to 0 to indicate we start at the first element of string

// possible options: DFS or BFS
// DFS: pre order traversal --> visit root, then left, then right
    // pre order traversal for the following: 1, 2, n, n, 3, 4, n, n, 5, n, n OR 1,2,3,4,5
    //              1
    //          2       3
    //        n   n   4    5
    //              n  n  n  n
// start at root node, then recursively do left subtree in preorder traversal, then recursively do right subtree in preorder traversal
    // String returned from encoder: can use comma or space for delimiter:
        // note: must include null in String so when we decode it, we know where to add the nodes
    // "1,2,N,N,3,4,N,N,5,N,N"

    // given the string we created, how do we know to stop building the left subtree and start building the right subtree
        // when we reach a null, that's when we know to stop
        // when BOTH the left and right child are NULL, then that's when we know to stop creating the subtree
        // for each leaf node we have, we specified that their left and right child are NULL