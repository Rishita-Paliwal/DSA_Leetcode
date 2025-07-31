class Solution {
    public int[] runningSum1(int[] nums) {
     //Approach 1 
     int prefix[] = new int[nums.length];
     prefix[0]=nums[0];
     for(int i=1; i<nums.length;i++){
        prefix[i]= prefix[i-1] + nums[i];
    
     } 
     return prefix;  

    }
    public int[] runningSum(int[] nums){
        //Approach 2
        for(int i=1;i<nums.length;i++){
            nums[i]= nums[i-1]+ nums[i];
        }
        return nums;
    }
}