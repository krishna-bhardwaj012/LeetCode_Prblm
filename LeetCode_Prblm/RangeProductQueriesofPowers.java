import java.util.*;

public class RangeProductQueriesofPowers {
    static final int MOD = 1_000_000_007;

    public int[] productQueries(int n, int[][] queries) {
        List<Long> powersList = new ArrayList<>();
        for (int bit = 0; bit < 31; bit++) {
            if ((n & (1 << bit)) != 0) {
                powersList.add((long)(1 << bit));
            }
        }

        long[] powers = new long[powersList.size()];
        for (int i = 0; i < powers.length; i++) {
            powers[i] = powersList.get(i);
        }

        long[] prefixProd = new long[powers.length + 1];
        prefixProd[0] = 1;
        for (int i = 0; i < powers.length; i++) {
            prefixProd[i + 1] = (prefixProd[i] * powers[i]) % MOD;
        }

        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            long numerator = prefixProd[right + 1];
            long denominator = prefixProd[left];

            answers[i] = (int)((numerator * modInverse(denominator, MOD)) % MOD);
        }
        return answers;
    }

    private long modInverse(long a, int mod) {
        return modPow(a, mod - 2, mod);
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        long cur = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * cur) % mod;
            }
            cur = (cur * cur) % mod;
            exp >>= 1;
        }
        return result;
    }

    // Main method to test your code
    public static void main(String[] args) {
        RangeProductQueriesofPowers obj = new RangeProductQueriesofPowers();

        int n1 = 15;
        int[][] queries1 = {{0, 1}, {2, 2}, {0, 3}};
        System.out.println(Arrays.toString(obj.productQueries(n1, queries1)));  // Output: [2, 4, 64]

        int n2 = 2;
        int[][] queries2 = {{0, 0}};
        System.out.println(Arrays.toString(obj.productQueries(n2, queries2)));  // Output: [2]
    }
}
