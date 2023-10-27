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
        // base case
        if(root==null){
            return 0;
        }

        int count = 0;
        helper(root, count);
        return max;
    }

    private void helper(TreeNode node, int c){
        if(node==null){
            return;
        }

        c++;
        max = Math.max(c, max);
        helper(node.left, c);
        helper(node.right, c);
    }
}

// recursive DFS: TC = O(n), SC: O(1)