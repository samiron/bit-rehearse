package of.samiron.leetcode;

import java.util.List;

public class WordSearch {

  public boolean exist(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;

    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        if (dfs(board, word, x, y, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(final char[][] board, final String word, final int x, final int y, final int i) {

    if (i == word.length()) {
      // this means the match is already found in the previous iteration.
      return true;
    }

    if (x >= board.length || x < 0 || y >= board[0].length || y < 0 || board[x][y] != word.charAt(i) || board[x][y] == '#') {
      return false;
    }

    var originalChar = board[x][y];

    board[x][y] = '#';
    boolean found = dfs(board, word, x + 1, y, i + 1) ||
      dfs(board, word, x - 1, y, i + 1) ||
      dfs(board, word, x, y + 1, i + 1) ||
      dfs(board, word, x, y - 1, i + 1);

    board[x][y] = originalChar;

    return found;
  }

  record Input(char[][] board, String word) {
  }

  public static void main(String[] args) {
    var inputs = List.of(
      new Input(new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
      }, "ABCCED"),

      new Input(new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
      }, "SEE"),

      new Input(new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}
      }, "ABCB")

    );

    for (var input : inputs) {
      var result = new WordSearch().exist(input.board, input.word);
      System.out.printf("Search for %s => %b\n", input.word, result);
    }

  }

}
