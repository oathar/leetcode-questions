import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each element
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        
        // Step 2: Use a min-heap (priority queue) to keep top k frequent elements
        // The heap stores elements (numbers), ordered by their frequency (ascending)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>( (a, b) -> freq.get(a) - freq.get(b) );
        
        // Step 3: For each unique number, push into heap; if heap size > k, pop the least frequent
        for (Integer num : freq.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // Step 4: Extract elements from the heap into result array
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
