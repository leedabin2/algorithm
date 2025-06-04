 import java.util.*;
import java.io.*;

class Main {
  static final int INF = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    
    int testCase = 0;

    while(true) {
      int N = Integer.parseInt(br.readLine());

      if (N == 0) break;

      int[][] graph = new int[N][N];

      for (int i =0 ; i < N; i++) {
        String[] row = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
          graph[i][j] = Integer.parseInt(row[j]);
        }
      }

      int[][] dist = new int[N][N];
      int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

      for (int i = 0; i < N; i++) {
        Arrays.fill(dist[i], INF);
      }


      PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
      pq.add(new int[]{0,0, graph[0][0]}); // x y cost
      dist[0][0] = graph[0][0];


      while(!pq.isEmpty()) {
        int[] curr = pq.poll();

        int x = curr[0], y = curr[1], cost = curr[2];

        if (dist[x][y] < cost) continue;

        for (int[] dir : directions) {
          int nx = dir[0] + x, ny = dir[1] + y;

          if (0<=nx && nx < N && 0<=ny && ny < N) {
            if (dist[nx][ny] > graph[nx][ny] + dist[x][y]) {
              dist[nx][ny] = graph[nx][ny] + dist[x][y];
              pq.add(new int[]{nx, ny, graph[nx][ny] + dist[x][y]});
            }
          }
        }
        
      }
      testCase++;

      System.out.println("Problem " + testCase +": " + dist[N-1][N-1]);

    }
  }
} 