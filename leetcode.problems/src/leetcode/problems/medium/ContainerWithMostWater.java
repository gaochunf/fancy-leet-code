package leetcode.problems.medium;

/**
 * 
 * https://leetcode.com/problems/container-with-most-water/description/
 * 
 * @author gaochf
 *
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int result = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = height.length - 1; j > i; j--) {
				if (height[j] >= height[i]) {
					int area = height[i] * (j - i);
					if (area > result) {
						result = area;
					}
					break;
				} else {
					int area = height[j] * (j - i);
					if (area > result) {
						result = area;
					}
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		ContainerWithMostWater cwmw = new ContainerWithMostWater();
		int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println("result: " + cwmw.maxArea(height));
	}
}
