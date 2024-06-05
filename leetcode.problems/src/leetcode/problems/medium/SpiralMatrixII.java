package leetcode.problems.medium;

/**
 * 
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 * 
 * @author gaochf
 *
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];

		int[][] direction = new int[4][2];
		// right
		direction[0][0] = 0;
		direction[0][1] = 1;
		// down
		direction[1][0] = 1;
		direction[1][1] = 0;
		// left
		direction[2][0] = 0;
		direction[2][1] = -1;
		// up
		direction[3][0] = -1;
		direction[3][1] = 0;

		int value = 1;
		int currentDirection = 0;
		int indexi = 0;
		int indexj = 0;
		while (value <= n * n) {
			result[indexi][indexj] = value;
			// calculate next index (i,j)
			int nexti = indexi + direction[currentDirection][0];
			int nextj = indexj + direction[currentDirection][1];
			if (nexti >= n || nextj >= n || nexti < 0 || nextj < 0 || result[nexti][nextj] != 0) {
				currentDirection = (currentDirection + 1) % 4;
			}

			indexi = indexi + direction[currentDirection][0];
			indexj = indexj + direction[currentDirection][1];

			value++;
		}
		return result;
	}

	public static void main(String[] args) {
		SpiralMatrixII smii = new SpiralMatrixII();
		int param = 3;
		System.out.println("param " + param + ":" + smii.generateMatrix(param));
	}
}
