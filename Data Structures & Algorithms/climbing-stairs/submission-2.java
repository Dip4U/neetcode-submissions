class Solution {
    public int climbStairs(int n) {
        // Base cases handled efficiently
        if (n <= 1) return 1;
        if (n == 2) return 2;
        
        int oneStepBefore = 2; // Ways to reach step 2
        int twoStepsBefore = 1; // Ways to reach step 1
        int current = 0;
        
        // Iteratively calculate combinations up to n
        for (int i = 3; i <= n; i++) {
            current = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore; // Move step window forward
            oneStepBefore = current;
        }
        
        return current;
    }
}
