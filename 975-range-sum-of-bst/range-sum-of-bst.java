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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;

            if (node.val >= low && node.val <= high) {
                sum += node.val;
            }
            if (node.val > low) {
                stack.push(node.left); // possible valid nodes in left
            }
            if (node.val < high) {
                stack.push(node.right); // possible valid nodes in right
            }
        }
        return sum;
    }
}
