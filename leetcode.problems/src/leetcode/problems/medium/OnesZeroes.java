package leetcode.problems.medium;

/**
 * 
 * https://leetcode.com/problems/ones-and-zeroes/description/
 * 
 * @author gaochf
 *
 */
public class OnesZeroes {
	public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String str : strs) {
			int cntZero = 0, cntOne = 0;
			for (char ch : str.toCharArray()) {
				if (ch == '0') {
					cntZero++;
				} else {
					cntOne++;
				}
			}
			for (int i = m; i >= cntZero; i--) {
				for (int j = n; j >= cntOne; j--) {
					dp[i][j] = Math.max(dp[i][j], dp[i - cntZero][j - cntOne] + 1);
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		OnesZeroes oz = new OnesZeroes(); 
		String[] param = new String[] { "10", "0001", "111001", "1", "0" };
		int m = 5;
		int n = 3;
		System.out.println("result: " + oz.findMaxForm(param, m, n));
	}
}
