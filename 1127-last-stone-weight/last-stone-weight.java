import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // max-heap (PriorityQueue in reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // add all stones to heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // smash the two heaviest stones until at most one remains
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // heaviest
            int x = maxHeap.poll(); // second heaviest
            
            if (y != x) {
                maxHeap.add(y - x); // put the difference back
            }
        }

        // return last stone weight or 0 if none left
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
