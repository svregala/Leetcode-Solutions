/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.
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
   public List<Integer> inorderTraversal(TreeNode root) {
       ArrayList<Integer> result = new ArrayList<>();
       Inorder(root, result);
       return result;
   }
   
   private void Inorder(TreeNode node, ArrayList<Integer> array){
       if(node == null){
           return;
       }
       Inorder(node.left, array);
       array.add(node.val);
       Inorder(node.right, array);
   }
}