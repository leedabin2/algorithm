import java.io.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {

      int N = Integer.parseInt(br.readLine());
      long[] days = new long[N];

      String[] info = br.readLine().split(" ");

      for (int i = 0; i < N; i++) days[i] = Long.parseLong(info[i]);

      long answer = 0;
      
      long max = days[N-1];
      for (int i = N-2; i >=0 ; i--) {
        if (days[i] < max) {
          answer += (max - days[i]);
        }
        else max = days[i];
      }

      System.out.println(answer);
    }
   }
}