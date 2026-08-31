class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length>100 || prices.length<2)
            return 0;
        int left=0,right=1,maxProfit=0;   
        while(right< prices.length)
        {
             if(prices[left]< prices[right])
                maxProfit=Math.max(maxProfit,prices[right]-prices[left]);
             else
                left=right;


        right++;
            
        } 

         
    return maxProfit;
        

    }
}
