/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:
- The left subtree of a node contains only nodes with keys less than the node's key.
- The right subtree of a node contains only nodes with keys greater than the node's key.
- Both the left and right subtrees must also be binary search trees.
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
   public boolean isValidBST(TreeNode root) {
      return dfs_help(root, Long.MIN_VALUE, Long.MAX_VALUE);
   }

   private boolean dfs_help(TreeNode node, long l_bound, long u_bound){
      if(node==null){
         return true;
      }
      if(node.val <= l_bound || node.val >= u_bound){
         return false;
      }
      return dfs_help(node.left, l_bound, node.val) && dfs_help(node.right, node.val, u_bound);
   }
}

//      5
//   3     7
//       4   8

// Option 1: inorder traversal, add everything to a list, then see if that list is sorted O(2n)~O(n), SC: O(n)
// Option 2: recursively calling helper on left and right child with changing bounds
    // start with root, and check if it is between negative and positive infinity as bounds --> true
    // then, check left child of 5 and see if it lies between min=-inf and max=5 --> true
    // then, check right child, node 7, if it's between min=5, max=inf --> true
    // then, check left child of 7, node 4, if it's between min=5, max=7 --> false
    // then, check right child of 7, node 8, if it's between min=7, max=inf 

    // TC: O(n) since we visit each node once
    // SC: O(h) with h as the maximum height of the DFS call

/* OPTION 1
class Solution {
    List<Integer> arr = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        dfs_inorder(root);
        for(int i=0; i<arr.size()-1; i++){
            if(arr.get(i) >= arr.get(i+1)){
                return false;
            }
        }

        return true;
    }

    private void dfs_inorder(TreeNode node){
        if(node==null){
            return;
        }
        dfs_inorder(node.left);
        arr.add(node.val);
        dfs_inorder(node.right);
    }
}
*/