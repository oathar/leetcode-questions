class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        int n = nums.length;
        // 1. Build max heap
        buildMaxHeap(nums, n);

        // 2. Sort: move max to end, reduce heap, heapify again
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            // now heap size is i
            maxHeapify(nums, 0, i);
        }
    }

    private void buildMaxHeap(int[] nums, int n) {
        // from last non-leaf down to 0
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i, n);
        }
    }

    private void maxHeapify(int[] nums, int i, int heapSize) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(nums, i, largest);
            // recursively fix the affected subtree
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
