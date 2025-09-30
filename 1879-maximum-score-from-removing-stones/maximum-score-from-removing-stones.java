import java.util.PriorityQueue;

class Solution {
    public int maximumScore(int a, int b, int c) {
        // Use a max-heap (largest first)
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        if (a > 0) pq.offer(a);
        if (b > 0) pq.offer(b);
        if (c > 0) pq.offer(c);
        
        int score = 0;
        while (pq.size() >= 2) {
            int x = pq.poll();
            int y = pq.poll();
            // remove one from each
            x--;
            y--;
            score++;
            if (x > 0) pq.offer(x);
            if (y > 0) pq.offer(y);
        }
        return score;
    }
}
