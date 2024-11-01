import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        // 외곽선 1, 내부는 2
        int[][] graph = new int[102][102];
   
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int x2 = r[2] * 2;
            int y1 = r[1] * 2;
            int y2 = r[3] * 2;
            
            for (int i = x1 ; i <x2+1; i++) {
                if (graph[i][y1] != 2) graph[i][y1] = 1;
                if (graph[i][y2] != 2) graph[i][y2] = 1;
            }
            for (int j = y1; j < y2+1; j++) {
                if (graph[x1][j] != 2) graph[x1][j] = 1;
                if (graph[x2][j] != 2) graph[x2][j] = 1;
            }
            
            for (int i = x1+1 ; i < x2; i++) {
                for (int j = y1+1; j < y2; j++) {
                    graph[i][j] = 2;
                }
            }
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {characterX * 2, characterY * 2, 0});
        boolean[][] visited = new boolean[102][102];
        visited[characterX * 2][characterY * 2] = true;
        int[][] dist = {{1,0},{-1,0},{0,-1},{0,1}};
 
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currDistance = curr[2];
            
            if (currX == itemX * 2 && currY == itemY * 2) {
                answer = currDistance / 2;
                break;
            }
            
            for (int[] d : dist) {
                int nx = d[0] + currX;
                int ny = d[1] + currY;
                
                if ( 0>nx || nx > 102 || 0 > ny || ny > 102 ) {
                    continue;
                }
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx,ny,currDistance+1});
                }
            }   
            
        }
    
        return answer;
    }
}