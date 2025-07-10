import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[][] room = new int[N][2];

    for (int i =0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      room[i][0] = Integer.parseInt(row[0]);
      room[i][1] = Integer.parseInt(row[1]);
    }

    Arrays.sort(room, (a, b) -> 
    {
      if (a[0] == b[0]) {
        return Integer.compare(a[1], b[1]);
      } 
      return Integer.compare(a[0], b[0]);
    });



    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(room[0][1]);


    for (int i = 1; i < N; i++) {

      if (pq.peek() <= room[i][0]) {
        pq.poll();
      } 
      pq.add(room[i][1]);
    }

    System.out.println(pq.size());


  }
} 