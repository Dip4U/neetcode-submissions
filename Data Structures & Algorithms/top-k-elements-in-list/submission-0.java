class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        return java.util.Arrays.stream(nums)
            .boxed()
            .collect(java.util.stream.Collectors.groupingBy(
                java.util.function.Function.identity(), 
                java.util.stream.Collectors.counting()
            ))
            .entrySet() 
            .stream()
            .sorted(java.util.Map.Entry.comparingByValue(java.util.Collections.reverseOrder()))
            .limit(k)
            .map(java.util.Map.Entry::getKey)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
