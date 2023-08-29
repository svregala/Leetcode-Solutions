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
    // global variable -- turn it true if the following is met:
    // if we reached a leaf node && if targetSum is met
    boolean path = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case
        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                return true;
            }
        }

        if(root.left == null || root.right == null){
            if(targetSum == root.val){
                return false;
            }
        }

        helper(root.left, targetSum, root.val);
        helper(root.right, targetSum, root.val);

        return path;
    }

    private void helper(TreeNode node, int target, int current){
        if(node == null){
            return;
        }

        current+=node.val;
        if(node.left == null && node.right == null){
            if(current == target){
                path = true;
            }
            return;
        }

        // visit the left subtree/node
        helper(node.left, target, current);

        // visit the right subtree/node
        helper(node.right, target, current);
    }
}