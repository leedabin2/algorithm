import java.util.*;
import java.io.*;

class Main {
  static int[][] A = new int[100][100]; 
  static int rSize = 3, cSize = 3; // 초기 크기
  static int answer = 0;
  static int r, c, k;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

 
    String[] st = br.readLine().split(" ");

    r = Integer.parseInt(st[0]) - 1;
    c = Integer.parseInt(st[1]) - 1;

    k = Integer.parseInt(st[2]);


    for (int i =0 ;i < 3; i++) {
      String[] row = br.readLine().split(" ");

      for (int j =0; j < 3; j++) {
        A[i][j] = Integer.parseInt(row[j]);
      }
    }

    while(true) {
    
      if (A[r][c] == k) {
        System.out.println(answer);
        return;
      } else if (answer > 100) {
        System.out.println(-1);
        return;
      }

      if (rSize >= cSize) {
        // R연산 
        rSort();
      } else if (rSize < cSize) {
        cSort();
      }
      answer++;

    }


  }
  static void rSort() {
    int maxCol = 0; // 가장 긴 행의 길이를 저장

       // 수의 등장 횟수가 작은 거 먼저, 같으면 수의 크기가 작은 거 먼저
    for (int i =0; i < rSize; i++) {
       Map<Integer, Integer> count = new HashMap<>();

      for (int j = 0; j < cSize; j++ ) {
        int val = A[i][j];
        if (val == 0) continue;
        count.put(val, count.getOrDefault(val,0)+1);
      }

      List<int[]> sorted = new ArrayList<>();
      for (Map.Entry<Integer, Integer> entry : count.entrySet()){
        sorted.add(new int[]{entry.getKey(), entry.getValue()});
      }
      
      // 횟수 - 오름차순, 같으면 숫자 오름차순
      sorted.sort( (a, b) -> {
        if (a[1] == b[1]) return a[0] - b[0];
        return a[1] - b[1];
      });

      int idx = 0;
      for (int[] pair : sorted) {
        if (idx >= 100) break;
        A[i][idx++] = pair[0];
        if (idx >= 100) break;
        A[i][idx++] = pair[1];
      }

      while(idx < cSize) {
        A[i][idx++] = 0;
      }

      maxCol = Math.max(maxCol, idx);


    }
    cSize = maxCol; 
  }
  static void cSort() {
    int maxRow = 0;
    for (int j =0; j < cSize; j++) {
      Map<Integer, Integer> count = new HashMap<>();
      for (int i = 0; i < rSize; i++) {
        int val = A[i][j];
        if (val == 0) continue;
        count.put(val, count.getOrDefault(val,0) + 1);
      }

      List<int[]> sorted = new ArrayList<>();

      for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            sorted.add(new int[]{entry.getKey(), entry.getValue()});
      }

      sorted.sort((a, b) -> {
        if (a[1] == b[1]) return a[0] - b[0];
        return a[1] - b[1];
      });

      int idx = 0;
        for (int[] pair : sorted) {
            if (idx >= 100) break;
            A[idx++][j] = pair[0];
            if (idx >= 100) break;
            A[idx++][j] = pair[1];
        }

        while(idx < rSize) {
          A[idx++][j] = 0;
        }

        maxRow = Math.max(maxRow, idx);
    }

    rSize = maxRow;

  }
} 