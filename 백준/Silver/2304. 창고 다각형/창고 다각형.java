import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    List<int[]> gidoong = new ArrayList<>();

    for (int i =0 ;i < N; i++) {
      String[] st = br.readLine().split(" ");
      int x = Integer.parseInt(st[0]);
      int h = Integer.parseInt(st[1]);

      gidoong.add(new int[]{x,h});

    }

    Collections.sort(gidoong, (a,b) -> Integer.compare(a[0], b[0]));

    int width = 0;
    
    int maxHeight = 0;
    int maxIndex = 0;

    for (int i =0; i< N; i++) {
      if (gidoong.get(i)[1] > maxHeight) {
        maxHeight = gidoong.get(i)[1];
        maxIndex = i;
      }
    }

    int leftHeight = gidoong.get(0)[1];
    int leftIndex = gidoong.get(0)[0];
    for (int i = 1; i <= maxIndex; i++) {
      int x = gidoong.get(i)[0];
      int h = gidoong.get(i)[1];
      if (h > leftHeight) {
        width += (x - leftIndex) * leftHeight;
        leftHeight = h;
        leftIndex = x;
      }
    }

    
    int rightHeight = gidoong.get(N-1)[1];
    int rightIndex = gidoong.get(N-1)[0];
    for (int i = N-2; i >= maxIndex; i--) {
      int x = gidoong.get(i)[0];
      int h = gidoong.get(i)[1];
      if (h > rightHeight) {
        width += (rightIndex - x) * rightHeight;
        rightHeight = h;
        rightIndex = x;
      }
    }

    int left = gidoong.get(maxIndex)[0];
    int right = gidoong.get(maxIndex)[0];
    for (int i = maxIndex + 1; i < N; i++) {
      if (gidoong.get(i)[1] == maxHeight) {
        right = gidoong.get(i)[0];
      }
    }
    for (int i = maxIndex - 1; i >= 0; i--) {
      if (gidoong.get(i)[1] == maxHeight) {
        left = gidoong.get(i)[0];
      }
    }

    width += (right - left + 1) * maxHeight;

    System.out.print(width);

  }
}