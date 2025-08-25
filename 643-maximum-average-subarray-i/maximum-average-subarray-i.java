class Solution {
    public double findMaxAverage(int[] nums, int k) {
                // Calculate the sum of the first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        
        // Initialize maxSum with the first window sum
        int maxSum = windowSum;
        
        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            // Update the window sum: subtract the element going out and add the new element
            windowSum = windowSum - nums[i - k] + nums[i];
            
            // Update the maxSum if the new windowSum is larger
            maxSum = Math.max(maxSum, windowSum);
        }
        
        // Return the maximum average
        return (double) maxSum / k;
    }
}