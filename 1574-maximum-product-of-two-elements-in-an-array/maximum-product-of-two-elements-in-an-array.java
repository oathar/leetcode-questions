import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int maxProduct(int[] nums) {
        // Max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all numbers to heap
        for (int num : nums) {
            maxHeap.add(num);
        }
        
        // Extract two largest numbers
        int first = maxHeap.poll();
        int second = maxHeap.poll();
        
        return (first - 1) * (second - 1);
    }
}
