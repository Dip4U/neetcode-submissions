class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length>100 || prices.length<2)
            return 0;
        int buyPrice=prices[0],sellPrice= prices[1],maxProfit=0;   
        for(int i=0;i<prices.length-1;i++)
        {
            buyPrice=Math.min(buyPrice,prices[i]);
            for(int j=i+1;j<prices.length;j++)
            {
                maxProfit=Math.max(maxProfit,prices[j]-buyPrice);
            }

        } 

         
    return maxProfit;
        

    }
}
