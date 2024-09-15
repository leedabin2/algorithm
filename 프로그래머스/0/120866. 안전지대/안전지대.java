class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int m = board.length;
     
        int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
            
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < m; j++) {
                if (board[i][j] == 1) {
     
                    for (int[] d : dist) {
                        int nextX = d[0] + i;
                        int nextY = d[1] + j;
                    
                        if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                            if (board[nextX][nextY] == 0) {
                                board[nextX][nextY] = 2;
                            }
                        }
                    }
                }
            }
        }
         for (int i = 0; i < board.length; i++) {
            for (int j = 0 ; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}