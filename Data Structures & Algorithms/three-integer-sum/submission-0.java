

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Fix 1: Look backward to properly skip duplicates
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    
                    // Skip duplicates
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    
                    // Fix 2: Move the pointers inward to break out of the match
                    l++;
                    r--;
                } 
                // Fix 3: Use else-if / else to separate the conditions cleanly
                else if (sum < 0) {
                    l++;
                } else { 
                    r--;
                }
            }     
        }
        return res;
    }
}
