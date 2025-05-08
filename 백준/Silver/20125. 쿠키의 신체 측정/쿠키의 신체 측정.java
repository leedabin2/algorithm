import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    
    Character[][] board = new Character[N][N];
    for (int i = 0; i < N; i++) {
      String[] st = br.readLine().split("");
      for (int j = 0; j < N; j++) {
        board[i][j] = st[j].charAt(0);
      }
    }

    int head = 0;
    StringBuilder sb = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    int x = 0;
    int y = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == '*') {
          head++;
          y = j;
          break;
        }
      }
      if(head == 1) {
        x = i + 1;
        sb.append((x + 1)).append(" ").append((y + 1)).append("\n"); 
        break;
      }
    }
    int leftarm = 0;
    for (int i = y-1 ; i >= 0; i--) {
      if (board[x][i] == '*') leftarm++;
      else break;
    }
    int rightarm = 0;
    for (int i = y+1 ; i < N; i++) {
      if (board[x][i] == '*') rightarm++;
      else break;
    }

    int line = 0;
    for (int i = x+1; i < N; i++) {
      if (board[i][y] == '*') line++;
      else break;
    }

    int leftstart = x + line + 1;
    int leftleg = 0;
    for (int i = leftstart ; i < N; i++) {
      if (board[i][y-1] == '*') leftleg++;
      else break;
    }

    int rightleg = 0;
    for (int i = leftstart; i < N; i++) {
      if (board[i][y+1] == '*') rightleg++;
      else break;
    }


    sb2.append(leftarm).append(" ")
       .append(rightarm).append(" ")
       .append(line).append(" ")
       .append(leftleg).append(" ")
       .append(rightleg);


    System.out.print(sb);
    System.out.println(sb2);
    




  }
}