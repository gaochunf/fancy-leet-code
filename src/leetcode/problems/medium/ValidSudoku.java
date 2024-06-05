package leetcode.problems.medium;

/**
 * 
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * @author gaochf
 *
 */
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		int[] count = new int[9];
		// check rows
		for (int row = 0; row < 9; row++) {
			// reset
			for (int i = 0; i < 9; i++) {
				count[i] = 0;
			}
			for (int column = 0; column < 9; column++) {
				char value = board[row][column];
				if (value != '.') {
					int valueint = (int) (value - '1');
					count[valueint]++;
				}
			}
			// check
			for (int i = 0; i < 9; i++) {
				if (count[i] > 1) {
					return false;
				}
			}
		}
		// check columns
		for (int column = 0; column < 9; column++) {
			// reset
			for (int i = 0; i < 9; i++) {
				count[i] = 0;
			}
			for (int row = 0; row < 9; row++) {
				char value = board[row][column];
				if (value != '.') {
					int valueint = (int) (value - '1');
					count[valueint]++;
				}
			}
			// check
			for (int i = 0; i < 9; i++) {
				if (count[i] > 1) {
					return false;
				}
			}
		}
		// check sub-box
		for (int boxi = 0; boxi < 7; boxi = boxi + 3) {
			for (int boxj = 0; boxj < 7; boxj = boxj + 3) {
				// reset
				for (int i = 0; i < 9; i++) {
					count[i] = 0;
				}
				// box
				for (int subboxi = boxi; subboxi - boxi < 3; subboxi++) {
					for (int subboxj = boxj; subboxj - boxj < 3; subboxj++) {
						char value = board[subboxi][subboxj];
						if (value != '.') {
							int valueint = (int) (value - '1');
							count[valueint]++;
						}
					}
				}
				// check
				for (int i = 0; i < 9; i++) {
					if (count[i] > 1) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {

		ValidSudoku vs = new ValidSudoku();

		char[][] param = new char[9][9];
		param[0] = new char[] { '5', '3', '.', '.', '7', '.', '.', '.', '.' };
		param[1] = new char[] { '6', '.', '.', '1', '9', '5', '.', '.', '.' };
		param[2] = new char[] { '.', '9', '8', '.', '.', '.', '.', '6', '.' };
		param[3] = new char[] { '8', '.', '.', '.', '6', '.', '.', '.', '3' };
		param[4] = new char[] { '4', '.', '.', '8', '.', '3', '.', '.', '1' };
		param[5] = new char[] { '7', '.', '.', '.', '2', '.', '.', '.', '6' };
		param[6] = new char[] { '.', '6', '.', '.', '.', '.', '2', '8', '.' };
		param[7] = new char[] { '.', '.', '.', '4', '1', '9', '.', '.', '5' };
		param[8] = new char[] { '.', '.', '.', '.', '8', '.', '.', '7', '9' };
		System.out.println(" result : " + vs.isValidSudoku(param));

	}

}
