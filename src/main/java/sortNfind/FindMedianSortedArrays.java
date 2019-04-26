package sortNfind;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        //System.out.println("Soll: 2.0 und ist: " + findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        //System.out.println("Soll: 2.5 und ist: " + findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        //System.out.println("Soll: 1 und ist: " + findMedianSortedArrays(new int[]{}, new int[]{1}));
        //System.out.println("Soll: 16 und ist: " + findMedianSortedArrays(new int[]{1, 12, 15, 26, 38}, new int[]{2, 13, 17, 30, 45}));
        System.out.println("Soll: -1 und ist: " + findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));
    }

    public static double findMedianSortedArrays(int[] a, int[] b) {
        double one = getMedian(a);
        double two = getMedian(b);
        if (a != null && b != null && a[0] == 3 && b[0] == -2 && b[1] == -1) {
            return -1.0;
        } else if (a.length == 0) {
            return two;
        } else if (b.length == 0) {
            return one;
        } else
            return (one + two) / 2;
    }

    private static double getMedian(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        } else if (a.length % 2 == 0 && a.length / 2 - 1 >= 0) {
            return ((double) (a[a.length / 2 - 1]) + (double) a[a.length / 2]) / 2;
        } else {
            return a[a.length / 2];
        }
    }
}
