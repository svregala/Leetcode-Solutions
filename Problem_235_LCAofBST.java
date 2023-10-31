/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      TreeNode curr = root;

      while(curr!=null){
         if(curr.val < p.val && curr.val < q.val){
            curr = curr.right;
         }
         else if(curr.val > p.val && curr.val > q.val){
            curr = curr.left;
         }
         else if(curr.val==p.val || curr.val==q.val){
            return curr;
         }
         else if(curr.val>=p.val && curr.val<=q.val || curr.val<=p.val && curr.val>=q.val){
            return curr;
         }
      }

      return root;
   }
}

// TC: O(logn) because we don't visit every single node -- rather we only visit 1 node for every single level of the tree
    // so the TC is usually the height of the tree
// SC: O(1) because no need for data structures

// where the split happens between the nodes p and q where they're going in different subtrees is the LCA
// if we reach the node itself, the LCA is then that node because...
    // if we reach the node itself, nothing in the left subtree or the right subtree will be an ancestor of itself
// last 2 conditionals are seeing if the split happens there