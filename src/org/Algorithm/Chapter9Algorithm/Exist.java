package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/6/15. 给出一个二维的字母板和一个单词，寻找字母板网格中是否存在这个单词。
 * 单词可以由按顺序的相邻单元的字母组成，其中相邻单元指的是水平或者垂直方向相邻。每个单元中的字母最多只能使用一次
 */
public class Exist {
	public boolean exist(char[][] board, String word) {
		// write your code here
		if (board == null || board.length <= 0 || board[0].length <= 0) {
			return false;
		}
		if (word.equals("")) {
			return true;
		}
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				boolean res = isWord(board, word, false, visited, board.length - 1, board[0].length - 1, i, j, 0);
				if (res) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isWord(char[][] board, String word, boolean flag, boolean[][] visited, int row, int col, int r,
			int c, int index) {
		if (flag || index == word.length()) {
			return true;
		}
		if (r > row || c > col || r < 0 || c < 0 || visited[r][c] || board[r][c] != word.charAt(index)) {
			return false;
		}
		visited[r][c] = true;
		if (isWord(board, word, false, visited, row, col, r + 1, c, index + 1)
					|| isWord(board, word, false, visited, row, col, r, c + 1, index + 1)
					|| isWord(board, word, false, visited, row, col, r - 1, c, index + 1)
					|| isWord(board, word, false, visited, row, col, r, c - 1, index + 1)) {
		    return true;
        }
		visited[r][c] = false;
		return false;
	}

	public static void main(String[] args) {
		Exist exist = new Exist();
		String a = "ABCE";
		String b = "SFES";
		String c = "ADEE";
		char[][] arr = new char[][] { a.toCharArray(), b.toCharArray(), c.toCharArray() };
		boolean k = exist.exist(arr, "CESEEE");
		System.out.println(k);
	}
}
