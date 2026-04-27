public class hasValidPath {
    int[][] grid;
    int m;
    int n;
    // 该坐标是否走过
    boolean[][] used;
    // 第1行对应街道类型1，第2行对应街道类型2.。。
    // 每3个元素代表x方向上的变化量，y方向上的变化量，下一个可选的街道类型
    // 比如第1行，表示类型1，也就是横线那种类型的街道，只能y方向上-1，或者+1，x方向不能变化，在往左走的时候，左边只能是类型1，类型4和类型6，往右边走的时候，右边只能是类型1，类型3，类型5
    int[][][] direction = {
            {{0, -1, 1}, {0, -1, 4}, {0, -1, 6}, {0, 1, 1}, {0, 1, 3}, {0, 1, 5}},
            {{-1, 0, 2}, {-1, 0, 3}, {-1, 0, 4}, {1, 0, 2}, {1, 0, 5}, {1, 0, 6}},
            {{0, -1, 1}, {0, -1, 4}, {0, -1, 6}, {1, 0, 2}, {1, 0, 5}, {1, 0, 6}},
            {{1, 0, 2}, {1, 0, 5}, {1, 0, 6}, {0, 1, 1}, {0, 1, 3}, {0, 1, 5}},
            {{0, -1, 1}, {0, -1, 4}, {0, -1, 6}, {-1, 0, 2}, {-1, 0, 3}, {-1, 0, 4}},
            {{0, 1, 1}, {0, 1, 3}, {0, 1, 5}, {-1, 0, 2}, {-1, 0, 3}, {-1, 0, 4}},
    };

    public boolean hasValidPath(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.used = new boolean[m][n];
        return hasValidPath(0, 0);
    }

    public boolean hasValidPath(int x, int y) {
        used[x][y] = true;
        // 已经到右下角了
        if (x == m - 1 && y == n - 1) {
            return true;
        }

        // 选取该坐标下的可选方向列表direction[grid[x][y] - 1]
        // 尝试每个方向
        for (int[] d : direction[grid[x][y] - 1]) {
            int newx = x + d[0];
            int newy = y + d[1];
            // 这个方向必须合法，也就是坐标不能越界，且没有遍历过，且类型需要满足
            if (isValid(newx, newy, d[2]) && hasValidPath(newx, newy)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValid(int x, int y, int type) {
        return x >= 0 && y >= 0 && x < m && y < n && !used[x][y] && grid[x][y] == type;
    }
//
//    作者：XHSF
//    链接：https://leetcode.cn/problems/check-if-there-is-a-valid-path-in-a-grid/solutions/320495/java-shen-du-you-xian-tong-guo-shu-zu-jian-hua-pan/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
