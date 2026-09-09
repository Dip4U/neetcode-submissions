class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Start the recursive backtracking from index 0
        backtrack(0, nums, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, int target, List<Integer> current, List<List<Integer>> result) {
        // Base case: if target is met, add the combination clone to results
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Base case: if target is exceeded or we run out of numbers
        if (target < 0 || index >= nums.length) {
            return;
        }

        // Decision 1: Include nums[index] and continue tracking (target decreases)
        current.add(nums[index]);
        backtrack(index, nums, target - nums[index], current, result);
        
        // Backtrack step: remove the last element before making the next choice
        current.remove(current.size() - 1);

        // Decision 2: Skip nums[index] entirely and move to the next unique number
        backtrack(index + 1, nums, target, current, result);
    }
}