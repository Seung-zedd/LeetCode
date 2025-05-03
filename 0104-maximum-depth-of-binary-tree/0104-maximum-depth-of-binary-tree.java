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
public class Solution {
    public int maxDepth(TreeNode root) {
        int level = 0; // start from zero
        // if the root is null
        if (root == null) {
            return level;
        }

        Queue<NodeInfo> q = new LinkedList<>();
        q.offer(new NodeInfo(root, ++level));

        while (!q.isEmpty()) {
            NodeInfo nodeInfo = q.poll();
            TreeNode curNode = nodeInfo.node;
            int curLevel = nodeInfo.level;

            level = Math.max(level, curLevel);

            if (curNode.left != null) {
                q.offer(new NodeInfo(curNode.left, curLevel + 1));
            }
            if (curNode.right != null) {
                q.offer(new NodeInfo(curNode.right, curLevel + 1));
            }

        }
        return level;
    }
    // 내부 클래스 정의
    static class NodeInfo {
        TreeNode node;
        int level;

        NodeInfo(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}