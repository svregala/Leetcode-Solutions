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
        else if(root.left==null && root.right==null){
            return 1;
        }

        maxDepthHelper(root, 0);
        return max;
    }

    private void maxDepthHelper(TreeNode a, int temp_count){
        if(a==null){
            return;
        }

        temp_count++;
        if(temp_count > max){
            max = temp_count;
        }
        
        maxDepthHelper(a.left, Math.max(temp_count, 1));
        maxDepthHelper(a.right, Math.max(temp_count, 1));
    }
}