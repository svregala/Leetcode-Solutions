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
        if(root==null){
            return root;
        }
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node){
        if(node==null){
            return;
        }

        TreeNode swap = node.left;
        node.left = node.right;
        node.right = swap;

        dfs(node.left);
        dfs(node.right);
    }
}
// TC: O(n), n==num nodes, iterating through all nodes
// SC: O(h), where h is the height of the binary tree
    // function uses dfs approach to traverse the binary tree recursively. 
    // worst case, max number of function calls that will be stored on the call stack is equal to the height of the tree