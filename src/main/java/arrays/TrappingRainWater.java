package arrays;

public class TrappingRainWater {
    TrappingRainWater() {
    }

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        int[] height = null;

        height = new int[]{0, 5, 1, 5, 1, 2, 1, 2, 1, 2, 1, 0};
        System.out.println("7: " + trw.trap(height));


        height = new int[]{0, 1, 3, 2, 0};
        System.out.println("0: " + trw.trap(height));

        height = new int[]{0, 5, 1, 2, 1, 3, 1, 6, 0};
        System.out.println("17: " + trw.trap(height));

        height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("6: " + trw.trap(height));

    }

    public int trap(int[] height) {
        if (height.length < 3) return 0;

        int ans = 0;
        int l = 0;
        int r = height.length - 1;

        // find the left and right edge which can hold water
        while (l < r && height[l] <= height[l + 1]) l++;
        while (l < r && height[r] <= height[r - 1]) r--;

        while (l < r) {
            int left = height[l];
            int right = height[r];
            if (left <= right) {
                // add volume until an edge larger than the left edge
                while (l < r && left >= height[++l]) {
                    ans += left - height[l];
                }
            } else {
                // add volume until an edge larger than the right volum
                while (l < r && height[--r] <= right) {
                    ans += right - height[r];
                }
            }
        }
        return ans;
    }
}
