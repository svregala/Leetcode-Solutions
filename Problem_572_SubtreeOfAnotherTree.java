/*
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
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
   public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if(subRoot==null){
         return true;
      }
      else if(root==null){
         return false;
      }
      else if(isSameTree(root, subRoot)){
         return true;
      }

      return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
   }

   private boolean isSameTree(TreeNode orig, TreeNode sub){
      if(orig==null && sub==null){
         return true;
      }
      else if(orig==null && sub!=null || orig!=null && sub==null){
         return false;
      }
      else if(orig.val != sub.val){
         return false;
      }
      return isSameTree(orig.left, sub.left) && isSameTree(orig.right, sub.right);
   }
}

// TC: O(r*s), with r==size of root tree and s==size of subRoot tree
    // worse case scenario: for each node in root tree, we are checking if it's the same tree (same tree iterates through at most s times)
// SC: O(h), with h as maximum depth of the DFS, it costs O(h) to maintain the system stack
// subTree function:
    // if subRoot is null, then it's a subtree of root regardless if root is null or non-null
    // if root is null, and subRoot is non-null, then return false because subRoot cannot be a subtree of a null root
        // order of the above 2 points matters --> explain why
    // return true if isSameTree(root, subRoot) is true
    // otherwise, recursively call isSubtree(root.left, subRoot) and isSubtree(root.right, subRoot), return or results