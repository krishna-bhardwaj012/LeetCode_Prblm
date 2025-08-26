public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.isPowerOfTwo(1));   // true
        System.out.println(sol.isPowerOfTwo(16));  // true
        System.out.println(sol.isPowerOfTwo(3));   // false
        System.out.println(sol.isPowerOfTwo(0));   // false
        System.out.println(sol.isPowerOfTwo(-2));  // false
    }
}
