class Solution {
    void reverse(int nums[], int starting, int ending){
        while(starting<ending){
            int temp = nums[starting];
            nums[starting] = nums[ending];
            nums[ending]= temp;
            starting++;
            ending--;
        }
    }
    public void rotate(int[] nums, int k) {
         k = k%nums.length;
        reverse(nums,0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        
    }
}