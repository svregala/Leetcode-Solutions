/*
Given the root of a binary tree, invert the tree, and return its root.
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
   public TreeNode invertTree(TreeNode root) {
       helper(root);
       return root;
   }
   public void helper(TreeNode root){
       if(root == null){
           return;
       }
       TreeNode holder = root.left;
       root.left = root.right;
       root.right = holder;
       helper(root.left);
       helper(root.right);
       return;
   }

}