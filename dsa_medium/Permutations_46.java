class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> smallList = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        helper(nums, smallList, finalList);
        return finalList;

        
    }
    void helper(int nums[], List<Integer> smallList, List<List<Integer>> finalList){
        //base case
        if(nums.length == smallList.size()){
            finalList.add(new ArrayList<Integer>(smallList));
            return;
        }
        //iterate the nums
        for(int i=0; i<nums.length; i++){
            if(!smallList.contains(nums[i])){
                smallList.add(nums[i]); //modify val
                helper(nums, smallList, finalList); //recursive call
                //stack fall
                smallList.remove(smallList.size()-1);
            }
        }
    }
}