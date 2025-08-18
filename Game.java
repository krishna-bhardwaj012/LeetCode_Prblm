import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] cards1 = {4, 1, 8, 7};
        int[] cards2 = {1, 2, 1, 2};

        System.out.println(sol.judgePoint24(cards1)); // true
        System.out.println(sol.judgePoint24(cards2)); // false
    }
}

class Solution {
    private static final double EPSILON = 1e-6;
    private static final int TARGET = 24;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }
        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - TARGET) < EPSILON;
        }

        int n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                for (double val : compute(nums.get(i), nums.get(j))) {
                    next.add(val);
                    if (solve(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (Math.abs(b) > EPSILON) res.add(a / b);
        if (Math.abs(a) > EPSILON) res.add(b / a);
        return res;
    }
}
