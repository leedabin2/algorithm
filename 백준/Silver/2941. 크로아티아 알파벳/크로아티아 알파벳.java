import java.io.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String s = br.readLine();

      int cnt = 0;
      for (int i = 0; i < s.length(); i++) {
         
        // 3글자 인경우
        if (i+2 < s.length() && s.substring(i, i+3).equals("dz=")) {
          cnt++;
          i += 2;
        }

        // 2글자인 경우
        else if ( i + 1 < s.length())
        {
          String two = s.substring(i, i+2);

          if (two.equals("c=") || two.equals("c-") ||
              two.equals("d-") ||
              two.equals("lj") || two.equals("nj") ||
              two.equals("s=") || two.equals("z=")) {
              cnt++;
              i += 1;
          } else {
            cnt++;
          }

        }

        else cnt++;
      }

      System.out.println(cnt);
      
   }
}