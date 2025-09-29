class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // We can track the largest and second largest
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x > max1) {
                // shift down
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max2 = x;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}
