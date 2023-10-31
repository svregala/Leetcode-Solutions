/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
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
   List<Integer> arr = new ArrayList<>();
   public int kthSmallest(TreeNode root, int k) {
      dfs_inorder(root);
      return arr.get(k-1);
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
// TC: O(n), visiting nodes only once
// SC: O(n), sorter array

// Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

/*
When you are constructing the BST, at every node maintain a count - which is the number of nodes smaller than current node[ in other words number of nodes to the left of current node]. Also every node has a pointer which points to it parent [ this is to handle the case when a node is deleted from the BST] .

Now lets say everything is done and query comes:
Starting at root in O(1) you know if your k is the left half of right half by comparing k with the count of current node. If k is smaller than the count that means our answer lies in the left half otherwise it is in the right half. Keep repeating this until we find our node

Insert Operation:
Just do normal BST insert and ensure to increment the count of the node if you are going down left of the tree and once you find the spot to insert assign the parent to the node.

Delete operation:
Consider deleting some x node now since we have reference to the parent of every node we simply check if the node being deleted is to left or right of parent by comparing its value and if it is in the left simply decrement the count of the parent.

*/