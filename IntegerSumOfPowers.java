public class IntegerSumOfPowers {
    public static void main(String[] args) {
        int n = 10;
        int x = 2;

        Solution sol = new Solution();
        int result = sol.numberOfWays(n, x);
        System.out.println("Number of ways: " + result);
    }
}

class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // base case

        for (int num = 1; Math.pow(num, x) <= n; num++) {
            int power = (int) Math.pow(num, x);
            for (int target = n; target >= power; target--) {
                dp[target] = (dp[target] + dp[target - power]) % MOD;
            }
        }

        return dp[n];
    }
}
