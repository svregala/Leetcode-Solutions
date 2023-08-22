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
        List<Integer> result = new ArrayList<>();
        inorderTravHelper(root,result);
        return result;
    }

    private void inorderTravHelper(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }

        inorderTravHelper(node.left, list);
        list.add(node.val);
        inorderTravHelper(node.right,list);
    }
}