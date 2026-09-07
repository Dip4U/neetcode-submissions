class Solution {
    public String longestPalindrome(String s) {
        int start=0,end=0;
        for(int i=0;i<s.length();i++)
        {
           int len1= getLen(s,i,i);
           int len2= getLen(s,i,i+1);
           int maxLen=Math.max(len1,len2);

         if (maxLen > (end - start + 1)) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        
        // Return the final longest substring slice
        return s.substring(start, end + 1);
        
    }
    public int getLen(String s, int left,int right)
    {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        return right-left-1;
    }
}
