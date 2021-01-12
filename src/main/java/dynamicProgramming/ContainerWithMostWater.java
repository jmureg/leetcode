package dynamicProgramming;

/*
https://leetcode.com/problems/container-with-most-water/
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater container = new ContainerWithMostWater();
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("epectation 49: " + container.maxAreaIntuitive(input));

        input = new int[]{1, 1};
        System.out.println("epectation 1: " + container.maxAreaIntuitive(input));

        input = new int[]{4,3,2,1,4};
        System.out.println("epectation 16: " + container.maxAreaIntuitive(input));

        input = new int[]{1,2,1};
        System.out.println("epectation 2: " + container.maxAreaIntuitive(input));

        input = new int[]{1,2};
        System.out.println("epectation 1: " + container.maxAreaIntuitive(input));
    }

    public int maxAreaIntuitive(int[] height) {
        int currentMax = 0;
        if(height.length==2) {
            return Math.min(height[0],height[1]);
        } else {
            for(int i=0; i<height.length-1; i++) {
                for(int j=i; j<height.length; j++) {
                    int min = Math.min(height[i], height[j]);
                    int currentArea = (j-i) * min;

                    if(currentArea>currentMax) {
                        currentMax = currentArea;
                        //System.out.println("new max with: " + currentArea + " and i: " + height[i] + " and j: " + height[j]);
                    }
                }
            }
        }
        return currentMax;
    }

}
