import java.util.HashMap;
import java.util.HashSet;

public class createBinaryTree {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int[] arr : descriptions){
            int p = arr[0];
            int c = arr[1];
            int lr = arr[2];
            if(!map.containsKey(p)){
                map.put(p,new TreeNode(p));
            }
            if(!map.containsKey(c)){
                map.put(c,new TreeNode(c));
            }
            if(lr == 1){
                map.get(p).left = map.get(c);
            }else{
                map.get(p).right = map.get(c);
            }
            set.add(c);
        }
        for(int key : map.keySet()){
            if(!set.contains(key)){
                return map.get(key);
            }
        }
        return null;
    }
}

class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

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
