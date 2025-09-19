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
        return convertArray(nums, 0, nums.length - 1);
    }

    private TreeNode convertArray(int[] nums, int start, int end) {
        // Base case: invalid range
        if (start > end) {
            return null;
        }
        
        // Find the middle element
        int mid = start + (end - start) / 2;
        
        // Root node is the middle element
        TreeNode root = new TreeNode(nums[mid]);
        
        // Recursively build left and right subtrees
        root.left = convertArray(nums, start, mid - 1);
        root.right = convertArray(nums, mid + 1, end);
        
        return root;
    }
}
