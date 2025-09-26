import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        // Max heap: store {soldierCount, rowIndex}
        // Sort by soldierCount descending, if tie by rowIndex descending
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]
        );

        for (int i = 0; i < mat.length; i++) {
            int soldiers = countSoldiers(mat[i]);
            maxHeap.add(new int[]{soldiers, i});

            // Keep only k elements in the heap
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Extract results from heap (reverse order since it's a maxHeap)
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll()[1];
        }
        return result;
    }

    // Count soldiers (number of 1's in the row)
    private int countSoldiers(int[] row) {
        int count = 0;
        for (int val : row) {
            if (val == 1) count++;
            else break; // since rows are sorted
        }
        return count;
    }
}
