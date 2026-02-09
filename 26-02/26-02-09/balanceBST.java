import java.util.ArrayList;

public class balanceBST {
    ArrayList<Integer> list = new ArrayList<>();

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);
            list.add(node.val);
            dfs(node.right);
        }

        public TreeNode buildBST(int left, int right) {
            if (left > right) {
                return null;
            }

            int mid = left + (right - left) / 2;

            // 创建根节点
            TreeNode root = new TreeNode(list.get(mid));

            root.left = buildBST(left, mid - 1);
            root.right = buildBST(mid + 1, right);

            return root;

        }
        public TreeNode balanceBST(TreeNode root) {
            dfs(root);
            return buildBST(0, list.size() - 1);

        }
    }
}
