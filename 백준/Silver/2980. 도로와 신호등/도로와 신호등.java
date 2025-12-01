import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]); 
        int L = Integer.parseInt(st[1]); 

        boolean[] stop = new boolean[L + 1];
        int[][] info = new int[L + 1][2];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int d = Integer.parseInt(line[0]);
            int r = Integer.parseInt(line[1]);
            int g = Integer.parseInt(line[2]);

            stop[d] = true;
            info[d][0] = r;
            info[d][1] = g;
        }

        int time = 0;
        int pos = 0;

        while (pos++ < L) {
          time++;
          if (stop[pos]) {

            int curr = time % (info[pos][0] + info[pos][1]);

            if (curr <= info[pos][0]) {
              // 빨간 불
              time += (info[pos][0] - curr);
            }

            if (curr == 0) continue;
          }
          
        }

        

        

        System.out.println(time);
    }
}
