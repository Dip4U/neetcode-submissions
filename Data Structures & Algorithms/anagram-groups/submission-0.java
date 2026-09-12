class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> val=new LinkedHashMap();
        for(String str:strs)
        {
           String key= Arrays.stream(str.split("")).sorted(Comparator.naturalOrder()).
            collect(Collectors.joining(""));
            val.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        List<List<String>> result=new ArrayList();

        return new ArrayList<>(val.values());
        
    }
}
