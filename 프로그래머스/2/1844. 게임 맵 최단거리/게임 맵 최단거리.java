import java.util.*;
// 5 : 55
class Solution {
  static int n, m;
    static boolean[][] visited;
    static int[][] directions;
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        answer = bfs(0, 0, 1, maps);
        return answer;
    }
    private static int bfs(int x, int y,int d, int[][] maps) {
      Deque<int[]> queue = new ArrayDeque<>();
      queue.add(new int[]{x,y,d});
      visited[x][y] = true;

      while (!queue.isEmpty()) {
        int[] c = queue.poll();
        int cx = c[0];
        int cy = c[1];
        int dist = c[2];

        if (cx == n-1 && cy == m-1) {
          return dist;
        }

        for (int[] dir : directions) {
          int nx = dir[0] + cx;
          int ny = dir[1] + cy;

          if ( 0 <= nx && nx < n && 0<= ny && ny < m && maps[nx][ny] == 1) {
            if (!visited[nx][ny]) {
              visited[nx][ny] = true;
              queue.add(new int[]{nx,ny,dist+1});
            }
          }
        }
      }

      return -1;

    }

}