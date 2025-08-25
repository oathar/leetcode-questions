class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int zeroCount = 0;
        int maxLen = 0;

        while (right < nums.length) {
            // Expand window by including nums[right]
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If more than k zeros, shrink window from left
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }
}
