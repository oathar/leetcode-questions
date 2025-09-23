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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key); // search in left
        } 
        else if (key > root.val) {
            root.right = deleteNode(root.right, key); // search in right
        } 
        else {
            // Node found
            if (root.left == null) return root.right;   // no left child
            else if (root.right == null) return root.left; // no right child
            
            // Node with two children
            TreeNode successor = findMin(root.right); 
            root.val = successor.val;  // copy value
            root.right = deleteNode(root.right, successor.val); // delete successor
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
