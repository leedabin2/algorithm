import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    
    int[][] cogwheel = new int[5][8];

    for (int i = 1 ; i <= 4; i++) {
      String row = br.readLine();
      for (int j = 0; j < 8; j++) {
        cogwheel[i][j] = row.charAt(j) - '0';

      }
    }

    int K = Integer.parseInt(br.readLine());

    for (int i = 0; i < K; i++) {
      String[] row = br.readLine().split(" ");

      int rotateNumber = Integer.parseInt(row[0]);
      int dir = Integer.parseInt(row[1]);

      int[] rotation = new int[5];
      rotation[rotateNumber] = dir;


      for (int j = rotateNumber; j > 1; j--) {
        if (cogwheel[j][6] != cogwheel[j-1][2]) {
          rotation[j-1] = -rotation[j];
        } else break;
      }

      for (int j = rotateNumber; j < 4; j++) {
        if (cogwheel[j][2] != cogwheel[j+1][6]) {
          rotation[j+1] = -rotation[j];
        } else break;
      }

      // 회전 
      for (int j = 1; j <= 4; j++) {

        if (rotation[j] == 0) continue;

        if (rotation[j] == 1) {
          int temp  = cogwheel[j][7];

          for (int k = 7; k > 0; k--) {
            cogwheel[j][k] = cogwheel[j][k-1];
          }
          cogwheel[j][0] = temp;
        }
        else if (rotation[j] == -1) {
          int temp = cogwheel[j][0];
          for (int k = 0; k < 7 ; k++) {
            cogwheel[j][k] = cogwheel[j][k+1];
          }
          cogwheel[j][7] = temp;
        }
      }


    }

    int total = 0;
    for (int i = 1; i <= 4; i++) {
      if (cogwheel[i][0] == 1) {
        total += ( 1 << (i-1));
      }
    }

    System.out.println(total);

    
  }
} 