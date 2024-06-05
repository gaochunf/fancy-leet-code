package leetcode.problems.medium;

/**
 * 
 * https://leetcode.com/problems/word-search/description/
 * 
 * @author gaochf
 *
 */
public class WordSearch {

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (exists(board, word, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean exists(char[][] board, String word, int index, int i, int j) {
		if (index == word.length()) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == ' ') {
			return false;
		}

		if (board[i][j] == word.charAt(index)) {
			char temp = word.charAt(index);
			board[i][j] = ' ';
			if (exists(board, word, index + 1, i + 1, j) || exists(board, word, index + 1, i, j + 1)
					|| exists(board, word, index + 1, i - 1, j) || exists(board, word, index + 1, i, j - 1)) {
				return true;
			}
			board[i][j] = temp;
		}

		return false;
	}

	public static void main(String[] args) {
		WordSearch ws = new WordSearch();

		char[][] board = new char[3][4];
		board[0] = new char[] { 'A', 'B', 'C', 'E' };
		board[1] = new char[] { 'S', 'F', 'C', 'S' };
		board[2] = new char[] { 'A', 'D', 'E', 'E' };
		String word = "SEE";
		System.out.println(word + ": result: " + ws.exist(board, word));
	}

}
