class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        Map<Character, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> mp.get(b) - mp.get(a)
        );

        maxHeap.addAll(mp.keySet());

        StringBuilder res = new StringBuilder();

        while (maxHeap.size() > 1) {
            char one = maxHeap.poll();
            char two = maxHeap.poll();

            res.append(one);
            res.append(two);

            mp.put(one, mp.get(one) - 1);
            mp.put(two, mp.get(two) - 1);

            if (mp.get(one) > 0) {
                maxHeap.add(one);
            }

            if (mp.get(two) > 0) {
                maxHeap.add(two);
            }
        }

        if (!maxHeap.isEmpty()) {
            char last = maxHeap.poll();
            if (mp.get(last) > 1) {
                return "";
            }
            res.append(last);
        }

        return res.toString();
    }
}
