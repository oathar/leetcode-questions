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
   public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Recursively find depth of left and right subtrees
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        // Current depth = 1 (for root) + max of left and right depths
        return 1 + Math.max(lh, rh);
    }
}