package leetCode;

// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {

    public int trap(int[] height) {
        int left = 0, right = height.length -1, leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;

        int trapped = 0;
        while(left < right) {
            if (height[left] < height[right]) {

                if (height[left] >= leftMax)
                    leftMax = height[left];
                else trapped += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    trapped += rightMax - height[right];
                right--;
            }
        }
        return trapped;
    }
}
