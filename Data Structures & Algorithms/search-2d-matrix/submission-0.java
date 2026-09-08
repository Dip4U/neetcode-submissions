class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bot = m - 1, mid = 0, targetRow = -1;

        // 1. Binary search to find the correct row
        while (top <= bot) { // FIXED: Changed < to <= to avoid skipping the last row
            mid = top + (bot - top) / 2;

            // FIXED: Changed to >= and <= so we catch exact boundary matches
            if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
                targetRow = mid;
                break;
            }
            // FIXED: Move down only if the target exceeds the entire row's max value
            else if (target > matrix[mid][n - 1]) {
                top = mid + 1;
            }
            else {
                bot = mid - 1;
            }
        }
        
        if (targetRow == -1) return false;
        
        // 2. Binary search within the found row
        int low = 0, high = n - 1; // FIXED: Set high to n - 1 instead of 0

        while (low <= high) { // FIXED: Changed < to <=
            mid = low + (high - low) / 2;
            
            // FIXED: Compared the actual matrix values instead of index pointers
            if (matrix[targetRow][mid] == target) {
                return true; 
            } else if (matrix[targetRow][mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }       
        }
        return false;
    }
}
