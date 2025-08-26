public class ReorderedPowerOf2 {
    
    public static boolean reorderedPowerOf2(int n) {
        int[] countN = digitCount(n);
        
        // Check powers of two up to 2^30
        for (int i = 0; i < 31; i++) {
            int power = 1 << i;
            if (matches(countN, digitCount(power))) {
                return true;
            }
        }
        return false;
    }
    
    private static int[] digitCount(int num) {
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return count;
    }
    
    private static boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(1));   // true
        System.out.println(reorderedPowerOf2(10));  // false
        System.out.println(reorderedPowerOf2(46));  // true (64)
        System.out.println(reorderedPowerOf2(128)); // true
        System.out.println(reorderedPowerOf2(821)); // true (128)
    }
}
