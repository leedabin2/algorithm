import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] channel = new String[N];
    for (int i =0 ; i < N; i++) channel[i] = br.readLine();

    StringBuilder sb = new StringBuilder();


    for (int i = 0; i < N; i++) {
      if (channel[i].equals("KBS1")) {
        for (int j = 0; j < i; j++) sb.append("1");
        for (int j = i; j > 0; j--) {
          sb.append("4");
          String tmp = channel[j];
          channel[j] = channel[j-1];
          channel[j-1] = tmp;
        }

        break;
      }
   

    }

    for (int i = 0; i < N; i++) {
      if (channel[i].equals("KBS2")) {
        for (int j = 0; j < i; j++) sb.append("1");
        for (int j = i; j > 1 ;j--) {
          sb.append("4");
          String tmp = channel[j];
          channel[j] = channel[j-1];
          channel[j-1] = tmp;
        }
      break;
      }
    }

    System.out.println(sb.toString());

  }

} 
