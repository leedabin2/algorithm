import java.io.*;

class Main {
  static int N, M;
  static int[][] d = new int[][]{{0,0}, {0,1}, {0, -1}, {-1,0}, {1,0}};
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] st = br.readLine().split(" ");

      N = Integer.parseInt(st[0]);
      M = Integer.parseInt(st[1]);

      int x = Integer.parseInt(st[2]);
      int y = Integer.parseInt(st[3]);
      int K = Integer.parseInt(st[4]);

      int[][] map = new int[N][M];

       // 1 : 위, 2 : 앞, 3 : 오른쪽, 4 : 왼쪽, 5 : 뒤, 6: 바닥
      int[] dice = new int[7];

      for (int i = 0; i < N; i++) {
        String[] row = br.readLine().split(" ");
        for (int j = 0; j < M; j++) {
          map[i][j] = Integer.parseInt(row[j]);
        }
      }

      int[] cmd = new int[K];

      String[] line = br.readLine().split(" ");
      for (int i = 0; i < K; i++) {
          cmd[i] = Integer.parseInt(line[i]);
      }

      StringBuilder sb = new StringBuilder();

      for (int i =0; i < K; i++) {
        // 주사위 명령 대로 이동
        int dir = cmd[i];
        int nx = d[dir][0] + x;
        int ny = d[dir][1] + y;

        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

        x = nx;
        y = ny;

        moveDice(dir, dice);

        if (map[x][y] == 0) {
          map[x][y] = dice[6]; // 바닥면에 복사
        } else {
          dice[6] = map[x][y];
          map[x][y] = 0;
        }

        sb.append(dice[1]).append("\n");
      }

      System.out.println(sb.toString());
      
   } 
  
    static void moveDice(int dir, int[] dice) {
    int tmp = dice[1];
    switch (dir) {
        case 1: // 동
          dice[1] = dice[4];
          dice[4] = dice[6];
          dice[6] = dice[3];
          dice[3] = tmp;      
        break;

        case 2: // 서
          dice[1] = dice[3];
          dice[3] = dice[6];
          dice[6] = dice[4];
          dice[4] = tmp;
        break;

        case 3: // 남
          dice[1] = dice[5];
          dice[5] = dice[6];
          dice[6] = dice[2];
          dice[2] = tmp;
          break;
        
        case 4: // 북
          dice[1] = dice[2];
          dice[2] = dice[6];
          dice[6] = dice[5];
          dice[5] = tmp;
          break;
    }
   }
}