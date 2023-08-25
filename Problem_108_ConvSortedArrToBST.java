/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a 
height-balanced binary search tree.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        // Base case
        if(nums.length == 0){
            return null;
        }
        else if(nums.length == 1){
            return new TreeNode(nums[0]);
        }

        // takes in index 0 and last index
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] arr, int left, int right){
        // return null if the right index is less than left index
        if(right<left){
            return null;
        }

        // take middle element as head value each time to become a height balanced tree
        int mid = left + (right-left)/2;    // to prevent overflow exception
        TreeNode root = new TreeNode(arr[mid]);

        // recursively construct left subtree using left half of array
        root.left = helper(arr, left, mid-1);
        // recursively construct right subtree using right half of array
        root.right = helper(arr, mid+1, right);

        return root;
    }
}