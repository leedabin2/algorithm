import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    char[][] room = new char[N][N];
    for (int i =0; i < N; i++) {
      String st = br.readLine();
      for (int j = 0; j < N; j++) {
        room[i][j] = st.charAt(j);
      }
    }

    int garo = 0;
    int sero = 0;
    for (int i =0 ; i < N; i++) {
      int count = 0;
      for (int j = 0; j < N; j++) {
        if (room[i][j] == '.') {
          count++;
        } else {
          if (count >= 2) garo++;
          count = 0;
        }
      }
      if (count >= 2) {
        garo++;
      }
      
    }

    for (int j = 0; j < N; j++) {
      int count = 0;
      for (int i = 0; i < N; i++) {
        if (room[i][j] == '.') count++; 
        else {
          if (count >= 2) sero++;
          count =0;
        }
      } 
      if (count >= 2) sero++;
    }

    System.out.println(garo + " " + sero);
  }
}