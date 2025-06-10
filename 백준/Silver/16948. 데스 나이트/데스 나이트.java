import java.util.*;
import java.io.*;

class Main {
  static int[][] directions = new int[][]{{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};
  static int[][] dist;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    String[] row = br.readLine().split(" ");
    
    int r1 = Integer.parseInt(row[0]);
    int c1 = Integer.parseInt(row[1]);
    int r2 = Integer.parseInt(row[2]);
    int c2 = Integer.parseInt(row[3]);

    dist = new int[N][N];
    for (int i = 0; i < N; i++) Arrays.fill(dist[i],-1);

    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{r1,c1});
    dist[r1][c1] = 0;

    while(!queue.isEmpty()) {
      int[] curr = queue.poll();

      int cx = curr[0], cy = curr[1];

      for (int[] dir : directions) {
        int nx = dir[0] + cx, ny = dir[1] + cy;

        if ( 0<= nx && nx < N && 0 <=ny && ny < N) {
          if (dist[nx][ny] == -1) {
            dist[nx][ny] = dist[cx][cy] + 1;
            queue.add(new int[]{nx, ny});
          }
        }
      }
    }


    if (dist[r2][c2] == -1) System.out.println(-1);
    else System.out.println(dist[r2][c2]);

    
  }
} 