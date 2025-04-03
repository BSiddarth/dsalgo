import java.util.Arrays;

public class TrappingRainWater {

    public static void main(String[] args) {
        int [] array = {0,1,0,2,1,0,1,3,2,1,2,1};
        int [] leftMax = new int[array.length];
        int [] rightMax = new int[array.length];
        leftMax[0] = array[0];
        rightMax[array.length - 1] = array[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], array[i]);
        }
        for (int i = array.length-2 ; i >=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], array[i]);
        }
     int maxwater = 0;
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));
        int totalWater = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            totalWater = Math.min(rightMax[i] , leftMax[i]);
            maxwater += totalWater-array[i];
        }
        System.out.println(maxwater);
    }
}
