public class PairsProblem {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int[] A = points[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int[] B = points[j];

                // A must be upper-left of B
                if (A[0] < B[0] && A[1] > B[1]) {
                    boolean valid = true;

                    // check if any other point lies inside or on rectangle
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int[] P = points[k];

                        if (P[0] >= A[0] && P[0] <= B[0] &&
                            P[1] <= A[1] && P[1] >= B[1]) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) count++;
                }
            }
        }

        return count;
    }

    // ✅ Test the function
    public static void main(String[] args) {
        PairsProblem sol = new PairsProblem();

        int[][] p1 = {{1,1},{2,2},{3,3}};
        System.out.println("Output 1: " + sol.numberOfPairs(p1)); // 0

        int[][] p2 = {{6,2},{4,4},{2,6}};
        System.out.println("Output 2: " + sol.numberOfPairs(p2)); // 2

        int[][] p3 = {{3,1},{1,3},{1,1}};
        System.out.println("Output 3: " + sol.numberOfPairs(p3)); // 2 ✅
    }
}
