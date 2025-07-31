class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> smallList= new ArrayList<>();
         List<List<Integer>> bigList = new ArrayList<>();
         helper(candidates,target, 0, smallList, bigList);
         return bigList;
        
    }
    void helper(int nums[], int target, int index, List<Integer> smallList, List<List<Integer>> bigList){
        if(target==0){
            bigList.add(new ArrayList<>(smallList));
            return;
        }
        if(target<0){
            return;
        }
        for(int i= index; i<nums.length; i++){
            smallList.add(nums[i]);
            helper(nums, target- nums[i], i, smallList, bigList);
            smallList.remove(smallList.size()-1);
        }

    }
}