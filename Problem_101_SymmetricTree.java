/* 
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
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
    boolean res = true;
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null && root.right==null){
            return true;
        }
        isSymHelper(root.left, root.right);
        return res;
    }

    private void isSymHelper(TreeNode a, TreeNode b){
        if(a==null && b==null){
            return;
        }
        else if((a==null && b!=null) || (a!=null && b==null) || (a.val != b.val)){
            res = false;
            return;
        }

        isSymHelper(a.left, b.right);
        isSymHelper(a.right, b.left);
    }
}