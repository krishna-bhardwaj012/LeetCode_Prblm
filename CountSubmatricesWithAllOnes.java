public class CountSubmatricesWithAllOnes {

    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] heights = new int[n];
        int[] sum = new int[n];
        int[] stack = new int[n];
        int total = 0;

        for (int i = 0; i < m; i++) {
            // build histogram heights for this row
            for (int j = 0; j < n; j++) {
                heights[j] = mat[i][j] == 0 ? 0 : heights[j] + 1;
            }

            // monotonic stack logic
            int top = -1;
            for (int j = 0; j < n; j++) {
                while (top >= 0 && heights[stack[top]] >= heights[j]) {
                    top--;
                }
                if (top >= 0) {
                    int prev = stack[top];
                    sum[j] = sum[prev] + heights[j] * (j - prev);
                } else {
                    sum[j] = heights[j] * (j + 1);
                }
                stack[++top] = j;
                total += sum[j];
            }
        }
        return total;
    }

    // ✅ Main method for testing locally
    public static void main(String[] args) {
        CountSubmatricesWithAllOnes solver = new CountSubmatricesWithAllOnes();

        int[][] mat1 = {{1,0,1},{1,1,0},{1,1,0}};
        int[][] mat2 = {{0,1,1,0},{0,1,1,1},{1,1,1,0}};

        System.out.println(solver.numSubmat(mat1)); // Expected 13
        System.out.println(solver.numSubmat(mat2)); // Expected 24
    }
}
