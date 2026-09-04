class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left=0;
        int right=numbers.length-1;
        if(target<-1000 || target>1000)
        return new int [0];
        if(numbers.length<2 || numbers.length>30000)
        return new int [0];

        while(left<right)
        {
            if(numbers[left]>1000 || numbers[right]> 1000 || numbers[left]<-1000 || numbers[right]< -1000)
            return new int [0];
            if(numbers[left]+numbers[right]>target)
            {
                right--;
            }
            else if(numbers[left]+numbers[right]<target)
            {
                left++;
            }
            else
            return new int[]{left+1,right+1};
        }
        return new int[0];
        
    }
}
