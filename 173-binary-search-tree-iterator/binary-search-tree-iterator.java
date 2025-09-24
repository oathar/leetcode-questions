/**
 * Definition for a binary tree node (given by the problem).
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        // push the leftmost path from root
        pushAllLeft(root);
    }

    // Helper: push all left children of node onto stack
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();  // the next smallest
        int result = node.val;
        if (node.right != null) {
            // if there is a right subtree, push its left path
            pushAllLeft(node.right);
        }
        return result;
    }
}
