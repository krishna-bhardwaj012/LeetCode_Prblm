import java.util.*;

public class FindtheMinimumAreatoCoverAllOnesI {
    static class Solution {
        public int minimumArea(int[][] grid) {
            int rows = grid.length, cols = grid[0].length;

            int minRow = rows, maxRow = -1;
            int minCol = cols, maxCol = -1;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                        minRow = Math.min(minRow, i);
                        maxRow = Math.max(maxRow, i);
                        minCol = Math.min(minCol, j);
                        maxCol = Math.max(maxCol, j);
                    }
                }
            }

            // No 1's found
            if (maxRow == -1) return 0;

            return (maxRow - minRow + 1) * (maxCol - minCol + 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = {
            {0,0,0,0},
            {0,1,1,0},
            {0,1,0,0},
            {0,0,0,0}
        };
        System.out.println(sol.minimumArea(grid1)); // Output: 4

        int[][] grid2 = {
            {0,0},
            {0,0}
        };
        System.out.println(sol.minimumArea(grid2)); // Output: 0
    }
}
