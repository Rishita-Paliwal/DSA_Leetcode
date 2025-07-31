class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    void merge(int[] nums, int low, int mid, int high) {
        List<Integer> result = new ArrayList<>();
        int left = low, right = mid + 1;

        // Merge the two sorted halves into result
        while (left <= mid && right <= high) {
            if (nums[left] < nums[right]) {
                result.add(nums[left++]);
            } else {
                result.add(nums[right++]);
            }
        }

        // Copy remaining elements of left half (if any)
        while (left <= mid) {
            result.add(nums[left++]);
        }

        // Copy remaining elements of right half (if any)
        while (right <= high) {
            result.add(nums[right++]);
        }

        // ✅ Only now, copy back to nums
        for (int i = low; i <= high; i++) {
            nums[i] = result.get(i - low);
        }
    }
}
