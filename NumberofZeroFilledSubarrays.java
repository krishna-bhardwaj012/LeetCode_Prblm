public class NumberofZeroFilledSubarrays {

    public static long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long zeros = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
                count += zeros;
            } else {
                zeros = 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 0, 0, 2, 0, 0, 4};
        int[] nums2 = {0, 0, 0, 2, 0, 0};
        int[] nums3 = {2, 10, 2019};

        System.out.println(zeroFilledSubarray(nums1)); // 6
        System.out.println(zeroFilledSubarray(nums2)); // 9
        System.out.println(zeroFilledSubarray(nums3)); // 0
    }
}
