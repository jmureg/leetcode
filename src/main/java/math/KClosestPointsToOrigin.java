package math;

import java.util.Arrays;
import java.util.PriorityQueue;

/*

https://leetcode.com/problems/k-closest-points-to-origin/

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 */
public class KClosestPointsToOrigin {
    KClosestPointsToOrigin() {
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin kc = new KClosestPointsToOrigin();
        int[][] points = null;
        int k = 0;

        points = new int[][]{{1, 3}, {-2, 2}};
        k = 1;
        System.out.println("{-2,2}" + Arrays.toString(kc.kClosest(points, k)));

        points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        k = 2;
        System.out.println("[[3,3],[-2,4]]" + Arrays.toString(kc.kClosest(points, k)));
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> cache = new PriorityQueue<>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));
        int max = 0;
        for (int[] point : points
        ) {
            cache.add(point);
            if (cache.size() > K) {
                cache.poll();
            }
        }
        int[][] ans = new int[cache.size()][];
        int counter = 0;
        for (int[] point : cache
        ) {
            ans[counter++] = point;
        }
        return ans;
    }

    //O(n*log(n))
    public int[][] kClosest1(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * a[0] + b[1] * a[1]);
        return Arrays.copyOfRange(points, 0, K);
    }

    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(K, (p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }
}
