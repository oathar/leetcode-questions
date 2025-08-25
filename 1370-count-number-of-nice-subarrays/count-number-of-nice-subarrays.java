class Solution {
    public int numberOfSubarrays(int[] nums, int K) {
        if(K<0){
            return 0;
        }
        for(int i=0; i<nums.length; i++)
        {
            nums[i]= nums[i]%2;
        }
        return subArray(nums, K) - subArray(nums,K-1);

    }
    int subArray(int nums[],int K){
        int right=0, left=0, sum=0, nsa=0;
        for(right=0; right<nums.length;right++)
        {
            sum+= nums[right];
            while(sum>K && left <= right)
            {
                sum-= nums[left];
                left++;
            }
            nsa+=right-left+1;
        }
        return nsa;
    }
}