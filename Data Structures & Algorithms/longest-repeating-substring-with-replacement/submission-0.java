class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> count=new HashMap();
        int l=0;
        int maxf=0;
        int res=0;

        for(int r=0;r<s.length();r++)
        {
            char rightChar=s.charAt(r);
            count.put(rightChar,count.getOrDefault(rightChar,0)+1);
            maxf=Math.max(maxf,count.get(rightChar));

            int windowLength=r-l+1;
            if(windowLength-maxf>k)
            {
                char leftChar=s.charAt(l);
                l++;
                count.put(leftChar,count.get(leftChar)-1);
            }
            res=Math.max(res,r-l+1);

        }
        return res;

    }
}
