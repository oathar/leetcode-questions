import java.util.*;

class TaskManager {
    // Map from taskId -> a pair [userId, priority]
    private Map<Integer, int[]> taskMap;
    // TreeSet holding (priority, taskId) with custom ordering
    private TreeSet<TaskKey> set;

    private static class TaskKey {
        int priority;
        int taskId;
        TaskKey(int p, int t) {
            this.priority = p;
            this.taskId = t;
        }
    }

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        set = new TreeSet<>(new Comparator<TaskKey>() {
            @Override
            public int compare(TaskKey a, TaskKey b) {
                if (a.priority != b.priority) {
                    return Integer.compare(b.priority, a.priority); // descending priority
                } else {
                    return Integer.compare(b.taskId, a.taskId); // descending taskId
                }
            }
        });
        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            add(userId, taskId, priority);
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        set.add(new TaskKey(priority, taskId));
    }

    public void edit(int taskId, int newPriority) {
        int[] info = taskMap.get(taskId);
        int userId = info[0];
        int oldPriority = info[1];
        // remove old key
        set.remove(new TaskKey(oldPriority, taskId));
        // update
        taskMap.put(taskId, new int[]{userId, newPriority});
        // insert new key
        set.add(new TaskKey(newPriority, taskId));
    }

    public void rmv(int taskId) {
        int[] info = taskMap.get(taskId);
        int oldPriority = info[1];
        set.remove(new TaskKey(oldPriority, taskId));
        taskMap.remove(taskId);
    }

    public int execTop() {
        if (set.isEmpty()) return -1;
        TaskKey tk = set.first();  // highest priority / taskId
        set.remove(tk);
        int taskId = tk.taskId;
        int[] info = taskMap.get(taskId);
        int userId = info[0];
        taskMap.remove(taskId);
        return userId;
    }
}
