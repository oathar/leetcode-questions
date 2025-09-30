import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    private int sqDist(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        // max-heap by squared distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(sqDist(p2), sqDist(p1))
        );
        for (int[] pt : points) {
            maxHeap.offer(pt);
            if (maxHeap.size() > k) {
                maxHeap.poll();  // remove the farthest among them
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
}
