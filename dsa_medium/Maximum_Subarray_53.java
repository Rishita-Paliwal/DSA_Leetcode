class Solution {
    //Kadanes Algo
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            sum = sum+ nums[i];
            sum = Math.max(sum,nums[i]);
            max = Math.max(sum,max);
        }
        return max;
        
    }
}