import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int rows = board.length;
        int cols = board[0].length;
        
        int[][] dp = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            dp[i][0] = board[i][0];
            answer = Math.max(dp[i][0],answer);
        }
        
        for (int j = 0; j < cols; j++) {
            dp[0][j] = board[0][j];
            answer = Math.max(dp[0][j],answer);
        }
        
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1])) + 1;
                    answer = Math.max(dp[i][j],answer);
                }
            }
        }


        return answer * answer;
    }
}