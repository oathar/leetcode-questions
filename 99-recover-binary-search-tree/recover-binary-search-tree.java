/**
 * Definition for a binary tree node (given by LeetCode).
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;  // tracks previous node in inorder

    public void recoverTree(TreeNode root) {
        inorder(root);
        // swap the two wrong nodes
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        // traverse left
        inorder(node.left);

        // visit current: check if there is a violation
        if (prev != null && node.val < prev.val) {
            // found a pair out of order
            if (first == null) {
                // first time we see a violation
                first = prev;
                second = node;
            } else {
                // second time: update second
                second = node;
            }
        }

        prev = node;  // update prev

        // traverse right
        inorder(node.right);
    }
}
