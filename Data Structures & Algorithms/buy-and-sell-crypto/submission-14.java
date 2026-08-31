class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length>100 || prices.length<2)
            return 0;
        int buyPrice=Integer.MAX_VALUE,sellPrice= prices[1],maxProfit=0;   
        for(int i=0;i<prices.length-1;i++)
        {
                        if(buyPrice<prices[i])
                        continue;


            buyPrice=Math.min(buyPrice,prices[i]);
            for(int j=i;j<prices.length;j++)
            {
                maxProfit=Math.max(maxProfit,prices[j]-buyPrice);
            }
            
        } 

         
    return maxProfit;
        

    }
}
