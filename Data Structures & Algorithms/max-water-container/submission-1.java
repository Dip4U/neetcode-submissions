class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int vol = 0;
        
        while (l < r) {
            // 1. Bug Fix: Multiply by the minimum height of the bars, NOT the pointers
            vol = Math.max(vol, (r - l) * Math.min(heights[l], heights[r]));
            
            // 2. Bug Fix: Move the pointer pointing to the shorter bar
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return vol;
    }
}
