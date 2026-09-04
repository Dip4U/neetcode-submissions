class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        
        while (l < r) {
            // Move the left pointer forward if it's not a letter or digit
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } 
            // Move the right pointer backward if it's not a letter or digit
            else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } 
            // If both are alphanumeric, compare them case-insensitively
            else {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false; // Mismatch found
                }
                l++;
                r--;
            }
        }
        
        return true; // No mismatches found
    }
}
