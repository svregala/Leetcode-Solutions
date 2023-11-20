/* 
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.
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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        // base case
        if(root==null){
            return 0;
        }

        dfs(root);
        return max;
    }

    private int dfs(TreeNode node){
        // height is 0
        if(node==null){
            return 0;
        }

        int l = dfs(node.left);
        int r = dfs(node.right);

        // update max by taking the max diameter that passes through current node
        max = Math.max(max, l+r);
        return Math.max(l,r) + 1;
        // return max depth of current node by adding 1 to max depth of deepest subtree
    }
}

// TC: O(n), with n==num nodes -- iterating through all nodes once
// SC: O(h), with h==height of binary tree

// recursively go down the left subtree, then the right subtree
    // update max to max of current max and left+right
    // return max of l and r plus 1