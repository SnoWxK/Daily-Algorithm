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
public class sumRootToLeaf {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentVal) {
        // 1. 基准情形：如果节点为空，返回 0
        if (node == null) {
            return 0;
        }

        // 2. 核心逻辑：将当前值左移一位（相当于 * 2），并加上当前节点的值
        // 使用位运算更贴合二进制题目背景
        currentVal = (currentVal << 1) | node.val;

        // 3. 叶子节点判断：如果到达叶子节点，返回该路径形成的完整数字
        if (node.left == null && node.right == null) {
            return currentVal;
        }

        // 4. 递归计算左右子树的和
        return dfs(node.left, currentVal) + dfs(node.right, currentVal);
    }
}
