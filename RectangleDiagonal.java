public class RectangleDiagonal {

    /**
     * Returns the area of the rectangle with the longest diagonal.
     * If multiple rectangles share the longest diagonal, returns the one with the largest area.
     *
     * @param dimensions dimensions[i][0] = length, dimensions[i][1] = width
     * @return area of the chosen rectangle
     */
    public static int areaOfRectangleWithLongestDiagonal(int[][] dimensions) {
        long bestDiagSq = -1;  // track squared diagonal to avoid sqrt
        int bestArea = 0;

        for (int[] d : dimensions) {
            int l = d[0], w = d[1];
            long diagSq = 1L * l * l + 1L * w * w; // use long to avoid overflow
            int area = l * w;

            if (diagSq > bestDiagSq || (diagSq == bestDiagSq && area > bestArea)) {
                bestDiagSq = diagSq;
                bestArea = area;
            }
        }
        return bestArea;
    }

    // Quick demo
    public static void main(String[] args) {
        int[][] ex1 = {{9, 3}, {8, 6}};
        System.out.println(areaOfRectangleWithLongestDiagonal(ex1)); // 48

        int[][] ex2 = {{3, 4}, {4, 3}};
        System.out.println(areaOfRectangleWithLongestDiagonal(ex2)); // 12
    }
}
