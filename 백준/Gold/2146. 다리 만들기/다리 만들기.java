import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }
        
        // 섬 구분하기
        visited = new boolean[N][N];
        int label = 2; 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    bfsLable(i, j, label);
                    label++;
                }
            }
        }
        
        // 다리 만들기 
        int answer = Integer.MAX_VALUE; 
        for (int l = 2; l <= label; l++) {
          answer = Math.min(bfsBridge(l), answer);
        }
        System.out.println(answer);
    }

    private static int bfsBridge(int label) {
      Deque<int[]> queue = new ArrayDeque<>();
      int[][] dist = new int[N][N];
      for (int[] d: dist) Arrays.fill(d, -1);
      for (int i =0 ; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (board[i][j] == label) {
            queue.add(new int[]{i, j});
            dist[i][j] = 0;
          }
        }
      }

      while(!queue.isEmpty()) {
        int[] curr = queue.poll();
        int cx =curr[0], cy = curr[1];

        for (int[] dir : directions) {
          int nx = dir[0] + cx, ny = dir[1] + cy;
          if (0 <= nx && nx < N && 0 <= ny && ny < N) {
            if (board[nx][ny] != label && board[nx][ny] != 0 ) {
              // 다른 섬에 도착했을 때
              return dist[cx][cy];
            }
            if (board[nx][ny] == 0 && dist[nx][ny] == -1) {
              dist[nx][ny] = dist[cx][cy] + 1;
              queue.add(new int[]{nx, ny});
            }
          }
        }
      }
      return Integer.MAX_VALUE;
    }
    
    private static void bfsLable(int x, int y, int label) {
        visited[x][y] = true;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        board[x][y] = label;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0], cy = curr[1];
            
            for (int[] dir : directions) {
                int nx = dir[0] + cx, ny = dir[1] + cy;
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (board[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        board[nx][ny] = label;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}