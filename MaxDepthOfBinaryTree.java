/* 
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
   int max_count=1;
   public int maxDepth(TreeNode root) {
       if(root==null){
           return 0;
       }else if(root.left==null && root.right==null){
           return 1;
       }
       
       int temp_count = 1;
       helper(root.left, temp_count);
       helper(root.right, temp_count);
       
       return max_count; 
   }
   
   public void helper(TreeNode root, int ct){
       if(root==null){
           if(ct>max_count){
               max_count = ct;
           }
           return;
       }
       ct++;
       helper(root.left, ct);
       helper(root.right, ct);
   }
}