package arrays;

public class OverlappingRectangles {

    OverlappingRectangles(){

    }
    public static void main(String args[] ) throws Exception {
        OverlappingRectangles olr = new OverlappingRectangles();
        int[] one = null;
        int[] two = null;

        one = new int[]{7,8,13,15};
        two = new int[]{10,8,12,20};

        System.out.println("true: " + olr.isRectangleOverlap(one, two));

        one = new int[]{0,0,2,2};
        two = new int[]{1,1,3,3};
        System.out.println("true: " + olr.isRectangleOverlap(one, two));

        one = new int[]{0,0,2,2};
        two = new int[]{3,3,4,4};
        System.out.println("false: " + olr.isRectangleOverlap(one, two));

        one = new int[]{0,0,1,1};
        two = new int[]{1,0,2,1};
        System.out.println("false: " + olr.isRectangleOverlap(one, two));
    }

    public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
        return !(rec2[0] >= rec1[2] || rec2[1] >= rec1[3]
                || rec1[0] >= rec2[3] || rec1[1] >= rec2[3]);
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }


    public boolean isRectangleOverlapCases(int[] rec1, int[] rec2) {
        if(rec1==null || rec2==null) {
            return false;
        }

        int[] one = null;
        int[] two = null;

        // order to avoid case duplication
        if(rec1[0]<rec2[0] && rec1[1]<rec2[1]) {
            one = rec1;
            two = rec2;
            if (one[0]<=two[0] && one[1]<=two[1] && two[0]<=one[2] && two[1]<=one[3]) {
                return true;
            }
        } else if (rec1[0]>rec2[0] && rec1[1]<rec2[0]){
            one = rec2;
            two = rec2;
            if (one[3]<=two[3] && one[2]<=two[2] && two[2]>one[0] && two[1]<one[3]) {
                return true;
            }
        }
        return false;
    }
}
