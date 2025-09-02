<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 07bf6dc (Added LeetCode_Prblm folder with solutions)
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
<<<<<<< HEAD
=======
// public class IntegerSumOfPowers {
//     public static void main(String[] args) {
//         int n = 10;
//         int x = 2;

//         Solution sol = new Solution();
//         int result = sol.numberOfWays(n, x);
//         System.out.println("Number of ways: " + result);
//     }
// }

// class Solution {
//     private static final int MOD = 1_000_000_007;

//     public int numberOfWays(int n, int x) {
//         int[] dp = new int[n + 1];
//         dp[0] = 1; // base case

//         for (int num = 1; Math.pow(num, x) <= n; num++) {
//             int power = (int) Math.pow(num, x);
//             for (int target = n; target >= power; target--) {
//                 dp[target] = (dp[target] + dp[target - power]) % MOD;
//             }
//         }

//         return dp[n];
//     }
// }


import java.util.*;

public class IntegerSumOfPowers {
    private static final int MOD = 1_000_000_007;
    private int[][] dp;

    public int numberOfWays(int n, int x) {
        dp = new int[n + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(n, x, 1);
    }

    private int dfs(int remaining, int power, int current) {
        if (remaining == 0) return 1; // found a way
        if (remaining < 0) return 0;  // invalid
        if (Math.pow(current, power) > remaining) return 0; // too large

        if (dp[remaining][current] != -1) return dp[remaining][current];

        int take = dfs(remaining - (int) Math.pow(current, power), power, current + 1);
        int skip = dfs(remaining, power, current + 1);

        return dp[remaining][current] = (int) ((take + (long) skip) % MOD);
    }

    public static void main(String[] args) {
        IntegerSumOfPowers obj = new IntegerSumOfPowers();
        int n = 10;
        int x = 2;
        int result = obj.numberOfWays(n, x);
        System.out.println("Number of ways: " + result);
    }
}
>>>>>>> b5f344a (Added Game.java file)
=======
>>>>>>> 07bf6dc (Added LeetCode_Prblm folder with solutions)
