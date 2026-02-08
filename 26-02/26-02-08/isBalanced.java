class isBalanced {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左子树高度
        int leftHeight = height(node.left);
        if (leftHeight == -1) {
            return -1; // 左子树不平衡，直接返回
        }

        // 递归计算右子树高度
        int rightHeight = height(node.right);
        if (rightHeight == -1) {
            return -1; // 右子树不平衡，直接返回
        }

        // 检查当前节点是否平衡
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // 不平衡
        }

        // 返回当前节点的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
