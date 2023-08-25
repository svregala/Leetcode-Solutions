/*
Given a binary tree, determine if it is height-balanced.
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
    public boolean isBalanced(TreeNode root) {
        // Base case, if roots is empty or if it's only 1 element
        if(root == null || (root.left==null && root.right == null)){
            return true;
        }

        // return -1 when tree is unbalanced
        if(helper(root)==-1){
            return false;
        }

        return true;
    }

    private int helper(TreeNode node){
        // base case -- return 0 if node is null (height of null node with previous node is 0)
        if(node == null){
            return 0;
        }

        // calculate height of left subtree
        int left_height = helper(node.left);
        // calculate height of right subtree
        int right_height = helper(node.right);

        // return -1 if left subtree or right subtree is unbalanced
        if(left_height==-1 || right_height==-1){
            return -1;
        }

        // return -1 if subtree height difference is more than 1, hence unbalanced
        if(Math.abs(left_height-right_height) > 1){
            return -1;
        }

        // return height of subtree with max of left_height, right_height + 1
        return Math.max(left_height,right_height)+1;
    }
}