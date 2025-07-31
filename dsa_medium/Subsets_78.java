class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> bigList = new ArrayList<>();
        helper(nums,0 , new ArrayList<Integer>(),bigList);
        return bigList;
        
    }
    void helper(int nums[], int index, List<Integer> smallList,List<List<Integer>> bigList){
        bigList.add(new ArrayList<Integer>(smallList));
        if(index>nums.length){
            return;
        }
        for(int i= index; i<nums.length; i++){
            smallList.add(nums[i]);
            helper(nums, i+1, smallList, bigList);
            smallList.remove(smallList.size()-1);
        }
    }
}