
class Solution {
    public int rob(int[] nums) {
        // Base case: If there's only 1 house, just rob it (no neighbors to trigger alarms)
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        // Return the maximum of either ignoring the last house OR ignoring the first house
        return Math.max(
            robLinear(nums, 0, nums.length - 2), // Scenario A
            robLinear(nums, 1, nums.length - 1)  // Scenario B
        );
    }
    
    // This is the exact same logic from House Robber I, just with start/end boundaries
    private int robLinear(int[] nums, int start, int end) {
        int rob1 = 0;
        int rob2 = 0;
        
        for (int i = start; i <= end; i++) {
            int currentMax = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = currentMax;
        }
        
        return rob2;
    }
}
