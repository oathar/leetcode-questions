/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    // Recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        
        int curr = root.val;
        int pv = p.val;
        int qv = q.val;
        
        if (pv < curr && qv < curr) {
            // both on left
            return lowestCommonAncestor(root.left, p, q);
        } else if (pv > curr && qv > curr) {
            // both on right
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // split point OR one equals root => root is LCA
            return root;
        }
    }
    
    // Iterative
    public TreeNode lowestCommonAncestorIter(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            int curr = node.val;
            int pv = p.val;
            int qv = q.val;
            
            if (pv < curr && qv < curr) {
                node = node.left;
            } else if (pv > curr && qv > curr) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;  // theoretically p and q are guaranteed to be in the tree, so this won't happen in valid input
    }
}