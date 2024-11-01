import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        Deque<int[]> q= new ArrayDeque<>();
        q.offer(new int[] {0,0,1});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            int distance = curr[2];
            
            if (currX == n-1 && currY == m-1) {
                return distance;
            }
            
            for (int[] d : dist) {
                int nx = d[0] + currX;
                int ny = d[1] + currY;
                
                if (0 > nx || nx > n-1 || 0 > ny || ny > m-1) {
                    continue;
                }
                
                if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx,ny,distance+1});
                }
            }
        }
        return -1;
    }
}