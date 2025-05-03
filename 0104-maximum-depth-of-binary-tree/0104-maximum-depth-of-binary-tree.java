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
        {
        // if the root is null
        if (root == null) {
            return 0;
        }

        // 사전 세팅
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            // 현재 레벨의 모든 노드를 처리
            int size = q.size();
            level++; // 새 레벨로 이동

            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();

                if (curNode.left != null) {
                    q.offer(curNode.left);
                }
                if (curNode.right != null) {
                    q.offer(curNode.right);
                }
            }

        }
        return level;

    }

    }
}