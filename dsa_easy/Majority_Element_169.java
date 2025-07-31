class Solution {
    public int majorityElement(int[] nums) {
        //blyor Moore Voting Algorithm
        int candidate =0;
        int count =0;
        for(int num:nums){
            if(count ==0)candidate=num;
            count += (candidate==num)?1:-1;
        }
        return candidate;
    }
}