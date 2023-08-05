/* 
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
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
   boolean retVal = true;
   public boolean isSymmetric(TreeNode root) {
       if(root.right==null && root.left==null){
           return true;
       }
       compare(root.left, root.right);
       return retVal;
   }
   
   private void compare(TreeNode one, TreeNode two){
       if(one==null && two==null){
           return;
       }
       if(one==null || two==null){
           retVal = false;
           return;
       }
       if(one.val != two.val){
           retVal = false;
           return;
       }
       
       compare(one.left, two.right);
       compare(one.right, two.left);
   }
}