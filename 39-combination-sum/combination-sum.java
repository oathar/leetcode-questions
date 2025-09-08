import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // optional, helps with pruning
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, 
                           List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path)); // make a copy
            return;
        }
        if (target < 0) {
            return; // stop if sum exceeded
        }

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]); // choose
            backtrack(candidates, target - candidates[i], i, path, result); // reuse allowed
            path.remove(path.size() - 1); // undo (backtrack)
        }
    }
}
