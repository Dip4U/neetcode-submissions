class Solution {
    public boolean isAnagram(String s, String t) {
     return  
     s.chars().sorted().mapToObj(c->String.valueOf(c)).collect(Collectors.joining(""))
     .equalsIgnoreCase(
        t.chars().sorted().mapToObj(c->String.valueOf(c)).collect(Collectors.joining(""))
            );
    }
}
