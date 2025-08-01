import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> smallList = new ArrayList<>();
        List<List<Integer>> bigList = new ArrayList<>();
        helper(1, n, k, smallList, bigList);
        return bigList;
    }

    void helper(int start, int n, int k, List<Integer> smallList, List<List<Integer>> bigList) {
        if (smallList.size() == k) {
            bigList.add(new ArrayList<>(smallList));
            return;
        }

        for (int i = start; i <= n; i++) {
            smallList.add(i);
            helper(i + 1, n, k, smallList, bigList);
            smallList.remove(smallList.size() - 1); // backtrack
        }
    }
}
