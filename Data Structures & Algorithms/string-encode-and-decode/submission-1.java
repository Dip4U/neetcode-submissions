

class Solution {

    // Encodes to: "5#Hello5#World"
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(); // StringBuilder is faster than StringBuffer
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    // Decodes by reading the length first, then skipping the marker
    public List<String> decode(String str) {
        List<String> strEncoded = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            // 1. Find the delimiter right after the length digits
            int posn = str.indexOf("#", i);
            
            // 2. Parse everything from 'i' up to '#' as the integer length
            int length = Integer.parseInt(str.substring(i, posn));
            
            // 3. Extract the string starting right after '#'
            String st = str.substring(posn + 1, posn + 1 + length);
            strEncoded.add(st);
            
            // 4. Crucial: Move 'i' completely past the extracted string
            i = posn + 1 + length;
        }
        return strEncoded;
    }
}
