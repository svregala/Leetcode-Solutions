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
    int max = 0;
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root, 0);
        return max;
    }

    private void dfs(TreeNode node, int count){
        if(node==null){
            return;
        }
        count++;
        max = Math.max(max, count);

        dfs(node.left, count);
        dfs(node.right, count);
    }
}
// TC: O(n), n==num nodes
// SC: O(h), height of binary tree
    // worst case, max number of function calls that will be stored on the call stack is equal to the height of the tree