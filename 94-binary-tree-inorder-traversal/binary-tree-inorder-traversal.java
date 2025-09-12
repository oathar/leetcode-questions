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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                // Push current node and go left
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break; // traversal finished
                }
                // Visit node
                node = stack.pop();
                result.add(node.val);

                // Go right
                node = node.right;
            }
        }

        return result;
    }
}