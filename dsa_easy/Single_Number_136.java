class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for(int val:nums){
            x= x^val;
        }
        return x;
        
    }
}