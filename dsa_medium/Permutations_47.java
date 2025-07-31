import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // Sort to handle duplicates
        boolean[] isVisited = new boolean[nums.length];
        List<List<Integer>> bigList = new ArrayList<>();
        List<Integer> smallList = new ArrayList<>();
        helper(nums, smallList, bigList, isVisited);
        return bigList;
    }

    private void helper(int[] nums, List<Integer> smallList, List<List<Integer>> bigList, boolean[] isVisited) {
        // Base case
        if (smallList.size() == nums.length) {
            bigList.add(new ArrayList<>(smallList));
            return;
        }

        // Branching logic inside the method block
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) continue;

            // Skip duplicate numbers
            if (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1]) continue;

            smallList.add(nums[i]);
            isVisited[i] = true;
            helper(nums, smallList, bigList, isVisited);
            smallList.remove(smallList.size() - 1);
            isVisited[i] = false;
        }
    }
}
