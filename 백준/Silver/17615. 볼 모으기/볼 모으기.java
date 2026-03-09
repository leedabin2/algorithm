import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String input = br.readLine();

    int leftRed = 0;
    int rightRed = 0;
    int leftBlue = 0;
    int rightBlue = 0;

    int totalRed = 0;
    int totalBlue = 0;

    for (int i = 0; i < N; i++) {
      char color = input.charAt(i);
      if (color == 'R') totalRed++;
      else if (color == 'B') totalBlue++;
    }

    while (leftRed < N && input.charAt(leftRed) == 'R') {
      leftRed++;
    }

    int idx = N-1;
    while (idx >= 0 && input.charAt(idx) == 'R') {
      rightRed++;
      idx--;
    }

    while (leftBlue < N && input.charAt(leftBlue) == 'B') {
      leftBlue++;
    }

    idx = N-1;
    while (idx >= 0 && input.charAt(idx) == 'B') {
      rightBlue++;
      idx--;
    }


    int minRed = Math.min(totalRed-leftRed, totalRed-rightRed);
    int minBlue = Math.min(totalBlue-leftBlue, totalBlue-rightBlue);

    System.out.println(Math.min(minRed, minBlue));

   }
}