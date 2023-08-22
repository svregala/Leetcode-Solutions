/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
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
    // Global variable that will change constantly
    boolean res = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        sameTreeHelper(p, q);
        return res;
    }

    // helper function (recursion) to assign a value to res
    private void sameTreeHelper(TreeNode a, TreeNode b){
        if(a==null && b==null){
            return;
        }
        else if(a==null && b!=null){
            res=false;
            return;
        }
        else if(a!=null && b==null){
            res=false;
            return;
        }
        // a and b are NOT null
        else{
            if(a.val != b.val){
                res=false;
            }
        }

        sameTreeHelper(a.left, b.left);
        sameTreeHelper(a.right, b.right);
    }
}