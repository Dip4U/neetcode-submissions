class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        // Tracks max money if we skipped or robbed the previous house
        int rob1 = 0; // Represents two houses back (i - 2)
        int rob2 = 0; // Represents one house back (i - 1)
        
        // Iterate through each house to make the optimal decision
        for (int num : nums) {
            // Find max: rob current house + what we had 2 houses ago, OR skip current house
            int currentMax = Math.max(num + rob1, rob2);
            
            // Move the window forward
            rob1 = rob2;
            rob2 = currentMax;
        }
        
        return rob2;
    }
}
