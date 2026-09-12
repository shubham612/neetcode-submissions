class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if (word.length() > m * n) return false;   // pruning

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (helper(board, word, i, j, m, n, 0, visited))
                    return true;
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int m, int n, int idx, boolean[][] visited) {
        if (idx == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(idx))
            return false;

        visited[i][j] = true;
        boolean found = helper(board, word, i+1, j, m, n, idx+1, visited)
                      || helper(board, word, i-1, j, m, n, idx+1, visited)
                      || helper(board, word, i, j+1, m, n, idx+1, visited)
                      || helper(board, word, i, j-1, m, n, idx+1, visited);
        visited[i][j] = false;   // backtrack
        return found;
    }
}