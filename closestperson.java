public class closestperson {

    // Method: decide who reaches z first
    public int findClosest(int x, int y, int z) {
        int d1 = Math.abs(x - z);  // distance of Person 1
        int d2 = Math.abs(y - z);  // distance of Person 2

        if (d1 < d2) return 1;     // Person 1 closer
        if (d2 < d1) return 2;     // Person 2 closer
        return 0;                  // Both equal distance
    }

    // Main method for testing
    public static void main(String[] args) {
        closestperson cp = new closestperson();

        System.out.println(cp.findClosest(2, 7, 4)); // 1
        System.out.println(cp.findClosest(2, 5, 6)); // 2
        System.out.println(cp.findClosest(1, 5, 3)); // 0
    }
}
