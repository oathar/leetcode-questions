class Solution {
    public int maximumScore(int a, int b, int c) {
        long total = (long)a + b + c;  // use long to avoid overflow
        long mx = Math.max(a, Math.max(b, c));
        // maximum possible if always pairing
        long maxPossible = total / 2;
        // maximum possible constrained by largest pile
        long constrained = total - mx;
        return (int)Math.min(maxPossible, constrained);
    }
}
