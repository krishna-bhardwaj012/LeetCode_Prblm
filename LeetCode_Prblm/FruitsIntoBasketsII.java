public class FruitsIntoBasketsII {

    public int FruitsIntoBaskets(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n]; // Track used baskets
        int unplaced = 0;

        for (int i = 0; i < n; i++) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true; // Mark basket as used
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                unplaced++; // Fruit couldn't be placed
            }
        }

        return unplaced; //  You must return an int here
    }

    public static void main(String[] args) {
        FruitsIntoBasketsII obj = new FruitsIntoBasketsII();

        int[] fruits1 = {4, 2, 5};
        int[] baskets1 = {3, 5, 4};
        System.out.println("Unplaced fruits: " + obj.FruitsIntoBaskets(fruits1, baskets1)); // Output: 1

        int[] fruits2 = {3, 6, 1};
        int[] baskets2 = {6, 4, 7};
        System.out.println("Unplaced fruits: " + obj.FruitsIntoBaskets(fruits2, baskets2)); // Output: 0
    }
}
