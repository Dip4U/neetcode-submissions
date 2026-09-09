class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 1. Sort the array so that identical numbers sit next to each other
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int index, int target, int[] candidates, List<Integer> current, List<List<Integer>> result) {
        // Base case: Target reached
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Base case: Target exceeded
        if (target < 0) {
            return;
        }

        // Loop through all remaining candidates to make a decision
        for (int i = index; i < candidates.length; i++) {
            // CRUCIAL: Skip duplicate numbers at the same decision depth 
            // This prevents generating identical combinations
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Include the current element
            current.add(candidates[i]);
            
            // Move to 'i + 1' so the same exact element index is never reused
            backtrack(i + 1, target - candidates[i], candidates, current, result);
            
            // Undo the move (Backtrack)
            current.remove(current.size() - 1);
        }
    }
}