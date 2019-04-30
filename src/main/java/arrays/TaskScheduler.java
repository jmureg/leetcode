package arrays;

import java.util.*;

public class TaskScheduler {
    private int coolDown;
    
    TaskScheduler(int cd){
        this.coolDown = cd;
    }
    
    public int execute(int[] tasks) {
        int ans = 0;
        List<Integer> cache = initCache();

        for (int currentTask:tasks
             ) {
            if(cache.contains(currentTask)) {
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
        for (int i=0; i<=this.coolDown; i++) {
            cache.add(0);
        }

        return cache;
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler(2);
        int[] tasks = null;

        tasks = new int[]{1, 1, 1, 2, 2, 3, 1, 1};
        System.out.println("15: " + ts.execute(tasks));

        tasks = new int[]{1, 1, 2, 3, 1};
        System.out.println("7: " + ts.execute(tasks));

        tasks = new int[]{1, 2, 3, 1};
        System.out.println("4: " + ts.execute(tasks));


    }

}
