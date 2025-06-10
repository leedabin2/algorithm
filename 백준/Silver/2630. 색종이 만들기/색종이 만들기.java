import java.util.*;
import java.io.*;

class Main {
  static int[][] papers;
  static int white = 0;
  static int blue = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    
    papers = new int[N][N];
    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        papers[i][j] = Integer.parseInt(row[j]);
      }
    }

    check(0, 0, N);

    System.out.println(white);
    System.out.println(blue);

  }

  private static void check(int x, int y, int size) {
    if (isSame(x,y,size)) {
      if (papers[x][y] == 0) white++;
      else blue++;
      return;
    }

    int half = size / 2;
    check(x, y, half); 
    check(x, y+half, half);
    check(x+half, y, half);
    check(x+half, y+half, half);
  }

  private static boolean isSame(int x, int y, int size) {
    int value = papers[x][y];
    for (int i = x; i < x+size; i++ ) {
      for (int j = y; j < y+size; j++) {
        if (papers[i][j] != value) return false;
      }
    }
    return true;
  }
} 