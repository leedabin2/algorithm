import java.io.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());

      int cnt = 0;
      for (int i =0; i < N; i++) {
        String s = br.readLine();
        boolean[] seen = new boolean[26]; 
        boolean isGroup =true;

        char prev = 0; // 이전 문자 저장
        for (char ch : s.toCharArray()) {
          int idx = ch - 'a';

          if (ch != prev) {
            if (seen[idx]) {
              // 이전에도 등장하고, 다시 등장했다면 그룹 아님
              isGroup = false;
              break;
            }

            seen[idx] = true; // 첫 등장
          }

          prev = ch;
        }
        if (isGroup) cnt++;
      }

      System.out.println(cnt);

   }
}