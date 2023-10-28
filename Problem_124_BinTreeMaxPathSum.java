/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. 
A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.
Given the root of a binary tree, return the maximum path sum of any non-empty path.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   int res = 0;

   public int maxPathSum(TreeNode root) {
      if(root==null){
         return 0;
      }else if(root.left==null && root.right==null){
         return root.val;
      }

      res = root.val;
      dfs(root);
      return res;
   }

   // return max path sum without sleeping
   private int dfs(TreeNode node){
      if(node==null){
         return 0;
      }

      int leftMax = dfs(node.left);
      int rightMax = dfs(node.right);
      
      // since leftMax or rightMax could be negative, so update
      leftMax = Math.max(leftMax, 0);
      rightMax = Math.max(rightMax, 0);

      // compute max path sum WITH split from node
      res = Math.max(res, node.val+leftMax+rightMax);

      return Math.max(leftMax, rightMax) + node.val;
   }
}
// TC: O(n), visiting each node once
// SC: O(h), height of tree

// if we're starting at a node, we could only split once
    // e.g. [10,9,20,null,null,15,7], we split up the root node, CANNOT split at 20
    //      10
    //    9    20
    //       15  7
    // whenever we split from a node, we CANNOT get any of its parents
        // say we split at 20, the path would be 15+20+7 and nothing more
// brute force approach
    // for every single node, consider it being the top most node
        // then, from the left subtree --> determine what's the maximum path we could create in the left subtree if we never split
            // not split as in not including the right subtree
        // Similarly, for the right subtree
    // doing this recursively will eliminate repeated work

// DFS: O(n), it depends on the return value of recursive function
    // consider [1,2,3,null,null,4,5]
    //              1
    //          2       3
    //              4       5
    
    // start at root --> now go left, we want to know the maximum path we can get from the left subtree if we never end up splitting
    // then visit the right subtree
    // we CANNOT go above a node that we SPLIT (reason: a node can only appear in the sequence at most once)

    // at each node, think about what's the max at each node -->
        // at node 2, max sum is 2
        // at node 4, max sum is 4
        // at node 5, max sum is 5
        // at node 3, an option for the final result could be 4+3+5=12
            // but if we're not to consider this option and consider node 1 to be in the result, then max sum would be 8 (5+3)
        // at node 1 (where we use split in result), an option for final result could be 5+3+1+2 = 11
    // now say, it was -4 and -5, we wouldn't want to include this in our result because the sum is decreased if we include these
        // so we return max(-4, -5, 0)
