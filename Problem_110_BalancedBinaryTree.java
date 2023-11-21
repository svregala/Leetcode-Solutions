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
    boolean bal = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return bal;
    }

    private int dfs(TreeNode node){
        if(node==null){
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if(Math.abs(left-right)>1){
            bal = false;
        }

        return Math.max(left,right) + 1;
    }
}

// TC: O(n), visiting each node at most once
// SC: O(h), h==binary tree --> max number of function calls stored on call stack is equal to height of tree
// Algorithm:
    // base case -- return 0 if node is null (height of null node with previous node is 0)
    // we then calculate the max height of the left subtree and the max height of the right subtree
    // when the height difference between left and right is more than 1, change bal to false
    // return statement is most important, return max of left and right + 1 -- the +1 increments the count