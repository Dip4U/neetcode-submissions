

public class Solution {
    
    // Thread-safe immutable map for structural extensibility
    private static final Map<Character, Character> BRACKET_MAP = Map.of(
        ')', '(',
        '}', '{',
        ']', '['
    );

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        // Bounded capacity allocation prevents internal array resizing
        Deque<Character> stack = new ArrayDeque<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (BRACKET_MAP.containsKey(current)) {
                // If stack is empty or top doesn't match the required open bracket
                if (stack.isEmpty() || stack.pop() != BRACKET_MAP.get(current)) {
                    return false;
                }
            } else {
                stack.push(current);
            }
        }

        return stack.isEmpty();
    }
}
