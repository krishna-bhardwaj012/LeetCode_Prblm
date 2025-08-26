import java.util.*;

public class maxCollectedFruits {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        Map<String, Integer> memo = new HashMap<>();
        return dfs(0, 0, 0, 0, fruits, memo);
    }

    private int dfs(int x1, int y1, int x2, int y2, int[][] grid, Map<String, Integer> memo) {
        int n = grid.length;
        int x3 = x1 + x2 - y1 - y2;
        int y3 = x1 + x2 - x3;

        if (!isValid(x1, y1, n) || !isValid(x2, y2, n) || !isValid(x3, y3, n))
            return Integer.MIN_VALUE;

        if (x1 == n - 1 && y1 == n - 1)
            return grid[x1][y1];

        String key = x1 + "," + y1 + "," + x2 + "," + y2;
        if (memo.containsKey(key))
            return memo.get(key);

        int current = grid[x1][y1];
        if (x2 != x1 || y2 != y1)
            current += grid[x2][y2];
        if ((x3 != x1 || y3 != y1) && (x3 != x2 || y3 != y2))
            current += grid[x3][y3];

        int max = Integer.MIN_VALUE;
        int[][] dirs = {{1, 0}, {0, 1}};

        for (int[] d1 : dirs)
            for (int[] d2 : dirs)
                for (int[] d3 : dirs) {
                    int next = dfs(x1 + d1[0], y1 + d1[1],
                                   x2 + d2[0], y2 + d2[1],
                                   grid, memo);
                    max = Math.max(max, next);
                }

        memo.put(key, current + max);
        return current + max;
    }

    private boolean isValid(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    // ✅ Add this main method
    public static void main(String[] args) {
        maxCollectedFruits solver = new maxCollectedFruits();

        int[][] grid1 = {
            {1, 2, 3, 4},
            {5, 6, 8, 7},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int[][] grid2 = {
            {1, 1},
            {1, 1}
        };

        System.out.println("Output 1: " + solver.maxCollectedFruits(grid1)); // Should print: 100
        System.out.println("Output 2: " + solver.maxCollectedFruits(grid2)); // Should print: 4
    }
}
