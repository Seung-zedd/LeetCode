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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       // base condition
        if (root == null) {
            return null;
        } 
        
        // preorder traversal
        if (root == p) {
            return p;
        }
        if (root == q) {
            return q;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // subtree가 다른 경우
        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }
}