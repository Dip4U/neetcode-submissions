class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = nums[0]; // Start with the first element
        int maxSum = nums[0]; // Tracks the absolute maximum found
        
        for (int i = 1; i < nums.length; i++) {
            // Decides whether to add to the existing subarray or start a new one
            if (curSum + nums[i] < nums[i]) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
            
            // CRITICAL FIX: Track the maximum sum seen so far
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}
