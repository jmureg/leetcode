package arrays;

import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/task-scheduler/

Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

 */
public class TaskScheduler {
    private int coolDown;

    TaskScheduler(int cd) {
        this.coolDown = cd;
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler(2);
        int[] tasks = null;

        tasks = new int[]{1, 1, 1, 2, 2, 3, 1, 1};
        System.out.println("15: " + ts.execute(tasks));

        tasks = new int[]{1, 1, 2, 3, 1};
        System.out.println("7: " + ts.execute(tasks));

        tasks = new int[]{1, 2, 3, 1, 1};
        System.out.println("4: " + ts.execute(tasks));
    }

    public int execute(int[] tasks) {
        int ans = 0;
        List<Integer> cache = initCache();

        for (int currentTask : tasks
        ) {
            if (cache.contains(currentTask)) {
                int pos = cache.indexOf(currentTask);
                ans += pos;
            }
            ans++;
            cache.remove(0);
            cache.add(currentTask);
        }

        return ans;
    }

    private List<Integer> initCache() {
        List<Integer> cache = new LinkedList<Integer>();
        for (int i = 0; i <= this.coolDown; i++) {
            cache.add(0);
        }
        return cache;
    }

}
