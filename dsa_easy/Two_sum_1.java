class Solution {
    public int[] twoSum(int[] nums, int target) {
        int pair[]= new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int result = target-nums[i];
            if(map.get(result)!=null){
                pair[0]= map.get(result);
                pair[1] = i;
            }
            else{
                map.put(nums[i],i);
            }

        }
        return pair;
        
    }
}