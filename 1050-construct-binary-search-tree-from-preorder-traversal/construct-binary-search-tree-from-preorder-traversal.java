/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int idx = 0;

    private TreeNode constructTree(int[] preorder, int min, int max) {
        if (idx >= preorder.length) {
            return null;
        }

        int key = preorder[idx];

        if (key <= min || key >= max) {
            return null;
        }

        TreeNode root = new TreeNode(key);
        idx++;

        root.left = constructTree(preorder, min, key);
        root.right = constructTree(preorder, key, max);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return constructTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
