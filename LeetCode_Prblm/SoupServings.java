import java.util.HashMap;
import java.util.Map;

public class SoupServings {

    private Map<String, Double> memo = new HashMap<>();

    public double soupServings(int n) {
        if (n > 5000) return 1.0; // Large n → probability approaches 1

        // Convert to units of 25 mL
        n = (n + 24) / 25;
        return dfs(n, n);
    }

    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5; // both empty
        if (a <= 0) return 1.0;           // A empty first
        if (b <= 0) return 0.0;           // B empty first

        String key = a + "," + b;
        if (memo.containsKey(key)) return memo.get(key);

        double prob =
            0.25 * dfs(a - 4, b) +
            0.25 * dfs(a - 3, b - 1) +
            0.25 * dfs(a - 2, b - 2) +
            0.25 * dfs(a - 1, b - 3);

        memo.put(key, prob);
        return prob;
    }

    public static void main(String[] args) {
        SoupServings s = new SoupServings();
        System.out.printf("%.5f%n", s.soupServings(50));   // 0.62500
        System.out.printf("%.5f%n", s.soupServings(100));  // 0.71875
    }
}
