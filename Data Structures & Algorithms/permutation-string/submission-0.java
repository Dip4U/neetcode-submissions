class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Counts []=new int[26];
        int s2Counts[]=new int[26];
        int l=s1.length(),r=s2.length();

        if(l>r)
        return false;

        for(int i=0;i<l;i++)
        {
            s1Counts[s1.charAt(i)-'a']++;
            s2Counts[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(s1Counts,s2Counts))
        return true;

        for(int i=l;i<r;i++)
        {
            s2Counts[s2.charAt(i)-'a']++;
            s2Counts[s2.charAt(i-l)-'a']--;

            if(Arrays.equals(s1Counts,s2Counts))
                return true;
        }
        return false;
        
    }
}
