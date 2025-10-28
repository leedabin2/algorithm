
import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        
        int[][][] cost = new int[n][n][4];
        
        for (int[][] c : cost)
            for (int[] r : c)
                Arrays.fill(r, Integer.MAX_VALUE);
        
        Deque<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{0, 0, 1, 0});
        q.add(new int[]{0, 0, 3, 0});
        cost[0][0][1] = 0;
        cost[0][0][3] = 0;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            int cx = now[0], cy = now[1], dir = now[2], c = now[3];
            
            if (cx == n-1 && cy == n-1) {
                answer = Math.min(c, answer);
                continue;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + cx;
                int ny = dy[d] + cy;
                
                if (nx >= n || ny >= n || nx < 0 || ny < 0) continue;
                if (board[nx][ny] == 1) continue; 
                
                int nextCost = c + 100;
                if (dir != d) nextCost += 500;
                
                if (cost[nx][ny][d] > nextCost) {
                    cost[nx][ny][d] = nextCost;
                    q.add(new int[]{nx, ny, d, nextCost});
                }
            
                
            }
        }
        return answer;
    }
}