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

        // p와 q 노드를 찾는다.
        if (root == p) {
            return p;
        }
        if (root == q) {
            return q;
        }
        
        // p와 q가 특정 subtree에 존재한다는 보장이 없으므로 변수 추가
        TreeNode findNode1 = lowestCommonAncestor(root.left, p, q);
        TreeNode findNode2 = lowestCommonAncestor(root.right, p, q);

        // p와 q가 다른 subtree에 존재
        if ((findNode1 != null) && (findNode2 != null)) {
            return root;
        } // p와 q가 같은 subtree에 존재
        else if (findNode1 == null) {
            return findNode2;
        } else {
            return findNode1;
        }
    }
}