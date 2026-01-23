import java.io.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");

      int H = Integer.parseInt(st[0]);
      int W = Integer.parseInt(st[1]);
      int X = Integer.parseInt(st[2]);
      int Y = Integer.parseInt(st[3]);


      int[][] A = new int[H][W];
      int[][] B = new int[H+X][W+Y];

      for (int i = 0; i < H+X; i++) {
        String[] row = br.readLine().split(" ");
        for (int j = 0; j < W+Y; j++) {
          B[i][j] = Integer.parseInt(row[j]);
        }
      }

      for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
          if (i >= X && j >= Y) {
            // 겹치는 부분
            A[i][j] = B[i][j] - A[i-X][j-Y];
          } else {
            A[i][j] = B[i][j];
          }
        }
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
          if (j == W-1) sb.append(A[i][j]);
          else sb.append(A[i][j]).append(" ");
        }
        sb.append("\n");
      }

      System.out.println(sb.toString());


    
   }
}