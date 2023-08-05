/* 
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.
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
   public int diameterOfBinaryTree(TreeNode root) {
       // Create an array to hold the diameter of the tree
       // need to recursively edit the len array
       int len[] = new int[1];

       // Recursively calculate the height of the tree and update the diameter array
       diamHelper(root, len);

       // return diameter of tree
       return len[0];
   }

   public int diamHelper(TreeNode node, int[] len){
       // Base case: if the root is null, the height is 0
       if(node==null){
           return 0;
       }

       int left = diamHelper(node.left, len);
       int right = diamHelper(node.right, len);

       // Update diameter array by taking the maximum diameter that passes through the current node
       len[0] = Math.max(len[0], left+right);

       // Return maximum depth of the current node by adding 1 to the maximum depth of its deepest subtree
       return Math.max(left,right)+1;
   }

}